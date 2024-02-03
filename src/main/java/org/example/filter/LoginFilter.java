package org.example.filter;

import org.example.command.action.LoginCommand;
import org.example.data.DataBase;
import org.example.data.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static org.example.Resources.PAGE_LOGIN;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        User userSession = (User) httpServletRequest.getSession().getAttribute("user");
        String loginInput = request.getParameter("loginInput");
        Optional<User> user = DataBase.findUserByLogin(loginInput);
        if (userSession == null) {
            if (user.isEmpty()) {
                HttpServletRequest httpServletRequest1 = (HttpServletRequest) request;
                httpServletRequest1.getRequestDispatcher(PAGE_LOGIN).forward(request, response);
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
