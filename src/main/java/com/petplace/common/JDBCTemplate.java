package com.petplace.common;

import javax.xml.transform.Result;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * packageName    : com.petplace.common
 * fileName       : JDBCTemplate
 * author         : jun
 * date           : 2024. 9. 13.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 13.        jun       최초 생성
 */
public class JDBCTemplate {
    /**
     * Connection 객체 생성 후 반환
     *
     * @return conn : Connection 객체 반환
     */
    public static Connection getConnection() {
        Connection conn = null;
        Properties prop = new Properties();
        String filePath = JDBCTemplate.class.getResource("/db/driver/driver.properties").getPath();
        try {
            prop.load(new FileInputStream(filePath));
            Class.forName(prop.getProperty("driver"));
            conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
            System.out.println("DB Connection Success");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    /**
     * Connection 객체 반환 메서드
     * @param conn 반환하고자 하는 Connection 객체
     */
    public static void close(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Statement | PreparedStatement 객체 반환 메서드
     * @param stmt 반환하고자 하는 Statement | PreparedStatement 객체
     */
    public static void close(PreparedStatement stmt) {
        try {

            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * ResultSet 객체 반환 메서드
     * @param rs 반환하고자 하는 ResultSet 객체
     */
    public static void close(ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * commit 처리 메서드
     * @param conn Connection 객체
     */
    public static void commit(Connection conn){
        try{
            if (conn != null && !conn.isClosed()){
                conn.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * rollback 처리 메서드
     * @param conn Connection 객체
     */
    public static void rollback(Connection conn){
        try{
            if (conn != null && !conn.isClosed()){
                conn.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
