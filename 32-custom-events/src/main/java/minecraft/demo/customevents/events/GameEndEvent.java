package minecraft.demo.customevents.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class GameEndEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final Player winner;
    private final Player loser;

    private final int finalScore;

    public GameEndEvent(Player winner, Player loser, int finalScore) {
        this.winner = winner;
        this.loser = loser;
        this.finalScore = finalScore;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList () {
        return handlers;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getLoser() {
        return loser;
    }

    public int getFinalScore() {
        return finalScore;
    }
}
