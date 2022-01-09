package org.chengbing.other;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
public class SecKillController {
    @Resource
    RedisTemplate redisTemplate;
    @GetMapping("seckill")
    public void secKill()
    {
        String uid = "CryoWolf" + ":" + UUID.randomUUID();
        Jedis jedis = new Jedis("192.168.129.131", 6379);
        jedis.select(15);

        String storageKey = "storage:1";
        jedis.watch(storageKey);
        String s = jedis.get(storageKey);
        if(s == null) {
            System.out.println("The SecKill has not started yet! Thanks for your patient!");
            return;
        }
        // if less or equal to zero : end

        int num = Integer.parseInt(s);
        if(num <= 0) {
            System.out.println("Already Ended.");
            return;
        }

        // If the storage is greater than zero : secKill
        // Succeed: storage -1, record the user information using set
        Boolean userKey = jedis.sismember("userkey", uid);
        if(userKey) {
            System.out.println("Already Operated");
            return;
        }else {
            Transaction multi = jedis.multi();
            multi.decr(storageKey);
            multi.sadd("userkey", uid);
            List<Object> exec = multi.exec();
            if(exec == null || exec.size() == 0)
            {
                System.out.println("The Operation Failed.");
                return;
            }else
            {
                System.out.println("Succeed! The User Id is "+uid);
            }
        }

    }

    @GetMapping("seckill2")
    public void secKill2() {
        String uid = "CryoWolf_" + UUID.randomUUID();
            SessionCallback sessionCallback = new SessionCallback() {
                @Override
                public Object execute(RedisOperations redisOperations) throws DataAccessException {
                    redisTemplate.setEnableTransactionSupport(true);
                    redisTemplate.watch("storage:1");
                    Integer storage = (Integer) redisTemplate.opsForValue().get("storage:1");
                    if(storage == null) {
                        System.out.println("Hasn't been started yet");
                        return null;
                    }
                    if(storage <= 0) {
                        System.out.println("Empty Storage, Event Ended");
                        return null;
                    }
                    Boolean isMem = redisTemplate.opsForSet().isMember("userkey", uid);
                    if(isMem) {
                        System.out.println("Already Purchased");
                        return null;
                    }
                    redisOperations.multi();
                    redisOperations.opsForValue().decrement("storage:1");
                    redisOperations.opsForSet().add("userkey", uid);
                    List exec = redisOperations.exec();
                    return exec;
                }
            };
            List execute = (List) redisTemplate.execute(sessionCallback);
            if(execute == null || execute.size() == 0)
            {
                System.out.println("The Operation Failed.");
                return;
            }else
            {
                System.out.println("Succeed! The User Id is "+uid);
            }


    }
}
