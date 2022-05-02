package minecraft.demo.commandmanagers.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ExplodeCommand extends SubCommands {

    public ExplodeCommand() {
        super.name = "explode";
        super.description = "Explode a player into smithereens";
        super.syntax = "/prank explode <player>";
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    String getDescription() {
        return super.description;
    }

    @Override
    String getSyntax() {
        return super.syntax;
    }

    @Override
    public void perform(Player player, String ...args) {
        if (args.length != 1) return;
        String targetName = args[0];
        Player target = Bukkit.getPlayer(targetName);
        if (target == null) return;
        target.playSound(target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
        target.setHealth(0.0);
        target.sendMessage("You just got exploded son!");
        player.sendMessage("You successfully bombed " + targetName);
    }
}
