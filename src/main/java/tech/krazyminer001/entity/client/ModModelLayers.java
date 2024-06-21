package tech.krazyminer001.entity.client;

import tech.krazyminer001.OctoComputing;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import static tech.krazyminer001.utility.Util.of;

public class ModModelLayers {
    public static final EntityModelLayer LEAF_MONSTER = new EntityModelLayer(of("leaf_monster"), "main");
    public static final EntityModelLayer LEAF_GOD = new EntityModelLayer(of("leaf_god"), "main");
    public static final EntityModelLayer LEAF_PROJECTILE = new EntityModelLayer(of("leaf_projectile"), "main");
}
