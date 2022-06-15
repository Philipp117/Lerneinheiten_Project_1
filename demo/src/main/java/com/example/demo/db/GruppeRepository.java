package com.example.demo.db;

import com.example.demo.model.Gruppe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GruppeRepository extends JpaRepository<Gruppe, Integer>
{

}