package com.dxj.xuer.persistence;

import com.dxj.xuer.domain.SysUser;

/**
 * ibatis����ϵͳ�û����Mapper�ӿ�
 * @author <a href="tuziilm@gmail.com">Tuziilm</a>
 *
 */
public interface SysUserMapper extends BaseMapper<SysUser>{

	SysUser getByUsername(String username);
}