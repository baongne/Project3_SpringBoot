/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.project3.repository;

import com.example.project3.models.ThanhVien;
import com.example.project3.models.ThongTinSD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 * @author Huu Qoc Bao
 */
@Repository
public interface ThongTinSDRepository extends JpaRepository<ThongTinSD, Integer> {

    List<ThongTinSD> findByThanhVien(ThanhVien thanhVien);

//    List<ThongTinSD> findByThietBi(ThietBi thietBi);

}
