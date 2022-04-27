package minecraft.demo.randomtpplugin.commands;

import minecraft.demo.randomtpplugin.utils.CustomConfigUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class RandomTPCommand implements CommandExecutor {
    private final Map<Player, Long> cooldownTable;
    private final Set<Material> badBlock;

    public RandomTPCommand() {
        cooldownTable = new HashMap<>();
    }

    {
        badBlock = new HashSet<>();
        badBlock.add(Material.FIRE);
        badBlock.add(Material.LAVA);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;

        if (args.length > 1) return false;

        if (player.hasPermission(Permission.DEFAULT_PERMISSION.name()) && args.length == 1) {
            String targetName = args[0];
            Player target = player.getServer().getPlayer(targetName);
            if (target == null) return false;
            target.teleport(this.randomLocation(target));
            target.sendMessage("You are teleported by " + player.getDisplayName());
            player.sendMessage("Your teleport command executed");
            return true;
        }

        if (!cooldownTable.containsKey(player)) {
            cooldownTable.put(player, System.currentTimeMillis());
            player.teleport(this.randomLocation(player));
            player.sendMessage("You are teleport to a new position");
            return true;
        }

        long cooldown = CustomConfigUtils.get().getLong("cooldown");
        long timeElapsed = System.currentTimeMillis() - cooldownTable.get(player);

        if (timeElapsed >= cooldown) {
            cooldownTable.replace(player, System.currentTimeMillis());
            player.teleport(this.randomLocation(player));
            player.sendMessage("You are teleport to a new position");
        } else {
            player.sendMessage("You must be waiting " + (cooldown - timeElapsed) + " to teleport again!");
            return false;
        }

        return true;
    }

    private Location randomLocation(Player player) {
        Random random = new Random();

        int rawX = (int) player.getLocation().getX();
        int rawZ = (int) player.getLocation().getZ();

        World world = player.getWorld();

        while (true) {
            int x;
            int z;

            if (CustomConfigUtils.get().getBoolean("world-border")) {
                x = rawX + random.nextInt(CustomConfigUtils.get().getInt("randomX"));
                z = rawZ + random.nextInt(CustomConfigUtils.get().getInt("randomZ"));
            } else {
                x = rawX + random.nextInt(99999);
                z = rawZ + random.nextInt(99999);
            }

            int y = world.getHighestBlockYAt(x, z) + 1;
            Location location = new Location(player.getWorld(), x, y, z);
            if (isSafety(location)) return location;
        }
    }

    private Boolean isSafety(Location location) {
        int blockX = location.getBlockX();
        int blockY = location.getBlockY();
        int blockZ = location.getBlockZ();

        Block block = location.getWorld().getBlockAt(blockX, blockY, blockZ);
        Block below = location.getWorld().getBlockAt(blockX, blockY - 1, blockZ);
        Block above = location.getWorld().getBlockAt(blockX, blockY + 1, blockZ);

        boolean isSolid = block.isSolid() || above.isSolid();

        return !isSolid && below.isSolid() && !badBlock.contains(below.getType());
    }
}
