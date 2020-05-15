package com.cec.contact.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cec.contact.constant.CEC_Constants;
import com.cec.contact.model.CEC_HelpCentre;
import com.cec.contact.model.CEC_HelpCentreTranslator;
import com.cec.contact.service.CEC_AWSS3Service;
import com.cec.contact.service.CEC_HelpCentreService;


@Controller
public class CEC_HelpCentreController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CEC_HelpCentreController.class);

	@Autowired
	private CEC_HelpCentreService cecHelpCentreService;

	@Autowired
	private CEC_AWSS3Service cec_AWSS3Service;

	final String projectPath = System.getProperty(CEC_Constants.USER_DIR);

	Path srcPath = Paths.get(projectPath + File.separator + CEC_Constants.PATH_LOCATION);

	@RequestMapping("/")
	public ModelAndView showEditProductPage() throws IOException {

		List<CEC_HelpCentre> cecList = null;
		CEC_HelpCentreTranslator cec_HelpCentreTranslator = null;
		byte[] data = null;
		ModelAndView response = new ModelAndView(CEC_Constants.FILE_UPLOAD_STATUS);
		Path desPath = null;
		try {
			cecList = cecHelpCentreService.findAll();
		} catch (Exception e) {
			LOGGER.error("Error retrieving CECHelpCentre List" + e.getStackTrace(), e);
			response.addObject(CEC_Constants.NAME, "Error while retrieving records from CECHelpCentre");
		}
		if (cecList != null && !cecList.isEmpty()) {

			data = cec_AWSS3Service.downloadFile(CEC_Constants.DOWNLOAD_FILE_PATH);

			Files.write(srcPath, data);
			
			

			for (CEC_HelpCentre cecHelpCentre : cecList) {
				if (cecHelpCentre.getAwsFileName() != null && cecHelpCentre.getAwsFolder() != null
						&& cecHelpCentre.getBrandCode() != null && cecHelpCentre.getCecIsoCountryCode() != null
						&& cecHelpCentre.getCookieInformation() != null && cecHelpCentre.getBrandCode() != null && cecHelpCentre.getPrivacyLink() != null 
						&& cecHelpCentre.getTermsOfUse() != null && cecHelpCentre.getRedirectUrl() != null) {
					try {
						
						try {
							cec_HelpCentreTranslator = cecHelpCentreService.findTranslator(cecHelpCentre.getCecHelpCentrelanguage());
						} catch (Exception e) {
							LOGGER.error("Error retrieving CECHelpCentreTranslator" + e.getStackTrace(), e);
							response.addObject(CEC_Constants.NAME, "Error while retrieving records from CECHelpCentreTranslator");
						}

						Stream<String> lines = Files.lines(srcPath);
						List<String> replaced = lines
								.map(line -> line.replace(CEC_Constants.CEC_LANGUAGE_C, "EN")
										.replace(CEC_Constants.CEC_COUNTRY_C, cecHelpCentre.getCecIsoCountryCode())
										.replace(CEC_Constants.CEC_BRAND_ID_C, cecHelpCentre.getBrandCode())
										.replace(CEC_Constants.CEC_COOKIE_INFORMATION_C,
												cecHelpCentre.getCookieInformation())
										.replace(CEC_Constants.CEC_PRIVACY_LINK_C, cecHelpCentre.getPrivacyLink())
										.replace(CEC_Constants.CEC_TERMS_AND_USAGE_C, cecHelpCentre.getTermsOfUse())
										.replace(CEC_Constants.CEC_REDIRECT_URL_C, cecHelpCentre.getRedirectUrl()))
								.collect(Collectors.toList());
						desPath = Paths.get(projectPath + File.separator + CEC_Constants.TEMPLATES_PATH
								+ cecHelpCentre.getAwsFileName());

						Files.write(desPath, replaced);
						lines.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					boolean flag = cec_AWSS3Service.uploadFile(desPath.toFile(), cecHelpCentre.getAwsFolder());
					if (flag == true) {
						response.addObject(CEC_Constants.NAME, "S3 bucket Upload Successful");

						/*try {
							cecHelpCentreService.updateStatus("Deployed", cecHelpCentre.getId());
							response.addObject(CEC_Constants.NAME, "S3 bucket Upload Successful");
						} catch (Exception e) {
							LOGGER.error("Error updating CECHelpCentre" + e.getMessage(), e);
							response.addObject(CEC_Constants.NAME, "Error while Updating CECHelpCentre");
						}*/

					} else {
						desPath.toFile().delete();
						response.addObject(CEC_Constants.NAME, "S3 bucket Upload Failed");
					}

				}

			}
		}

		return response;

	}

	public void WriteToFile(String fileContent, String fileName) throws IOException {
		String tempFile = projectPath + File.separator + fileName;
		File file = new File(tempFile);		
		if (file.exists()) {
			
			file.delete();
		}		
		OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
		Writer writer = new OutputStreamWriter(outputStream);
		writer.write(fileContent);
		writer.close();

	}

}
