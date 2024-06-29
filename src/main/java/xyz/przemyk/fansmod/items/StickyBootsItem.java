package xyz.przemyk.fansmod.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import xyz.przemyk.fansmod.registry.FansModItems;

public class StickyBootsItem extends ArmorItem {

    public StickyBootsItem() {
        super(FansModItems.STICKY_ARMOR_MATERIAL, Type.BOOTS, new Properties().durability(ArmorItem.Type.BOOTS.getDurability(15)));
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return super.getDefaultAttributeModifiers().withModifierAdded(Attributes.MOVEMENT_SPEED, new AttributeModifier(ResourceLocation.withDefaultNamespace("effect.slowness"), -0.3D, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL), EquipmentSlotGroup.FEET);
    }
}
