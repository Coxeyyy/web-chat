package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Optional;

import static org.example.Resources.COMMAND_SHOW_ADMIN_PANEL;

public class BanUnbanUserMessageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        String loginInput = request.getParameter("loginInput");
        Optional<User> user = DataBase.findUserByLogin(loginInput);
        if(user.isPresent() && user.get().isWriteMessages()) {
            user.get().setWriteMessages(false);
        } else {
            user.get().setWriteMessages(true);
        }
        return new RedirectResult(COMMAND_SHOW_ADMIN_PANEL);
    }
}
