package com.github.antirelic11.nebula;

import com.github.antirelic11.nebula.commands.IsNebulaRunningCommand;
import com.github.antirelic11.nebula.commands.SmokeDetectorCommand;
import com.github.antirelic11.nebula.secret.SmokeDetector;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod(modid = "nebula", useMetadata=true)
public class Nebula {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new SmokeDetector());
        ClientCommandHandler.instance.registerCommand(new IsNebulaRunningCommand());
        ClientCommandHandler.instance.registerCommand(new SmokeDetectorCommand());
    }

    public static GuiScreen screenToOpenNextTick = null;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) return;
        if (screenToOpenNextTick != null) {
            Minecraft.getMinecraft().displayGuiScreen(screenToOpenNextTick);
            screenToOpenNextTick = null;
        }
    }
}
