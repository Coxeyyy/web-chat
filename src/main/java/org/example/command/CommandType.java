package org.example.command;

import org.example.command.action.BanUnbanUserMessageCommand;
import org.example.command.action.LoginCommand;
import org.example.command.action.UserSendMessageCommand;
import org.example.command.action.LogoutCommand;
import org.example.command.action.UserRefreshPageCommand;
import org.example.command.show.ShowChatPageCommand;
import org.example.command.show.ShowLoginPageCommand;
import org.example.command.show.ShowAdminPanelPageCommand;

public enum CommandType {
    EMPTY(new EmptyCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    USER_SEND_MESSAGE(new UserSendMessageCommand()),
    BAN_UNBAN_USER_MESSAGE(new BanUnbanUserMessageCommand()),
    USER_REFRESH_PAGE(new UserRefreshPageCommand()),

    SHOW_CHAT_PAGE(new ShowChatPageCommand()),
    SHOW_LOGIN_PAGE(new ShowLoginPageCommand()),
    SHOW_ADMINPANEL_PAGE(new ShowAdminPanelPageCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
