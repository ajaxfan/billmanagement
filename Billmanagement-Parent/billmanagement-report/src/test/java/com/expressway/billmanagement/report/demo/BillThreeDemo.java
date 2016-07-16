package com.expressway.billmanagement.report.demo;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.expressway.billmanagement.data.models.BillThree;
import com.expressway.billmanagement.report.api.IReportService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;

public class BillThreeDemo {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-report.xml");
		IReportService dao = (IReportService) context.getBean("reportService");
		try {
			print(dao.getPrintableObject(IReportService.THREE_BILL, createList()));
		} catch (JRException e) {
			e.printStackTrace();
		}
		context.close();
	}

	private static List createList() {
		List list = new ArrayList();

		for (int i = 0; i < 3; i++) {
			BillThree bean = new BillThree();
			bean.setArrears("456798");
			bean.setBillCount("1245679");
			bean.setBillName("LSWER879864564");
			bean.setBillNo("234234-234234, 1231456-897987, 456456-234234");
			bean.setFreeCar("2342234");
			bean.setHarvester("234234");
			bean.setInvalidCard("242344");
			bean.setManageCar("2342342");
			bean.setMilitaryVehicle("45645654");
			bean.setNoCard("4564544");
			bean.setPassCar("5645456");
			bean.setReceivableCard("45645645");
			bean.setReceivableInvalid("234234");
			bean.setReceiveCard("234234");
			bean.setReceiveInvalid("5656565");
			bean.setTotalFare("2222222");
			bean.setUcrossCar("2342342");
			bean.setUrgentCar("1234678");

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
