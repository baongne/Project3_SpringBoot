/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.project3.models;

/**
 *
 * @author Huu Quoc Bao
 */
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "thanhvien")
public class ThanhVien implements Serializable {
    @Id
    @Column(name = "MaTV")
    private int maTV;
    @Column(name = "HoTen")
    private String hoTen;
    @Column(name = "Khoa")
    private String khoa;
    @Column(name = "Nganh")
    private String nganh;
    @Column(name = "SDT")
    private String sdt;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;

}
