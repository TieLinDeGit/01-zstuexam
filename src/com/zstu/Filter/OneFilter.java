package com.zstu.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        HttpSession session =null;
        String url =request.getRequestURI();
        if (url.indexOf("login")!=-1||"/zstuexam/".equals(url)){
            filterChain.doFilter( servletRequest, servletResponse);
            return;
        }
        session=request.getSession(false);
        if(session!=null){
            filterChain.doFilter( servletRequest, servletResponse);
            return;
        }
        request.getRequestDispatcher("/login.html").forward(servletRequest,servletResponse);
    }
}
