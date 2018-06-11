package com.eastrise.xunwu.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录验证失败处理器
 * create by gzq on 2018/6/11 10:31
 */
public class LoginAuthFailHandler extends SimpleUrlAuthenticationFailureHandler{

    private final LoginUrlEntryPoint loginUrlEntryPoint;

    public LoginAuthFailHandler(LoginUrlEntryPoint loginUrlEntryPoint) {
        this.loginUrlEntryPoint = loginUrlEntryPoint;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String targetUrl = this.loginUrlEntryPoint.determineUrlToUseForThisRequest(request,response,exception);
        targetUrl += "?" + exception.getMessage();
        System.out.println(targetUrl);
        super.setDefaultFailureUrl(targetUrl);
        super.onAuthenticationFailure(request, response, exception);
    }
}
