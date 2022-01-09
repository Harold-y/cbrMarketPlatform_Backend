package org.chengbing.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.State;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.chengbing.util.Result;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
public interface StateMapper extends BaseMapper<State> {
    IPage<Map> selectPageState(Page<Map> page);
    Map selectStateById(Integer stateId);
    IPage<Map> searchState(String searchContent, Page<Map> page);
    List<State> selectStateByRegionId(Integer regionId);
}
