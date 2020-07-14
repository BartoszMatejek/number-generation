package com.recruitment.exercise.repository;

import com.recruitment.exercise.model.Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRepository extends JpaRepository<Number, Long> {
}
