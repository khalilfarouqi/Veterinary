package com.app.Membres.repository;

import com.app.Membres.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Members,Long> {

}
