package io.github.zdany01.respawntotem;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;

public class Utils {
    public static void ExecuteCommandAs(Player player, String command, int executionLevel, MinecraftServer server){
        server.getCommands().performCommand(player.createCommandSourceStack().withSuppressedOutput().withPermission(executionLevel),command);
    }
    public static void ExecuteCommandAs(Player player, String command, int executionLevel){
        ExecuteCommandAs(player, command, executionLevel, player.getServer());
    }
}
