package minecraft.demo.signs.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CustomSign implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;

        player.getWorld().getBlockAt(player.getLocation()).setType(Material.OAK_WALL_SIGN);

        Sign sign = (Sign) player.getWorld().getBlockAt(player.getLocation()).getState();

        sign.line(2, Component.text("big booty"));

        sign.update();

        return true;
    }
}
