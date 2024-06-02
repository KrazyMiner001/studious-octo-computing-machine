package com.goggaguys.item.custom;

import com.goggaguys.OctoComputing;
import com.klikli_dev.modonomicon.client.gui.BookGuiManager;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class Phyllonomicon extends Item {
    public static final Identifier PHYLLONOMICON_ID = new Identifier(OctoComputing.MOD_ID, "phyllonomicon");

    public Phyllonomicon(Settings settings) {
        super(settings);
    }

    public void openPhyllonomicon() {
        BookGuiManager.get().openBook(PHYLLONOMICON_ID);
    }

    public void openPhyllonomicon(Identifier entry, int page) {
        BookGuiManager.get().openEntry(PHYLLONOMICON_ID, entry, page);
    }


}
