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

        if (args.length == 0) {
            player.getWorld().getBlockAt(player.getLocation()).setType(Material.OAK_WALL_SIGN);
        } else if (args.length == 2) {
            int lineNumber = Integer.parseInt(args[0] + "");
            if (lineNumber > 4 || lineNumber < 1) {
                player.sendMessage("You need to provide an available line");
                return false;
            }
            player.getWorld().getBlockAt(player.getLocation()).setType(Material.OAK_WALL_SIGN);
            Sign sign = (Sign) player.getWorld().getBlockAt(player.getLocation()).getState();
            sign.line(lineNumber - 1, Component.text(args[1]));
            sign.update();
        } else {
            player.sendMessage("Arguments not match");
            return false;
        }

        return true;
    }
}
