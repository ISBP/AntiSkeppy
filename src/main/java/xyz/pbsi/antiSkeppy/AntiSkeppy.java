package xyz.pbsi.antiSkeppy;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiSkeppy extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("Store").setExecutor(new Store());
        MuteChat a = new MuteChat(this);     this.getCommand("Mutechat").setExecutor(a);
        this.getServer().getPluginManager().registerEvents(a, this);
        this.getCommand("rank").setExecutor((new Rank()));
        this.getCommand("discord").setExecutor(new Discord());
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler
    public void join(PlayerJoinEvent join)
    {
        Player p = join.getPlayer();
        join.setJoinMessage("");
        p.sendMessage("§7Welcome to the events server, " + p.getName() + ".");
    }
    @EventHandler
    public void leave(PlayerQuitEvent leave)
    {
        leave.setQuitMessage("");
    }
}
