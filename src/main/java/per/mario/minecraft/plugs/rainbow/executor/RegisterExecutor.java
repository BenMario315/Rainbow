package per.mario.minecraft.plugs.rainbow.executor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @PackageName per.mario.miecraft.plugs.rainbow.executor
 * @ClassName RegisterCommand
 * @Author mario
 * @Date 2020-12-23 21:17:45
 * @Description TODO
 * @Version 1.0
 **/
public class RegisterExecutor extends AbstractCommandExecutor {

    public <T extends AbstractCommandExecutor> RegisterExecutor() {
        super(RegisterExecutor.class);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            sender.sendMessage("注册成功");
            return true;
        }
        return false;
    }
}
