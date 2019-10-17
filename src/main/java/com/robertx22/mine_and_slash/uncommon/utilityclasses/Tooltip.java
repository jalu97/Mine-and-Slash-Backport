package com.robertx22.mine_and_slash.uncommon.utilityclasses;

import com.robertx22.mine_and_slash.uncommon.localization.CLOC;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class Tooltip {

    public static void add(String str, List<ITextComponent> list) {

        list.add(CLOC.blank(str));
    }

    public static void add(ITextComponent str, List<ITextComponent> list) {
        list.add(str);
    }

    public static ITextComponent color(TextFormatting format, ITextComponent comp) {
        return new StringTextComponent(format + "").appendSibling(comp);
    }

    public static void addEmpty(List<ITextComponent> tooltip) {
        tooltip.add(CLOC.blank(""));
    }
}
