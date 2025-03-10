package net.chris.pedestals.item.ItemClasses;

import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.components.ModComponents;
import net.chris.pedestals.components.UUIDAndBoolComponent;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.TextureKey;
import net.minecraft.client.data.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import java.util.Optional;
import java.util.UUID;


public class LockboxItem extends Item {

    public LockboxItem(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ItemStack stack = context.getStack();
        UUIDAndBoolComponent stackComponent = stack.get(ModComponents.UUID_BOOL_COMPONENT);
        UUID stackUUID = stackComponent.uuid();
        boolean isStackMapped = stackComponent.isMapped();
        return super.useOnBlock(context);
    }

    public static final Model LOCKBOX_MODEL = itemModel("lockbox", TextureKey.ALL);

    private static Model itemModel(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(Pedestals121.MOD_ID, "item/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    public static TextureMap lockboxMap(String color) {
        TextureMap textureMap = new TextureMap();

        //Map the glass texture to the vanilla glass texture with the specified color, or to normal glass if no color is specified.
        if (!color.isEmpty()) {
            textureMap.put(TextureKey.ALL, Identifier.of("minecraft", "block/" + color + "_stained_glass"));
        } else {
            textureMap.put(TextureKey.ALL, Identifier.of("minecraft", "block/glass"));
        }

        return textureMap;
    }

}