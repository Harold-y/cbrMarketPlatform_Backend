package org.chengbing.service.impl;

import org.chengbing.dao.UtilMapper;
import org.chengbing.service.IUserService;
import org.chengbing.service.IUtilService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UtilServiceImpl implements IUtilService {

    @Resource
    UtilMapper mapper;
    @Override
    public String getUploadFolder() {
        return mapper.getUploadFolder();
    }
}
