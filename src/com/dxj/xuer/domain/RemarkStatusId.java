package com.dxj.xuer.domain;

/**
 * 包含remark, status, id字段
 * @author <a href="tuziilm@gmail.com">Tuziilm</a>
 *
 */
public class RemarkStatusId extends RemarkId{
    /** 状态,1:正常,0:异常*/
    protected Byte status;

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
