//package com.heima.apis.wemedia;
//
//import com.heima.apis.article.fallback.IArticleClientFallback;
//import com.heima.model.admin.dtos.AdChannelDto;
//import com.heima.model.common.dtos.ResponseResult;
//import com.heima.model.wemedia.dtos.WmChannelDto;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@FeignClient(value = "leadnews-wemedia", fallback = IArticleClientFallback.class, url = "http://localhost:8802/wemedia/MEDIA/wemedia")   //value是远程调用的，fallback是降级用的
//public interface IChannelClient {
//
//    /**
//     * 管理端微服务新增频道到自媒体微服务
//     * @param dto
//     * @return
//     */
//    @PostMapping("/api/v1/channel/save")
//    public ResponseResult saveChannel(@RequestBody WmChannelDto dto);
//}
