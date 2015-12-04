package com.dxj.xuer.statistics.analyzer;

import com.dxj.xuer.statistics.common.ChartPvUvData;

import java.util.List;

public interface Analyzer {
    List<ChartPvUvData> analyze() throws Exception;
}
