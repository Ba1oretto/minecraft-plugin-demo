package minecraft.demo.motdplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class GoodWeatherListener implements Listener {
    @EventHandler
    public void onWeatherChangedEvent(WeatherChangeEvent event) {
        event.setCancelled(true);
    }
}
