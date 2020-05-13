package util;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class JDBCUtils {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/staff_manage?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USERNAME = "user";
    private static final String DB_PASSWORD = "liangcanxin";

    static {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e){
            System.err.println("DBTester Driver load failure...");
        }
    }

    /**
     * 使用Statement 执行 SQL-SELECT
     *
     * @param sql 语句
     * @return List Of map
     */
    public static List<Map<String, Object>> executeSelect(String sql){
        List<Map<String, Object>> list = null;
        //自动关闭连接
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            list = rs2map(rs);
        } catch (SQLException e){
            System.err.printf("Error: %s\n",e.getMessage());
        }
        return list;
    }

    /**
     * 使用Statement 执行 SQL-UPDATE、DELETE、INSERT
     *
     * @param sql 语句
     * @return 影响的记录数
     */
    public static int executeUpdate(String sql) {
        int affectRows = 0;
        // 自动关闭连接
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            Statement statement = con.createStatement();
            affectRows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.printf("Error: %s\n", e.getMessage());
        }
        return affectRows;
    }

    /**
     * 使用PreparedStatement 执行 SQL-SELECT
     *
     * @param sql    带参数的语句
     * @param params 参数数组
     * @return ResultSet
     */
    public static List<Map<String, Object>> prepareSelect(String sql, Object[] params) {
        List<Map<String, Object>> list = null;
        // 自动关闭连接
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            // 设置参数, 可以根据情况增加分支
            for (int i = 0; i < params.length; i++) {
                if (params[i] instanceof Integer) {
                    preparedStatement.setInt(i + 1, (Integer) params[i]);
                } else if (params[i] instanceof String) {
                    preparedStatement.setString(i + 1, (String) params[i]);
                } else if (params[i] instanceof Double) {
                    preparedStatement.setDouble(i + 1, (Double) params[i]);
                } else {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
            ResultSet rs = preparedStatement.executeQuery();
            list = rs2map(rs);
            System.out.println(preparedStatement);
        } catch (SQLException e) {
            System.err.printf("Error: %s\n", e.getMessage());
        }
        return list;
    }

    /**
     * 使用PreparedStatement 执行 SQL-UPDATE、DELETE、INSERT
     *
     * @param sql    带参数的语句
     * @param params 参数数组
     * @return ResultSet
     */
    public static int prepareUpdate(String sql, Object[] params) {
        int affectRows = 0;
        // 自动关闭连接
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            // 设置参数, 可以根据情况增加分支
            for (int i = 0; i < params.length; i++) {
                if (params[i] instanceof Integer) {
                    preparedStatement.setInt(i + 1, (Integer) params[i]);
                } else if (params[i] instanceof String) {
                    preparedStatement.setString(i + 1, (String) params[i]);
                } else if (params[i] instanceof Double) {
                    preparedStatement.setDouble(i + 1, (Double) params[i]);
                } else if (params[i] instanceof Long) {
                    preparedStatement.setLong(i + 1, (Long) params[i]);
                } else {
                    preparedStatement.setObject(i + 1, params[i]);
                }
            }
            affectRows = preparedStatement.executeUpdate();
            System.out.println(preparedStatement);
        } catch (SQLException e) {
            System.err.printf("Error: %s\n", e.getMessage());
        }
        return affectRows;
    }

    private static List<Map<String, Object>> rs2map(ResultSet rs) throws SQLException {
        if (rs == null) {
            return null;
        }
        List<Map<String, Object>> list = new ArrayList<>();
        int n = rs.getMetaData().getColumnCount(); // 获取结果集的字段数
        String[] fieldNames = new String[n];       // 字段名数组
        for (int i = 0; i < n; i++) {
            fieldNames[i] = rs.getMetaData().getColumnName(i + 1);
        }
        while (rs.next()) {
            Map<String, Object> map = new HashMap<>();
            for (String fieldName : fieldNames) {
                map.put(fieldName.toLowerCase().trim(), rs.getObject(fieldName));
            }
            list.add(map);
        }
        return list;
    }
}
