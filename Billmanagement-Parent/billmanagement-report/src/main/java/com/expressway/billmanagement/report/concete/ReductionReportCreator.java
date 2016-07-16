package com.expressway.billmanagement.report.concete;

import org.springframework.stereotype.Component;

import com.expressway.billmanagement.report.abstracts.AbstractReportCreator;
import com.expressway.billmanagement.report.annotations.ReportInfo;

/**
 * 免费车辆报表
 *
 * @author Ajaxfan
 */
@Component
@ReportInfo(name = "ReductionReport")
class ReductionReportCreator extends AbstractReportCreator {
}