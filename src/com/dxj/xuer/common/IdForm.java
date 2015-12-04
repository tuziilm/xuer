package com.dxj.xuer.common;

import com.dxj.xuer.domain.Id;

/**
 * 带有ID的表单基类
 * @author <a href="tuziilm@gmail.com">Tuziilm</a>
 *
 */
public abstract class IdForm<T extends Id> {
    protected Integer id;

    public abstract T newObj();
    public abstract void populateObj(T obj);

    public T toObj(){
        T t= newObj();
        t.setId(id);
        populateObj(t);
        return t;
    }
    
    public boolean isModified(){
    	return id != null && id > 0;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
