package xyz.pbsi.antiSkeppy;
import xyz.pbsi.antiSkeppy.AntiSkeppy;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.InheritanceNode;
import net.luckperms.api.model.group.Group;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Rank implements CommandExecutor {
/**    private final AntiSkeppy plugin;
    private final LuckPerms luckPerms;

    public SetGroupCommand(AntiSkeppy plugin, LuckPerms luckPerms) {
        this.plugin = plugin;
        this.luckPerms = luckPerms;
    }
**/

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§cIncorrect usage");
            return false;
        } else {
            @NotNull OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
            String rank = args[1];

            //Group group = luckPerms.getGroupManager().getGroup(rank);
            if (rank == null || args[1].isEmpty() || args[0].isEmpty()) {
                return false;
            } else {
                Bukkit.getServer().dispatchCommand(
                        Bukkit.getConsoleSender(),
                        "lp user " + target.getName() +
                                " parent set " + rank);
                sender.sendMessage("§aGranted " + target.getName() + " " + rank);
                return true;
            }
        }
    }
}