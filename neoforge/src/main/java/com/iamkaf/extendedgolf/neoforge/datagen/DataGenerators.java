package com.iamkaf.extendedgolf.neoforge.datagen;

import com.iamkaf.extendedgolf.ExtendedGolf;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = ExtendedGolf.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        BlockTagsProvider blockTagsProvider =
                new ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(true, blockTagsProvider);
        generator.addProvider(true,
                new ModItemTagProvider(packOutput,
                        lookupProvider,
                        blockTagsProvider.contentsGetter(),
                        existingFileHelper
                )
        );

        generator.addProvider(true, new ModLanguageProvider(packOutput));
    }
}