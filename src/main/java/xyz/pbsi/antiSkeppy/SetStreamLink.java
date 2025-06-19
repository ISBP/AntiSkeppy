package xyz.pbsi.antiSkeppy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class SetStreamLink implements CommandExecutor {
    private static String streamlink;
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(args.length==1)
        {
            streamlink = args[0];
            commandSender.sendMessage("§cSet the stream link to §4"+args[0]+"§c!");
            return true;
        }
        return false;
    }
    public static String getStreamLink()
    {
        return streamlink;
    }

}
