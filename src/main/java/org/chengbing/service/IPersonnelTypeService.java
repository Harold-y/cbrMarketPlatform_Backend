package org.chengbing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.PersonnelAuth;
import org.chengbing.entity.PersonnelType;
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
public interface IPersonnelTypeService extends IService<PersonnelType> {
    IPage<PersonnelType> selectPagePersonnelType(Page<PersonnelType> page);
    Integer insertPersonnelType(PersonnelType personnelType);
    IPage<PersonnelType> searchPersonnelType(String searchContent, Page<PersonnelType> page);
    List<Map> selectAuthByPersonnelTypeId(Integer personnelTypeId);
    Integer insertPersonnelAuth(PersonnelAuth auth);
    Integer deletePersonnelAuth(Integer authId, Integer personnelTypeId);
}
