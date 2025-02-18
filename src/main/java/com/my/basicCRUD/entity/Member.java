package com.my.basicCRUD.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "member")
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(name = "member_name", length = 100, nullable = false)
    private String name;

    private int age;
    private String address;

    @Transient
    private String del_yn;
}
