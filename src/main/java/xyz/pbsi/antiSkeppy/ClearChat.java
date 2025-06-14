package xyz.pbsi.antiSkeppy;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ClearChat implements CommandExecutor  {
    @Override

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        for(int i = 0; i <100; i++)
        {

            Bukkit.broadcastMessage("");
        }
        Bukkit.broadcastMessage("§c§lClear Chat:§r§f Chat has been cleared!");
        return true;
    }
}
