package per.mario.minecraft.plugs.rainbow.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @PackageName per.mario.minecraft.plugs.rainbow.model
 * @ClassName PlayerModel
 * @Author mario
 * @Date 2020-12-25 02:39:29
 * @Description TODO
 * @Version 1.0
 **/

@Data
public class GamePlayer implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private String password;

    private String email;

    private String currentIp;

    private String ips;

    private Date joinTime;

    private Date latePlayTime;

    private Date leftTime;

}
