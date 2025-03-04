package net.chris.pedestals.criteria;

import com.mojang.serialization.Codec;
import net.chris.pedestals.Pedestals121;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class PlaceEpicItemOnPedestalCriterion extends AbstractCriterion<PlaceEpicItemOnPedestalCriterion.Conditions> {

    public static final Identifier ID = Identifier.of(Pedestals121.MOD_ID, "place_epic_item_on_pedestal");

    @Override
    public Codec<Conditions> getConditionsCodec() {
        return Conditions.CODEC;
    }

    public record Conditions(Optional<LootContextPredicate> playerPredicate) implements AbstractCriterion.Conditions {

        public static Codec<PlaceEpicItemOnPedestalCriterion.Conditions> CODEC = LootContextPredicate.CODEC.optionalFieldOf("player")
                .xmap(Conditions::new, Conditions::player).codec();

        @Override
        public Optional<LootContextPredicate> player() {
            return playerPredicate;
        }

        public boolean requirementsMet() {
            return true;
        }
    }

    public void trigger(ServerPlayerEntity player) {
        trigger(player, Conditions::requirementsMet);
    }

}
