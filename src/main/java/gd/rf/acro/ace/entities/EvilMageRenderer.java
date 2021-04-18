package gd.rf.acro.ace.entities;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.feature.HeadFeatureRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.feature.StuckArrowsFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.util.Identifier;

public class EvilMageRenderer extends MobEntityRenderer<EvilMageEntity, BipedEntityModel<EvilMageEntity>> {
    public EvilMageRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new PlayerEntityModel<>(0,false), 0.5f);
        this.addFeature(new ArmorFeatureRenderer(this, new BipedEntityModel(0.5F), new BipedEntityModel(1.0F)));
        this.addFeature(new HeldItemFeatureRenderer(this));
        this.addFeature(new StuckArrowsFeatureRenderer(this));
        this.addFeature(new HeadFeatureRenderer(this));
    }

    @Override
    public Identifier getTexture(EvilMageEntity entity) {
        return new Identifier("ace","textures/entity/wizard.png");
    }
}
