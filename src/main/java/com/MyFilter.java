package com;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(value = "/")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();

        out.println("Filtro é chamado antes");

        chain.doFilter(request, response);

        out.println("Filtro é chamado depois");
    }

    @Override
    public void destroy() {
    }
}
