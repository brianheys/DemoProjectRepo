package com.cec.contact;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.HttpRequestBase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.cec.contact.controller.CEC_HelpCentreController;
import com.cec.contact.model.CEC_HelpCentre;
import com.cec.contact.repository.CEC_HelpCentreRepository;
import com.cec.contact.service.CEC_AWSS3Service;
import com.cec.contact.service.CEC_HelpCentreService;
import com.cec.contact.service.impl.CEC_AWSS3ServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { CEC_SpringBootDemoApplication.class })
public class CEC_HelpCentreControllerTest {

	@Mock
	private AmazonS3 amazonS3;

	@Mock
	private S3Object s3Object;
	
	@Autowired
	private CEC_AWSS3Service cec_AWSS3Service;

	@Mock
	S3ObjectInputStream s3ObjectInputStream;

	@Mock
	HttpRequestBase httpRequestBase;
	@Mock
	private CEC_HelpCentreRepository cecHelpCentreRepository;

	@Mock
	private CEC_HelpCentreService cecHelpCentreService;
	@Mock
	private CEC_AWSS3ServiceImpl aWSS3ServiceImpl;

	@InjectMocks
	private CEC_HelpCentreController cecHelpCentreController;
	List<CEC_HelpCentre> cecList = null;

	byte[] bytes;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testShowEditProductPage() throws IOException {
		cecList = new ArrayList<CEC_HelpCentre>();
		CEC_HelpCentre cecHelpCentre = new CEC_HelpCentre();
		cecHelpCentre.setId(1L);
		cecHelpCentre.setAwsFileName("brand.html");
		cecHelpCentre.setAwsFolder("gb-br");
		cecHelpCentre.setBrand("H32523");
		cecHelpCentre.setCecIsoCountryCode("GB");
		cecHelpCentre.setBrandCode("FGH");
		cecHelpCentre.setCountry("India");
		cecHelpCentre.setRedirectUrl("RedirectUrl");
		cecHelpCentre.setTermsOfUse("termsofUse");
		cecHelpCentre.setCookieInformation("cookieInformation");
		cecHelpCentre.setPrivacyLink("privacyLink");

		cecList.add(cecHelpCentre);
		InputStream inputStream = this.getClass().getResourceAsStream("/templates/index.js");
		bytes = IOUtils.toByteArray(inputStream);

		File file = null;
		Mockito.when(this.cecHelpCentreService.findAll()).thenReturn(cecList);
		Mockito.when(amazonS3.getObject(Mockito.anyString(), Mockito.anyString())).thenReturn(s3Object);
		Mockito.when(s3Object.getObjectContent()).thenReturn(new S3ObjectInputStream(inputStream, httpRequestBase));
		Mockito.when(aWSS3ServiceImpl.downloadFile(Mockito.anyString())).thenReturn(bytes);
		Mockito.when(aWSS3ServiceImpl.uploadFile(file, "")).thenReturn(true);
		cecHelpCentreController.showEditProductPage();
		

		assertEquals(bytes, aWSS3ServiceImpl.downloadFile("text"));
		assertEquals(true, aWSS3ServiceImpl.uploadFile(file, ""));

	}

}
