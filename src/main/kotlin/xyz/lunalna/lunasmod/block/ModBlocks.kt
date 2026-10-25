package xyz.lunalna.lunasmod.block

import net.neoforged.neoforge.registries.DeferredRegister
import xyz.lunalna.lunasmod.Lunasmod

// Needed for `val X by REGISTRY.register...` property delegates
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModBlocks {
    val REGISTRY: DeferredRegister.Blocks = DeferredRegister.createBlocks(Lunasmod.ID)
}
