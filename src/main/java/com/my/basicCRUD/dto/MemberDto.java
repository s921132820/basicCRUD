package com.my.basicCRUD.dto;

import com.my.basicCRUD.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String name;
    private int age;
    private String address;

    //위에가 private에서 외부에서 못씀
    // 외부로부터 값 받으면 하나씩 넣어서 쓰려면 public
    // 아래 생성자를 만들어주는게 @AllArgsConstructor
    //    public  MemberDto(Long id, String name, int age, String address) {
    //        this.id = id;
    //        this.name = name;
    //        this.age = age;
    //        this.address =address;
     //   }

    // Entity -> DTO 변환
    public static MemberDto fromEntity(Member entity) {
        return new MemberDto(
                entity.getMemberId(),
                entity.getName(),
                entity.getAge(),
                entity.getAddress()
        );
    }

    // DTO -> Entity 변환
    public static Member fromDto(MemberDto dto) {
        Member member = new Member();
        member.setMemberId(dto.getId());
        member.setName(dto.getName());
        member.setAge(dto.getAge());
        member.setAddress(dto.getAddress());
        return member;
    }
}
