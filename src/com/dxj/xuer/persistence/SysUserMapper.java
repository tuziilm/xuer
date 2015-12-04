package com.dxj.xuer.persistence;

import com.dxj.xuer.domain.SysUser;

/**
 * ibatis操作系统用户表的Mapper接口
 * @author <a href="tuziilm@gmail.com">Tuziilm</a>
 *
 */
public interface SysUserMapper extends BaseMapper<SysUser>{

	SysUser getByUsername(String username);
}