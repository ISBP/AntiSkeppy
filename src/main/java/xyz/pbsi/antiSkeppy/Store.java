package xyz.pbsi.antiSkeppy;


import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class Store implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (sender instanceof Player player) {
            TextComponent message = new TextComponent("§cCheck out our store§4 here§c!");
            message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://antiskeppy-shop.tebex.io/"));
            player.sendMessage(message);

        }
        return true;
    }
}
