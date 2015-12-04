package com.dxj.xuer.domain;

/**
 * Author: <a href="tuziilm@163.com">Tuziilm</a>
 * Date: 15-12-2
 * Time: ÏÂÎç6:00
 */
public class Article extends RemarkId {

    private String title;

    private String content;

    private Integer type;

    private Integer readCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }
}
