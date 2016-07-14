package com.expressway.billmanagement.report.api;

import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperPrint;

/**
 * 报表生成器
 *
 * @author Ajaxfan
 */
public interface IReportCreator {
	/**
	 * 提供参数和数据，生成报表对象
	 * 
	 * @param parameters
	 * @param beans
	 * @return
	 */
	public JasperPrint create(Map<String, Object> parameters, List<Object> beans);
}
