package per.mario.minecraft.plugs.rainbow;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import per.mario.minecraft.plugs.rainbow.common.Constant;
import per.mario.minecraft.plugs.rainbow.executor.RegisterExecutor;
import per.mario.minecraft.plugs.rainbow.manager.EventsRegisterManager;
import per.mario.minecraft.plugs.rainbow.manager.CommandRegisterManager;
import per.mario.minecraft.plugs.rainbow.executor.AbstractCommandGenerator;

import java.util.ArrayList;

public final class Rainbow extends JavaPlugin {

    //        配置文件(仅插件内部:[命令配置文件、字体文件],用户可配置文件:消息配置文件、数据库配置文件)
    //        [命令配置文件、消息配置文件、数据库配置文件]

    @Override
    public void onLoad() {
        // Plugin onload logic
        getLogger().info(Constant.LOADING);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        //        初始化监听器
        EventsRegisterManager.init(this);

        //        初始化执行器
        //        1.初始化名令执行器
        RegisterExecutor registerExecutor = new RegisterExecutor();
        PluginCommand pluginCommand = AbstractCommandGenerator.getPluginCommand(this, registerExecutor);

        //        2.注册命令
        CommandRegisterManager.init(this, pluginCommand);


        //        日志
        getLogger().info(Constant.ENABLE);

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info(Constant.DISABLE);
    }


}
