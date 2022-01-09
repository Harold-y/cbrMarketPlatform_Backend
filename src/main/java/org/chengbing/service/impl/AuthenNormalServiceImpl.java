package org.chengbing.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.AuthenClearance;
import org.chengbing.entity.AuthenItem;
import org.chengbing.entity.AuthenNormal;
import org.chengbing.dao.AuthenNormalMapper;
import org.chengbing.service.IAuthenNormalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
@Service
public class AuthenNormalServiceImpl extends ServiceImpl<AuthenNormalMapper, AuthenNormal> implements IAuthenNormalService {
    @Resource
    AuthenNormalMapper mapper;

    @Override
    public IPage<AuthenNormal> selectPageAuthenNormal(Page<AuthenNormal> page) {
        return mapper.selectPageAuthenNormal(page);
    }

    @Override
    public Integer insertAuthenNormal(AuthenNormal item) {
        return mapper.insertAuthenNormal(item);
    }

    @Override
    public IPage<AuthenNormal> searchAuthenNormal(String searchContent, Page<AuthenNormal> page) {
        return mapper.searchAuthenNormal(searchContent, page);
    }

    @Override
    public List<LinkedHashMap> selectAffiliation(Integer authId) {
        return mapper.selectAffiliation(authId);
    }

    @Override
    public Integer insertClearance(AuthenClearance clearance) {
        return mapper.insertClearance(clearance);
    }

    @Override
    public Integer deleteClearance(Integer authenId, Integer authenItemId) {
        return mapper.deleteClearance(authenId, authenItemId);
    }
}
