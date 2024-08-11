package com.github.gtexpert.inb.common;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.github.gtexpert.inb.api.INBValues;

@Mod.EventBusSubscriber(modid = INBValues.MODID)
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {}
}
