package kz.mono;

import kz.mono.bot.SupportBot;
import kz.mono.utils.JsonUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String token = "";

        List<Long> moderatorIds = JsonUtils.readModeratorIdsFromJson("src/main/resources/moderators.json");

        SupportBot supportBot = new SupportBot(token, moderatorIds);

        System.out.println("VPN Support Bot is running...");
    }
}
