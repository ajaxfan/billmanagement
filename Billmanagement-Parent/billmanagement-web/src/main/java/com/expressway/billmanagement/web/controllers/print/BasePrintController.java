package com.expressway.billmanagement.web.controllers.print;

import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

/**
 * 打印控制器基类
 * 
 * @author Ajaxfan
 */
abstract class BasePrintController {
    
    /**
     * 写出序列号对象到客户端
     * @param obj
     * @param response
     */
    protected void writeReportToClient(Object obj, HttpServletResponse response) {
        // 设置响应头
        response.setContentType("application/octet-stream");

        // 使用Object Stream的方式将可序列化对象，写出到客户端
        OutputStream streamOutPut = null;
        ObjectOutputStream objectOutput = null;

        try {
            streamOutPut = response.getOutputStream();
            objectOutput = new ObjectOutputStream(streamOutPut);

            objectOutput.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (objectOutput != null) {
                try {
                    objectOutput.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    objectOutput = null;
                }
            }
            if (streamOutPut != null) {
                try {
                    streamOutPut.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    streamOutPut = null;
                }
            }
        }
    }
}
