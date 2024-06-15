package models;

import strategies.BotPlayingStrategy;
import strategies.BotPlayingStrategyFactory;

public class Bot extends Player {
    BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;

    public Bot(int id, String name, BotDifficultyLevel botDifficultyLevel, Symbol playerSymbol) {
        super(id, name, PlayerType.BOT, playerSymbol);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyByDifficulty(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return this.botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("Bot is thinking..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Move botMove = botPlayingStrategy.makeMove(board);
        botMove.setPlayer(this);
        return botMove;
    }
}
