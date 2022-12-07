/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
/**
 *
 * @author Luong Vinh Khang
 */
public class SQLServerDataProvider {
    Connection connection;
    
    public void open(){
        String strServer = "VINHKHANG";
        String strDataBase = "DA_QL_CH_VANPHONGPHAM_JAVA";
        String strUserName = "sa";
        String strPassword = "10021091$";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://" + strServer 
                                   + ":1433;databaseName=" + strDataBase 
                                   + ";user=" + strUserName 
                                   + ";password=" + strPassword;
            connection = DriverManager.getConnection(connectionURL);
            if(connection!=null)
                System.out.println("Kết nối thành công!");
            else System.out.println("Kết nối không thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Trả kết quả
    public ResultSet executeQuery(String sql){
        ResultSet rs = null;
        try {
            Statement sm = connection.createStatement();
            rs = sm.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    //Kiểm tra
    public int executeUpdate(String sql){
        int n = -1;
        try {
            Statement sm = connection.createStatement();
            n = sm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }
}
