package com.expressway.billmanagement.report.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 报表类型信息
 * 
 * @author Ajaxfan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ReportInfo {
    /** 报表名称 */
    String name();

    /** 后缀名称 */
    String suffix() default ".jasper";
}
