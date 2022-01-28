package io.github.zdany01.respawntotem;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.MinecraftServer;

public class Totem extends Item{
    public Totem(){
        super(new Item.Properties().tab(MainClass.RespawnTotemCTab).stacksTo(1));
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand){
        ItemStack handItem = player.getItemInHand(hand);
        if(!world.isClientSide){
            Boolean playerFound = false;
            MinecraftServer sMinecraftServer = player.getServer();
            String DefaultTotemName = new ItemStack(MainClass.Totem_ITEM.get()).getDisplayName().getString();
            String handItemName = handItem.getDisplayName().getString();
            if(!handItemName.equals(DefaultTotemName)){
                handItemName = handItemName.replace("[", "").replace("]", "");
                String[] PlayerList = sMinecraftServer.getPlayerNames();
                for(int i = 0; i < PlayerList.length; i++){ if(PlayerList[i].equals(handItemName)) playerFound = true; }
                if(playerFound){
                    String respawncmd = "tellraw @a [\"\",{\"text\":\"✞ Player \"},{\"text\":\"" + handItemName + "\",\"bold\":true,\"color\":\"green\"},{\"text\":\" has been resurrected ✞\"}]";
                    Utils.ExecuteCommandAs(player, String.format("teleport {0} {1}", handItemName, player.getDisplayName().getString()), 4, sMinecraftServer);
                    player.getInventory().removeItem(player.getItemInHand(hand));
                    Utils.ExecuteCommandAs(player, "gamemode survival " + handItemName, 4, sMinecraftServer);
                    Utils.ExecuteCommandAs(player, respawncmd, 4, sMinecraftServer);
                } else{
                    String command = "tellraw @a [\"\",{\"text\":\"Player \"},{\"text\":\"" + handItemName + "\",\"bold\":true,\"color\":\"red\"},{\"text\":\" not found\"}]";
                    Utils.ExecuteCommandAs(player, command, 4, sMinecraftServer);
                }
            } else {
                String command = "/tellraw @s [\"\",{\"text\":\"!!!\",\"obfuscated\":true},{\"text\":\"You have to \"},{\"text\":\"rename\",\"bold\":true},{\"text\":\" me with the \"},{\"text\":\"name\",\"bold\":true},{\"text\":\" of the \"},{\"text\":\"dead person\",\"bold\":true},{\"text\":\".\"},{\"text\":\"!!!\",\"obfuscated\":true}]";
                Utils.ExecuteCommandAs(player, command, 4,sMinecraftServer);
            }
        }
        return super.use(world,player,hand);
    }
}
