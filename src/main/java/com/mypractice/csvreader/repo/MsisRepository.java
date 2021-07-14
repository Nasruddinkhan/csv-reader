package com.mypractice.csvreader.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.csvreader.entity.Msis;

@Repository
public interface MsisRepository extends JpaRepository<Msis, String>{

}
