package xyz.lunalna.lunasmod.entity

import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.PathfinderMob
import net.minecraft.world.entity.ai.attributes.AttributeSupplier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.ai.goal.GoalSelector
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal
import net.minecraft.world.entity.ai.goal.RandomStrollGoal
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level

class Maxi(type: EntityType<out Maxi>, level: Level) : PathfinderMob(type, level) {
    override fun registerGoals() {
        goalSelector.addGoal(99, RandomStrollGoal(this, 1.0))
        // the dog will be very evil and stare at you even if you are 10 blocks away o.o
        goalSelector.addGoal(67, LookAtPlayerGoal(this, Player::class.java, 10f))
        targetSelector.addGoal(42, HurtByTargetGoal(this))
        // idk if this belongs in the target selector but it works so dont fix it :D
        targetSelector.addGoal(12, MeleeAttackGoal(this, 1.5, true))
    }

    companion object {
        fun createAttributes(): AttributeSupplier.Builder = createMobAttributes()
            // super buff animal
            .add(Attributes.MAX_HEALTH, 20.0)
            .add(Attributes.MOVEMENT_SPEED, 0.3)
            .add(Attributes.ATTACK_DAMAGE, 3.0)
    }
}
