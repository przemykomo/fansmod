package xyz.przemyk.fansmod.items;

import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import xyz.przemyk.fansmod.Registration;
import xyz.przemyk.fansmod.materials.ModArmorMaterial;

import java.util.UUID;

public class StickyBootsItem extends ArmorItem {

    public StickyBootsItem() {
        super(ModArmorMaterial.STICKY, EquipmentSlotType.FEET, new Properties().group(Registration.FANS_ITEM_GROUP));
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);

        if (equipmentSlot == slot) {
            multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), "Speed", -0.3D, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }

        return multimap;
    }
}
