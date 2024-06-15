
package strategies;

import models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyByDifficulty(BotDifficultyLevel botDifficultyLevel) {
        if (botDifficultyLevel==BotDifficultyLevel.EASY) {
            return new EasyBotPlayingStategy();
        }

        return null;
    }
}
