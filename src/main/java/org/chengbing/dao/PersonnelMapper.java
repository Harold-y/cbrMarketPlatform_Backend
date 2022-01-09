package org.chengbing.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.Personnel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.chengbing.util.ResultWithStr;
import org.springframework.web.multipart.MultipartFile;

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
public interface PersonnelMapper extends BaseMapper<Personnel> {
    IPage<Personnel> selectPagePersonnel(Page<Personnel> page);
    Integer insertPersonnel(Personnel personnel);
    IPage<Personnel> searchPersonnel(String searchContent, Page<Personnel> page);
    String selectPasswordByPersonnelId(Integer personnelId);
    Integer updatePasswordByPersonnelId(String personnelPassword, Integer personnelId);
    Personnel selectPersonnelById(Integer personnelId);
    Integer updatePersonnelById(Personnel personnel);
    Integer personnelLogIn(String personnelEmail, String personnelPassword);
    List<String> personnelAuth(Integer personnelId);
    Map selectPersonnelProfileById(Integer personnelId);

    Integer updatePersonnelProfileName(Integer personnelId, String personnelFirstName, String personnelMidName, String personnelLastName);
    Integer updatePersonnelEmail(Integer personnelId, String personnelEmail);

}
