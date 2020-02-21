package com.lianxun.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ExcelListener
 * @Description
 * @Author Vera
 * @Date 2020/2/21 16:38
 * @Version 1.0
 **/
public class ExcelListener extends AnalysisEventListener {
    private List<Object> datas = new ArrayList<Object>();

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        datas.add(o);
    }

    public List<Object> getDatas() {
        return datas;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
