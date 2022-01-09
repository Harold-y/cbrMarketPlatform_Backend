package org.chengbing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.MerchandisePropertyType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
public interface IMerchandisePropertyTypeService extends IService<MerchandisePropertyType> {
    IPage<Map> selectPageMerchandisePropertyType(Page<Map> page);
    Integer insertMerchandisePropertyType(MerchandisePropertyType merchandisePropertyType);
    IPage<Map> searchMerchandisePropertyType(String searchContent, Page<Map> page);
    Map selectPageMerchandisePropertyTypeById(Integer merchPropertyTypeId);
}
