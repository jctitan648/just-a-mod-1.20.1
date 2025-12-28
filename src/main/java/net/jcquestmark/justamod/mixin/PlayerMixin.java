package net.jcquestmark.justamod.mixin;

import net.jcquestmark.justamod.init.ModAttributes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin {
    @SuppressWarnings("unused")
    @Unique
    private Player just_a_mod$self() {
        return (Player) (Object) this;
    }

    @SuppressWarnings("InvalidInjectorMethodSignature")
    @Inject(method="createAttributes", at=@At("RETURN"))
    private static AttributeSupplier.Builder createCritAttributes(CallbackInfoReturnable<AttributeSupplier.Builder> cir) {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.ATTACK_DAMAGE, 1.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_SPEED)
                .add(Attributes.LUCK)
                .add(ForgeMod.BLOCK_REACH.get())
                .add(Attributes.ATTACK_KNOCKBACK)
                .add(ForgeMod.ENTITY_REACH.get())
                .add(ModAttributes.CRITICAL_CHANCE.get(), 0.0F)
                .add(ModAttributes.CRITICAL_DAMAGE.get(), 50.0F);
    }

    @SuppressWarnings("ParameterCanBeLocal")
    @Redirect(method = "attack", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/common/ForgeHooks;getCriticalHit(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/entity/Entity;ZF)Lnet/minecraftforge/event/entity/player/CriticalHitEvent;"))
    private CriticalHitEvent applyCritFormula(Player player, Entity target, boolean vanillaCritical, float damageModifier) {
        vanillaCritical = vanillaCritical || just_a_mod$rollCritChance(player);
        damageModifier = vanillaCritical ? 1.0f + ((float) player.getAttributeValue(ModAttributes.CRITICAL_DAMAGE.get()) / 100.0f) : 1.0f;

        CriticalHitEvent hitResult = new CriticalHitEvent(player, target, damageModifier, vanillaCritical);
        MinecraftForge.EVENT_BUS.post(hitResult);
        if (hitResult.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW || (vanillaCritical && hitResult.getResult() == net.minecraftforge.eventbus.api.Event.Result.DEFAULT))
        {
            return hitResult;
        }
        return null;
    }

    @Unique
    private boolean just_a_mod$rollCritChance(Player player) {
        return Math.random() * 100 < player.getAttributeValue(ModAttributes.CRITICAL_CHANCE.get());
    }
}
