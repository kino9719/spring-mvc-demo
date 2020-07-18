package com.example.filter;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Order(1)
@WebFilter(urlPatterns = {"/"}, dispatcherTypes = {DispatcherType.REQUEST})
public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpSession session = request.getSession(true);

        if (session.getAttribute("username") == null) {
            response.sendRedirect("/login");
            return;
        }

        chain.doFilter(request, response);
    }
}

