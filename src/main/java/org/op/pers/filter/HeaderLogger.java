package org.op.pers.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Collections;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class HeaderLogger implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        log.info("----- Request ---------");
        Collections.list(req.getHeaderNames()).forEach(n -> log.info(n + ": " + req.getHeader(n)));

        chain.doFilter(request, response);

        log.info("----- response ---------");
        rep.getHeaderNames().forEach(n -> log.info(n + ": " + rep.getHeader(n)));

        log.info("response status: " + rep.getStatus());
    }

    @Override
    public void destroy() {
        //remove this
    }
}
