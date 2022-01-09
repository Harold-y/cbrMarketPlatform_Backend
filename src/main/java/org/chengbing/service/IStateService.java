package org.chengbing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.State;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
public interface IStateService extends IService<State> {
    IPage<Map> selectPageState(Page<Map> page);
    Map selectStateById(Integer stateId);
    IPage<Map> searchState(String searchContent, Page<Map> page);
    List<State> selectStateByRegionId(Integer regionId);
}
