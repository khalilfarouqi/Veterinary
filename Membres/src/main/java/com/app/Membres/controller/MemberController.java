package com.app.Membres.controller;

import com.app.Membres.dto.MemberDto;
import com.app.Membres.entity.Members;
import com.app.Membres.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private ModelMapper modelMapper;

    private MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping
    public List<MemberDto> getAllMembers(){
        return memberService.getAllMember().stream().map(Members -> modelMapper.map(Members, MemberDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getMembersById(@PathVariable(name = "id") Long id){
        Members Members = memberService.getMembersById(id);

        MemberDto MembersResponse = modelMapper.map(Members, MemberDto.class);

        return ResponseEntity.ok().body(MembersResponse);
    }

    @PostMapping
    public ResponseEntity<MemberDto> createMembers(@RequestBody MemberDto MemberDto){

        Members MembersRequest = modelMapper.map(MemberDto, Members.class);

        Members Members = memberService.createMember(MembersRequest);

        MemberDto MembersResponse = modelMapper.map(Members, MemberDto.class);

        return new ResponseEntity<MemberDto>(MembersResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDto> updateMembers(@PathVariable long id, @RequestBody MemberDto MemberDto){

        Members MembersRequest = modelMapper.map(MemberDto, Members.class);

        Members Members = memberService.updateMember(id, MembersRequest);

        MemberDto MembersResponse = modelMapper.map(Members, MemberDto.class);

        return ResponseEntity.ok().body(MembersResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMembers(@PathVariable(name = "id") Long id){
        memberService.deleteMember(id);
        return new ResponseEntity<String>("Members deleted successfully", HttpStatus.OK);
    }

}
