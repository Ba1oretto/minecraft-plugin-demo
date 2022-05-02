package minecraft.demo.wolfyutilities.window;

import me.wolfyscript.utilities.api.inventory.gui.GuiCluster;
import me.wolfyscript.utilities.api.inventory.gui.GuiUpdate;
import me.wolfyscript.utilities.api.inventory.gui.GuiWindow;
import me.wolfyscript.utilities.api.inventory.gui.button.buttons.DummyButton;
import minecraft.demo.wolfyutilities.cache.MyCache;
import minecraft.demo.wolfyutilities.cluster.CustomCluster;
import org.bukkit.Material;

public class CustomWindow extends GuiWindow<MyCache> {
    //These constants can be private because the Buttons are local and can only be accessed inside this GuiWindow!
    private static final String CUSTOM_LOCAL_BUTTON = "custom_local_button";

    public CustomWindow(GuiCluster<MyCache> guiCluster) {
        super(guiCluster, CustomCluster.CUSTOM_WINDOW.getKey(), 54); //Use the constant you defined in the the GuiCluster
    }

    @Override
    public void onInit() {
        //Called on initialization. Used to register Buttons.
        //For example create a dummy button and use the constant you defined on top!
        registerButton(new DummyButton(CUSTOM_LOCAL_BUTTON, Material.BARRIER));
    }

    @Override
    public void onUpdateSync(GuiUpdate<MyCache> update) {
        //Updated sync
        update.setButton(1, CUSTOM_LOCAL_BUTTON);
        update.setButton(2, CustomCluster.CUSTOM_GLOBAL_BUTTON);
        //As you can see... it can get quite messy if you don't use constants!
        //You would have duplicate Strings everywhere and it makes it more difficult to maintain!
    }

    @Override
    public void onUpdateAsync(GuiUpdate<MyCache> update) {
        //Updated async
    }

}
