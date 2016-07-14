package com.expressway.billmanagement.report.abstracts;

import java.util.List;
import java.util.Map;

import com.expressway.billmanagement.report.api.IReportCreator;

import net.sf.jasperreports.engine.JasperPrint;

/**
 * 创建报表对象
 *
 * @author Ajaxfan
 */
public abstract class AbstractReportCreator implements IReportCreator {
	/**
	 * 创建报表对象
	 * 
	 * @param parameter
	 *            报表参数
	 * @param beans
	 *            报表数据
	 * @return
	 */
	public abstract JasperPrint create(Map<String, Object> parameter, List<Object> beans);
}
