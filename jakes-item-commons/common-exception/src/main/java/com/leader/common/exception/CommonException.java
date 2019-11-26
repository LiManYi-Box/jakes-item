package com.leader.common.exception;

public class CommonException extends HqBaseException {

    public CommonException(String errCode, String desc) {
        super(errCode, desc);
    }

    public CommonException(String errCode, String desc, Throwable causeBy) {
        super(errCode, desc, causeBy);
    }

    public CommonException(CommonErrCode errCode) {
        super(errCode.getCode(), errCode.getDesc());
    }

    public CommonException(CommonErrCode errCode, Throwable causeBy) {
        super(errCode.getCode(), errCode.getDesc(), causeBy);
    }

    public CommonException(CommonErrCode errCode, String desc) {
        super(errCode.getCode(), desc);
    }

    public CommonException(CommonErrCode errCode, String desc, Throwable causeBy) {
        super(errCode.getCode(), desc, causeBy);
    }

}



