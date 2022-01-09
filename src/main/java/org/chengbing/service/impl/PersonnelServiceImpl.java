package org.chengbing.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.Merchandise;
import org.chengbing.entity.Personnel;
import org.chengbing.dao.PersonnelMapper;
import org.chengbing.service.IPersonnelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.chengbing.util.AESUtils;
import org.chengbing.util.RandomPassUtil;
import org.chengbing.util.Result;
import org.chengbing.util.ResultWithStr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
@Service
public class PersonnelServiceImpl extends ServiceImpl<PersonnelMapper, Personnel> implements IPersonnelService {

    @Resource
    PersonnelMapper mapper;

    @Value("${file.uploadFolder}")
    String uploadFolder;

    @Override
    public IPage<Personnel> selectPagePersonnel(Page<Personnel> page) {
        return mapper.selectPagePersonnel(page);
    }

    @Override
    public Integer insertPersonnel(Personnel personnel) {
        LocalDateTime dateTime = LocalDateTime.now();
        personnel.setPersonnelEnrollTime(dateTime);
        personnel.setPersonnelStatus(1);
        String ranPass = RandomPassUtil.randomPass(12);
        String converted = "";
        try {
            converted = AESUtils.aesEncryptStr(ranPass, AESUtils.getPkey());
        } catch (Exception e) {
            e.printStackTrace();
        }
        personnel.setPersonnelPassword(converted);
        return mapper.insertPersonnel(personnel);
    }

    @Override
    public IPage<Personnel> searchPersonnel(String searchContent, Page<Personnel> page) {
        return mapper.searchPersonnel(searchContent, page);
    }

    @Override
    public String selectPasswordByPersonnelId(Integer personnelId) {
        String unconverted = mapper.selectPasswordByPersonnelId(personnelId);
        String converted = "";
        if(unconverted!=null && !unconverted.equals(""))
        {
            try {
                converted = AESUtils.aesDecodeStr(unconverted, AESUtils.getPkey());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return converted;
    }

    @Override
    public Integer updatePasswordByPersonnelId(String personnelPassword, Integer personnelId) {
        String encrypted = AESUtils.aesEncryptStr(personnelPassword, AESUtils.getPkey());
        return mapper.updatePasswordByPersonnelId(encrypted, personnelId);
    }

    @Override
    public Personnel selectPersonnelById(Integer personnelId) {
        return mapper.selectPersonnelById(personnelId);
    }

    @Override
    public Integer updatePersonnelById(Personnel personnel) {
        if(personnel.getPersonnelStatus() == 0)
            personnel.setPersonnelResignTime(LocalDateTime.now());
        return mapper.updatePersonnelById(personnel);
    }

    @Override
    public Integer personnelLogIn(String personnelEmail, String personnelPassword) {
        String converted = "";
        if(personnelPassword!=null && !personnelPassword.equals(""))
        {
            try {
                converted = AESUtils.aesEncryptStr(personnelPassword, AESUtils.getPkey());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mapper.personnelLogIn(personnelEmail, converted);
    }

    @Override
    public List<String> personnelAuth(Integer personnelId) {
        return mapper.personnelAuth(personnelId);
    }

    @Override
    public Map selectPersonnelProfileById() {
        return mapper.selectPersonnelProfileById(Integer.parseInt((String)StpUtil.getLoginId()));
    }

    @Override
    public Integer updatePersonnelProfileName(String personnelFirstName, String personnelMidName, String personnelLastName) {
        return mapper.updatePersonnelProfileName(Integer.parseInt((String)StpUtil.getLoginId()), personnelFirstName, personnelMidName, personnelLastName);
    }

    @Override
    public Integer updatePersonnelEmail(String personnelEmail) {
        return mapper.updatePersonnelEmail(Integer.parseInt((String)StpUtil.getLoginId()), personnelEmail);
    }

    @Override
    public ResultWithStr<Integer> updateProfileImg(MultipartFile img) {
        try {
            Integer personnelId = Integer.parseInt((String)StpUtil.getLoginId());
            String filePath = uploadFolder + "/personnel/" ;
            File dest = new File(filePath);
            if(!dest.exists()){
                dest.mkdirs();
            }
            img.transferTo(new File(filePath, personnelId+".jpg"));
        } catch (Exception e)
        {
            return new ResultWithStr<>(-1,406, e.getMessage());
        }
        return new ResultWithStr<>(1, 200, "Success");
    }

    @Override
    public Result<Integer> getLoginId()
    {
        return new Result<>(Integer.parseInt((String)StpUtil.getLoginId()), 200);
    }

}
