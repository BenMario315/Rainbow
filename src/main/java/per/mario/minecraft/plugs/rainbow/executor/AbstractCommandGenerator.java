package per.mario.minecraft.plugs.rainbow.executor;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName per.mario.minecraft.plugs.thearchy.utils
 * @ClassName CommandGenerator
 * @Author mario
 * @Date 2020-04-09 18:44:34
 * @Description TODO
 * @Version 1.0
 **/
public abstract class AbstractCommandGenerator {

    /**
     * 创造一个命令对象
     *
     * @param plugin 插件对象
     * @param name   命令名称
     * @return 返回一个命令对象，如果出现异常则返回null
     */
    private static PluginCommand getPluginCommand(Plugin plugin, String name) {
        if (StringUtils.isNotBlank(name) && null != plugin) {
            try {
                Class<PluginCommand> clz = PluginCommand.class;
                Constructor<PluginCommand> constructor = clz.getDeclaredConstructor(String.class, Plugin.class);
                constructor.setAccessible(true);
                return constructor.newInstance(name, plugin);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 创造一个命令对象
     *
     * @param plugin  插件对象
     * @param name    命令名称
     * @param aliases 命令别名List<String>类型
     * @return 返回一个命令对象，如果出现异常则返回null
     */
    private static PluginCommand getPluginCommand(Plugin plugin, String name, List<String> aliases) {
        PluginCommand command = getPluginCommand(plugin, name);
        if (command == null) return null;
        command.setAliases(aliases);
        return command;
    }


    /**
     * 创造一个命令对象
     *
     * @param plugin      插件对象
     * @param name        命令名称
     * @param aliases     命令别名List<String>类型
     * @param description 命令的简介
     * @return 返回一个命令对象，如果出现异常则返回null
     */
    private static PluginCommand getPluginCommand(Plugin plugin, String name, List<String> aliases, String description) {
        PluginCommand command = getPluginCommand(plugin, name, aliases);
        if (command == null) return null;
        command.setDescription(description);
        return command;
    }


    /**
     * 创造一个命令对象
     *
     * @param plugin      插件对象
     * @param name        命令名称
     * @param aliases     命令别名List<String>类型
     * @param description 命令的简介
     * @param label       命令标签
     * @return 返回一个命令对象，如果出现异常则返回null
     */
    private static PluginCommand getPluginCommand(Plugin plugin, String name, List<String> aliases, String description, String label) {
        PluginCommand command = getPluginCommand(plugin, name, aliases, description);
        if (command == null) return null;
        command.setLabel(label);
        return command;
    }

    /**
     * 创造一个命令对象
     *
     * @param plugin      插件对象
     * @param name        命令名称
     * @param aliases     命令别名List<String>类型
     * @param description 命令的简介
     * @param label       命令标签
     * @param permission  执行此命令所需的权限
     * @return 返回一个命令对象，如果出现异常则返回null
     */
    private static PluginCommand getPluginCommand(Plugin plugin, String name, List<String> aliases, String description, String label, String permission) {
        PluginCommand command = getPluginCommand(plugin, name, aliases, description, label);
        if (command == null) return null;
        command.setPermission(permission);
        return command;
    }

    /**
     * 创造一个命令对象
     *
     * @param plugin            插件对象
     * @param name              命令名称
     * @param aliases           命令别名List<String>类型
     * @param description       命令的简介
     * @param label             命令标签
     * @param permission        执行此命令所需的权限
     * @param permissionMessage 权限不足时发送的消息
     * @return 返回一个命令对象，如果出现异常则返回null
     */
    private static PluginCommand getPluginCommand(Plugin plugin, String name, List<String> aliases, String description, String label, String permission, String permissionMessage) {
        PluginCommand command = getPluginCommand(plugin, name, aliases, description, label, permission);
        if (command == null) return null;
        command.setPermissionMessage(permissionMessage);
        return command;
    }

    /**
     * 创造一个命令对象
     *
     * @param plugin            插件对象
     * @param name              命令名称
     * @param aliases           命令别名List<String>类型
     * @param description       命令的简介
     * @param label             命令标签
     * @param permission        执行此命令所需的权限
     * @param permissionMessage 权限不足时发送的消息
     * @param usage             命令的用法示例
     * @return 返回一个命令对象，如果出现异常则返回null
     */
    private static PluginCommand getPluginCommand(Plugin plugin, String name, List<String> aliases, String description, String label, String permission, String permissionMessage, String usage) {
        PluginCommand command = getPluginCommand(plugin, name, aliases, description, label, permission, permissionMessage);
        if (command == null) return null;
        command.setUsage(usage);
        return command;
    }

    /**
     * @param plugin            插件对象
     * @param name              命令名称
     * @param aliases           命令别名List<String>类型
     * @param description       命令的简介
     * @param label             命令标签
     * @param permission        执行此命令所需的权限
     * @param permissionMessage 权限不足时发送的消息
     * @param usage             命令的用法示例
     * @param tabCompleter      Tab补全建议
     * @return
     */
    private static PluginCommand getPluginCommand(Plugin plugin, String name, List<String> aliases, String description, String label, String permission, String permissionMessage, String usage, TabCompleter tabCompleter) {
        PluginCommand command = getPluginCommand(plugin, name, aliases, description, label, permission, permissionMessage, usage);
        if (command == null) return null;
        command.setTabCompleter(tabCompleter);
        return command;
    }


    /**
     * 创造一个命令对象
     *
     * @param plugin          插件对象
     * @param commandExecutor 命令执行器对象
     * @return 返回一个命令对象，如果出现异常则返回null
     */
    public static PluginCommand getPluginCommand(Plugin plugin, AbstractCommandExecutor commandExecutor) {
        if (StringUtils.isNotBlank(commandExecutor.getName()) && null != plugin) {
            PluginCommand pluginCommand = getPluginCommand(plugin,
                    commandExecutor.getName(),
                    commandExecutor.getAliases(),
                    commandExecutor.getDescription(),
                    commandExecutor.getLabel(),
                    commandExecutor.getPermission(),
                    commandExecutor.getPermissionMessage(),
                    commandExecutor.getUsage(),
                    commandExecutor.getTabCompleter()
            );
            pluginCommand.setExecutor(commandExecutor);
            return pluginCommand;
        }
        return null;
    }

    /**
     * 创造一组命令对象
     * @param plugin
     * @param commandExecutorList
     * @return
     */
    public static List<PluginCommand> getPluginCommand(Plugin plugin, List<AbstractCommandExecutor> commandExecutorList) {
        List<PluginCommand> pluginCommandList = new ArrayList<PluginCommand>();

        if (null != commandExecutorList && !commandExecutorList.isEmpty() && null != plugin) {
            for (AbstractCommandExecutor commandExecutor : commandExecutorList) {
                PluginCommand pluginCommand = getPluginCommand(plugin, commandExecutor);
                if (pluginCommand != null) pluginCommandList.add(pluginCommand);
            }
            return pluginCommandList;
        }
        return null;
    }
}