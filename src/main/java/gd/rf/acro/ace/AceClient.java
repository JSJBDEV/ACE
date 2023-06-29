package gd.rf.acro.ace;

import gd.rf.acro.ace.entities.BoltEntityRenderer;
import gd.rf.acro.ace.entities.EvilMageRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.BipedEntityModel;

public class AceClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3495eb, ACE.WATER_TRAP_BLOCK);

        BlockRenderLayerMap.INSTANCE.putBlock(ACE.AIR_TRAP_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ACE.EARTH_TRAP_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ACE.WATER_TRAP_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ACE.FIRE_TRAP_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ACE.MAGIC_BLOCK, RenderLayer.getTranslucent());


        EntityRendererRegistry.register(ACE.BOLT_ENTITY_TYPE, (context) -> new BoltEntityRenderer(context, 1,false));
        EntityRendererRegistry.register(ACE.EVIL_MAGE_ENTITY_TYPE, EvilMageRenderer::new);
    }
}
