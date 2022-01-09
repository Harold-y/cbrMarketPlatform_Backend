package org.chengbing.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.MerchandisePropertyType;
import org.chengbing.dao.MerchandisePropertyTypeMapper;
import org.chengbing.service.IMerchandisePropertyTypeService;
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
public class MerchandisePropertyTypeServiceImpl extends ServiceImpl<MerchandisePropertyTypeMapper, MerchandisePropertyType> implements IMerchandisePropertyTypeService {
    @Resource
    MerchandisePropertyTypeMapper mapper;

    @Override
    public IPage<Map> selectPageMerchandisePropertyType(Page<Map> page) {
        return mapper.selectPageMerchandisePropertyType(page);
    }

    @Override
    public Integer insertMerchandisePropertyType(MerchandisePropertyType merchandisePropertyType) {
        return mapper.insertMerchandisePropertyType(merchandisePropertyType);
    }

    @Override
    public IPage<Map> searchMerchandisePropertyType(String searchContent, Page<Map> page) {
        return mapper.searchMerchandisePropertyType(searchContent, page);
    }

    @Override
    public Map selectPageMerchandisePropertyTypeById(Integer merchPropertyTypeId) {
        return mapper.selectPageMerchandisePropertyTypeById(merchPropertyTypeId);
    }
}
