package com.expressway.billmanagement.report.api;

import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperPrint;

/**
 * 报表服务接口
 *
 * @author Ajaxfan
 */
public interface IReportService {
	/** 三联单 */
	public static final int THREE_BILL = 1;
	/** 票据使用明细 */
	public static final int Bill_USE_DETAIL = 2;
	/** 车流量 */
	public static final int CAR_FLOW = 3;
	/** ETC报表 */
	public static final int ETC_REPORT = 4;
	/** MTC报表 */
	public static final int MTC_REPORT = 5;
	/** 免费车报表 */
	public static final int REDUCTION_REPORT = 6;
	/** 收费站车流量报表 */
	public static final int TOLL_GATE_CAR_FLOW = 7;

	/**
	 * @param parameters
	 * @param list
	 * @return
	 */
	public JasperPrint getPrintableObject(int reportType, Map<String, Object> parameters, List<Object> list);

	/**
	 * @param list
	 * @return
	 */
	public JasperPrint getPrintableObject(int reportType, List<Object> list);
}
