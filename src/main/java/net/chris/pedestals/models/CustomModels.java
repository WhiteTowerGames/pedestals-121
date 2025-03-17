package net.chris.pedestals.models;

import net.chris.pedestals.Pedestals121;
import net.minecraft.block.Block;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.ModelIds;
import net.minecraft.client.data.TextureKey;
import net.minecraft.client.data.TextureMap;
import net.minecraft.util.Identifier;

import java.util.Optional;

import static net.minecraft.block.Blocks.GOLD_BLOCK;

public class CustomModels {

    public static final TextureKey GOLD = TextureKey.of("gold");

    public static final Model FANCY_CARPET_MODEL = block("fancy_carpet", TextureKey.WOOL, GOLD);
    public static final Model PEDESTAL_MODEL = block("parent_pedestal", TextureKey.ALL);
    public static final Model PEDESTAL_MODEL_MORE = block("parent_pedestal_more", TextureKey.SIDE, TextureKey.TOP);
    public static final Model LOCKBOX_MODEL = item("lockbox", TextureKey.ALL);

    public static Model block(String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(Pedestals121.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model item(@SuppressWarnings("SameParameterValue") String parent, TextureKey... requiredTextureKeys) {
        return new Model(Optional.of(Identifier.of(Pedestals121.MOD_ID, "item/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    @Deprecated(forRemoval = true)
    public static TextureMap fancyCarpetMap(String color) {
        TextureMap textureMap = new TextureMap();

        //Map the wool texture to the vanilla wool texture with the specified color
        textureMap.put(TextureKey.WOOL, Identifier.of("minecraft", "block/"+color+"_wool"));

        //Map the gold texture to the gold block texture
        textureMap.put(GOLD, Identifier.of("minecraft", "block/gold_block"));

        return textureMap;
    }

    public static TextureMap fancyCarpetMap(Block block) {
        return new TextureMap()
                .put(TextureKey.WOOL, ModelIds.getBlockSubModelId(block, ""))
                .put(GOLD, ModelIds.getBlockSubModelId(GOLD_BLOCK, ""));
    }

    public static TextureMap pedestalMap(Block block) {
        return new TextureMap()
                .put(TextureKey.ALL, ModelIds.getBlockSubModelId(block, ""));

    }

    public static TextureMap pedestalMapWood(Block block) {
        return new TextureMap()
                .put(TextureKey.SIDE, ModelIds.getBlockSubModelId(block, ""))
                .put(TextureKey.TOP, ModelIds.getBlockSubModelId(block, "_top"));
    }

    public static TextureMap dustMap(String shade) {
        TextureMap textureMap = new TextureMap();
        switch (shade) {
            case "dust1" -> textureMap.put(TextureKey.ALL, Identifier.of(Pedestals121.MOD_ID, "item/lockbox_dust_1"));
            case "dust2" -> textureMap.put(TextureKey.ALL, Identifier.of(Pedestals121.MOD_ID, "item/lockbox_dust_2"));
            case "dust3" -> textureMap.put(TextureKey.ALL, Identifier.of(Pedestals121.MOD_ID, "item/lockbox_dust_3"));
            case "dust4" -> textureMap.put(TextureKey.ALL, Identifier.of(Pedestals121.MOD_ID, "item/lockbox_dust_4"));
        }
        return textureMap;
    }

    public static TextureMap lockboxMap(Block block) {
        return new TextureMap()
                .put(TextureKey.ALL, ModelIds.getBlockSubModelId(block, ""));
    }

}
