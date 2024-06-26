package com.example.project3.repository;
/**
 *
 * @author Huu Quoc Bao
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project3.models.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findById(int id);
}