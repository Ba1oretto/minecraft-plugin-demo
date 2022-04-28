package minecraft.demo.customevents.listeners;

import minecraft.demo.customevents.events.GameEndEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GameListeners implements Listener {
    @EventHandler
    public void onGameEnd(GameEndEvent event) {
        Bukkit.getServer().broadcastMessage("Game has ended!");
        Bukkit.getServer().broadcastMessage("Winner: " + event.getWinner().getName());
        Bukkit.getServer().broadcastMessage("Loser: " + event.getLoser().getName());
    }
}
