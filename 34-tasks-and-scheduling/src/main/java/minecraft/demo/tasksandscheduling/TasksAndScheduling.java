package minecraft.demo.tasksandscheduling;

import minecraft.demo.tasksandscheduling.tasks.CoolTask;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public final class TasksAndScheduling extends JavaPlugin {

    @Override
    public void onEnable() {
        BukkitTask coolTask = new CoolTask(this, 5).runTaskTimer(this, 0L, 40L);
        new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.run();
    }
}
