package xyz.friendtality.forgottenbakery.mixin.structures;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.TrialChambersStructurePools;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.lwjgl.stb.STBIZlibCompress;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TrialChambersStructurePools.class)
public class TrialChamberPicesMixin {

    @Inject(method = "bootstrap", at = @At(value = "INVOKE", target = "registerTargetsAsPools"), cancellable = true)
    private static void bootstrap(BootstrapContext<StructureTemplatePool> context, CallbackInfo ci) {

    }
}
