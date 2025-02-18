package com.my.basicCRUD.controller;

import com.my.basicCRUD.dto.MemberDto;
import com.my.basicCRUD.entity.Member;
import com.my.basicCRUD.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    // 생성자 주입
    private final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("insertForm")
    public String insertFormView() {
        return "insertMember";
    }

    @PostMapping("insert")
    public String insert(MemberDto dto) {
        System.out.println(dto);
        return "showMember";
    }

    @GetMapping("view")
    public String showMember(Model model) {
        List<MemberDto> memberList = memberService.findAllMembers();
        model.addAttribute("list", memberList);
        System.out.println(memberList);
        return "showMember";
    }
}
