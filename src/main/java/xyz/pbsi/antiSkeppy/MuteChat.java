package xyz.pbsi.antiSkeppy;

import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;



public class MuteChat implements CommandExecutor, Listener {
    private boolean chat = true;
    private AntiSkeppy plugin;
    public final String bypass = "staff.member";

    public MuteChat(AntiSkeppy plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event)
    {
        Player player = event.getPlayer();
        if(!player.hasPermission(bypass) && !chat)
        {
            event.setCancelled(true);
            player.sendMessage("§c§lMutechat:§r§f Chat is currently muted!");
        }
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        chat = !chat;
        if(chat)
        {
            plugin.getServer().broadcastMessage("§a§lMutechat:§r§f Chat has been unmuted!");
        }
        else
        {
            plugin.getServer().broadcastMessage("§c§lMutechat:§r§f Chat has been muted!");
        }
        return true;
    }
}