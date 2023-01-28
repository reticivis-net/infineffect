package net.reticivis.infineffect.mixin;

import net.minecraft.entity.effect.StatusEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.entity.effect.StatusEffectUtil.class)
public class InfineffectMixin {
    @Inject(
        method = "durationToString",
        at = @At("HEAD")
    )
    private static void myMethodHead(
        StatusEffectInstance effect, float multiplier, CallbackInfoReturnable<String> cir
    ) {
        // permanent is set at net.minecraft.network.packet.s2c.play.EntityStatusEffectS2CPacket and is literally just
        // "this.duration >= 32767" so its easiest to just set it to false and move on with our lives
        effect.setPermanent(false);
    }
}
