package net.chris.pedestals.components;

import net.chris.pedestals.Pedestals121;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModComponents {
    /// And this is the good stuff; This is my first attempt at making an advanced component with a record. Fingers
    /// crossed that this works.
    ///
    /// 1 hour and a can of Monster Mango Loco later, this thing works as intended.
    /// I'm surprised.
    ///
    /// In any case, this data component contains a `UUID` and **two** `Boolean` flags (one of which is optional and only to be used with keys).
    ///
    /// `KeyItem`s will be initialized with no `UUID`, as they must save and hold the UUID that lockboxes are initialized with.
    ///
    ///
    /// `LockboxItem`s will be initialized with a ***random*** `UUID` that will then be slotted into a single **KeyItem**'s **UUIDAndBoolComponent**.
    ///
    /// The first Boolean, `isMapped`, keeps track of whether a `KeyItem` or `LockboxItem` has been paired
    /// with a `LockboxItem` or `KeyItem` respectively.
    ///
    /// The second (***and optional***) `Boolean` is **only for key copying functionality**.
    /// `KeyItem` initializes it as *false* at first. You can then place a ***mapped*** `KeyItem` (i.e. one that has been paired with a `LockBoxItem`)
    /// together with a ***blank, newly crafted*** `KeyItem` in a crafting grid to create a duplicate of that key.
    /// The outputted `KeyItem` then has its `isCopy` flag set to `true`. This process results in three things:
    ///
    /// 1) The old `KeyItem` has copied its properties to the new `KeyItem`. This now means you can share access to locked `PedestalBlocks`
    /// with your ~~nonexistent~~ *ahem* friends.
    ///
    /// 2) Upon further inspection, the new `KeyItem`'s `tooltip` now reads ***"Duplicate Key"***.
    ///
    /// 3) The *duplicated* `KeyItem` ***cannot*** be used to create further copies that can unlock the same `LockboxItem`.
    ///
    /// In short:
    ///
    /// <ul>
    /// <li>This custom data component holds a `UUID` and two `Boolean`s</li>
    /// <li>The second `Boolean` is optional and is used to balance key duplication.</li>
    /// </ul>
    public static final ComponentType<UUIDAndBoolComponent> UUID_BOOL_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Pedestals121.MOD_ID, "uuid_bool"),
            ComponentType.<UUIDAndBoolComponent>builder().codec(UUIDAndBoolComponent.UUID_BOOL_CODEC).build()
    );

    public static void initialize() {
        Pedestals121.LOGGER.info("Registering components for Pedestals");
    }
}
