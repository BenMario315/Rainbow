package per.mario.minecraft.plugs.rainbow.manager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;
import per.mario.minecraft.plugs.rainbow.Rainbow;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @PackageName per.mario.minecraft.plugs.rainbow.manager
 * @ClassName RegisterExecutorManager
 * @Author mario
 * @Date 2020-12-25 15:38:37
 * @Description TODO
 * @Version 1.0
 **/
public class CommandRegisterManager {

    private CommandMap commandMap;

    public static void init(Rainbow rainbow, PluginCommand command) {
//        1.获取CommandMap对象
        CommandMap commandMap = getCommandMap(rainbow);

//        2.注册命令
        commandMap.register("",command);
    }


    /**
     * 获取CommandMap对象
     *
     * @param plugin 插件对象
     * @return 返回CommandMap对象，如果异常，则返回null
     */
    private static CommandMap getCommandMap(Plugin plugin) {
        try {
            if (plugin != null) {
                Field field = SimplePluginManager.class.getDeclaredField("commandMap");
                field.setAccessible(true);
                return (CommandMap) field.get(plugin.getServer().getPluginManager());
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 注册命令
     *
     * @param plugin  插件对象
     * @param command 被注册的命令
     * @return
     */
    public static Boolean commandRegister(Plugin plugin, Command command) {
        CommandMap commandMap = getCommandMap(plugin);
        if (commandMap != null)
            return commandMap.register("", command);
        return false;
    }

    /**
     * 注册命令
     *
     * @param plugin         插件对象
     * @param fallbackPrefix 命令之前的前缀，以使命令独一无二
     * @param command        被注册的命令
     * @return
     */
    public static Boolean commandRegister(Plugin plugin, String fallbackPrefix, Command command) {
        CommandMap commandMap = getCommandMap(plugin);
        if (commandMap != null)
            return commandMap.register(fallbackPrefix, command);
        return false;
    }


    /**
     * 注册命令
     *
     * @param plugin         插件对象
     * @param label          命令的别名
     * @param fallbackPrefix 命令之前的前缀，以使命令独一无二
     * @param command        被注册的命令
     * @return
     */
    public static Boolean commandRegister(Plugin plugin, String label, String fallbackPrefix, Command command) {
        CommandMap commandMap = getCommandMap(plugin);
        if (commandMap != null)
            return commandMap.register(label, fallbackPrefix, command);
        return false;
    }

    /**
     * 注册命令
     *
     * @param plugin         插件对象
     * @param fallbackPrefix 命令之前的前缀，以使命令独一无二
     * @param commands       被注册的命令集合List<Command>类型
     */
    public static void commandRegister(Plugin plugin, String fallbackPrefix, List<Command> commands) {
        CommandMap commandMap = getCommandMap(plugin);
        if (commandMap != null)
            commandMap.registerAll(fallbackPrefix, commands);
    }


}
