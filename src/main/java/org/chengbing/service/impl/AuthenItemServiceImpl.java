package org.chengbing.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.AuthenItem;
import org.chengbing.dao.AuthenItemMapper;
import org.chengbing.service.IAuthenItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class AuthenItemServiceImpl extends ServiceImpl<AuthenItemMapper, AuthenItem> implements IAuthenItemService {

    @Resource
    AuthenItemMapper mapper;

    @Override
    public IPage<AuthenItem> selectPageAuthenItem(Page<AuthenItem> page) {
        return mapper.selectPageAuthenItem(page);
    }

    @Override
    public Integer insertAuthenItem(AuthenItem item) {
        return mapper.insertAuthenItem(item);
    }

    @Override
    public IPage<AuthenItem> searchAuthenItem(String searchContent, Page<AuthenItem> page) {
        return mapper.searchAuthenItem(searchContent, page);
    }
}
