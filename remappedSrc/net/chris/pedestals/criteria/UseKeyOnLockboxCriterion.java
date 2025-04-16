package net.chris.pedestals.criteria;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.chris.pedestals.Pedestals121;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class UseKeyOnLockboxCriterion extends AbstractCriterion<UseKeyOnLockboxCriterion.Conditions> {

    public static final Identifier ID = Identifier.of(Pedestals121.MOD_ID, "use_key_on_lockbox");

    @Override
    public Codec<net.chris.pedestals.criteria.UseKeyOnLockboxCriterion.Conditions> getConditionsCodec() {
        return net.chris.pedestals.criteria.UseKeyOnLockboxCriterion.Conditions.CODEC;
    }

    public record Conditions(Optional<LootContextPredicate> playerPredicate) implements AbstractCriterion.Conditions {

        public static Codec<UseKeyOnLockboxCriterion.Conditions> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                LootContextPredicate.CODEC.optionalFieldOf("player").forGetter(net.chris.pedestals.criteria.UseKeyOnLockboxCriterion.Conditions::player)).apply(instance, net.chris.pedestals.criteria.UseKeyOnLockboxCriterion.Conditions::new));

        @Override
        public Optional<LootContextPredicate> player() {
            return playerPredicate;
        }

        public boolean requirementsMet() {
            return true;
        }
    }
    public void trigger(ServerPlayerEntity player) {
        trigger(player, net.chris.pedestals.criteria.UseKeyOnLockboxCriterion.Conditions::requirementsMet);
    }
}
