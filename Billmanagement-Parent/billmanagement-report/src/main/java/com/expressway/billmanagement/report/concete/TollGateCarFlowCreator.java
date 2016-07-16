package com.expressway.billmanagement.report.concete;

import org.springframework.stereotype.Component;

import com.expressway.billmanagement.report.abstracts.AbstractReportCreator;
import com.expressway.billmanagement.report.annotations.ReportInfo;

/**
 * 收费站车流量报表
 *
 * @author Ajaxfan
 */
@Component
@ReportInfo(name = "TollGateCarFlow")
class TollGateCarFlowCreator extends AbstractReportCreator {
}