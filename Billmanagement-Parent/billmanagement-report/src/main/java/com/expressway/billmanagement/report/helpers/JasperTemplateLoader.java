package com.expressway.billmanagement.report.helpers;

import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * 模板加载工具
 *
 * @author Ajaxfan
 */
@Component
public final class JasperTemplateLoader {
	/** 模板的安放路径 */
	private static final String TEMPLATE_PATH = "/com/expressway/billmanagement/report/resources/";

	/**
	 * 报表模板文件
	 * 
	 * @param fileName
	 *            模板文件名称
	 * @return
	 */
	public synchronized static JasperReport load(String fileName) {
		try {
			return (JasperReport) JRLoader
					.loadObject(JasperTemplateLoader.class.getResourceAsStream(TEMPLATE_PATH + fileName));
		} catch (JRException e) {
			e.printStackTrace();
		}
		return null;
	}
}
