package com.github.antirelic11.nebula.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import org.apache.logging.log4j.LogManager;

public class SmokeDetectorCommand extends CommandBase {

    private boolean toggleSmokeDetector = false;
    public void smokeDetectorSound() {
        if(toggleSmokeDetector) {
            if (Minecraft.getMinecraft().thePlayer != null) {
                Minecraft.getMinecraft().thePlayer.playSound("minecraft:note.pling", 1.0F, 1.0F);
            }
        }
    }

    @Override
    public String getCommandName() {
        return "smokedetector";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        LogManager.getLogger("SmokeDetectorMode").info("Plays a noteblock sound every 15 seconds.");
        String status = toggleSmokeDetector ? "OFF" : "ON";
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§cSmoke detector :§l " + status));
        toggleSmokeDetector = !toggleSmokeDetector;
    }
}
