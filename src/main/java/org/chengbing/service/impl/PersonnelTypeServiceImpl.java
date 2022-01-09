package org.chengbing.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.PersonnelAuth;
import org.chengbing.entity.PersonnelType;
import org.chengbing.dao.PersonnelTypeMapper;
import org.chengbing.service.IPersonnelTypeService;
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
public class PersonnelTypeServiceImpl extends ServiceImpl<PersonnelTypeMapper, PersonnelType> implements IPersonnelTypeService {

    @Resource
    PersonnelTypeMapper mapper;

    @Override
    public IPage<PersonnelType> selectPagePersonnelType(Page<PersonnelType> page) {
        return mapper.selectPagePersonnelType(page);
    }

    @Override
    public Integer insertPersonnelType(PersonnelType personnelType) {
        return mapper.insertPersonnelType(personnelType);
    }

    @Override
    public IPage<PersonnelType> searchPersonnelType(String searchContent, Page<PersonnelType> page) {
        return mapper.searchPersonnelType(searchContent, page);
    }

    @Override
    public List<Map> selectAuthByPersonnelTypeId(Integer personnelTypeId) {
        return mapper.selectAuthByPersonnelTypeId(personnelTypeId);
    }

    @Override
    public Integer insertPersonnelAuth(PersonnelAuth auth) {
        return mapper.insertPersonnelAuth(auth);
    }

    @Override
    public Integer deletePersonnelAuth(Integer authId, Integer personnelTypeId) {
        return mapper.deletePersonnelAuth(authId, personnelTypeId);
    }
}
