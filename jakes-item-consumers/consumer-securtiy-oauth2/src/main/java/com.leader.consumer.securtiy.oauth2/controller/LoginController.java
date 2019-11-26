package com.leader.consumer.securtiy.oauth2.controller;

import com.google.common.collect.Maps;
import com.leader.common.exploit.StringUtils;
import com.leader.common.web.OkHttpClientUtil;
import com.leader.common.web.ResponseResult;
import com.leader.common.web.ResultUtil;
import com.leader.provider.api.domain.custom.LoginUserInfo;
import com.leader.provider.api.domain.custom.UserEun;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private static final String URL_OAUTH_TOKEN = "http://localhost:8090/oauth/token";

    @Value("${common.oauth.grant_type}")
    public String grantType;

    @Value("${common.oauth.client_id}")
    public String clientId;

    @Value("${common.oauth.client_secret}")
    public String clientSecret;

    @Resource(name = "userDetailsService")
    UserDetailsService userDetailsService;

    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Resource
    TokenStore tokenStore;

    @PostMapping("/user/login")
    public ResponseResult<Map<String, Object>> login(@RequestBody UserEun userEun) throws IOException {

        UserDetails userDetails = userDetailsService.loadUserByUsername(userEun.getUsername());
        if (userDetails == null || !bCryptPasswordEncoder.matches(userEun.getPassword(), userDetails.getPassword())) {
            return new ResultUtil().error(50000, "用户名或密码错误");
        }
        Map<String, String> data = Maps.newHashMap();
        data.put("username", userEun.getUsername());
        data.put("password", userEun.getPassword());
        data.put("grant_type", grantType);
        data.put("client_id", clientId);
        data.put("client_secret", clientSecret);
        Response response = OkHttpClientUtil.getInstance().postData(URL_OAUTH_TOKEN, data);
        String arr = response.body().string();
        logger.info("Arr ---- " + arr);
        Map<String, Object> map = StringUtils.toMap(arr);
        Map<String, Object> responseOut = new HashMap<>();
        for (String key : map.keySet()) {
            logger.info("key：" + key + "  value：" + map.get(key));
        }
        responseOut.put("token", map.get("access_token"));
        return new ResultUtil().success(responseOut);
    }

    /**
     * 实现token获取
     *
     * @return
     */
    @GetMapping(value = "/user/info")
    public ResponseResult<LoginUserInfo> info() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUserInfo loginUserInfo = new LoginUserInfo();
        loginUserInfo.setName(authentication.getName());
        return new ResultUtil().success(loginUserInfo);
    }

    /**
     * 删除Token
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/user/logout")
    public ResponseResult<Void> logOut(HttpServletRequest request) {
        String token = request.getParameter("access_token");
        OAuth2AccessToken auth2AccessToken = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(auth2AccessToken);
        return new ResultUtil().success(null);
    }

}

