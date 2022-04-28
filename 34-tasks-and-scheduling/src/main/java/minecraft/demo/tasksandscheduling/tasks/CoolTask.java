package minecraft.demo.tasksandscheduling.tasks;

import minecraft.demo.tasksandscheduling.TasksAndScheduling;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Range;

public class CoolTask extends BukkitRunnable {
    private final TasksAndScheduling plugin;
    private int counter;

    public CoolTask(TasksAndScheduling plugin, @Range(from = 1L, to = Integer.MAX_VALUE) int counter) {
        this.plugin = plugin;
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.println("TASK HAS BEEN RUN!!!");
        if (this.counter > 1) this.counter --;
        else this.cancel();
    }
}
