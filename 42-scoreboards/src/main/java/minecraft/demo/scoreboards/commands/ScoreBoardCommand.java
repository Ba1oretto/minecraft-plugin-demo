package minecraft.demo.scoreboards.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.NotNull;

public class ScoreBoardCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;

        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

        Objective scoreboardObjective = scoreboard.registerNewObjective("test", "dummy", Component.text("Scoreboard Title", TextColor.color(0, 0, 255)));

        scoreboardObjective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score1 = scoreboardObjective.getScore(ChatColor.GOLD + "Money: $" + ChatColor.GREEN + 1);
        score1.setScore(0);

        Score score2 = scoreboardObjective.getScore("");
        score2.setScore(114514);

        Score score3 = scoreboardObjective.getScore(ChatColor.DARK_PURPLE + "https://xvideos.com/");
        score3.setScore(1919810);

        player.setScoreboard(scoreboard);
        return true;
    }
}
