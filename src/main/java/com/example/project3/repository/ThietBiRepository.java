/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.project3.repository;

/**
 *
 * @author Huu Quoc Bao
 */
import com.example.project3.models.ThietBi;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThietBiRepository extends JpaRepository<ThietBi, Integer> {

    @Override
    Optional<ThietBi> findById(Integer id);

    @Override
    List<ThietBi> findAll();

}

