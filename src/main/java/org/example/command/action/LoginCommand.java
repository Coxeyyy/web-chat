package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.data.UserType;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Optional;

import static org.example.Resources.*;

public class LoginCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        String loginInput = request.getParameter("loginInput");
        String passwordInput = request.getParameter("passwordInput");
        Optional<User> user = DataBase.findUserByLogin(loginInput);
        HttpSession session = request.getSession();
        request.getServletContext().setAttribute("listUser", DataBase.listUser);
        if(user.isPresent() && user.get().getPassword().equals(passwordInput)) {
            user.get().setOnline(true);
            request.getSession(true);
            session.setAttribute("user", user.get());
            if(user.get().getUserType().equals(UserType.ADMIN)) {
                return new RedirectResult(COMMAND_SHOW_ADMIN_PANEL);
            }
            return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
        } else {
            session.setAttribute("errorLoginMessage", "Invalid login or password");
            return new RedirectResult(COMMAND_SHOW_LOGIN_PAGE);
        }
    }
}
