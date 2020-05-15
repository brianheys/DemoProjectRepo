package com.cec.contact;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cec.contact.model.CEC_HelpCentre;
import com.cec.contact.repository.CEC_HelpCentreRepository;
import com.cec.contact.service.impl.CEC_CecHelpCentreServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { CEC_SpringBootDemoApplication.class })
public class CEC_HelpCentreServiceTest {

	@MockBean
	private CEC_HelpCentreRepository cecHelpCentreRepository;

	@InjectMocks
	@Autowired
	private CEC_CecHelpCentreServiceImpl cecHelpCentreService;
	
	List<CEC_HelpCentre> cecList = null;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		}

	@Test
	public void getAllHelpCentreListTest() {
		cecList = new ArrayList<CEC_HelpCentre>();
		CEC_HelpCentre cec = new CEC_HelpCentre();
		cec.setId(1L);
		cec.setAwsFileName("brand.html");
		cec.setAwsFolder("gb-br");
		cec.setBrand("H32523");
		cec.setCecIsoCountryCode("GB");
		cecList.add(cec);
		Mockito.when(this.cecHelpCentreRepository.findByStatus())
				.thenReturn(cecList);
		List<CEC_HelpCentre> contactList = cecHelpCentreService.findAll();
		Assert.assertNotNull(contactList);
		Assert.assertEquals(contactList.size(), 1);

	}
	
	@Test
	public void updateStatusTest() {
		
		CEC_HelpCentre cec = new CEC_HelpCentre();
		cec.setId(1L);
		cec.setAwsFileName("brand.html");
		cec.setAwsFolder("gb-br");
		cec.setBrand("H32523");
		cec.setCecIsoCountryCode("GB");
		Mockito.doNothing().when(this.cecHelpCentreRepository).updateStatus(Mockito.anyString(), Mockito.anyLong());		
		cecHelpCentreService.updateStatus(cec.getStatus(), cec.getId());	
	}

}
