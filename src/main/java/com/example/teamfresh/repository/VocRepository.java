package com.example.teamfresh.repository;

import com.example.teamfresh.enums.ProcessEnum;
import com.example.teamfresh.model.Voc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VocRepository extends JpaRepository<Voc, Integer> {
    List<Voc> findByCustomerId(int customerId);
    List<Voc> findAllByprocessStatus(ProcessEnum processStatus);
}
