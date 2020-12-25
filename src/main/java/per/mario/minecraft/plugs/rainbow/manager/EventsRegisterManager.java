package per.mario.minecraft.plugs.rainbow.manager;

import per.mario.minecraft.plugs.rainbow.Rainbow;
import per.mario.minecraft.plugs.rainbow.listener.PlayerListener;

/**
 * @PackageName per.mario.minecraft.plugs.rainbow.manager
 * @ClassName RegisterEventsManager
 * @Author mario
 * @Date 2020-12-25 14:54:36
 * @Description TODO
 * @Version 1.0
 **/
public class EventsRegisterManager {

    public static void init(Rainbow rainbow){

        rainbow.getServer().getPluginManager().registerEvents(new PlayerListener(), rainbow);

    }


}
