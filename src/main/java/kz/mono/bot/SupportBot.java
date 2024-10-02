package kz.mono.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import kz.mono.service.impl.MessageProcessor;
import kz.mono.service.impl.MessageService;
import kz.mono.service.impl.MessageRouter;
import kz.mono.service.impl.ModeratorValidator;

import java.util.List;

public class SupportBot {
     final TelegramBot bot;
     final MessageService messageService;
     final MessageRouter messageRouter;
     final ModeratorValidator moderatorValidator;
     final MessageProcessor messageProcessor;

    public SupportBot(String token, List<Long> moderatorIds) {
        this.bot = new TelegramBot(token);
        this.messageService = new MessageService();
        this.messageRouter = new MessageRouter(bot, moderatorIds);
        this.moderatorValidator = new ModeratorValidator(moderatorIds);
        this.messageProcessor = new MessageProcessor(messageService, messageRouter, moderatorValidator, bot);

        bot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                messageProcessor.processMessage(update.message().chat().id(), update.message().text());
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}
