package xyz.lunalna.lunasmod.entity

import net.minecraft.world.entity.MobCategory
import net.neoforged.neoforge.registries.DeferredRegister
import xyz.lunalna.lunasmod.Lunasmod

object ModEntities {
    val REGISTRY: DeferredRegister.Entities = DeferredRegister.createEntities(Lunasmod.ID)

    val MAXI = REGISTRY.registerEntityType("maxi", ::Maxi, MobCategory.CREATURE) {
        it.sized(0.45f, 0.8f)
    }
}
