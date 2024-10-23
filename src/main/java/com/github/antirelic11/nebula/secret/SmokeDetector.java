package com.github.antirelic11.nebula.secret;

import com.github.antirelic11.nebula.commands.SmokeDetectorCommand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class SmokeDetector {
    private int ticks = 0;
    private static final int interval = 300;

    public SmokeDetector() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {

        ticks++;
        if (ticks >= interval) {
            new SmokeDetectorCommand().smokeDetectorSound();
            ticks = 0;
        }
    }
}
