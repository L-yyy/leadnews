package com.heima.user.service;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.UserRelationDto;

public interface ApUserRelationService {

    /**
     * 关注or取关作者
     * @param dto
     * @return
     */
    ResponseResult follow(UserRelationDto dto);
}
