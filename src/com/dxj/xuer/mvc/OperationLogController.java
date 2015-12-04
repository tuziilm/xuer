package com.dxj.xuer.mvc;

import com.dxj.xuer.common.OperationLogType;
import com.dxj.xuer.common.Paginator;
import com.dxj.xuer.domain.OperationLog;
import com.dxj.xuer.service.OperationLogService;
import com.dxj.xuer.service.SysUserService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/operation_log")
public class OperationLogController extends ListController<OperationLog, OperationLogService, OperationLogController.Query> {
	private final Logger log= LoggerFactory.getLogger(getClass());
    @Resource
    private SysUserService sysUserService;

	public OperationLogController() {
		super("operation_log");
	}
	@Resource
	public void setOperationLogService(OperationLogService operationLogService){
		this.service=operationLogService;
	}

    @Override
    protected boolean preList(int page, Paginator paginator, Query query, Model model) {
        model.addAttribute("operationLogTypeMap", OperationLogType.asMap());
        model.addAttribute("operationLogTypes", OperationLogType.values());
        model.addAttribute("sysUserMap", sysUserService.getCache());
        return super.preList(page, paginator, query, model);
    }

    public static class Query extends com.dxj.xuer.common.Query {
    	protected Integer userId;
    	protected Integer type;
        protected String startTime;
        protected String endTime;

        public Query() {
            this.startTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
            this.endTime = startTime+" 23:59:59";
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime.replaceAll("/", "-");
            this.addItem("startTime", startTime);
        }

		public String getEndTime() {
			return endTime;
		}

		public void setEndTime(String endTime) {
			this.endTime = endTime.replaceAll("/", "-")+" 23:59:59";
			this.addItem("endTime", endTime);
		}
    }
}
