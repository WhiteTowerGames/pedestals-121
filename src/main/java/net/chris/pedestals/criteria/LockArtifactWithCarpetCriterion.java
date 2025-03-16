package net.chris.pedestals.criteria;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.chris.pedestals.Pedestals121;
import net.chris.pedestals.block.entity.PedestalBlockEntity;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.Optional;


public class LockArtifactWithCarpetCriterion extends AbstractCriterion<LockArtifactWithCarpetCriterion.Conditions> {

    public static final Identifier ID = Identifier.of(Pedestals121.MOD_ID, "lock_artifact_with_carpet");

    @Override
    public Codec<Conditions> getConditionsCodec() {
        return Conditions.CODEC;
    }

    public record Conditions(Optional<LootContextPredicate> playerPredicate) implements AbstractCriterion.Conditions {

        public static Codec<LockArtifactWithCarpetCriterion.Conditions> CODEC = RecordCodecBuilder.create(instance -> instance.group(
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
            //Then, we decide whether to trigger the advancement based on whether the item is an artifact (Items that emit particles in pedestals).
            return PedestalBlockEntity.ITEM_PARTICLE_MAP.containsKey(storedLockbox.getItem());
        }
    }
    public void trigger(ServerPlayerEntity player, ItemStack storedItem, ItemStack storedCarpet, ItemStack storedLockbox) {
        trigger(player, conditions -> conditions.requirementsMet(storedItem, storedCarpet, storedLockbox));
    }
}
