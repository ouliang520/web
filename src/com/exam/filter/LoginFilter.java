package com.exam.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        HttpServletResponse response =(HttpServletResponse)servletResponse;
        HttpSession session =request.getSession(false);
        String url =request.getRequestURI();
        if (url.contains("login") ||"/myWeb/".equals(url)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }else if (session != null) {
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //跳回登录界面

        request.getRequestDispatcher("/login_error2.html").forward(servletRequest,servletResponse);
        }
    }

