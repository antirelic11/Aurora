package com.github.antirelic11.nebula.secret;

import com.github.antirelic11.nebula.commands.SmokeDetectorCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SmokeDetector {
    private int ticks = 0;
    private static final int interval = 15;

    public SmokeDetector() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void triggerSmokeDetector() {
        if (Minecraft.getMinecraft().thePlayer != null) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("hello"));
        }
        ticks++;
        if (ticks >= interval) {
            new SmokeDetectorCommand().smokeDetectorSound();
            ticks = 0;
        }
    }
}
