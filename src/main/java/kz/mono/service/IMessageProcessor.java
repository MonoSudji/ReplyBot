package kz.mono.service;

public interface IMessageProcessor {
    void processMessage(long chatId, String message);
}
