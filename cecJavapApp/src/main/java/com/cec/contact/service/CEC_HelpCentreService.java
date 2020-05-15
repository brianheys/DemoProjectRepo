package com.cec.contact.service;

import java.util.List;

import com.cec.contact.model.CEC_HelpCentre;
import com.cec.contact.model.CEC_HelpCentreTranslator;


public interface CEC_HelpCentreService {
	
	List<CEC_HelpCentre> findAll();
	
	void updateStatus(String status,Long id);
	
	CEC_HelpCentreTranslator findTranslator(String sfid);

}
	