package org.chengbing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.AuthenClearance;
import org.chengbing.entity.AuthenItem;
import org.chengbing.entity.AuthenNormal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
public interface IAuthenNormalService extends IService<AuthenNormal> {
    IPage<AuthenNormal> selectPageAuthenNormal(Page<AuthenNormal> page);
    Integer insertAuthenNormal(AuthenNormal item);
    IPage<AuthenNormal> searchAuthenNormal(String searchContent, Page<AuthenNormal> page);
    List<LinkedHashMap> selectAffiliation(Integer authId);
    Integer insertClearance(AuthenClearance clearance);
    Integer deleteClearance(Integer authenId, Integer authenItemId);
}
