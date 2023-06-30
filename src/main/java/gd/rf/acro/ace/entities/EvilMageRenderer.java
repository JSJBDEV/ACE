package gd.rf.acro.ace.entities;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class EvilMageRenderer extends MobEntityRenderer<EvilMageEntity, BipedEntityModel<EvilMageEntity>> {


    public EvilMageRenderer(EntityRendererFactory.Context context) {
        super(context, new BipedEntityModel<>(context.getPart(EntityModelLayers.PLAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(EvilMageEntity entity) {
        return new Identifier("ace","textures/entity/wizard.png");
    }
}
