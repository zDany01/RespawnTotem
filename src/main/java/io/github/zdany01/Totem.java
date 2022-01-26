package io.github.zdany01;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;

import io.github.zdany01.respawntotem.MainClass;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.chat.*;

public class Totem extends Item{
    public Totem(){
        super(new Item.Properties()
        .tab(MainClass.RespawnTotemCTab)

        );
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand){
        
        return super.use(world,player,hand);
    }


}
