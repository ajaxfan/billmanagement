package com.expressway.billmanagement.report.abstracts;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.expressway.billmanagement.report.annotations.ReportInfo;
import com.expressway.billmanagement.report.api.IReportCreator;
import com.expressway.billmanagement.report.api.IResourceLoader;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * 创建报表对象
 *
 * @author Ajaxfan
 */
public abstract class AbstractReportCreator implements IReportCreator {
    /** 报表资源加载工具 */
    private @Autowired IResourceLoader<JasperReport> jasperTemplateLoader;
    
    /**
     * @param parameter
     * @param beans
     * @return
     */
    @Override
    public JasperPrint create(Map<String, Object> parameter, List<Object> beans) {
        try {
            return JasperFillManager.fillReport(jasperTemplateLoader.load(getName()), parameter,
                    new JRBeanCollectionDataSource(beans));
        } catch (JRException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return 报表名称
     */
    private String getName() {
        // 记录了report信息的Annotaion对象
        ReportInfo info = (ReportInfo) this.getClass().getAnnotation(ReportInfo.class);

        // 报表名称
        return new StringBuilder(info.name()).append(info.suffix()).toString();
    }
}
