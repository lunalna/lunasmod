package xyz.lunalna.lunasmod

import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import xyz.lunalna.lunasmod.block.ModBlocks
import xyz.lunalna.lunasmod.entity.Maxi
import xyz.lunalna.lunasmod.entity.ModEntities

@Mod(Lunasmod.ID)
object Lunasmod {
    const val ID = "lunasmod"

    val LOGGER: Logger = LogManager.getLogger(ID)

    init {
        ModBlocks.REGISTRY.register(MOD_BUS)
        ModEntities.REGISTRY.register(MOD_BUS)

        MOD_BUS.addListener<EntityAttributeCreationEvent> {
            it.put(ModEntities.MAXI.get(), Maxi.createAttributes().build())
        }
    }
}
