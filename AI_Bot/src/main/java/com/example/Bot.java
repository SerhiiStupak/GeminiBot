import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    private static final Logger log = LoggerFactory.getLogger(Bot.class);

    public Bot(DefaultBotOptions botOptions, String botToken) {
        super(botOptions, botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            var text = update.getMessage().getText();
            var chatId = update.getMessage().getChatId();
            SendMessage sendMessage = new SendMessage(chatId.toString(), text);
            try {
                sendApiMethod(sendMessage);
            } catch (TelegramApiException e) {
                log.error("Exception while sending message", e);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "AI_445_bot";
    }
}
