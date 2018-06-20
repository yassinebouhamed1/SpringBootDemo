package org.sid.dao;

import org.sid.entities.Contacts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<Contacts, Long>{
	@Query("select c from Contacts c where c.nom like :x")
	public Page<Contacts> chercher(@Param("x")String mc,Pageable pageable); 

}
