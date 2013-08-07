package com.joyin.ticm.common.enums;

/**
 * 生成业务编号枚举
 * @author xusong
 * @version 1.0
 * @since 2013-7-25, 下午09:06:28
 */
public enum BusinessType {
	// 格式：各业务枚举名称("业务实体","业务编号属性","业务编号开头")
    DEPOSIT("Deposit", "depid", "CK"), ADVANCE("Advance", "reqid", "TQ");

    private String objName;
    private String objIdName;
    private String preNum;

    private BusinessType(String objName, String objIdName, String preNum) {
        this.objName = objName;
        this.objIdName = objIdName;
        this.preNum = preNum;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public String getObjIdName() {
        return objIdName;
    }

    public void setObjIdName(String objIdName) {
        this.objIdName = objIdName;
    }

    public String getPreNum() {
        return preNum;
    }

    public void setPreNum(String preNum) {
        this.preNum = preNum;
    }
}
