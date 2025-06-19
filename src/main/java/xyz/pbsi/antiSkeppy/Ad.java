package xyz.pbsi.antiSkeppy;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("deprecation")
public class Ad implements CommandExecutor, TabExecutor {
    String store = AntiSkeppy.getInstance().config.getString("Store");
    String dc = AntiSkeppy.getInstance().config.getString("Discord");
    String survival = "/server " +AntiSkeppy.getInstance().config.getString("SurvivalServerName");
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (args.length==0) {
            return false;
        }
        else if (args.length==1) {
            try {
                switch (args[0].toLowerCase()) {

                    case "discord":
                        String hoverMsgDiscord = "§cClick §4HERE §cto join our discord server!";
                        TextComponent discordAd = new TextComponent("\n§cCheck out our discord server §4HERE!\n");
                        discordAd.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(hoverMsgDiscord)));
                        discordAd.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, dc));
                        Bukkit.broadcast(discordAd);
                        playSoundAll(Sound.BLOCK_NOTE_BLOCK_BIT);
                        break;
                    case "store":
                        String hoverMsgStore = "§cClick §4HERE §cto visit our store!";
                        TextComponent storeAd = new TextComponent("\n§cCheck out our store §4HERE!\n");
                        storeAd.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(hoverMsgStore)));
                        storeAd.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, store));
                        Bukkit.broadcast(storeAd);
                        playSoundAll(Sound.BLOCK_NOTE_BLOCK_BIT);
                        break;
                    case "stream":
                        String stream = SetStreamLink.getStreamLink();
                        if (stream!=null) {
                            String hoverMsgStream = "§cClick §4HERE §cto watch AntiSkeppy's livestream!";
                            TextComponent streamAd = new TextComponent("\n§cClick §4HERE §cto watch AntiSkeppy's livestream!\n");
                            streamAd.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(hoverMsgStream)));
                            streamAd.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, stream));
                            Bukkit.broadcast(streamAd);
                            playSoundAll(Sound.BLOCK_NOTE_BLOCK_BIT);
                        }
                        else
                        {
                            commandSender.sendMessage("§cStream link is not set! §7(/setstreamlink <link>");
                        }
                        break;
                    case "survival":
                        if (AntiSkeppy.getInstance().config.getString("SurvivalServerName")==null)
                        {
                            throw new Exception("Config value not found.");
                        }
                        else {
                            String hoverMsgSurvival = "§cClick §4HERE §cto connect to survival!";
                            TextComponent survivalAd = new TextComponent("\n§cClick §4HERE §cto connect to survival!\n");
                            survivalAd.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(hoverMsgSurvival)));
                            survivalAd.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, survival));
                            Bukkit.broadcast(survivalAd);
                            playSoundAll(Sound.BLOCK_NOTE_BLOCK_BIT);
                        }
                        break;
                    default:
                        return false;
                }
            } catch (Exception e) {
                commandSender.sendMessage("§cConfig values not found! Reload the server to reset the config.");
                AntiSkeppy.getInstance().resetConfigValues();
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    public void playSoundAll(Sound sound)
    {
        for(Player p : Bukkit.getOnlinePlayers())
        {
            p.playSound(p.getLocation(), sound, 100, 1);
        }
    }
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return Arrays.asList("discord", "store", "stream", "survival");
    }
}
