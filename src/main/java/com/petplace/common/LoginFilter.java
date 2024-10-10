package com.petplace.common;/**
 * packageName    : com.petplace.common
 * fileName       : LoginFilter
 * author         : jun
 * date           : 2024. 10. 10.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 10. 10.        jun       최초 생성
 */

import com.petplace.member.model.vo.Member;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jdk.jfr.Frequency;

import java.io.IOException;

@WebFilter(filterName = "adminCreateProduct.pd", value = "/adminCreateProduct.pd")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("로그인 필터 통과");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        Member loginUser = (Member) session.getAttribute("loginUser");
        if(loginUser == null){

            session.setAttribute("alertMsg","관리자만 접근이 가능합니다.");
            // 메인 페이지로 리다이렉트
            httpResponse.sendRedirect(httpRequest.getContextPath());
        }else if(loginUser.getStaus().equals('A')){
            chain.doFilter(request,response);
        }else{
            session.setAttribute("alertMsg","관리자만 접근이 가능합니다.");
            // 메인 페이지로 리다이렉트
            httpResponse.sendRedirect(httpRequest.getContextPath());
        }
        chain.doFilter(request, response);
    }
}
