package xyz.lunalna.lunasmod.client

import net.minecraft.client.model.EntityModel
import net.minecraft.client.model.geom.ModelLayerLocation
import net.minecraft.client.model.geom.ModelPart
import net.minecraft.client.model.geom.PartPose
import net.minecraft.client.model.geom.builders.CubeListBuilder
import net.minecraft.client.model.geom.builders.LayerDefinition
import net.minecraft.client.model.geom.builders.MeshDefinition
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState
import net.minecraft.resources.Identifier
import xyz.lunalna.lunasmod.Lunasmod

class MaxiModel(root: ModelPart) : EntityModel<LivingEntityRenderState>(root) {
    companion object {
        val LAYER = ModelLayerLocation(Identifier.fromNamespaceAndPath(Lunasmod.ID, "maxi"), "main")

        fun createBodyLayer(): LayerDefinition {
            val mesh = MeshDefinition()
            val main = mesh.root.addOrReplaceChild(
                "bb_main",
                CubeListBuilder.create()
                    .texOffs(26, 27).addBox(-3f, -4f, -7f, 2f, 4f, 2f)
                    .texOffs(0, 28).addBox(-3f, -4f, 5f, 2f, 4f, 2f)
                    .texOffs(8, 28).addBox(1f, -4f, 5f, 2f, 4f, 2f)
                    .texOffs(30, 20).addBox(1f, -4f, -7f, 2f, 4f, 2f)
                    .texOffs(0, 0).addBox(-3.5f, -9f, -7.5f, 7f, 5f, 15f)
                    .texOffs(0, 20).addBox(-3f, -11f, -9.5f, 6f, 6f, 2f)
                    .texOffs(16, 27).addBox(-1f, -8f, -12f, 2f, 2f, 3f)
                    .texOffs(16, 32).addBox(0.5f, -13f, -9f, 2f, 2f, 1f)
                    .texOffs(22, 33).addBox(-2.5f, -13f, -9f, 2f, 2f, 1f),
                PartPose.offset(0f, 24f, 0f),
            )
            main.addOrReplaceChild(
                "cube_r1",
                CubeListBuilder.create().texOffs(16, 20).addBox(0f, -1f, -1f, 1f, 1f, 6f),
                PartPose.offsetAndRotation(-0.5f, -7f, 8f, 0.6981f, 0f, 0f),
            )
            return LayerDefinition.create(mesh, 64, 64)
        }
    }
}
