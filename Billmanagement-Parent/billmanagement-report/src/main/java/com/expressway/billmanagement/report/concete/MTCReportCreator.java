package com.expressway.billmanagement.report.concete;

import org.springframework.stereotype.Component;

import com.expressway.billmanagement.report.abstracts.AbstractReportCreator;
import com.expressway.billmanagement.report.annotations.ReportInfo;

/**
 * MTC报表
 *
 * @author Ajaxfan
 */
@Component("mtcreportCreator")
@ReportInfo(name = "MTCReport")
class MTCReportCreator extends AbstractReportCreator {
}