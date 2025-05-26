package xyz.pbsi.antiSkeppy;

import org.bukkit.command.TabExecutor;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.TabCompleteEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MuteChat implements CommandExecutor, Listener, TabExecutor {
    private boolean chat = true;
    private boolean staff = false;
    private boolean self = false;
    private AntiSkeppy plugin;
    public final String bypass = "mc.bypass";
    public final String staffBypass = "mc.staff";
    public final String admin = "mc.admin";



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
        if(!player.hasPermission(staffBypass) && !chat && staff)
        {
            event.setCancelled(true);
            player.sendMessage("§c§lMutechat:§r§f Chat is currently restricted to §cstaff!");
        }
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length == 0) {
            if (!chat) {
                plugin.getServer().broadcastMessage("§a§lMutechat:§r§f Chat has been unmuted!");
                chat = !chat;
            } else {
                chat = false;
                plugin.getServer().broadcastMessage("§c§lMutechat:§r§f Chat has been muted!");
            }

            return true;
        }
        if (strings[0].equalsIgnoreCase("staff")) {
            if (commandSender.hasPermission(admin)) {
                if (staff) {
                    staff = false;
                    commandSender.sendMessage("§c§lMutechat:§r§f Set mode to §cNORMAL");
                } else {
                    staff = true;
                    commandSender.sendMessage("§c§lMutechat:§r§f Set mode to §cSTAFF");
                }
                return true;
            }
            else{
                commandSender.sendMessage("§cThis requires admin permission!");
                return true;
            }

        }

        if (strings[0].equalsIgnoreCase("Self")) {
            if (commandSender.hasPermission(admin)) {
                if (self) {
                    self = false;
                    commandSender.sendMessage("§c§lMutechat:§r§f Set mode to §cNORMAL");
                } else {
                    staff = true;
                    commandSender.sendMessage("§c§lMutechat:§r§f Set mode to §cSELF");
                }
                return true;
            }
            else{
                commandSender.sendMessage("§cThis requires admin permission!");
                return true;
            }

        }

        return false;
    }
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 1)
            return Arrays.asList("Staff");

        return new ArrayList<>();
    }
}