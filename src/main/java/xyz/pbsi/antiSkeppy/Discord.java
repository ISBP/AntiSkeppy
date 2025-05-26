package xyz.pbsi.antiSkeppy;


import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
@SuppressWarnings("deprecation")
public class Discord implements CommandExecutor  {
    //FileConfiguration config = this.getConfig();
    @Override

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (sender instanceof Player player) {
            TextComponent message = new TextComponent("§cCheck out our discord§4 here§c!");
            //String discord = config.getString("");

            message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://antiskeppy.xyz/discord"));
            player.sendMessage(message);

        }
        return true;
    }
}
