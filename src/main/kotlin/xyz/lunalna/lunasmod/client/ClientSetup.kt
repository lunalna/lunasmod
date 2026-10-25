package xyz.lunalna.lunasmod.client

import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.client.event.EntityRenderersEvent
import xyz.lunalna.lunasmod.Lunasmod
import xyz.lunalna.lunasmod.entity.ModEntities

@EventBusSubscriber(modid = Lunasmod.ID, value = [Dist.CLIENT])
object ClientSetup {
    @SubscribeEvent
    fun registerLayers(event: EntityRenderersEvent.RegisterLayerDefinitions) {
        event.registerLayerDefinition(MaxiModel.LAYER, MaxiModel::createBodyLayer)
    }

    @SubscribeEvent
    fun registerRenderers(event: EntityRenderersEvent.RegisterRenderers) {
        event.registerEntityRenderer(ModEntities.MAXI.get(), ::MaxiRenderer)
    }
}
