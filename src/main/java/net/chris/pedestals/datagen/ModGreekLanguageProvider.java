package net.chris.pedestals.datagen;

import net.chris.pedestals.block.ModBlocks;
import net.chris.pedestals.item.ModItemGroups;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static net.chris.pedestals.block.ModBlocks.*;
import static net.chris.pedestals.item.ModItems.*;

public class ModGreekLanguageProvider extends FabricLanguageProvider {

    public ModGreekLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "el_gr", registryLookup);
    }

    private static void addText(@NotNull TranslationBuilder builder, @NotNull Text text, @NotNull String value){
        builder.add(((TranslatableTextContent) text.getContent()).getKey(), value);
    }

    private static final String[] allColorsGreek = {"Λευκό", "Ανοιχτό Γκρι", "Γκρι", "Μαύρο",
            "Καφέ", "Κόκκινο", "Πορτοκαλί", "Κίτρινο", "Λαχανί", "Πράσινο", "Κυανό", "Ανοιχτό Μπλε", "Μπλε", "Μοβ", "Φούξια", "Ροζ"};

    private static final String[] allColorsGreekFeminine = {"Λευκή", "Ανοιχτή Γκρι", "Γκρι", "Μαύρη",
            "Καφέ", "Κόκκινη", "Πορτοκαλί", "Κίτρινη", "Λαχανί", "Πράσινη", "Κυανή", "Ανοιχτή Μπλε", "Μπλε", "Μοβ", "Φούξια", "Ροζ"};

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.STONE_BRICK_PEDESTAL, "Βάθρο από Τούβλα Πέτρας");
        translationBuilder.add(ModBlocks.MOSSY_STONE_BRICK_PEDESTAL, "Βάθρο από Βρυώδη Τούβλα Πέτρας");
        translationBuilder.add(ModBlocks.DEEPSLATE_BRICK_PEDESTAL, "Βάθρο από Τούβλα Βαθόλιθου");
        translationBuilder.add(ModBlocks.DEEPSLATE_TILE_PEDESTAL, "Βάθρο από Πλάκες Βαθόλιθου");
        translationBuilder.add(ModBlocks.POLISHED_GRANITE_PEDESTAL, "Βάθρο από Γυαλισμένο Γρανίτη");
        translationBuilder.add(ModBlocks.POLISHED_DIORITE_PEDESTAL, "Βάθρο από Γυαλισμένο Διορίτη");
        translationBuilder.add(ModBlocks.POLISHED_ANDESITE_PEDESTAL, "Βάθρο από Γυαλισμένο Ανδεσίτη");
        translationBuilder.add(ModBlocks.POLISHED_DEEPSLATE_PEDESTAL, "Βάθρο από Γυαλισμένο Βαθόλιθο");
        translationBuilder.add(ModBlocks.CALCITE_PEDESTAL, "Βάθρο από Ασβεστίτη");
        translationBuilder.add(ModBlocks.COPPER_PEDESTAL, "Βάθρο από Χαλκό");
        translationBuilder.add(ModBlocks.EXPOSED_COPPER_PEDESTAL, "Βάθρο από Εκτεθειμένο Χαλκό");
        translationBuilder.add(ModBlocks.WEATHERED_COPPER_PEDESTAL, "Βάθρο από Φθαρμένο Χαλκό");
        translationBuilder.add(ModBlocks.OXIDIZED_COPPER_PEDESTAL, "Βάθρο από Οξειδωμένο Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_COPPER_PEDESTAL, "Κερωμένο Βάθρο από Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL, "Κερωμένο Βάθρο από Εκτεθειμένο Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL, "Κερωμένο Βάθρο από Φθαρμένο Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL, "Κερωμένο Βάθρο από Οξειδωμένο Χαλκό");
        translationBuilder.add(ModBlocks.CUT_COPPER_PEDESTAL, "Βάθρο από Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL, "Βάθρο από Εκτεθειμένο Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL, "Βάθρο από Φθαρμένο Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL, "Βάθρο από Οξειδωμένο Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_CUT_COPPER_PEDESTAL, "Κερωμένο Βάθρο από Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL, "Κερωμένο Βάθρο από Εκτεθειμένο Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL, "Κερωμένο Βάθρο από Φθαρμένο Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL, "Κερωμένο Βάθρο από Οξειδωμένο Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.BRICK_PEDESTAL, "Βάθρο από Τούβλα");
        translationBuilder.add(ModBlocks.END_STONE_BRICK_PEDESTAL, "Βάθρο από Τούβλα Πέτρας Έντ");
        translationBuilder.add(ModBlocks.MUD_BRICK_PEDESTAL, "Βάθρο από Τούβλα Λάσπης");
        translationBuilder.add(ModBlocks.NETHER_BRICK_PEDESTAL, "Βάθρο από Τούβλα Νέδερ");
        translationBuilder.add(ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL, "Βάθρο από Γυαλισμένα Τούβλα Μαύρου Σιδήρου");
        translationBuilder.add(ModBlocks.POLISHED_BLACKSTONE_PEDESTAL, "Βάθρο από Γυαλισμένο Μαύρο Σίδερο");
        translationBuilder.add(ModBlocks.DARK_PRISMARINE_PEDESTAL, "Βάθρο από Σκούρα Πρισμαρίνη");
        translationBuilder.add(ModBlocks.PRISMARINE_BRICK_PEDESTAL, "Βάθρο από Τούβλα Πρισμαρίνης");
        translationBuilder.add(ModBlocks.PURPUR_BLOCK_PEDESTAL, "Βάθρο από Πέρπουρ");
        translationBuilder.add(ModBlocks.QUARTZ_BRICK_PEDESTAL, "Βάθρο από Τούβλα Χαλαζία");
        translationBuilder.add(ModBlocks.RED_NETHER_BRICK_PEDESTAL, "Βάθρο από Κόκκινα Τούβλα Νέδερ");
        translationBuilder.add(ModBlocks.SMOOTH_QUARTZ_PEDESTAL, "Βάθρο από Λείο Χαλαζία");
        translationBuilder.add(ModBlocks.POLISHED_TUFF_PEDESTAL, "Βάθρο από Γυαλισμένο Τόφο");
        translationBuilder.add(ModBlocks.TUFF_BRICK_PEDESTAL, "Βάθρο από Τούβλα Τόφου");
        translationBuilder.add(ModBlocks.OAK_LOG_PEDESTAL, "Βάθρο από Κορμό Βελανιδιάς");
        translationBuilder.add(ModBlocks.BIRCH_LOG_PEDESTAL, "Βάθρο από Κορμό Σημύδας");
        translationBuilder.add(ModBlocks.SPRUCE_LOG_PEDESTAL, "Βάθρο από Κορμό Έλατου");
        translationBuilder.add(ModBlocks.JUNGLE_LOG_PEDESTAL, "Βάθρο από Κορμό Ζούγκλας");
        translationBuilder.add(ModBlocks.DARK_OAK_LOG_PEDESTAL, "Βάθρο από Κορμό Σκούρας Βελανιδιάς");
        translationBuilder.add(ModBlocks.ACACIA_LOG_PEDESTAL, "Βάθρο από Κορμό Ακακίας");
        translationBuilder.add(ModBlocks.MANGROVE_LOG_PEDESTAL, "Βάθρο από Κορμό Μανγκρόβιου");
        translationBuilder.add(ModBlocks.CHERRY_LOG_PEDESTAL, "Βάθρο από Κορμό Κερασιάς");
        translationBuilder.add(ModBlocks.BAMBOO_LOG_PEDESTAL, "Βάθρο από Μπαμπού");
        translationBuilder.add(ModBlocks.BAMBOO_MOSAIC_PEDESTAL, "Βάθρο από Μωσαϊκό Μπαμπού");
        translationBuilder.add(ModBlocks.STRIPPED_OAK_LOG_PEDESTAL, "Βάθρο από Αποφλοιωμένο Κορμό Βελανιδιάς");
        translationBuilder.add(ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL, "Βάθρο από Αποφλοιωμένο Κορμό Σημύδας");
        translationBuilder.add(ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL, "Βάθρο από Αποφλοιωμένο Κορμό Έλατου");
        translationBuilder.add(ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL, "Βάθρο από Αποφλοιωμένο Κορμό Ζούγκλας");
        translationBuilder.add(ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL, "Βάθρο από Αποφλοιωμένο Κορμό Σκούρας Βελανιδιάς");
        translationBuilder.add(ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL, "Βάθρο από Αποφλοιωμένο Κορμό Ακακίας");
        translationBuilder.add(ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL, "Βάθρο από Αποφλοιωμένο Κορμό Μανγκρόβιου");
        translationBuilder.add(ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL, "Βάθρο από Αποφλοιωμένο Κορμό Κερασιάς");
        translationBuilder.add(ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL, "Βάθρο από Αποφλοιωμένο Μπαμπού");
        translationBuilder.add(ModBlocks.CHISELED_TUFF_BRICK_PEDESTAL, "Βάθρο από Λαξευμένα Τούβλα Τόφου");
        translationBuilder.add(ModBlocks.PALE_OAK_LOG_PEDESTAL, "Βάθρο από Κορμό Ανοιχτόχρωμης Βελανιδιάς");
        translationBuilder.add(ModBlocks.STRIPPED_PALE_OAK_LOG_PEDESTAL, "Βάθρο από Αποφλοιωμένο Κορμό Ανοιχτόχρωμης Βελανιδιάς");
        translationBuilder.add(ModBlocks.RESIN_BRICK_PEDESTAL, "Βάθρο από Τούβλα Ρητίνης");
        translationBuilder.add(ModBlocks.CRIMSON_LOG_PEDESTAL, "Βάθρο από Ερυθρό Βλαστό");
        translationBuilder.add(ModBlocks.STRIPPED_CRIMSON_LOG_PEDESTAL, "Βάθρο από Αποφλοιωμένο Ερυθρό Βλαστό");
        translationBuilder.add(ModBlocks.WARPED_LOG_PEDESTAL, "Βάθρο από Διαστρεβλωμένο Βλαστό");
        translationBuilder.add(ModBlocks.STRIPPED_WARPED_LOG_PEDESTAL, "Βάθρο από Αποφλοιωμένο Διαστρεβλωμένο Βλαστό");
        translationBuilder.add(ModBlocks.SMOOTH_SANDSTONE_PEDESTAL, "Βάθρο από Λεία Αμμόπετρα");
        translationBuilder.add(ModBlocks.SMOOTH_RED_SANDSTONE_PEDESTAL, "Βάθρο από Λεία Κόκκινη Αμμόπετρα");

        translationBuilder.add(ModBlocks.STONE_BRICK_PEDESTAL.asItem(), "Βάθρο από Τούβλα Πέτρας");
        translationBuilder.add(ModBlocks.MOSSY_STONE_BRICK_PEDESTAL.asItem(), "Βάθρο από Βρυώδη Τούβλα Πέτρας");
        translationBuilder.add(ModBlocks.DEEPSLATE_BRICK_PEDESTAL.asItem(), "Βάθρο από Τούβλα Βαθόλιθου");
        translationBuilder.add(ModBlocks.DEEPSLATE_TILE_PEDESTAL.asItem(), "Βάθρο από Πλάκες Βαθόλιθου");
        translationBuilder.add(ModBlocks.POLISHED_GRANITE_PEDESTAL.asItem(), "Βάθρο από Γυαλισμένο Γρανίτη");
        translationBuilder.add(ModBlocks.POLISHED_DIORITE_PEDESTAL.asItem(), "Βάθρο από Γυαλισμένο Διορίτη");
        translationBuilder.add(ModBlocks.POLISHED_ANDESITE_PEDESTAL.asItem(), "Βάθρο από Γυαλισμένο Ανδεσίτη");
        translationBuilder.add(ModBlocks.POLISHED_DEEPSLATE_PEDESTAL.asItem(), "Βάθρο από Γυαλισμένο Βαθόλιθο");
        translationBuilder.add(ModBlocks.CALCITE_PEDESTAL.asItem(), "Βάθρο από Ασβεστίτη");
        translationBuilder.add(ModBlocks.COPPER_PEDESTAL.asItem(), "Βάθρο από Χαλκό");
        translationBuilder.add(ModBlocks.EXPOSED_COPPER_PEDESTAL.asItem(), "Βάθρο από Εκτεθειμένο Χαλκό");
        translationBuilder.add(ModBlocks.WEATHERED_COPPER_PEDESTAL.asItem(), "Βάθρο από Φθαρμένο Χαλκό");
        translationBuilder.add(ModBlocks.OXIDIZED_COPPER_PEDESTAL.asItem(), "Βάθρο από Οξειδωμένο Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_COPPER_PEDESTAL.asItem(), "Κερωμένο Βάθρο από Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_EXPOSED_COPPER_PEDESTAL.asItem(), "Κερωμένο Βάθρο από Εκτεθειμένο Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_WEATHERED_COPPER_PEDESTAL.asItem(), "Κερωμένο Βάθρο από Φθαρμένο Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_OXIDIZED_COPPER_PEDESTAL.asItem(), "Κερωμένο Βάθρο από Οξειδωμένο Χαλκό");
        translationBuilder.add(ModBlocks.CUT_COPPER_PEDESTAL.asItem(), "Βάθρο από Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.EXPOSED_CUT_COPPER_PEDESTAL.asItem(), "Βάθρο από Εκτεθειμένο Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.WEATHERED_CUT_COPPER_PEDESTAL.asItem(), "Βάθρο από Φθαρμένο Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.OXIDIZED_CUT_COPPER_PEDESTAL.asItem(), "Βάθρο από Οξειδωμένο Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_CUT_COPPER_PEDESTAL.asItem(), "Κερωμένο Βάθρο από Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_EXPOSED_CUT_COPPER_PEDESTAL.asItem(), "Κερωμένο Βάθρο από Εκτεθειμένο Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_WEATHERED_CUT_COPPER_PEDESTAL.asItem(), "Κερωμένο Βάθρο από Φθαρμένο Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.WAXED_OXIDIZED_CUT_COPPER_PEDESTAL.asItem(), "Κερωμένο Βάθρο από Οξειδωμένο Κομμένο Χαλκό");
        translationBuilder.add(ModBlocks.BRICK_PEDESTAL.asItem(), "Βάθρο από Τούβλα");
        translationBuilder.add(ModBlocks.END_STONE_BRICK_PEDESTAL.asItem(), "Βάθρο από Τούβλα Πέτρας Έντ");
        translationBuilder.add(ModBlocks.MUD_BRICK_PEDESTAL.asItem(), "Βάθρο από Τούβλα Λάσπης");
        translationBuilder.add(ModBlocks.NETHER_BRICK_PEDESTAL.asItem(), "Βάθρο από Τούβλα Νέδερ");
        translationBuilder.add(ModBlocks.POLISHED_BLACKSTONE_BRICK_PEDESTAL.asItem(), "Βάθρο από Γυαλισμένα Τούβλα Μαύρου Σιδήρου");
        translationBuilder.add(ModBlocks.POLISHED_BLACKSTONE_PEDESTAL.asItem(), "Βάθρο από Γυαλισμένο Μαύρο Σίδερο");
        translationBuilder.add(ModBlocks.DARK_PRISMARINE_PEDESTAL.asItem(), "Βάθρο από Σκούρα Πρισμαρίνη");
        translationBuilder.add(ModBlocks.PRISMARINE_BRICK_PEDESTAL.asItem(), "Βάθρο από Τούβλα Πρισμαρίνης");
        translationBuilder.add(ModBlocks.PURPUR_BLOCK_PEDESTAL.asItem(), "Βάθρο από Πέρπουρ");
        translationBuilder.add(ModBlocks.QUARTZ_BRICK_PEDESTAL.asItem(), "Βάθρο από Τούβλα Χαλαζία");
        translationBuilder.add(ModBlocks.RED_NETHER_BRICK_PEDESTAL.asItem(), "Βάθρο από Κόκκινα Τούβλα Νέδερ");
        translationBuilder.add(ModBlocks.SMOOTH_QUARTZ_PEDESTAL.asItem(), "Βάθρο από Λείο Χαλαζία");
        translationBuilder.add(ModBlocks.POLISHED_TUFF_PEDESTAL.asItem(), "Βάθρο από Γυαλισμένο Τόφο");
        translationBuilder.add(ModBlocks.TUFF_BRICK_PEDESTAL.asItem(), "Βάθρο από Τούβλα Τόφου");
        translationBuilder.add(ModBlocks.OAK_LOG_PEDESTAL.asItem(), "Βάθρο από Κορμό Βελανιδιάς");
        translationBuilder.add(ModBlocks.BIRCH_LOG_PEDESTAL.asItem(), "Βάθρο από Κορμό Σημύδας");
        translationBuilder.add(ModBlocks.SPRUCE_LOG_PEDESTAL.asItem(), "Βάθρο από Κορμό Έλατου");
        translationBuilder.add(ModBlocks.JUNGLE_LOG_PEDESTAL.asItem(), "Βάθρο από Κορμό Ζούγκλας");
        translationBuilder.add(ModBlocks.DARK_OAK_LOG_PEDESTAL.asItem(), "Βάθρο από Κορμό Σκούρας Βελανιδιάς");
        translationBuilder.add(ModBlocks.ACACIA_LOG_PEDESTAL.asItem(), "Βάθρο από Κορμό Ακακίας");
        translationBuilder.add(ModBlocks.MANGROVE_LOG_PEDESTAL.asItem(), "Βάθρο από Κορμό Μανγκρόβιου");
        translationBuilder.add(ModBlocks.CHERRY_LOG_PEDESTAL.asItem(), "Βάθρο από Κορμό Κερασιάς");
        translationBuilder.add(ModBlocks.BAMBOO_LOG_PEDESTAL.asItem(), "Βάθρο από Μπαμπού");
        translationBuilder.add(ModBlocks.BAMBOO_MOSAIC_PEDESTAL.asItem(), "Βάθρο από Μωσαϊκό Μπαμπού");
        translationBuilder.add(ModBlocks.STRIPPED_OAK_LOG_PEDESTAL.asItem(), "Βάθρο από Αποφλοιωμένο Κορμό Βελανιδιάς");
        translationBuilder.add(ModBlocks.STRIPPED_BIRCH_LOG_PEDESTAL.asItem(), "Βάθρο από Αποφλοιωμένο Κορμό Σημύδας");
        translationBuilder.add(ModBlocks.STRIPPED_SPRUCE_LOG_PEDESTAL.asItem(), "Βάθρο από Αποφλοιωμένο Κορμό Έλατου");
        translationBuilder.add(ModBlocks.STRIPPED_JUNGLE_LOG_PEDESTAL.asItem(), "Βάθρο από Αποφλοιωμένο Κορμό Ζούγκλας");
        translationBuilder.add(ModBlocks.STRIPPED_DARK_OAK_LOG_PEDESTAL.asItem(), "Βάθρο από Αποφλοιωμένο Κορμό Σκούρας Βελανιδιάς");
        translationBuilder.add(ModBlocks.STRIPPED_ACACIA_LOG_PEDESTAL.asItem(), "Βάθρο από Αποφλοιωμένο Κορμό Ακακίας");
        translationBuilder.add(ModBlocks.STRIPPED_MANGROVE_LOG_PEDESTAL.asItem(), "Βάθρο από Αποφλοιωμένο Κορμό Μανγκρόβιου");
        translationBuilder.add(ModBlocks.STRIPPED_CHERRY_LOG_PEDESTAL.asItem(), "Βάθρο από Αποφλοιωμένο Κορμό Κερασιάς");
        translationBuilder.add(ModBlocks.STRIPPED_BAMBOO_LOG_PEDESTAL.asItem(), "Βάθρο από Αποφλοιωμένο Μπαμπού");
        translationBuilder.add(ModBlocks.CHISELED_TUFF_BRICK_PEDESTAL.asItem(), "Βάθρο από Λαξευμένα Τούβλα Τόφου");
        translationBuilder.add(ModBlocks.PALE_OAK_LOG_PEDESTAL.asItem(), "Βάθρο από Κορμό Ανοιχτόχρωμης Βελανιδιάς");
        translationBuilder.add(ModBlocks.STRIPPED_PALE_OAK_LOG_PEDESTAL.asItem(), "Βάθρο από Αποφλοιωμένο Κορμό Ανοιχτόχρωμης Βελανιδιάς");
        translationBuilder.add(ModBlocks.RESIN_BRICK_PEDESTAL.asItem(), "Βάθρο από Τούβλα Ρητίνης");
        translationBuilder.add(ModBlocks.CRIMSON_LOG_PEDESTAL.asItem(), "Βάθρο από Ερυθρό Βλαστό");
        translationBuilder.add(ModBlocks.STRIPPED_CRIMSON_LOG_PEDESTAL.asItem(), "Βάθρο από Αποφλοιωμένο Ερυθρό Βλαστό");
        translationBuilder.add(ModBlocks.WARPED_LOG_PEDESTAL.asItem(), "Βάθρο από Διαστρεβλωμένο Βλαστό");
        translationBuilder.add(ModBlocks.STRIPPED_WARPED_LOG_PEDESTAL.asItem(), "Βάθρο από Αποφλοιωμένο Διαστρεβλωμένο Βλαστό");
        translationBuilder.add(ModBlocks.SMOOTH_SANDSTONE_PEDESTAL.asItem(), "Βάθρο από Λεία Αμμόπετρα");
        translationBuilder.add(ModBlocks.SMOOTH_RED_SANDSTONE_PEDESTAL.asItem(), "Βάθρο από Λεία Κόκκινη Αμμόπετρα");

        translationBuilder.add(GLASS_LOCKBOX, "Ενισχυμένη Προθήκη");

        String actualName;

        for (int i = 0; i<=15; i++){
            /// Gilded Carpets:
            actualName = allColorsGreek[i];
            translationBuilder.add(ALL_FANCY_CARPETS.get(i), actualName+" Επίχρυσο Σεμεδάκι");
            translationBuilder.add(ALL_FANCY_CARPETS.get(i).asItem(), actualName+" Επίχρυσο Σεμεδάκι");
            /// Reinforced Lockboxes:
            actualName = allColorsGreekFeminine[i];
            translationBuilder.add(ALL_COLORED_LOCKBOXES.get(i), actualName+" Ενισχυμένη Προθήκη");
        }
        /// Keys:
        translationBuilder.add(LOCKBOX_KEY, "Κλειδί Προθήκης");
        translationBuilder.add(LOCKPICK, "Μαραφέτι");
        translationBuilder.add(CREATIVE_KEY, "Αντικλείδι");

        /// Item tooltips:
        translationBuilder.add("itemtooltip.pedestals.creative_key", "Αυτό το αντικλείδι μπορεί να ανοίξει οποιαδήποτε προθήκη!");
        translationBuilder.add("itemtooltip.pedestals.lockpick_disabled.l1", "Το μαραφέτι έχει απενεργοποιηθεί μέσω");
        translationBuilder.add("itemtooltip.pedestals.lockpick_disabled.l2", "του Κανόνα Παιχνιδιού enableLockpicks.");
        translationBuilder.add("itemtooltip.pedestals.lockpick_enabled.l1", "Κάνε δεξί κλικ σε μία προθήκη για");
        translationBuilder.add("itemtooltip.pedestals.lockpick_enabled.l2", "να προσπαθήσεις να τη διαρρήξεις!");
        translationBuilder.add("itemtooltip.pedestals.key_is_mapped", "Αυτό το κλείδι μπορεί να ανοίξει μια συγκεκριμένη προθήκη.");
        translationBuilder.add("itemtooltip.pedestals.key_unnamed", "Ονόμασέ το για να μη ξεχάσεις ποια.");
        translationBuilder.add("itemtooltip.pedestals.key_not_mapped.l1", "Αυτό το κλειδί δεν ανήκει σε κάποια προθήκη.");
        translationBuilder.add("itemtooltip.pedestals.key_not_mapped.l2", "Κάνε δεξί κλικ σε μία νέα προθήκη για να την ενώσεις!");
        translationBuilder.add("itemtooltip.pedestals.key_clone", "Αντίγραφο");

        /// Messages:
        translationBuilder.add("messages.pedestals.key_open", "Η προθήκη άνοιξε!");
        translationBuilder.add("messages.pedestals.key_wrong", "Αυτό το κλειδί δεν είναι σωστό...");
        translationBuilder.add("messages.pedestals.key_map", "Το κλειδί και η προθήκη ενώθηκαν!");
        translationBuilder.add("messages.pedestals.lockpicking_failed", "Δεν κατάφερες να διαρρήξεις την κλειδαριά...");
        translationBuilder.add("messages.pedestals.lockpicking_success", "Διέρρηξες την κλειδαριά!");
        translationBuilder.add("messages.pedestals.try_break_lockbox", "Το γυαλί φαίνεται άθραυστο... ίσως μπορείς με κάποιο τρόπο να το ανοίξεις.");

        /// Sounds:
        translationBuilder.add("sound.pedestals.lockpick_increase", "Διάρρηξη αναβαθμίζεται");

        /// Item Groups:
        addText(translationBuilder, ModItemGroups.PEDESTALS_GROUP.getDisplayName(), "Βάθρα");
        addText(translationBuilder, ModItemGroups.FANCY_CARPETS_GROUP.getDisplayName(), "Επίχρυσα Σεμεδάκια");
        addText(translationBuilder, ModItemGroups.LOCKBOXES_GROUP.getDisplayName(), "Ενισχυμένες Προθήκες");

        /// Advancements:
        addText(translationBuilder, ModAdvancementProvider.get_pedestal_title, "Βάθρα!");
        addText(translationBuilder, ModAdvancementProvider.get_pedestal_desc, "Κάνε δεξί κλίκ με ένα αντικείμενο για να το προβάλεις!");

        addText(translationBuilder, ModAdvancementProvider.read_power_of_pedestal_title, "Η Δύναμη των Φανταχτερών Εκθεμάτων");
        addText(translationBuilder, ModAdvancementProvider.read_power_of_pedestal_desc, "Το σήμα που εκπέμπει ένα βάθρο μέσω ενός συγκριτή εξαρτάται από τη σπανιότητα του αντικειμένου του.");

        addText(translationBuilder, ModAdvancementProvider.place_epic_item_title, "Μέγιστη Δύναμη!");
        addText(translationBuilder, ModAdvancementProvider.place_epic_item_desc, "Ένα Βάθρο που περιέχει ένα Επικό (μωβ) αντικείμενο επίσης τροφοδοτεί τον από κάτω κύβο του.");

        addText(translationBuilder, ModAdvancementProvider.place_pedestal_on_pedestal_title, "Βάθρα²");
        addText(translationBuilder, ModAdvancementProvider.place_pedestal_on_pedestal_desc, "Βάθρα επάνω σε Βάθρα... αρχίζω και ζαλίζομαι.");

        addText(translationBuilder, ModAdvancementProvider.collect_all_pedestals_title, "Μετρ των Βάθρων");
        addText(translationBuilder, ModAdvancementProvider.collect_all_pedestals_desc, "Από την πέτρα μέχρι το ξύλο και τον χαλκό, κανένα βάθρο δε ξέφυγε από τα χέρια σου. Η συλλογή σου ολοκληρώθηκε.");

        addText(translationBuilder, ModAdvancementProvider.get_fancy_carpet_title, "Επίχρυσα Σεμεδάκια!");
        addText(translationBuilder, ModAdvancementProvider.get_fancy_carpet_desc, "Η γιαγιά μου είχε ένα τέτοιο σε κάθε τραπεζάκι της.");

        addText(translationBuilder, ModAdvancementProvider.get_lockbox_title, "Ενισχυμένες Προθήκες!");
        addText(translationBuilder, ModAdvancementProvider.get_lockbox_desc, "Μία στιβαρή γυάλινη προθήκη, ενισχυμένο με διαμάντι για έξτρα ασφάλεια. Καλή τύχη να τη διαρρήξεις!");

        addText(translationBuilder, ModAdvancementProvider.use_key_title, "Το Κλειδί του Παραδείσου");
        addText(translationBuilder, ModAdvancementProvider.use_key_desc, "Τα εγγεγραμμένα κλειδιά και οι προθήκες μπορούν να αντιγραφούν μέσω κατασκευής.");

        addText(translationBuilder, ModAdvancementProvider.break_lockpick_title, "Παρά Λίγο Διαρρήκτης");
        addText(translationBuilder, ModAdvancementProvider.break_lockpick_desc, "Σπάσε ένα Μαραφέτι.");

        addText(translationBuilder, ModAdvancementProvider.pick_lock_title, "Ξεκλείδωμα 100");
        addText(translationBuilder, ModAdvancementProvider.pick_lock_desc, "Διάρρηξε με επιτυχία την κλειδαριά μιας προθήκης ώστε να αποκτήσεις πρόσβαση στο περιεχόμενό της.");

        addText(translationBuilder, ModAdvancementProvider.carpet_lock_artifact_title, "Αρχαιοκαπηλεία");
        addText(translationBuilder, ModAdvancementProvider.carpet_lock_artifact_desc, "Τοποθέτησε ένα κειμήλιο σε ένα βάθρο με σεμεδάκι, και ασφάλισέ το με μια προθήκη.");

        addText(translationBuilder, ModAdvancementProvider.all_the_colors_title, "Όλο το Ουράνιο Τόξο!");
        addText(translationBuilder, ModAdvancementProvider.all_the_colors_desc, "Μία πληθώρα επιλογών για να κάνεις τα βάθρα σου να ξεχωρίζουν!");

        addText(translationBuilder, ModAdvancementProvider.fully_clean_lockbox_title, "Η Μισή Αρχοντιά");
        addText(translationBuilder, ModAdvancementProvider.fully_clean_lockbox_desc, "Επανάφερε μία σκονισμένη Προθήκη σε καθαρή κατάσταση με τo Ξεσκονιστήρι.");
    }
}
