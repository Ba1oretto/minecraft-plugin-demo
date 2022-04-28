package minecraft.demo.silktouchspawners.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SpawnerBreakEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private boolean isCancelled;
    private final Player breaker;
    private final Block spawner;

    public SpawnerBreakEvent(Player breaker, Block spawner) {
        this.spawner = spawner;
        this.breaker = breaker;
        this.isCancelled = false;
    }



    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public Player getBreaker() {
        return breaker;
    }

    public Block getSpawner() {
        return spawner;
    }
}
