package com.heima.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.ChannelDto;
import com.heima.model.wemedia.dtos.WmChannelDto;
import com.heima.model.wemedia.pojos.WmChannel;

public interface WmChannelService extends IService<WmChannel> {

    /**
     * 查询所有频道
     * @return
     */
    public ResponseResult findAll();

    /**
     * 保存标签(通过admin网关，跳转到wemedia微服务)
     * @return
     */
    public ResponseResult saveChannel(WmChannel wmChannel);

    /**
     * 查询频道
     * @param dto
     * @return
     */
    ResponseResult findByNameAndPage(ChannelDto dto);

    /**
     * 修改频道
     * @param wmChannel
     * @return
     */
    ResponseResult updateChannel(WmChannel wmChannel);
}