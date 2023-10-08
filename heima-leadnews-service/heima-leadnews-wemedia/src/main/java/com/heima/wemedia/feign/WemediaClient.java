package com.heima.wemedia.feign;

import com.heima.apis.wemedia.IChannelClient;
import com.heima.model.admin.dtos.AdChannelDto;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.WmChannelDto;
import com.heima.wemedia.service.WmChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class WemediaClient implements IChannelClient {
//
//    @Autowired
//    private WmChannelService wmChannelService;
//
//    @PostMapping("/api/v1/channel/save")
//    @Override
//    public ResponseResult saveChannel(@RequestBody WmChannelDto dto) {
//        return wmChannelService.saveChannel(dto);
//    }
//}
