package kz.mono.service.impl;

import kz.mono.service.IMessageService;

import java.util.HashMap;
import java.util.Map;

public class MessageService  implements IMessageService {
    private final Map<Long, String> messageStorage = new HashMap<>();

    public void saveMessage(long userId, String message) {
        messageStorage.put(userId, message);
    }

    public String getMessage(long userId) {
        return messageStorage.get(userId);
    }

    public boolean isUserMessage(long userId) {
        return messageStorage.containsKey(userId);
    }

    public boolean isModeratorMessage(String message) {
        return message.startsWith("/reply");
    }
}
