package kz.mono.service;

public interface IMessageService {
    void saveMessage(long userId, String message);
    String getMessage(long userId);
    boolean isUserMessage(long userId);
    boolean isModeratorMessage(String message);
}
