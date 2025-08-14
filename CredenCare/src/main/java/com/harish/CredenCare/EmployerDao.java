package com.harish.CredenCare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDao extends JpaRepository<RegisterDaoemp,Integer>
{

}
