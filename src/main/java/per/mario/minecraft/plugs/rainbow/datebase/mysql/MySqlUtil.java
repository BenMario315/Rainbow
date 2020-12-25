package per.mario.minecraft.plugs.rainbow.datebase.mysql;

import com.alibaba.druid.pool.DruidDataSource;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * @PackageName per.mario.minecraft.plugs.rainbow.datebase.mysql
 * @ClassName DBUtil
 * @Author mario
 * @Date 2020-12-25 04:07:47
 * @Description TODO
 * @Version 1.0
 **/
public class MySqlUtil {

    private static DruidDataSource dataSource;

    static {
        dataSource = createDataSource();
    }

    private static DruidDataSource createDataSource() {
//        创建连接池对象
        dataSource = new DruidDataSource();
        dataSource.setUrl(DataSourceConfig.url);
        dataSource.setUsername(DataSourceConfig.user);
        dataSource.setPassword(DataSourceConfig.password);
//        设置连接池的初始参数
        dataSource.setInitialSize(DataSourceConfig.initSize);
        dataSource.setMaxActive(DataSourceConfig.maxActive);
        dataSource.setMaxWait(DataSourceConfig.maxWait);
        dataSource.setMinIdle(DataSourceConfig.minIdle);
        return dataSource;

    }

    public static Connection getConn() {
        try {
            if (dataSource == null || dataSource.isClosed()) {
                dataSource = createDataSource();
            }
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(ResultSet rs, Statement stat, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean exeUpdate(Connection conn, String sql, Object... params) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            //当传入的参数不为null时执行预处理
            if (Objects.nonNull(params)) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            //执行更新
            return ps.executeUpdate() > 0;
        } finally {
            MySqlUtil.close(null, ps, null);
        }

    }

    public static List<Map<String, Object>> queryToMap(String sql, Object... params) {
        //声明List集合存储所有查询的数据（内部的每一条数据使用一个Map对象表示）
        List<Map<String, Object>> list = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = MySqlUtil.getConn();
        try {
            ps = conn.prepareStatement(sql);
            //执行预处理（如果存在占位符，则为占位符填充具体的值）
            if (Objects.nonNull(params)) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            //执行查询
            rs = ps.executeQuery();
            //获取结果集元数据对象
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取总查询列数
            int columnCount = rsmd.getColumnCount();
            //遍历结果集
            while (rs.next()) {
                //每一次循环循环创建一个Map（查询到一条数据）
                Map<String, Object> map = new HashMap<>();
                //获取每一列的列标签
                for (int i = 1; i <= columnCount; i++) {
                    //获取指定的列标签
                    String cname = rsmd.getColumnName(i);
                    //获取列类型
                    int type = rsmd.getColumnType(i);
                    //根据列标签获取列值
                    Object value = rs.getObject(i);
                    //将一个查询列装入map
                    map.put(cname, value);
                }
                //将map集合（javabean）存储到List
                list.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, conn);
        }
        return list;
    }

    public static <T> T queryOne(Class<T> t, String sql, Object... params) {
        // 获取查询到到数据集合
        List<Map<String, Object>> list = queryToMap(sql, params);
        if (list.size() > 0) {
            // 获取一个Map对象
            Map<String, Object> map = list.get(0);
            // 将map集合转换为Javabean并返回
            return mapToBean(map, t);
        }
        return null;
    }


    public static <T> List<T> queryList(Class<T> t, String sql, Object... params) {
        List<T> list = new ArrayList<T>();
        // 获取所有查询的到的数据
        List<Map<String, Object>> maps = queryToMap(sql, params);
        // 遍历集合中每一条数据(map)
        maps.forEach(m -> {
            // 将map转换为Javabean
            T obj = mapToBean(m, t);
            // 将Javabean装入list
            list.add(obj);
        });
        return list;
    }

    private static <T> T mapToBean(Map<String, Object> map, Class<T> t) {
        try {
            // 根据提供的Class对象创建对应类型的Object
            T obj = t.newInstance();
            map.forEach((k, v) -> {
                try {
                    // 根据Field名称获取字段对象
                    Field field = t.getDeclaredField(k);
                    // 设置字段的可访问性
                    field.setAccessible(true);
                    // 为字段设置值
                    field.set(obj, v);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        try {
//            MySqlUtil.exeUpdate(MySqlUtil.getConn(),"INSERT INTO `mc_rainbow`.`t_game_player`(`name`) VALUES (?)","ben_mario");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

}
