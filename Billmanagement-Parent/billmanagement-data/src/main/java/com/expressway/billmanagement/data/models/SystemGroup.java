package com.expressway.billmanagement.data.models;

import javax.persistence.Id;

import com.expressway.billmanagement.data.helpers.StringHelper;
import com.expressway.billmanagement.data.helpers.UUIDGenerator;

/**
 * 用户组
 * 
 * @author FXStudio.Ajaxfan
 */
public class SystemGroup {
    @Id
    private String sysid;
    private String groupname;
    private String remark;

    public String getSysid() {
        if (StringHelper.isNullOrEmpty(sysid)) {
            return UUIDGenerator.random();
        }
        return sysid;
    }

    public void setSysid(String sysid) {
        this.sysid = sysid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
