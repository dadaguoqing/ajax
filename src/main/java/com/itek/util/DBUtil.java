/**
 * @Title: DBUtil.java
 * @Package com.itek.java11.jdbc.day01.util
 * @Description: TODO(��һ�仰�������ļ���ʲô)
 * @author mlsong
 * @date 2019��1��14��
 * @version v1.0
 */
package com.itek.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
    /*private static Logger logger = 
            LoggerFactory.getLogger(DBUtil.class);*/

    private static String url;
    private static String driver;
    private static String name;
    private static String pwd;
    
    private static BasicDataSource ds;
    
    static {
        // ��ʼ����̬��Ա����
        Properties prop = new Properties();
        try {
//            System.out.println(new File("resources/jdbc.properties").getAbsolutePath());
            
            // 从classpath(src / resources)路径下加载配置文件,返回字节输入流
            InputStream is = DBUtil.class
                    .getClassLoader()
                    .getResourceAsStream("jdbc.properties");
            
            
            prop.load(is);
            
            url = prop.getProperty("jdbc.url");
            driver = prop.getProperty("jdbc.driver");
            name = prop.getProperty("jdbc.name");
            pwd = prop.getProperty("jdbc.pwd");
            
            // ��ʼ�����ݿ�����ӳ�
            ds = new BasicDataSource();
            // 2. �������ݿ����Ӷ������������
            ds.setDriverClassName(driver);
            ds.setUsername(name); // ��¼��
            ds.setPassword(pwd); // ��¼����
            ds.setUrl(url);
            
        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }
    
    
    /**
     * @Title: getConnection
     * @Description: ��ȡ���ݿ�����
     * @param @return ����
     * @return Connection ��������
     * @throws
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // ��������
            Class.forName(driver);
            // ��������
            conn = DriverManager.getConnection(url, name, pwd);
        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
        }
        return conn;
    }
    
    /**
     * @Title: getPoolConnection
     * @Description: �����ݿ����ӳ��л�ȡ���Ӷ���
     * @param @return ����
     * @return Connection ��������
     * @throws
     */
    public static Connection getPoolConnection() {
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
        }
        return conn;
    }
    
    /**
     * @Title: closeConnection
     * @Description: �ر�����
     * @param @param conn ����
     * @return void ��������
     * @throws
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
//            logger.error(e.getMessage(), e);
        }
    }
}
