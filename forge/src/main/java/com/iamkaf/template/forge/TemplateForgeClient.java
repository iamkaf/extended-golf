package com.iamkaf.template.forge;

import com.iamkaf.template.Template;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

public class TemplateForgeClient {
    @Mod.EventBusSubscriber(modid = Template.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value =
            Dist.CLIENT)
    public static class ModBus {
        @SubscribeEvent
        public static void onConstructMod(final FMLConstructModEvent evt) {
//            TemplateClient.init();
        }
    }

    @Mod.EventBusSubscriber(modid = Template.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value =
            Dist.CLIENT)
    public static class ForgeBus {

    }
}

