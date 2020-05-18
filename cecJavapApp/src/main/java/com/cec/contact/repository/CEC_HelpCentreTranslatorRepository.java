package com.cec.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cec.contact.model.CEC_HelpCentreTranslator;


@Repository
public interface CEC_HelpCentreTranslatorRepository extends JpaRepository<CEC_HelpCentreTranslator, Long> {
	
	
	CEC_HelpCentreTranslator findBySfid(@Param("sfid") String sfid);
	
	


}
