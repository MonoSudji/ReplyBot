package kz.mono;

import kz.mono.bot.SupportBot;
import kz.mono.utils.JsonUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String token = "6338559400:AAH4CRBOdFCboJmXxosF_An6-Ss91VlU9Cs";

        List<Long> moderatorIds = JsonUtils.readModeratorIdsFromJson("src/main/resources/moderators.json");

        SupportBot supportBot = new SupportBot(token, moderatorIds);

        System.out.println("VPN Support Bot is running...");
    }
}
