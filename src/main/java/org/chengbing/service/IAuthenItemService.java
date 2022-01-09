package org.chengbing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.AuthenItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
public interface IAuthenItemService extends IService<AuthenItem> {
    IPage<AuthenItem> selectPageAuthenItem(Page<AuthenItem> page);
    Integer insertAuthenItem(AuthenItem item);
    IPage<AuthenItem> searchAuthenItem(String searchContent, Page<AuthenItem> page);
}
