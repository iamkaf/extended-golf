package com.iamkaf.template.forge;

import com.iamkaf.template.Template;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Template.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public final class TemplateForge {
    public TemplateForge() {
        EventBuses.registerModEventBus(Template.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Template.init();
    }
}
