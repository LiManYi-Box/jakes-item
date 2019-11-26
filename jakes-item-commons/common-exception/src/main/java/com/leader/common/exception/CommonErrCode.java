package com.leader.common.exception;

public enum CommonErrCode {

    NONE("000000", "OK"),

    LOGIN_INVALID("300000", "登录失效"),
    LOGIN_LOGGING("300001","已登陆"),

    ARGS_INVALID("400000", "请求参数有误"),
    UNPACK_ERROR("400001", "报文解析失败"),
    SIGN_INVALID("400010", "验签失败"),
    DECRYPT_ERROR("400020", "解密失败"),
    ACCESS_TOKEN_ERROR("400030","获取 ACESS_TOKEN 失败"),

    AUTH_TOKEN_INVALID("400300", "访问令牌非法"),
    NO_PERMISSION("400310", "没有访问权限"),
    NO_DATA_FOUND("400400", "没有数据"),

    NETWORK_ERROR("400500", "网络通讯故障"),

    BUSINESS("400600", "业务处理异常"),

    BAD_REQUEST("410000", "请求被拒绝"),

    SERVICE_NOT_EXISTS("420000", "服务不存在"),
    SERVICE_UNAVAILABLE("420001", "服务不可用"),
    SERVICE_ALREADY_EXISTS("420002", "服务已存在"),

    INTERNAL_SERVER_ERROR("500000", "服务器内部错误"),
    SERVICE_INVOKE_ERROR("500100", "服务调用出错"),
    DB_ERROR("500200", "数据库错误"),

    UNKNOW_ERROR("999999", "网络超时或未知异常"),

    ERROR("999998", "网络超时或未知异常"),
    AUTHCODE_ERROR("400700", "获取openId失败");

    String code;
    String desc;

    CommonErrCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
