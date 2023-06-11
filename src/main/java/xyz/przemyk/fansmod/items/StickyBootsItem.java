package xyz.przemyk.fansmod.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import xyz.przemyk.fansmod.materials.ModArmorMaterial;

import java.util.UUID;

public class StickyBootsItem extends ArmorItem {

    public StickyBootsItem() {
        super(ModArmorMaterial.STICKY, Type.BOOTS, new Properties());
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
        Multimap<Attribute, AttributeModifier> multiMap = HashMultimap.create(super.getDefaultAttributeModifiers(equipmentSlot));

        if (equipmentSlot == EquipmentSlot.FEET) {
            multiMap.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), "Speed", -0.3D, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }

        return multiMap;
    }
}
