package kz.mono.service.impl;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import kz.mono.service.IMessageProcessor;
import kz.mono.service.IModeratorValidator;

public class MessageProcessor implements IMessageProcessor {
    private final MessageService messageService;
    private final MessageRouter messageRouter;
    private final IModeratorValidator moderatorValidator;
    private final TelegramBot bot;

    public MessageProcessor(MessageService messageService, MessageRouter messageRouter, IModeratorValidator moderatorValidator, TelegramBot bot) {
        this.messageService = messageService;
        this.messageRouter = messageRouter;
        this.moderatorValidator = moderatorValidator;
        this.bot = bot;
    }

    @Override
    public void processMessage(long chatId, String message) {
        long userId = chatId;

        if (messageService.isModeratorMessage(message)) {
            if (moderatorValidator.isModerator(userId)) {
                handleModeratorMessage(userId, message);
            } else {
                bot.execute(new SendMessage(userId, "Команда доступна только для модераторов."));
            }
        } else {
            handleUserMessage(userId, message);
        }
    }

    private void handleUserMessage(long userId, String message) {
        messageService.saveMessage(userId, message);
        messageRouter.routeToModerators(userId, message);
    }

    private void handleModeratorMessage(long moderatorId, String message) {
        if (message.startsWith("/reply")) {
            String[] parts = message.split(" ", 3);

            if (parts.length >= 3) {
                try {
                    long userId = Long.parseLong(parts[1].trim());
                    String reply = parts[2].trim();

                    messageRouter.routeToUser(userId, "Спасибо за ожидание. Вот ответ модератора: " + reply);
                } catch (NumberFormatException e) {
                    System.err.println("Неправильный ID пользователя: " + message);
                }
            } else {
                System.err.println("Вы ввели сообщение не по форме: " + message);
            }
        } else {
            System.err.println("Сообщение не начинается с /reply: " + message);
        }
    }
}
