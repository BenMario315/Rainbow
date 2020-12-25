package per.mario.minecraft.plugs.rainbow.executor;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

import java.util.List;

/**
 * @PackageName per.mario.minecraft.plugs.thearchy.executor
 * @ClassName BaseExecutor
 * @Author mario
 * @Date 2020-04-13 16:38:43
 * @Description TODO
 * @Version 1.0
 **/
public abstract class AbstractCommandExecutor implements CommandExecutor {
    private final String postfix = "Executor";

    private String name;
    private List<String> aliases;
    private String description;
    private String label;
    private String permission;
    private String permissionMessage;
    private String usage;
    private TabCompleter tabCompleter;

    public <T extends AbstractCommandExecutor> AbstractCommandExecutor(Class<T> currentType) {
        this.name = StringUtils.substringBeforeLast(currentType.getSimpleName(), postfix);
    }

    public <T extends AbstractCommandExecutor> AbstractCommandExecutor(Class<T> currentType, List<String> aliases) {
        this.name = StringUtils.substringBeforeLast(currentType.getSimpleName(), postfix);
        this.aliases = aliases;
    }

    public <T extends AbstractCommandExecutor> AbstractCommandExecutor(Class<T> currentType, List<String> aliases, String description) {
        this.name = StringUtils.substringBeforeLast(currentType.getSimpleName(), postfix);
        this.aliases = aliases;
        this.description = description;
    }

    public <T extends AbstractCommandExecutor> AbstractCommandExecutor(Class<T> currentType, List<String> aliases, String description, String label) {
        this.name = StringUtils.substringBeforeLast(currentType.getSimpleName(), postfix);
        this.aliases = aliases;
        this.description = description;
        this.label = label;
    }

    public <T extends AbstractCommandExecutor> AbstractCommandExecutor(Class<T> currentType, List<String> aliases, String description, String label, String permission) {
        this.name = StringUtils.substringBeforeLast(currentType.getSimpleName(), postfix);
        this.aliases = aliases;
        this.description = description;
        this.label = label;
        this.permission = permission;
    }

    public <T extends AbstractCommandExecutor> AbstractCommandExecutor(Class<T> currentType, List<String> aliases, String description, String label, String permission, String permissionMessage) {
        this.name = StringUtils.substringBeforeLast(currentType.getSimpleName(), postfix);
        this.aliases = aliases;
        this.description = description;
        this.label = label;
        this.permission = permission;
        this.permissionMessage = permissionMessage;
    }

    public <T extends AbstractCommandExecutor> AbstractCommandExecutor(Class<T> currentType, List<String> aliases, String description, String label, String permission, String permissionMessage, String usage) {
        this.name = StringUtils.substringBeforeLast(currentType.getSimpleName(), postfix);
        this.aliases = aliases;
        this.description = description;
        this.label = label;
        this.permission = permission;
        this.permissionMessage = permissionMessage;
        this.usage = usage;
    }

    public <T extends AbstractCommandExecutor> AbstractCommandExecutor(Class<T> currentType, List<String> aliases, String description, String label, String permission, String permissionMessage, String usage, TabCompleter tabCompleter) {
        this.name = StringUtils.substringBeforeLast(currentType.getSimpleName(), postfix);
        this.aliases = aliases;
        this.description = description;
        this.label = label;
        this.permission = permission;
        this.permissionMessage = permissionMessage;
        this.usage = usage;
        this.tabCompleter = tabCompleter;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public String getPermission() {
        return permission;
    }

    public String getPermissionMessage() {
        return permissionMessage;
    }

    public String getUsage() {
        return usage;
    }

    public TabCompleter getTabCompleter() {
        return tabCompleter;
    }
}
