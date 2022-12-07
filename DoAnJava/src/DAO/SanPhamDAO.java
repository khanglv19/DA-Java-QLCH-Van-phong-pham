/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import POJO.SanPhamPOJO;
import java.sql.*;
/**
 *
 * @author Luong Vinh Khang
 */
public class SanPhamDAO {
    public static  ArrayList<SanPhamPOJO> layDanhSachSanPham(){
        ArrayList<SanPhamPOJO> dsSP = new ArrayList<SanPhamPOJO>();
        try {
            String sql = "select * from SANPHAM";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                SanPhamPOJO sp = new SanPhamPOJO();
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
    
    public static ArrayList<SanPhamPOJO> timKiemSanPhamTheoTen(String tenSP){
        ArrayList<SanPhamPOJO> dsSP = new ArrayList<SanPhamPOJO>();
        try {
            String sql = "select * from SANPHAM where TENSP like '%" + tenSP + "%'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                SanPhamPOJO sp = new SanPhamPOJO();
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
    
    public static boolean themSanPham(SanPhamPOJO sp){
        boolean kq = false;
        String sql = String.format("insert into SANPHAM (TENSP, GIA, SOLUONG) values (N'%s','%f','%d');", sp.getTenSP(), sp.getDonGia(), sp.getSoLuong());
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
    
    public static boolean capNhatSanPham(SanPhamPOJO sp){
        boolean kq = false;
        String sql = String.format("update SANPHAM SET TENSP = N'" + sp.getTenSP() + "', GIA = '" + sp.getDonGia() + "', SOLUONG = '" + sp.getSoLuong()+ "' where MASP ='" + sp.getMaSP() + "'");
        SQLServerDataProvider provider = new SQLServerDataProvider();
        provider.open();
        int n = provider.executeUpdate(sql);
        if(n == 1)
            kq = true;
        provider.close();
        return kq;
    }
    
    public static SanPhamPOJO laySanPham(int maSP){
        SanPhamPOJO sp = null;
        try {
            String sql = "select * from SANPHAM where MASP = " + maSP;
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            if(rs.next()){
                sp = new SanPhamPOJO();
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
