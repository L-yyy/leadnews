package com.heima.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.common.constants.UserConstants;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.AuthDto;
import com.heima.model.user.pojos.ApUser;
import com.heima.model.user.pojos.ApUserRealname;
import org.springframework.web.bind.annotation.RestController;

public interface ApUserRealnameService extends IService<ApUserRealname> {

    /**
     * 用户审核列表查询
     * @param dto
     * @return
     */
    ResponseResult findByNameAndPage(AuthDto dto);

    /**
     * 用户审核通过
     * @param dto
     * @return
     */
    ResponseResult updateStatus(AuthDto dto, Short status);
}
