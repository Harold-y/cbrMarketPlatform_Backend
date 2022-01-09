package org.chengbing.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.chengbing.entity.Personnel;
import com.baomidou.mybatisplus.extension.service.IService;
import org.chengbing.util.Result;
import org.chengbing.util.ResultWithStr;
import org.springframework.web.multipart.MultipartFile;

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
public interface IPersonnelService extends IService<Personnel> {
    IPage<Personnel> selectPagePersonnel(Page<Personnel> page);
    Integer insertPersonnel(Personnel personnel);
    IPage<Personnel> searchPersonnel(String searchContent, Page<Personnel> page);
    String selectPasswordByPersonnelId(Integer personnelId);
    Integer updatePasswordByPersonnelId(String personnelPassword, Integer personnelId);
    Personnel selectPersonnelById(Integer personnelId);
    Integer updatePersonnelById(Personnel personnel);
    Integer personnelLogIn(String personnelEmail, String personnelPassword);
    List<String> personnelAuth(Integer personnelId);
    Map selectPersonnelProfileById();
    Integer updatePersonnelProfileName(String personnelFirstName, String personnelMidName, String personnelLastName);
    Integer updatePersonnelEmail(String personnelEmail);

    public ResultWithStr<Integer> updateProfileImg(MultipartFile img);
    Result<Integer> getLoginId();
}
