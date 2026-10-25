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
import net.minecraft.util.Mth
import xyz.lunalna.lunasmod.Lunasmod
import kotlin.math.cos
import kotlin.math.sin

class MaxiModel(root: ModelPart) : EntityModel<LivingEntityRenderState>(root) {
    private val head = root.getChild("head")
    private val tail = root.getChild("tail")
    private val rightFrontLeg = root.getChild("right_front_leg")
    private val leftFrontLeg = root.getChild("left_front_leg")
    private val rightHindLeg = root.getChild("right_hind_leg")
    private val leftHindLeg = root.getChild("left_hind_leg")

    override fun setupAnim(state: LivingEntityRenderState) {
        super.setupAnim(state)
        head.yRot = state.yRot * Mth.DEG_TO_RAD
        head.xRot = state.xRot * Mth.DEG_TO_RAD
        tail.yRot = sin(state.ageInTicks * 0.3f) * 0.4f

        // values stolen from pig modeL
        val amplitude = 1.4f
        val freq = 0.6662f

        rightFrontLeg.xRot = cos(state.walkAnimationPos * freq + 0) * amplitude * state.walkAnimationSpeed
        leftHindLeg.xRot = cos(state.walkAnimationPos * freq + 0) * amplitude * state.walkAnimationSpeed
        //we need to use Mth.pi instead of Math.pi because minecraft wants float value instead of double like in standard library
        leftFrontLeg.xRot = cos(state.walkAnimationPos * freq + Mth.PI) * amplitude * state.walkAnimationSpeed
        rightHindLeg.xRot = cos(state.walkAnimationPos * freq + Mth.PI) * amplitude * state.walkAnimationSpeed
    }

    companion object {
        val LAYER = ModelLayerLocation(Identifier.fromNamespaceAndPath(Lunasmod.ID, "maxi"), "main")

        fun createBodyLayer(): LayerDefinition {
            val mesh = MeshDefinition()
            val root = mesh.root
            root.addOrReplaceChild(
                "body",
                CubeListBuilder.create().texOffs(0, 0).addBox(-3.5f, -9f, -7.5f, 7f, 5f, 15f),
                PartPose.offset(0f, 24f, 0f),
            )
            root.addOrReplaceChild(
                "head",
                CubeListBuilder.create()
                    .texOffs(0, 20).addBox(-3f, -3f, -1.5f, 6f, 6f, 2f)
                    .texOffs(16, 27).addBox(-1f, 0f, -4f, 2f, 2f, 3f)
                    .texOffs(16, 32).addBox(0.5f, -5f, -1f, 2f, 2f, 1f)
                    .texOffs(22, 33).addBox(-2.5f, -5f, -1f, 2f, 2f, 1f),
                PartPose.offset(0f, 16f, -8f),
            )
            root.addOrReplaceChild(
                "tail",
                CubeListBuilder.create().texOffs(16, 20).addBox(0f, -1f, -1f, 1f, 1f, 6f),
                PartPose.offsetAndRotation(-0.5f, 17f, 8f, 0.6981f, 0f, 0f),
            )
            root.addOrReplaceChild("right_front_leg", leg(26, 27), PartPose.offset(-2f, 20f, -6f))
            root.addOrReplaceChild("left_front_leg", leg(30, 20), PartPose.offset(2f, 20f, -6f))
            root.addOrReplaceChild("right_hind_leg", leg(0, 28), PartPose.offset(-2f, 20f, 6f))
            root.addOrReplaceChild("left_hind_leg", leg(8, 28), PartPose.offset(2f, 20f, 6f))
            return LayerDefinition.create(mesh, 64, 64)
        }

        private fun leg(u: Int, v: Int) = CubeListBuilder.create().texOffs(u, v).addBox(-1f, 0f, -1f, 2f, 4f, 2f)
    }
}
