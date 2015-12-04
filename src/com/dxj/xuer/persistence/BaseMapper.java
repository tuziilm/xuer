package com.dxj.xuer.persistence;

import com.dxj.xuer.common.Paginator;
import com.dxj.xuer.domain.Id;

import java.util.List;

/**
 * ibatis操作表的Mapper基础接口
 * @author <a href="tuziilm@gmail.com">Tuziilm</a>
 *
 */
public interface BaseMapper<T extends Id> {
	
    int deleteById(Integer id);
    
    int deleteByIds(int ids[]);

    int insert(T channel);

    List<T> selectAll();
    
    List<T> select(Paginator page);

    int count(Paginator page);

    T selectById(Integer id);
    
    int updateByIdSelective(T t);
    
    int updateById(T t);
}