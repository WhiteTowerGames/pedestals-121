package net.chris.pedestals.components;

import net.chris.pedestals.Pedestals121;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.UUID;

public class ModComponents {

    /// # LockAndKeyDataComponent
    /// And this is the good stuff—my first attempt at making an advanced component with a record.
    /// Fingers crossed that this works.
    ///
    /// **1 hour and a can of Monster Mango Loco later...** This thing actually works as intended.
    /// I'm surprised.
    ///
    /// ---
    ///
    /// This data component contains a `UUID` and **two** `boolean` flags (one of which is optional and only used with keys).
    /// To streamline this, {@link LockAndKeyDataComponent#LockAndKeyDataComponent(UUID, boolean)} is a delegate constructor
    /// that is used for lockboxes and initializes `isCopy` as `false`.
    ///
    /// ### How Items Use This Component:
    /// - **`KeyItem`s** start with *no* `UUID`, as they must store the `UUID` of a `LockboxItem` when paired.
    /// - **`LockboxItem`s** are initialized with a ***random*** `UUID`, which is then transferred to a `KeyItem` when linked.
    ///
    /// ### Boolean Flags:
    /// 1. **`isMapped`** – Tracks whether a `KeyItem` or `LockboxItem` has been paired.
    /// 2. **`isCopy`** (optional, used only for keys) – Tracks whether a `KeyItem` was created via duplication.
    ///
    /// ---
    ///
    /// ## Key Duplication:
    ///
    /// A `KeyItem` starts with `isCopy = false`. If a ***mapped*** `KeyItem` (i.e., one already linked to a `LockboxItem`)
    /// is placed in a crafting grid with a ***newly crafted, blank*** `KeyItem`, a duplicate is created.
    /// The resulting key has its `isCopy` flag set to `true`.
    ///
    /// **Key duplication results in three key things:**
    /// 1. The old `KeyItem` transfers its `UUID` to the new one, allowing shared access to locked `PedestalBlocks`
    ///    with your ~~nonexistent~~ *ahem* friends.
    /// 2. The duplicated `KeyItem`'s tooltip now reads ***"Duplicate Key"***.
    /// 3. *By default, duplicate keys cannot be used to create further copies*—only the original key can do that.
    /// This behavior is configurable via gamerule (see below).
    ///
    /// See also:
    /// <ul>
    /// <li>{@link net.chris.pedestals.gamerules.ModGameRules#INFINITE_KEY_DUPING INFINITE_KEY_DUPING} for the game rule controlling key duplication.</li>
    /// <li>{@link net.chris.pedestals.recipes.KeyDuplicationRecipe KeyDuplicationRecipe} for the recipe involved in key duplication.</li>
    /// </ul>
    /// ---
    ///
    /// ## Lockbox Duplication:
    ///
    /// A `LockboxItem` starts with a randomly generated `UUID`.
    /// If a ***mapped*** `LockboxItem` (i.e., one already linked to a `KeyItem`)
    /// is placed in a crafting grid with a ***newly crafted, blank*** `LockboxItem`, a duplicate is created.
    ///
    /// **Lockbox duplication results in** the old `LockboxItem` transferring its `UUID` to the new one, meaning both now share the same access.
    ///
    /// **Note:** Unlike `KeyItem`s, duplicated `LockboxItem`s **can** be used to create additional copies, meaning there is no restriction
    /// on further lockbox duplication.
    ///
    /// See also:
    /// * {@link net.chris.pedestals.recipes.LockboxDuplicationRecipe LockboxDuplicationRecipe} for the recipe involved in lockbox duplication.
    ///
    /// ---
    ///
    /// ### Summary:
    /// - This custom data component stores a `UUID` and two `boolean` flags.
    /// - The second `boolean` (`isCopy`) is optional and exists to balance `KeyItem` duplication.
    /// - Key duplication can be controlled via the gamerule {@link net.chris.pedestals.gamerules.ModGameRules#INFINITE_KEY_DUPING INFINITE_KEY_DUPING}.
    public static final ComponentType<LockAndKeyDataComponent> LOCK_AND_KEY_DATA = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Pedestals121.MOD_ID, "lockbox_data"),
            ComponentType.<LockAndKeyDataComponent>builder().codec(LockAndKeyDataComponent.UUID_BOOL_CODEC).build()
    );

    /// # UnlocksLockboxesComponent
    ///
    /// Represents a data component that allows an item to unlock all lockboxes.
    ///
    /// This component is primarily used by the creative-only **Skeleton Key** item, which acts as a master key,
    /// capable of opening any locked pedestal without requiring a specific UUID match.
    ///
    /// ### Usage:
    /// - This component can be assigned to custom key items via the `/give` command, enabling the creation of new master keys.
    /// - Example command to grant a player an item with this component:
    ///   ```
    ///   /give @p diamond[pedestals:unlocks_lockboxes={}]
    ///   ```
    /// - Any item with this component will bypass lockbox security.
    /// - The component's only and optional `value` **does not matter** and is there simply because *there needs to be
    /// a value*.
    /// - To reflect this, {@link UnlocksLockboxesComponent#UnlocksLockboxesComponent()} is a parameterless delegate constructor
    /// that simply passes in a `value` of `true`.
    ///
    /// ---
    ///
    /// ### See also:
    /// * {@link net.chris.pedestals.item.items.KeyItem#useOnBlock KeyItem#useOnBlock}
    /// for details on how interaction with items containing this component type are handled.
    public static final ComponentType<UnlocksLockboxesComponent> UNLOCKS_LOCKBOXES_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Pedestals121.MOD_ID, "unlocks_lockboxes"),
            ComponentType.<UnlocksLockboxesComponent>builder().codec(UnlocksLockboxesComponent.UNLOCKS_LOCKBOXES_CODEC).build()
    );

    /// # LockboxDustComponent
    /// <p>
    /// Represents the dust accumulation level of a lockbox.
    /// <p>
    /// This component stores an integer value indicating the amount of dust present on a lockbox.
    /// It is used to track the state of dust buildup over time and can be modified through brushing.
    /// A higher value means more dust has accumulated, obscuring the lockbox until it is cleaned.
    /// </p>
    ///
    /// ---
    ///
    /// <p>
    /// The dust level is managed as a data component, allowing efficient storage and retrieval
    /// without requiring a dedicated block entity.
    /// </p>
    ///
    /// ---
    ///
    /// <p>
    /// Brushing a lockbox with a brush item gradually removes dust, reducing this component’s value.
    /// Once fully cleaned, the dust overlay disappears.
    /// </p>
    ///
    /// @see LockboxDustComponent
    /// @see net.chris.pedestals.block.blocks.PedestalExtensionBlock PedestalExtensionBlock
    public static final ComponentType<LockboxDustComponent> LOCKBOX_DUST_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Pedestals121.MOD_ID, "lockbox_dust"),
            ComponentType.<LockboxDustComponent>builder().codec(LockboxDustComponent.LOCKBOX_DUST_COMPONENT).build()
    );

    public static void initialize() {
        Pedestals121.LOGGER.info("Registering components for Pedestals");
    }
}
