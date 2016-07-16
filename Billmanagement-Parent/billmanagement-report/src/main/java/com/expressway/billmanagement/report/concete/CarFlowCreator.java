package com.expressway.billmanagement.report.concete;

import org.springframework.stereotype.Component;

import com.expressway.billmanagement.report.abstracts.AbstractReportCreator;
import com.expressway.billmanagement.report.annotations.ReportInfo;

/**
 * 车流量报表
 *
 * @author Ajaxfan
 */
@Component
@ReportInfo(name = "CarFlow")
class CarFlowCreator extends AbstractReportCreator {
}
