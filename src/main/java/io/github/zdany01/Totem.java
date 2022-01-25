package io.github.zdany01;

import io.github.zdany01.respawntotem.MainClass;
import net.minecraft.world.item.Item;

public class Totem extends Item{
    public Totem(){
        super(new Item.Properties()
        .tab(MainClass.RespawnTotemCTab)
        
        );
    }
}
