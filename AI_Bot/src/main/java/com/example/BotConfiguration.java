package com.example;

import com.example.Gemini.GeminiClient;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BotConfiguration {
    @Bean
    @SneakyThrows
    public Bot telegramBot(
            @Value("${bot.token}") String botToken,
            TelegramBotsApi telegramBotsApi,
            GeminiClient geminiClient
    ) {
        var botOptions = new DefaultBotOptions();
        var bot = new Bot(botOptions, botToken, geminiClient);
        telegramBotsApi.registerBot(bot);
        return bot;
    }

    @Bean
    @SneakyThrows
    public TelegramBotsApi telegramBotsApi() {
        return new TelegramBotsApi(DefaultBotSession.class);
    }
}
