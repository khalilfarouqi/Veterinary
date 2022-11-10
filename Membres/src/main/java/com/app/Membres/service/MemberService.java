package com.app.Membres.service;

import com.app.Membres.entity.Members;
import com.app.Membres.exception.ResourceNotFoundException;
import com.app.Membres.repository.MembersRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MembersRepository membersRepository;

    public MemberService(MembersRepository membersRepository){
        this.membersRepository = membersRepository;
    }

    public List<Members> getAllMedication() {
        return membersRepository.findAll();
    }

    public Members createMedication(Members medication) {
        return membersRepository.save(medication);
    }

    public Members updateMedication(long id, Members membersRequest) {
        Members members = membersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medication", "id", id));

        members.setPost(membersRequest.getPost());
        members.setBirthDay(membersRequest.getBirthDay());
        members.setFirstName(membersRequest.getFirstName());
        members.setLastName(membersRequest.getLastName());
        members.setHiring_Date(membersRequest.getHiring_Date());

        return membersRepository.save(members);
    }

    public void deleteMedication(long id) {
        Members members = membersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Members", "id", id));

        membersRepository.delete(members);
    }

    public Members getMembersById(long id) {
        Optional<Members> result = membersRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException("Members", "id", id);
        }
    }

}
