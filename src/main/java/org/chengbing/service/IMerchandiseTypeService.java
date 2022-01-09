package org.chengbing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.MerchandiseType;
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
public interface IMerchandiseTypeService extends IService<MerchandiseType> {
    IPage<Map> selectPageMerchandiseType(Page<Map> page);
    Integer insertMerchandiseType(MerchandiseType merchandiseType);
    IPage<Map> searchMerchandiseType(String searchContent, Page<Map> page);
    Map selectPageMerchandiseTypeById(Integer merchTypeId);
}
