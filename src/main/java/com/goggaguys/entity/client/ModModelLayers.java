package com.goggaguys.entity.client;

import com.goggaguys.OctoComputing;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer LEAF_MONSTER = new EntityModelLayer(new Identifier(OctoComputing.MOD_ID, "leaf_monster"), "main");
    public static final EntityModelLayer LEAF_GOD = new EntityModelLayer(new Identifier(OctoComputing.MOD_ID, "leaf_god"), "main");
}
