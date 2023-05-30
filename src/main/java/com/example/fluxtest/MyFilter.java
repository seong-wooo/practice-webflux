package com.example.fluxtest;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("필터 실행됨");

        HttpServletResponse servletResponse = (HttpServletResponse) response;
        servletResponse.setContentType("text/event-stream; charset=utf-8");
        PrintWriter out = servletResponse.getWriter();

        for (int i = 0; i < 5; i++) {
            out.print("응답: " + i + "\n");
            out.flush(); // 버퍼를 비우다.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}
