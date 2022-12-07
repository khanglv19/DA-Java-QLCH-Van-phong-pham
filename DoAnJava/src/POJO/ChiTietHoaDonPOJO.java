/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;



/**
 *
 * @author Luong Vinh Khang
 */
public class ChiTietHoaDonPOJO {
    int maHD;
    int maSP;
    String tenSP;
    int soLuong;
    float donGia;
    
    //Các phương thức khởi tạo
    public ChiTietHoaDonPOJO() {
    }

    public ChiTietHoaDonPOJO(int maHD, int maSP, String tenSP, float donGia, int soLuong) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}
