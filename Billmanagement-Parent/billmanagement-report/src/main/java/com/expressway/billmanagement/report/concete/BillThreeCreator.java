package com.expressway.billmanagement.report.concete;

import org.springframework.stereotype.Component;

import com.expressway.billmanagement.report.abstracts.AbstractReportCreator;
import com.expressway.billmanagement.report.annotations.ReportInfo;

/**
 * 三联单报表对象创建
 *
 * @author Ajaxfan
 */
@Component
@ReportInfo(name = "BillThree")
class BillThreeCreator extends AbstractReportCreator {
}
