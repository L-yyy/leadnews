package com.heima.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.SensitiveDto;
import com.heima.model.wemedia.pojos.WmSensitive;

public interface WmSensitiveService extends IService<WmSensitive> {

    /**
     * 添加敏感词
     * @param wmSensitive
     * @return
     */
    ResponseResult insert(WmSensitive wmSensitive);

    /**
     * 敏感词查询
     * @param dto
     * @return
     */
    ResponseResult findByNameAndPage(SensitiveDto dto);

    /**
     * 修改铭感词
     * @param wmSensitive
     * @return
     */
    ResponseResult updateSensitive(WmSensitive wmSensitive);
}
