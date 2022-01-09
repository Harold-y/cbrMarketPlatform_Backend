package org.chengbing.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.State;
import org.chengbing.dao.StateMapper;
import org.chengbing.service.IStateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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
public class StateServiceImpl extends ServiceImpl<StateMapper, State> implements IStateService {
    @Resource
    StateMapper mapper;


    @Override
    public IPage<Map> selectPageState(Page<Map> page) {
        return mapper.selectPageState(page);
    }
    @Override
    public Map selectStateById(Integer stateId)
    {
        return mapper.selectStateById(stateId);
    }

    @Override
    public IPage<Map> searchState(String searchContent, Page<Map> page) {
        return mapper.searchState(searchContent, page);
    }

    @Override
    public List<State> selectStateByRegionId(Integer regionId) {
        return mapper.selectStateByRegionId(regionId);
    }

}
