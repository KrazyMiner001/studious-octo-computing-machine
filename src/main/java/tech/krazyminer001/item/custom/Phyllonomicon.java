package tech.krazyminer001.item.custom;

import com.klikli_dev.modonomicon.client.gui.book.BookAddress;
import tech.krazyminer001.OctoComputing;
import com.klikli_dev.modonomicon.client.gui.BookGuiManager;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import static tech.krazyminer001.utility.Util.of;


public class Phyllonomicon extends Item {
    public static final Identifier PHYLLONOMICON_ID = of("phyllonomicon");

    public Phyllonomicon(Settings settings) {
        super(settings);
    }

    public void openPhyllonomicon() {
        BookGuiManager.get().openBook(BookAddress.defaultFor(PHYLLONOMICON_ID));
    }

    public void openPhyllonomicon(Identifier entry, int page) {
        BookGuiManager.get().openEntry(PHYLLONOMICON_ID, entry, page);
    }


}
