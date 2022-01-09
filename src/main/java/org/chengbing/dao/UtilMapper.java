package org.chengbing.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UtilMapper {
    @Select("select uploadFolder from upload where uploadFolderId = 1")
    public String getUploadFolder();
}
