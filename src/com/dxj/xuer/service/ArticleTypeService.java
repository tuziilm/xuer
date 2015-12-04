package com.dxj.xuer.service;

import com.dxj.xuer.domain.ArticleType;
import com.dxj.xuer.persistence.ArticleTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: <a href="tuziilm@163.com">Tuziilm</a>
 * Date: 15-12-3
 * Time: ÉÏÎç10:24
 */
@Service
public class ArticleTypeService extends ObjectBasedGroupCacheSupportService<ArticleType> {

    private final static String LIST_ALL_KEY = "list_all_key";

    private final static String MAP_ALL_KEY = "map_all_key";

    private ArticleTypeMapper articleTypeMapper;

    @Autowired
    public void setArticleTypeMapper(ArticleTypeMapper articleTypeMapper) {
        this.mapper = articleTypeMapper;
        this.articleTypeMapper = articleTypeMapper;
    }
    @Override
    public String[] cacheGroupKeys() {
        return new String[]{LIST_ALL_KEY,MAP_ALL_KEY};
    }

    @Override
    public Object newObject(String cacheGroupKey) {
        if(cacheGroupKey.startsWith("map")){
            return new HashMap();
        }else{
            return new ArrayList();
        }
    }

    @Override
    public void updateCacheList(Map<String, Object> update, ArticleType articleType) {
        ((List<ArticleType>)update.get(LIST_ALL_KEY)).add(articleType);
        ((Map<Integer, ArticleType>)update.get(MAP_ALL_KEY)).put(articleType.getId(), articleType);
    }
    public List<ArticleType> getAllArticleTypesCache(){
        return (List<ArticleType>)getCache(LIST_ALL_KEY);
    }

    public Map<Integer, ArticleType> getAllArticleTypesMapCache(){
        return (Map<Integer, ArticleType>)getCache(MAP_ALL_KEY);
    }

}
