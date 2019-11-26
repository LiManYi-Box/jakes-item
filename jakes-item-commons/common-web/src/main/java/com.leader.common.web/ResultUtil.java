package com.leader.common.web;

public class ResultUtil {

    static class StatusCode{
        /**
         * 成功
         */
        private static final Integer OK = 20000;
        /**
         * 非法Token
         */
        private static final Integer ILLEGAL_TOKEN = 50008;
        /**
         * 其他账号登录
         */
        private static final Integer OTHER_CLIENTS_IN = 50012;
        /**
         * Token超时
         */
        private static final Integer TOKEN_EXPIRED = 50014;
        /**
         * 失败
         */
        private static final Integer EXPIRED = 50000;
    }



    /**
     * 请求成功返回
     *
     * @param object
     * @return
     */
    public static ResponseResult success(Object object) {
        ResponseResult msg = new ResponseResult();
        msg.setCode(StatusCode.OK);
        msg.setMessage("success");
        msg.setData(object);
        return msg;
    }

    public static ResponseResult success() {
        return success(null);
    }

    public static ResponseResult error(Integer code, String resultmsg) {
        ResponseResult msg = new ResponseResult();
        msg.setCode(code != null ? code : StatusCode.EXPIRED);
        msg.setMessage(resultmsg);
        return msg;
    }


}
