package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.Message;
import org.example.data.User;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class UserSendMessageCommand implements Command {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String message = request.getParameter("message");
        User user = (User) session.getAttribute("user");
        if (user.isWriteMessages() && !message.isEmpty()) {
            DataBase.listMessage.add(new Message(user.getLogin(), message));
        }
        request.getServletContext().setAttribute("listMessage", DataBase.listMessage);
        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
