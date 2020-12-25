package per.mario.minecraft.plugs.rainbow.datebase.mysql;

import lombok.Data;

/**
 * @PackageName per.mario.minecraft.plugs.rainbow.config
 * @ClassName DatebaseConfig
 * @Author mario
 * @Date 2020-12-25 04:00:41
 * @Description TODO
 * @Version 1.0
 **/
public class DataSourceConfig {

    //    数据库链接驱动
    public static String driver = "com.mysql.jdbc.Driver";
    //    数据库URL地址
    public static String url = "jdbc:mysql://localhost:3306/mc_rainbow";
    //    用户名
    public static String user = "mario";
    //    密码
    public static String password = "mario";
    //    初始连接数
    public static Integer initSize = 1;
    //    最大连接数
    public static Integer maxActive = 3;
    //    最长等待连接获取时间
    public static Integer maxWait = 5000;
    //    最小闲置连接数
    public static Integer minIdle = 1;


}
