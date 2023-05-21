package com.jerrylu086.bundled_up.mixin;

import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
// import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Items.class)
@SuppressWarnings("unused")
public class ItemsMixin {
    @Redirect(method = "<clinit>",
            at = @At(value = "NEW", target = "net/minecraft/world/item/BundleItem", ordinal = 0)
            // , slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=bundle"))
    )
    private static BundleItem bundleItem(Item.Properties properties) {
        return new BundleItem((new Item.Properties()).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS));
    }
}
