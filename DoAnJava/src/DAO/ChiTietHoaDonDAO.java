/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import POJO.ChiTietHoaDonPOJO;
import java.sql.*;
/**
 *
 * @author Luong Vinh Khang
 */
public class ChiTietHoaDonDAO {
    public static  ArrayList<ChiTietHoaDonPOJO> layDanhSachSanPham(){
        ArrayList<ChiTietHoaDonPOJO> dsSP = new ArrayList<ChiTietHoaDonPOJO>();
        try {
            String sql = "select * from CHITIETHD";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                ChiTietHoaDonPOJO sp = new ChiTietHoaDonPOJO();
                sp.setMaSP(rs.getInt("MASP"));
                sp.setTenSP(rs.getString("TENSP"));
                sp.setDonGia(rs.getFloat("GIA"));
                sp.setSoLuong(rs.getInt("SOLUONG"));
                dsSP.add(sp);
            }
            provider.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsSP;
    }
    
    
    
    public static boolean themHoaDon(ChiTietHoaDonPOJO sp){
        boolean kq = false;
        String sql = String.format("insert into CHITIETHD (TENSP, GIA, SOLUONG) values (N'%s','%f','%d');", sp.getTenSP(), sp.getDonGia(), sp.getSoLuong());
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sql);
        if(n == 1)
            kq = true;
        provider.close();
        return kq;
    }
    
    public static boolean xoaSanPham(int maSP){
        boolean kq = false;
        String sql = String.format("delete from SANPHAM where MASP = %d", maSP);
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sql);
        if(n == 1)
            kq = true;
        provider.close();
        return kq;
    }
    
    
    
    public static ChiTietHoaDonPOJO laySanPham(int maSP){
        ChiTietHoaDonPOJO sp = null;
        try {
            String sql = "select * from SANPHAM where MASP = " + maSP;
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            if(rs.next()){
                sp = new ChiTietHoaDonPOJO();
                sp.setMaSP(rs.getInt("MASP"));
                sp.setTenSP(rs.getString("TENSP"));
                sp.setDonGia(rs.getFloat("GIA"));
                sp.setSoLuong(rs.getInt("SOLUONG"));
            }
            provider.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }
}
