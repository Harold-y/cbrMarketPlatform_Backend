package org.chengbing.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.MerchandiseType;
import org.chengbing.dao.MerchandiseTypeMapper;
import org.chengbing.service.IMerchandiseTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class MerchandiseTypeServiceImpl extends ServiceImpl<MerchandiseTypeMapper, MerchandiseType> implements IMerchandiseTypeService {

    @Resource
    MerchandiseTypeMapper mapper;

    @Override
    public IPage<Map> selectPageMerchandiseType(Page<Map> page) {
        return mapper.selectPageMerchandiseType(page);
    }

    @Override
    public Integer insertMerchandiseType(MerchandiseType merchandiseType) {
        return mapper.insertMerchandiseType(merchandiseType);
    }

    @Override
    public IPage<Map> searchMerchandiseType(String searchContent, Page<Map> page) {
        return mapper.searchMerchandiseType(searchContent, page);
    }
    @Override
    public Map selectPageMerchandiseTypeById(Integer merchTypeId)
    {
        return mapper.selectPageMerchandiseTypeById(merchTypeId);
    }
}
