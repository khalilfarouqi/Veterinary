package com.app.Membres.service;

import com.app.Membres.entity.Members;
import com.app.Membres.exception.ResourceNotFoundException;
import com.app.Membres.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public List<Members> getAllMember() {
        return memberRepository.findAll();
    }

    public Members createMember(Members member) {
        return memberRepository.save(member);
    }

    public Members updateMember(long id, Members membersRequest) {
        Members members = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member", "id", id));

        members.setPost(membersRequest.getPost());
        members.setBirthDay(membersRequest.getBirthDay());
        members.setFirstName(membersRequest.getFirstName());
        members.setLastName(membersRequest.getLastName());
        members.setHiring_Date(membersRequest.getHiring_Date());

        return memberRepository.save(members);
    }

    public void deleteMember(long id) {
        Members members = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Members", "id", id));

        memberRepository.delete(members);
    }

    public Members getMembersById(long id) {
        Optional<Members> result = memberRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException("Members", "id", id);
        }
    }

}
