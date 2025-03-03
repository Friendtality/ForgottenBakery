package xyz.friendtality.forgottenbakery.common.mobeffects;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.friendtality.forgottenbakery.ForrgottenBakery;

import java.util.function.Supplier;

public class FBMobEffects {
    public static final DeferredRegister<MobEffect> FB_MOB_EFFECT = DeferredRegister.create(Registries.MOB_EFFECT, ForrgottenBakery.MODID);

    public static final DeferredHolder<MobEffect, GluttonousMobEffect> GLUTTONY = FB_MOB_EFFECT.register("gluttony", ()-> new GluttonousMobEffect(MobEffectCategory.HARMFUL,0x8f004f));

    public static void register(IEventBus eventBus){
        FB_MOB_EFFECT.register(eventBus);
    }
}
