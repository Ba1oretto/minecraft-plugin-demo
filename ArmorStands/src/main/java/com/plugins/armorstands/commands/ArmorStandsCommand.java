package com.plugins.armorstands.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;
import org.jetbrains.annotations.NotNull;

public class ArmorStandsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            World playerWorld = player.getWorld();
            Location playerLocation = player.getLocation();
            ArmorStand armorStand = (ArmorStand) playerWorld.spawnEntity(new Location(
                    playerWorld, playerLocation.getX(), playerLocation.getY(), playerLocation.getZ()), EntityType.ARMOR_STAND);
            setArmorStand(armorStand);
            return true;
        }
        return false;
    }

    private void setArmorStand(ArmorStand armorStand) {
        armorStand.setCanMove(false);
        armorStand.setInvulnerable(true);
        armorStand.setGlowing(true);
        armorStand.setBasePlate(false);
        armorStand.setBodyPose(new EulerAngle(Math.toRadians(110), Math.toRadians(0), Math.toRadians(0)));
        armorStand.setHeadPose(new EulerAngle(Math.toRadians(35), Math.toRadians(0), Math.toRadians(0)));
        armorStand.setLeftLegPose(new EulerAngle(Math.toRadians(170), Math.toRadians(0), Math.toRadians(0)));
        armorStand.setRightLegPose(new EulerAngle(Math.toRadians(170), Math.toRadians(0), Math.toRadians(0)));
        armorStand.setRightArmPose(new EulerAngle(Math.toRadians(90), Math.toRadians(155), Math.toRadians(0)));
        armorStand.setItem(EquipmentSlot.HAND, new ItemStack(Material.REDSTONE));
    }
}
