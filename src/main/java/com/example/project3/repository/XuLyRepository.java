/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 *
 * @author Lenovo
 */
@Repository
public interface XuLyRepository extends JpaRepository<XuLy, Integer> {

    List<XuLy> findByThanhVien(ThanhVien tv);
}
