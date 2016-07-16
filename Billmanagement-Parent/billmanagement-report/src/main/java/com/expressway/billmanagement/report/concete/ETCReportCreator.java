package com.expressway.billmanagement.report.concete;

import org.springframework.stereotype.Component;

import com.expressway.billmanagement.report.abstracts.AbstractReportCreator;
import com.expressway.billmanagement.report.annotations.ReportInfo;

/**
 * ETC报表
 *
 * @author Ajaxfan
 */
@Component("etcreportCreator")
@ReportInfo(name="ETCReport")
class ETCReportCreator extends AbstractReportCreator {
}
