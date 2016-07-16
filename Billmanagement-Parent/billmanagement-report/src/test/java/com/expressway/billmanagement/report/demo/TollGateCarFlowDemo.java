package com.expressway.billmanagement.report.demo;


import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.expressway.billmanagement.data.beans.TollGateCarFlow;
import com.expressway.billmanagement.report.api.IReportService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;

public class TollGateCarFlowDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-report.xml");
        IReportService dao = (IReportService) context.getBean("reportService");
        try {
            print(dao.getPrintableObject(IReportService.TOLL_GATE_CAR_FLOW, createList()));
        } catch (JRException e) {
            e.printStackTrace();
        }
        context.close();
    }

    private static List createList() {
        List list = new ArrayList();

        for (int i = 1; i <= 40; i++) {
            TollGateCarFlow bean = new TollGateCarFlow();
            bean.setActdistance(String.valueOf(i * 100));
            bean.setAxisum(String.valueOf(i * 300));
            bean.setCarType(i % 2 == 0 ? "1型" : "2型");
            bean.setCrossCount(String.valueOf(i * 125));
            bean.setCrossDate("2016-07-10 17:20:32");
            bean.setCrossType(i % 2 == 0 ? "出口" : "入口");
            bean.setEnterName("测试测试车市测试");
            bean.setTotalFare(String.valueOf(i * 236));
            bean.setTotalWeight(String.valueOf(i * 567));
            
            list.add(bean);
        }
        return list;
    }

    /**
     * 报表打印
     *
     * @param jasperPrint
     * @throws JRException
     */
    private static void print(JasperPrint jasperPrint) throws JRException {
        // 打印请求属性集合
        PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
        // 使用A4纸张
        printRequestAttributeSet.add(MediaSizeName.ISO_A4);

        // 实例化Jasper导出工具类
        JRPrintServiceExporter exporter = new JRPrintServiceExporter();
        // 设定导出文件对象
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        // 设定导出工具参数
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
        // 设置打印机参数
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
                new HashPrintServiceAttributeSet());
        // 不显示页面设置对话框
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
        // 不显示打印机选择对话框
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);

        // 执行打印操作
        exporter.exportReport();
    }
}
