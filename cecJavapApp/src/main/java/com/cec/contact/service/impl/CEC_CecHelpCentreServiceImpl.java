package com.cec.contact.service.impl;

import java.util.List;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cec.contact.model.CEC_HelpCentre;
import com.cec.contact.model.CEC_HelpCentreTranslator;
import com.cec.contact.repository.CEC_HelpCentreRepository;
import com.cec.contact.repository.CEC_HelpCentreTranslatorRepository;
import com.cec.contact.service.CEC_HelpCentreService;

@Service
@Transactional
public class CEC_CecHelpCentreServiceImpl implements CEC_HelpCentreService {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(CEC_CecHelpCentreServiceImpl.class);
	 

	@Autowired
	private CEC_HelpCentreRepository cecHelpCentreRepository;
	
	@Autowired
	private CEC_HelpCentreTranslatorRepository cec_HelpCentreTranslatorRepository;

	@Override
	public List<CEC_HelpCentre> findAll() {
		LOGGER.info("Find all====>>Start");
		List<CEC_HelpCentre> contactList = (List<CEC_HelpCentre>) cecHelpCentreRepository.findByStatus();
		LOGGER.info("Find all====>>End");
		return contactList;
	}

	@Override
	public void updateStatus(String status,Long id) {
		LOGGER.info("updateStatus====>>Start");
	    cecHelpCentreRepository.updateStatus(status,id);
	    LOGGER.info("updateStatus====>>End");
	}

	@Override
	public CEC_HelpCentreTranslator findTranslator(String sfid) {
		LOGGER.info("findTranslator====>>Start");
		CEC_HelpCentreTranslator cec_HelpCentreTranslator = cec_HelpCentreTranslatorRepository.findBySfid(sfid);
	    LOGGER.info("findTranslator====>>End");
		return cec_HelpCentreTranslator;
	}
	
	
	
	

}
