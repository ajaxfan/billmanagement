package com.expressway.billmanagement.report.concete;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.expressway.billmanagement.report.abstracts.AbstractReportCreator;
import com.expressway.billmanagement.report.helpers.JasperTemplateLoader;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * MTC报表
 *
 * @author Ajaxfan
 */
@Component("mtcreportCreator")
class MTCReportCreator extends AbstractReportCreator {
	/** 模板文件名称 */
	private static final String FILE_NAME = "MTCReport.jasper";

	/**
	 * @param parameter
	 * @param beans
	 * @return
	 */
	@Override
	public JasperPrint create(Map<String, Object> parameter, List<Object> beans) {
		try {
			return JasperFillManager.fillReport(JasperTemplateLoader.load(FILE_NAME), parameter,
					new JRBeanCollectionDataSource(beans));
		} catch (JRException e) {
			e.printStackTrace();
		}
		return null;
	}
}