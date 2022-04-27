package minecraft.demo.titlepackets.commands;

import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.server.network.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;

public class PacketTitle implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 1) return false;
        if (!sender.hasPermission(Permission.DEFAULT_PERMISSION.toString())) return false;

        String targetName = args[0];
        Player target = Bukkit.getServer().getPlayer(targetName);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + targetName + ChatColor.WHITE + " is not a player.");
            return false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < args.length; i ++) {
            sb.append(args[i]).append(" ");
        }
        String titleString = sb.toString().stripTrailing();
        String title = ChatColor.translateAlternateColorCodes('&', titleString);
        PlayerConnection playerConnection = ((CraftPlayer) target.getPlayer()).getHandle().b;
        IChatBaseComponent text = IChatBaseComponent.ChatSerializer.a("{'text':'" + title + "'}");

        return true;
    }
}
