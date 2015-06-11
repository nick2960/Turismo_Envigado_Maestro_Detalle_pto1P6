package com.example.nicols.turismo_envigado_maestro_detalle_pto2.dummy;

import android.content.Context;

import com.example.nicols.turismo_envigado_maestro_detalle_pto2.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    public static Context GlobalContext = null;
    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        addItem(new DummyItem("1", "Publicidad"));
        addItem(new DummyItem("2", "Hoteles"));
        addItem(new DummyItem("3", "Bares"));
        addItem(new DummyItem("4", "Turismo"));
        addItem(new DummyItem("5", "Demografia"));
        addItem(new DummyItem("6", "Acerca de"));
        addItem(new DummyItem("7", "Mapa"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String item_name;

        public DummyItem(String id, String item_name) {
            this.id = id;
            this.item_name = item_name;
        }

        @Override
        public String toString() {
            return item_name;
        }
    }
}
