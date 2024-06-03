package tech.krazyminer001.entity.client;

import tech.krazyminer001.OctoComputing;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer LEAF_MONSTER = new EntityModelLayer(new Identifier(OctoComputing.MOD_ID, "leaf_monster"), "main");
    public static final EntityModelLayer LEAF_GOD = new EntityModelLayer(new Identifier(OctoComputing.MOD_ID, "leaf_god"), "main");
    public static final EntityModelLayer LEAF_PROJECTILE = new EntityModelLayer(new Identifier(OctoComputing.MOD_ID, "leaf_projectile"), "main");
}
