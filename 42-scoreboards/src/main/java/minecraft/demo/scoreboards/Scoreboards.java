package minecraft.demo.scoreboards;

import minecraft.demo.scoreboards.commands.ScoreBoardCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Scoreboards extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("42-scoreboard").setExecutor(new ScoreBoardCommand());
    }

}
