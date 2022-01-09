package org.chengbing.service.impl;

import org.chengbing.entity.MerchandiseGenType;
import org.chengbing.dao.MerchandiseGenTypeMapper;
import org.chengbing.service.IMerchandiseGenTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
@Service
public class MerchandiseGenTypeServiceImpl extends ServiceImpl<MerchandiseGenTypeMapper, MerchandiseGenType> implements IMerchandiseGenTypeService {
    @Resource
    MerchandiseGenTypeMapper mapper;
}
