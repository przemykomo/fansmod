package xyz.przemyk.fansmod.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import xyz.przemyk.fansmod.materials.ModArmorMaterial;
import xyz.przemyk.fansmod.registry.Items;

import java.util.UUID;

public class StickyBootsItem extends ArmorItem {

    public StickyBootsItem() {
        super(ModArmorMaterial.STICKY, EquipmentSlotType.FEET, new Properties().group(Items.FANS_ITEM_GROUP));
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<Attribute, AttributeModifier> multimap = HashMultimap.create(super.getAttributeModifiers(equipmentSlot));

        if (equipmentSlot == slot) {
            multimap.put(Attributes.field_233821_d_, new AttributeModifier(UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), "Speed", -0.3D, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }

        return multimap;
    }
}
