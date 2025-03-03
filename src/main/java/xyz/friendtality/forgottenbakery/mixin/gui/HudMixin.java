package xyz.friendtality.forgottenbakery.mixin.gui;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import xyz.friendtality.forgottenbakery.common.mobeffects.FBMobEffects;

import java.util.List;



@Mixin(Gui.class)
public class HudMixin {

    private static final ResourceLocation FOOD_EMPTY_HUNGER_SPRITE = ResourceLocation.withDefaultNamespace("hud/food_empty_hunger");
    private static final ResourceLocation FOOD_HALF_HUNGER_SPRITE = ResourceLocation.withDefaultNamespace("hud/food_half_hunger");
    private static final ResourceLocation FOOD_FULL_HUNGER_SPRITE = ResourceLocation.withDefaultNamespace("hud/food_full_hunger");

    @Inject(method = "renderFood" ,at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;getFoodData()Lnet/minecraft/world/food/FoodData;"))
    private void injection(GuiGraphics guiGraphics, Player player, int y, int x, CallbackInfo ci, @Local(ordinal = 0) LocalRef<ResourceLocation> resourcelocation , @Local(ordinal=1) LocalRef<ResourceLocation> resourcelocation1,  @Local(ordinal = 2) LocalRef<ResourceLocation> resourcelocation2 ){
        if(player.hasEffect(FBMobEffects.GLUTTONY)){
        resourcelocation.set(FOOD_EMPTY_HUNGER_SPRITE);
            resourcelocation1.set(FOOD_HALF_HUNGER_SPRITE);
            resourcelocation2.set(FOOD_FULL_HUNGER_SPRITE);

        }
    }

}
