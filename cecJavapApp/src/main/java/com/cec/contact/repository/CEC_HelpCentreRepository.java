package com.cec.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cec.contact.model.CEC_HelpCentre;


@Repository
public interface CEC_HelpCentreRepository extends JpaRepository<CEC_HelpCentre, Long> {
	
	
	
	List<CEC_HelpCentre> findByStatus();
	
	@Modifying	
	void updateStatus(@Param("status") String status,@Param("id") Long id);


}
