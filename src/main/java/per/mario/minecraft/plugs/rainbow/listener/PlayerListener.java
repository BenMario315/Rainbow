package per.mario.minecraft.plugs.rainbow.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @PackageName per.mario.miecraft.plugs.rainbow.listener
 * @ClassName PlayerJoinListener
 * @Author mario
 * @Date 2020-12-24 19:33:32
 * @Description TODO
 * @Version 1.0
 **/
public class PlayerListener implements Listener {

    /**
     * 玩家加入事件
     * @param playerJoinEvent
     */
    @EventHandler
    public void playerJoin(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        if (!player.hasPlayedBefore()) {
//            新玩家
            playerJoinEvent.setJoinMessage("欢迎新玩家加入");
        } else {
//            老玩家
            playerJoinEvent.setJoinMessage("欢迎老玩家回归");
        }
    }
}
