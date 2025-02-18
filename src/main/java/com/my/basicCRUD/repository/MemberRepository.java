package com.my.basicCRUD.repository;

import com.my.basicCRUD.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // 전체 검색
    @Query(value = "SELECT * FROM member ORDER BY member_id ASC", nativeQuery = true)
    // 엔티티가 List로 들어감
    List<Member> searchAll();

    // 이름으로 검색
    @Query(value="SELECT * FROM member WHERE member_name LIKE %:keyword% ORDER BY address DESC;", nativeQuery = true)
    List<Member> searchName(@Param("keyword") String keyword);

    // 주소로 검색
    @Query(value="SELECT * FROM member WHERE address LIKE '%:keyword%' ORDER BY member_name DESC;", nativeQuery = true)
    List<Member> searchAddress(@Param("keyword") String keyword);
}
