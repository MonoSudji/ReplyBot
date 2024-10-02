package kz.mono.service.impl;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import kz.mono.service.IMessageRouter;

import java.util.List;

public class MessageRouter implements IMessageRouter {
    final TelegramBot bot;
    private final List<Long> moderatorIds;

    public MessageRouter(TelegramBot bot, List<Long> moderatorIds) {
        this.bot = bot;
        this.moderatorIds = moderatorIds;
    }

    public List<Long> getModeratorIds() {
        return moderatorIds;
    }

    public void routeToModerators(long userId, String message) {
        for (Long moderatorId : moderatorIds) {
            SendMessage sendMessage = new SendMessage(moderatorId, "Новое сообщение от пользователя " + userId + ": " + message + "\n\n" +
                    "Введите /reply <userId> <ответ> для ответа на это сообщение.");
            bot.execute(sendMessage);
        }
    }

    public void routeToUser(long userId, String message) {
        SendMessage sendMessage = new SendMessage(userId, message);
        bot.execute(sendMessage);
    }
}
