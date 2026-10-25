package xyz.lunalna.lunasmod.client

import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.client.renderer.entity.MobRenderer
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState
import net.minecraft.core.BlockPos
import net.minecraft.resources.Identifier
import xyz.lunalna.lunasmod.Lunasmod
import xyz.lunalna.lunasmod.entity.Maxi

class MaxiRenderState : LivingEntityRenderState() {
    var angry = false
}

class MaxiRenderer(ctx: EntityRendererProvider.Context) :
    MobRenderer<Maxi, MaxiRenderState, MaxiModel>(ctx, MaxiModel(ctx.bakeLayer(MaxiModel.LAYER)), 0.3f) {

    override fun createRenderState() = MaxiRenderState()

    // we should only send aggresssive state to client so it can paint the thing red
    override fun extractRenderState(entity: Maxi, state: MaxiRenderState, partialTick: Float) {
        super.extractRenderState(entity, state, partialTick)
        state.angry = entity.isAggressive
    }

    // red
    override fun getModelTint(state: MaxiRenderState) = if (state.angry) 0xFFFF4040.toInt() else -1

    override fun getTextureLocation(state: MaxiRenderState): Identifier = TEXTURE

    companion object {
        private val TEXTURE = Identifier.fromNamespaceAndPath(Lunasmod.ID, "textures/entity/maxi.png")
    }
}
