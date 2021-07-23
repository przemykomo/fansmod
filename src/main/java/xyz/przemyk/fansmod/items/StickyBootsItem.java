package xyz.przemyk.fansmod.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import xyz.przemyk.fansmod.materials.ModArmorMaterial;
import xyz.przemyk.fansmod.registry.Items;

import java.util.UUID;

public class StickyBootsItem extends ArmorItem {

    public StickyBootsItem() {
        super(ModArmorMaterial.STICKY, EquipmentSlot.FEET, new Properties().tab(Items.FANS_ITEM_GROUP));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
        Multimap<Attribute, AttributeModifier> multiMap = HashMultimap.create(super.getDefaultAttributeModifiers(equipmentSlot));

        if (equipmentSlot == slot) {
            multiMap.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), "Speed", -0.3D, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }

        return multiMap;
    }
}
