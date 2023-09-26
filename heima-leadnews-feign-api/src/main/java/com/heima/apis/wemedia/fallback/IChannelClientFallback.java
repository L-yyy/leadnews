package com.heima.apis.wemedia.fallback;

import com.heima.apis.wemedia.IChannelClient;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.wemedia.dtos.WmChannelDto;

public class IChannelClientFallback implements IChannelClient {

    /**
     * 管理端微服务新增频道到自媒体微服务
     * @param dto
     * @return
     */

    @Override
    public ResponseResult saveChannel(WmChannelDto dto) {
        return ResponseResult.errorResult(AppHttpCodeEnum.SERVER_ERROR, "使用feign添加频道失败");
    }
}
