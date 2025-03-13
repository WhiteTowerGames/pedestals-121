package net.chris.pedestals.criteria;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.chris.pedestals.Pedestals121;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.Optional;

import static net.minecraft.item.Items.TOTEM_OF_UNDYING;

public class LockTotemWithCarpetCriterion extends AbstractCriterion<LockTotemWithCarpetCriterion.Conditions> {

    public static final Identifier ID = Identifier.of(Pedestals121.MOD_ID, "lock_totem_with_carpet");

    @Override
    public Codec<Conditions> getConditionsCodec() {
        return Conditions.CODEC;
    }

    public record Conditions(Optional<LootContextPredicate> playerPredicate) implements AbstractCriterion.Conditions {

        public static Codec<LockTotemWithCarpetCriterion.Conditions> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                LootContextPredicate.CODEC.optionalFieldOf("player").forGetter(Conditions::player)
        ).apply(instance, Conditions::new));

        @Override
        public Optional<LootContextPredicate> player() {
            return playerPredicate;
        }

        public boolean requirementsMet(ItemStack storedItem, ItemStack storedCarpet, ItemStack storedLockbox) {
            //First, we check if the pedestal has any empty slots:
            if (storedItem.isEmpty() || storedCarpet.isEmpty() || storedLockbox.isEmpty()) {
                return false;
            }
            //Then, we decide whether to trigger the advancement based on whether the item is a totem.
            return storedItem.isOf(TOTEM_OF_UNDYING);
        }
    }
    public void trigger(ServerPlayerEntity player, ItemStack storedItem, ItemStack storedCarpet, ItemStack storedLockbox) {
        trigger(player, conditions -> conditions.requirementsMet(storedItem, storedCarpet, storedLockbox));
    }
}
