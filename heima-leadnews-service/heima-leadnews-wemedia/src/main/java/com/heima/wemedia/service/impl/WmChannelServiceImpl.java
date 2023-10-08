package com.heima.wemedia.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.apis.wemedia.IChannelClient;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.wemedia.dtos.WmChannelDto;
import com.heima.model.wemedia.pojos.WmChannel;
import com.heima.wemedia.mapper.WmChannelMapper;
import com.heima.wemedia.service.WmChannelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
@Slf4j
public class WmChannelServiceImpl extends ServiceImpl<WmChannelMapper, WmChannel> implements WmChannelService {

    /**
     * 查询所有频道
     * @return
     */
    @Override
    public ResponseResult findAll() {
        return ResponseResult.okResult(list());
    }

    /**
     * 保存标签(通过admin网关，跳转到wemedia微服务)
     * @return
     */
    @Override
    public ResponseResult saveChannel(WmChannel wmChannel) {

        //1.判断参数是否为空
        if (wmChannel == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }

        WmChannel channel = getOne(Wrappers.<WmChannel>lambdaQuery().eq(WmChannel::getName, wmChannel.getName()));
        if (channel != null){
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST, "频道已经存在");
        }
        //2.保存
        wmChannel.setCreatedTime(new Date());
        save(wmChannel);

        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

//    @Qualifier("com.heima.apis.wemedia.IChannelClient")
//    @Autowired
//    private IChannelClient iChannelClient;
//    /**
//     * feign远程新增频道
//     * @return
//     */
//    @Override
//    public ResponseResult saveChannel(WmChannelDto dto) {
//        iChannelClient.saveChannel(dto);
//
//        return null;
//    }



}