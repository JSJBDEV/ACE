package gd.rf.acro.ace.entities;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;

@Environment(EnvType.CLIENT)
public class BoltEntityRenderer extends FlyingItemEntityRenderer<BoltEntity> {
    public BoltEntityRenderer(EntityRenderDispatcher dispatcher, ItemRenderer itemRenderer, float scale, boolean lit) {
        super(dispatcher, itemRenderer, scale, lit);
    }
}
