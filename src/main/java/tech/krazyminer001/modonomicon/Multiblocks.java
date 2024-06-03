package tech.krazyminer001.modonomicon;

import tech.krazyminer001.OctoComputing;
import com.klikli_dev.modonomicon.api.ModonomiconAPI;
import com.klikli_dev.modonomicon.api.multiblock.Multiblock;
import net.minecraft.util.Identifier;

public class Multiblocks {
    public static final Multiblock VOIDSPAWN_GENERATOR = ModonomiconAPI.get().getMultiblock(new Identifier(OctoComputing.MOD_ID, "voidspawn_generator"));
}
