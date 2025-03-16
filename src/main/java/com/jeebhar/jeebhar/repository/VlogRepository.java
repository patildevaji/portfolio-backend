package com.jeebhar.jeebhar.repository;
import com.jeebhar.jeebhar.entity.Vlog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VlogRepository extends JpaRepository<Vlog, Long> {
}