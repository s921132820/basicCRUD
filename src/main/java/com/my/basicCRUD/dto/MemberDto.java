package com.my.basicCRUD.dto;

import com.my.basicCRUD.entity.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private Long id;
    @Size(min = 2, message = "이릉은 2자 이상으로 입력해야합니다.")
    private String name;
    @Range(min=0, max=120, message = "나이는 0세부터 120세까지 입니다.")
    private int age;
    @NotBlank(message = "주소는 꼭 입력해야합니다.")
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
