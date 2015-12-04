package com.dxj.xuer.service;

import com.dxj.xuer.domain.OperationLog;
import com.dxj.xuer.persistence.OperationLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationLogService extends BaseService<OperationLog> {
	@Autowired
	public void setOperationLogMapper(OperationLogMapper operationLogMapper) {
		this.mapper = operationLogMapper;
	}
}
