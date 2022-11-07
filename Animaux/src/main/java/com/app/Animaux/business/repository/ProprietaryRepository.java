package com.app.Animaux.business.repository;

import com.app.Animaux.business.entity.Proprietary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietaryRepository extends JpaRepository<Long, Proprietary> {
}
