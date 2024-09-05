package kz.mono.service;

public interface IMessageRouter {
    void routeToModerators(long userId, String message);
    void routeToUser(long userId, String message);
}
