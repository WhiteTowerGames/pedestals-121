package net.chris.pedestals.criteria;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.chris.pedestals.Pedestals121;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class FullyCleanLockboxCriterion extends AbstractCriterion<FullyCleanLockboxCriterion.Conditions> {

    public static final Identifier ID = Identifier.of(Pedestals121.MOD_ID, "fully_clean_lockbox");

    @Override
    public Codec<Conditions> getConditionsCodec() {
        return Conditions.CODEC;
    }

    public record Conditions(Optional<LootContextPredicate> playerPredicate) implements AbstractCriterion.Conditions {

        public static Codec<FullyCleanLockboxCriterion.Conditions> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                LootContextPredicate.CODEC.optionalFieldOf("player").forGetter(Conditions::player)
        ).apply(instance, Conditions::new));

        @Override
        public Optional<LootContextPredicate> player() {
            return playerPredicate;
        }

        public boolean requirementsMet(int currentDust) {
            return currentDust == 0;
        }
    }
    public void trigger(ServerPlayerEntity player, int currentDust) {
        trigger(player, conditions -> conditions.requirementsMet(currentDust));
    }
}
