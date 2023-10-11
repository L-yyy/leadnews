package com.heima.wemedia.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.NewsAuthDto;
import com.heima.model.wemedia.dtos.WmNewsDto;
import com.heima.model.wemedia.dtos.WmNewsPageReqDto;
import com.heima.model.wemedia.pojos.WmNews;

public interface WmNewsService extends IService<WmNews> {

    /**
     * 查询文章
     * @param dto
     * @return
     */
    public ResponseResult findAll(WmNewsPageReqDto dto);

    /**
     * 发布修改文章 或者 保存为草稿
     * @return
     */
    public ResponseResult submitNews(WmNewsDto wmNewsDto);

    /**
     * 文章的上下架
     * @param dto
     * @return
     */
    public ResponseResult downOrUp(WmNewsDto dto);

    /**
     * 媒体审核页面查询
     * @param dto
     * @return
     */
    ResponseResult findList(NewsAuthDto dto);

    /**
     * 查询文章VO详情
     * @param id
     * @return
     */
    ResponseResult findDetailArticleVo(Integer id);

    /**
     * 人工审核通过or失败
     * @param dto
     * @param wmNewsAuthPass
     * @return
     */
    ResponseResult chnageStatus(NewsAuthDto dto, Short wmNewsAuthPass);
}