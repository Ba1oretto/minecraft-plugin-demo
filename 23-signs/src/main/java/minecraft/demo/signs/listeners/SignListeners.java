package minecraft.demo.signs.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignListeners implements Listener {

    @EventHandler
    public void onSignChanged(SignChangeEvent event) {
        event.getBlock().setType(Material.DIAMOND_BLOCK);
    }
}
