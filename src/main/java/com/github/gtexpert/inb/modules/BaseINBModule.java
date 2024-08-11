package com.github.gtexpert.inb.modules;

import java.util.Collections;
import java.util.Set;

import net.minecraft.util.ResourceLocation;

import org.jetbrains.annotations.NotNull;

import com.github.gtexpert.inb.api.modules.IINBModule;
import com.github.gtexpert.inb.api.util.INBUtility;

public abstract class BaseINBModule implements IINBModule {

    @NotNull
    @Override
    public Set<ResourceLocation> getDependencyUids() {
        return Collections.singleton(INBUtility.inbId(INBModules.MODULE_CORE));
    }
}
