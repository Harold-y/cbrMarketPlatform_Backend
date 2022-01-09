package org.chengbing.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.AuthenItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
public interface AuthenItemMapper extends BaseMapper<AuthenItem> {
    IPage<AuthenItem> selectPageAuthenItem(Page<AuthenItem> page);
    Integer insertAuthenItem(AuthenItem item);
    IPage<AuthenItem> searchAuthenItem(String searchContent, Page<AuthenItem> page);
}
