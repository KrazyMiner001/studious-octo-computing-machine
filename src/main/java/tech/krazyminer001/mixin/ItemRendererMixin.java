package tech.krazyminer001.mixin;

import tech.krazyminer001.OctoComputing;
import tech.krazyminer001.compat.Mods;
import tech.krazyminer001.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import static tech.krazyminer001.utility.Util.of;


//@Mixin(ItemRenderer.class)
//public abstract class ItemRendererMixin {
//    @ModifyVariable(method = "renderItem*", at = @At(value = "HEAD"), argsOnly = true)
//    public BakedModel useLeafCoreAnimatedModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
//        if (stack.isOf(ModItems.LEAF_CORE) && Mods.GECKOLIB.isLoaded()) {
//            return ((ItemRendererAccessor) this).octocomputing$getModels().getModelManager().getModel(new ModelIdentifier(of("animated_leaf_core"), "inventory"));
//        }
//        return value;
//    }
//}
