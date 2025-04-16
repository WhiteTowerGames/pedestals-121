package net.chris.pedestals.item.items;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class CreativeKeyItem extends Item implements ItemTooltipCallback {
    public CreativeKeyItem(Settings settings) {
        super(settings);
    }

    @Override
    public void getTooltip(ItemStack stack, TooltipContext tooltipContext, TooltipType tooltipType, List<Text> lines) {
        lines.add(Text.translatable("itemtooltip.pedestals.creative_key").formatted(Formatting.AQUA));
    }
}
