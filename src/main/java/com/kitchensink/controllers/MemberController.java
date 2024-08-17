package com.kitchensink.controllers;


import com.kitchensink.dto.MemberDTO;
import com.kitchensink.exception.MemberNotFoundException;
import com.kitchensink.models.Member;
import com.kitchensink.services.MemberService;
import com.kitchensink.services.SequenceGeneratorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping
    public ResponseEntity<MemberDTO> createMember(@Valid @RequestBody MemberDTO memberDTO) {
        Member member = new Member();
        member.setId(sequenceGeneratorService.generateSequence("user_sequence"));
        member.setName(memberDTO.getName());
        member.setEmail(memberDTO.getEmail());
        member.setPhoneNumber(memberDTO.getPhoneNumber());

        memberService.createMember(member);
        memberDTO.setId(member.getId());
        return new ResponseEntity<>(memberDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public List<MemberDTO> getAllMembers() {
        return memberService.getAllMembers().stream()
                .map(member -> new MemberDTO(member.getId(),
                        member.getName(),
                        member.getEmail(),
                        member.getPhoneNumber()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable Long id) {
        Member member = memberService.getMemberById(id)
                .orElseThrow(() -> new MemberNotFoundException("Member not found with id: " + id));
        MemberDTO memberDTO = new MemberDTO(member.getId(), member.getName(), member.getEmail(), member.getPhoneNumber());
        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok("Member deleted successfully");
    }
}


