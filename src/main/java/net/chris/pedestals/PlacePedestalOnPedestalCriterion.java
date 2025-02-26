package net.chris.pedestals;

import com.mojang.serialization.Codec;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class PlacePedestalOnPedestalCriterion extends AbstractCriterion<PlacePedestalOnPedestalCriterion.Conditions> {

    public static final Identifier ID = Identifier.of(Pedestals121.MOD_ID, "place_pedestal_on_pedestal");



    @Override
    public Codec<PlacePedestalOnPedestalCriterion.Conditions> getConditionsCodec() {
        return PlacePedestalOnPedestalCriterion.Conditions.CODEC;
    }

    public record Conditions(Optional<LootContextPredicate> playerPredicate) implements AbstractCriterion.Conditions {

        public static Codec<PlacePedestalOnPedestalCriterion.Conditions> CODEC = LootContextPredicate.CODEC.optionalFieldOf("player")
                .xmap(PlacePedestalOnPedestalCriterion.Conditions::new, PlacePedestalOnPedestalCriterion.Conditions::player).codec();

        @Override
        public Optional<LootContextPredicate> player() {
            return playerPredicate;
        }

        public boolean requirementsMet() {
            return true;
        }
    }

    public void trigger(ServerPlayerEntity player) {
        trigger(player, PlacePedestalOnPedestalCriterion.Conditions::requirementsMet);
    }

}