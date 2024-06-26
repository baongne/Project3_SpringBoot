package com.example.project3.models;

/**
 *
 * @author Huu Quoc Bao
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "thanhvien")
public class Member {
    @Id
    @Column(name="MaTV")
    private int maTV;
    @Column(name="HoTen")
    private String tenTV;
    @Column(name="Khoa")
    private String khoa;
    @Column(name="Nganh")
    private String nganh;
    @Column(name="SDT")
    private String sdt;
    @Column(name="Password")
    private String password;
    @Column(name="Email")
    private String email;

    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public String getTenTV() {
        return tenTV;
    }

    public void setTenTV(String tenTV) {
        this.tenTV = tenTV;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
