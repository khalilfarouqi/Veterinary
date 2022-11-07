package com.app.Animaux.business.repository;

import com.app.Animaux.business.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository <Long, Animal> {

}
