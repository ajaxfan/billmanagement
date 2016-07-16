package com.expressway.billmanagement.report.concete;

import org.springframework.stereotype.Component;

import com.expressway.billmanagement.report.abstracts.AbstractReportCreator;
import com.expressway.billmanagement.report.annotations.ReportInfo;

/**
 * 票据使用明细
 *
 * @author Ajaxfan
 */
@Component
@ReportInfo(name = "BillUseDetail")
class BillUseDetailCreator extends AbstractReportCreator {
}
