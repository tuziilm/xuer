package com.dxj.xuer.service;

import com.dxj.xuer.domain.Article;
import com.dxj.xuer.persistence.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: <a href="tuziilm@163.com">Tuziilm</a>
 * Date: 15-12-3
 * Time: обнГ2:42
 */
@Service
public class ArticleService extends BaseService<Article>{
    @Autowired
    public void setArticleMapper(ArticleMapper articleMapper) {
        this.mapper = articleMapper;
    }
}
