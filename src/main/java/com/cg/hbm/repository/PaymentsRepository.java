package com.cg.hbm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.hbm.entity.Payments;

public interface PaymentsRepository extends JpaRepository<Payments,Integer> {

}