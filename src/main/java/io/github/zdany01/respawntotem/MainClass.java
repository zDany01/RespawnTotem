package io.github.zdany01.respawntotem;

import io.github.zdany01.Totem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod("respawntotem")
public class MainClass {
    public static final String MOD_ID = "respawntotem";

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final CreativeModeTab RespawnTotemCTab = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.ANVIL);
        }
    };
    
    public static final RegistryObject<Item> Totem_ITEM = ITEMS.register("totem", () -> new Totem());
    /*per registrare un oggetto effettuare:
    * public static final RegistryObject<Block/Iten> BLOCK/ITEM(name) = (BLOCKS/ITEMS).register("(item/block)id", () -> new Block/Item);
    *
    */

    public MainClass(){
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus); //registra tutti gli elementi del registro blocks
        ITEMS.register(bus); //registra tutti gli elementi del registro ITEMS
    }
}
