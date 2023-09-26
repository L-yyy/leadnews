package com.heima.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.article.pojos.ApArticle;
import org.apache.commons.net.nntp.Article;

public interface ArticleFreemakerService{

    /**
     * 创建文章页面并且上传到minIO
     * @param apArticle
     * @param cotent
     */
    void buildArticleToMinIO(ApArticle apArticle, String cotent);
}
