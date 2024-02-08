package org.example.command.show;

import org.example.command.Command;
import org.example.data.User;
import org.example.data.UserType;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.example.Resources.PAGE_ADMIN_PANEL;
import static org.example.Resources.PAGE_CHAT;

public class ShowAdminPanelPageCommand implements Command  {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user.getUserType().equals(UserType.CLIENT)) {
            return new ForwardResult(PAGE_CHAT);
        }
        return new ForwardResult(PAGE_ADMIN_PANEL);
    }
}
