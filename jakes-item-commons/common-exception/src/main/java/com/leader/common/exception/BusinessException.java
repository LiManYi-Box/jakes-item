package com.leader.common.exception;


public class BusinessException extends HqBaseException {
    private static final long serialVersionUID = 4872379062283135112L;
    private String code;
    private String msg;

    public BusinessException() {
        super(CommonErrCode.BUSINESS.getCode(), CommonErrCode.BUSINESS.getDesc());
        this.msg = CommonErrCode.BUSINESS.desc;
        this.code = CommonErrCode.BUSINESS.code;
    }

    public BusinessException(String msg) {
        super(CommonErrCode.BUSINESS.getCode(), msg);
        this.msg = msg;
    }

    public BusinessException(String code, String msg) {
        super(code, msg);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}


