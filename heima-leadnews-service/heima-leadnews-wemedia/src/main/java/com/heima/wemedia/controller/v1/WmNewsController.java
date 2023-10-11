package com.heima.wemedia.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.NewsAuthDto;
import com.heima.model.wemedia.dtos.WmNewsDto;
import com.heima.model.wemedia.dtos.WmNewsPageReqDto;
import com.heima.wemedia.service.WmNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 内容列表查询
 */
@RestController
@RequestMapping("/api/v1/news")
public class    WmNewsController {

    @Autowired
    private WmNewsService wmNewsService;

    /**
     * 查询内容列表
     * @param dto
     * @return
     */
    @PostMapping("/list")
    public ResponseResult findAll(@RequestBody WmNewsPageReqDto dto){
        return  wmNewsService.findAll(dto);
    }

    /**
     * 发布文章
     * @param dto
     * @return
     */
    @PostMapping("/submit")
    public ResponseResult submitNews(@RequestBody WmNewsDto dto){
        return wmNewsService.submitNews(dto);
    }

    /**
     * 文章上下架
     * @param dto
     * @return
     */
    @PostMapping("/down_or_up")
    public ResponseResult downOrUp(@RequestBody WmNewsDto dto){
        return wmNewsService.downOrUp(dto);
    }

    /**
     * 媒体审核页面分页查询
     * @param dto
     * @return
     */
    @PostMapping("/list_vo")
    public ResponseResult findList(@RequestBody NewsAuthDto dto){
        return wmNewsService.findList(dto);
    }

    @GetMapping("/one_vo/{id}")
    public ResponseResult findDetailArticleVo(@PathVariable("id") Integer id){
        return wmNewsService.findDetailArticleVo(id);
    }
}