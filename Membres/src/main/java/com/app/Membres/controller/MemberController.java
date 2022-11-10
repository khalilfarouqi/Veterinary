package com.app.Membres.controller;

import com.app.Membres.dto.MembersDto;
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
    public List<MembersDto> getAllMembers(){
        return memberService.getAllMember().stream().map(Members -> modelMapper.map(Members, MembersDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembersDto> getMembersById(@PathVariable(name = "id") Long id){
        Members Members = memberService.getMembersById(id);

        MembersDto MembersResponse = modelMapper.map(Members, MembersDto.class);

        return ResponseEntity.ok().body(MembersResponse);
    }

    @PostMapping
    public ResponseEntity<MembersDto> createMembers(@RequestBody MembersDto MembersDto){

        Members MembersRequest = modelMapper.map(MembersDto, Members.class);

        Members Members = memberService.createMember(MembersRequest);

        MembersDto MembersResponse = modelMapper.map(Members, MembersDto.class);

        return new ResponseEntity<MembersDto>(MembersResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembersDto> updateMembers(@PathVariable long id, @RequestBody MembersDto MembersDto){

        Members MembersRequest = modelMapper.map(MembersDto, Members.class);

        Members Members = memberService.updateMember(id, MembersRequest);

        MembersDto MembersResponse = modelMapper.map(Members, MembersDto.class);

        return ResponseEntity.ok().body(MembersResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMembers(@PathVariable(name = "id") Long id){
        memberService.deleteMember(id);
        return new ResponseEntity<String>("Members deleted successfully", HttpStatus.OK);
    }

}
