package xyz.pbsi.antiSkeppy;

import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class AntiSkeppy extends JavaPlugin implements Listener {
    private LuckPerms luckPerms;
    FileConfiguration config = this.getConfig();
    private static AntiSkeppy INSTANCE;
    @Override
    public void onEnable() {
        INSTANCE = this;
        // Plugin startup logic
        this.luckPerms = getServer().getServicesManager().load(LuckPerms.class);
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            LuckPerms api = provider.getProvider();

        }
        this.getCommand("Store").setExecutor(new Store());
        MuteChat a = new MuteChat(this);     this.getCommand("Mutechat").setExecutor(a);
        this.getServer().getPluginManager().registerEvents(a, this);
        this.getCommand("rank").setExecutor(new Rank());
        this.getCommand("discord").setExecutor(new Discord());
        this.getCommand("clearchat").setExecutor(new ClearChat());
        getServer().getPluginManager().registerEvents(this, this);
        if(!getDataFolder().exists())
        {
            getDataFolder().mkdir();
            this.saveDefaultConfig();
            config.addDefault("Server", "events");
            config.addDefault("Discord", "https://antiskeppy.xyz/discord");
            config.options().copyDefaults(true);
            saveConfig();
        }

    }
    public static AntiSkeppy getInstance() {
        return INSTANCE;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler
    public void join(PlayerJoinEvent join)
    {
        String srv = config.getString("Server");
        Player p = join.getPlayer();
        join.setJoinMessage("");
        p.sendMessage("§7Welcome to " + srv + " " + p.getName() + ".");
    }
    @EventHandler
    public void leave(PlayerQuitEvent leave)
    {
        leave.setQuitMessage("");
    }

}
