package com.cec.contact.controller;

import java.io.File;
import java.io.IOException;
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

	Path uploadPath = Paths.get(projectPath + File.separator + "\\src\\main\\resources\\templates\\main.js");
	
	List<CEC_HelpCentre> cecList = null;
	
	CEC_HelpCentreTranslator cec_HelpCentreTranslator = null;

	@RequestMapping("/")
	public ModelAndView showEditProductPage() throws IOException {

		//boolean status = cec_AWSS3Service.uploadFile(uploadPath.toFile(), "");

	
		
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
				
				try {
					cec_HelpCentreTranslator = cecHelpCentreService
							.findTranslator(cecHelpCentre.getCecHelpCentrelanguage());
				} catch (Exception e) {
					LOGGER.error("Error retrieving CECHelpCentreTranslator" + e.getStackTrace(), e);
					response.addObject(CEC_Constants.NAME,
							"Error while retrieving records from CECHelpCentreTranslator");
				}
				if (cecHelpCentre.getAwsFileName() != null && cecHelpCentre.getAwsFolder() != null
						&& cecHelpCentre.getLocale() != null && cecHelpCentre.getBrandCode() != null
						&& cecHelpCentre.getCecIsoCountryCode() != null && cecHelpCentre.getCookieInformation() != null
						&& cecHelpCentre.getBrandCode() != null && cecHelpCentre.getPrivacyLink() != null
						&& cecHelpCentre.getTermsOfUse() != null && cecHelpCentre.getRedirectUrl() != null && cec_HelpCentreTranslator !=null) {
					try {

						
						
						Stream<String> lines = Files.lines(srcPath);
						List<String> replaced = lines
								.map(line -> line.replace(CEC_Constants.CEC_LANGUAGE_C, cecHelpCentre.getLocale().substring(0, 2))
										.replace(CEC_Constants.CEC_COUNTRY_C, cecHelpCentre.getCecIsoCountryCode())
										.replace(CEC_Constants.CEC_BRAND_ID_C, cecHelpCentre.getBrandCode())
										.replace(CEC_Constants.CEC_COOKIE_INFORMATION_C,
												cecHelpCentre.getCookieInformation())
										.replace(CEC_Constants.CEC_PRIVACY_LINK_C, cecHelpCentre.getPrivacyLink())
										.replace(CEC_Constants.CEC_TERMS_AND_USAGE_C, cecHelpCentre.getTermsOfUse())
										.replace(CEC_Constants.CEC_REDIRECT_URL_C, cecHelpCentre.getRedirectUrl())
										.replace(CEC_Constants.CEC_Enquiry_Type__c, cec_HelpCentreTranslator.getEnquiryType())
										.replace(CEC_Constants.CEC_Enquiry_Type_Option0__c, cec_HelpCentreTranslator.getEnquiryTypeOp0())
										.replace(CEC_Constants.CEC_Enquiry_Type_Option1__c, cec_HelpCentreTranslator.getEnquiryTypeOp1())
										.replace(CEC_Constants.CEC_Enquiry_Type_Option2__c, cec_HelpCentreTranslator.getEnquiryTypeOp2())
										.replace(CEC_Constants.CEC_Additional_Details__c, cec_HelpCentreTranslator.getAdditionalDetail())
										.replace(CEC_Constants.CEC_Additional_Details_Option1__c, cec_HelpCentreTranslator.getAdditionalDetailOp1())
										.replace(CEC_Constants.CEC_Additional_Details_Option2__c, cec_HelpCentreTranslator.getAdditionalDetailOp2())
										.replace(CEC_Constants.CEC_Additional_Details_Option3__c, cec_HelpCentreTranslator.getAdditionalDetailOp3())
										.replace(CEC_Constants.CEC_Your_Details__c, cec_HelpCentreTranslator.getYourDetails())
										.replace(CEC_Constants.CEC_First_Name__c, cec_HelpCentreTranslator.getFirstName())
										.replace(CEC_Constants.CEC_Last_Name__c, cec_HelpCentreTranslator.getLastName())
										.replace(CEC_Constants.CEC_Email_Address__c, cec_HelpCentreTranslator.getEmailAddress())
										.replace(CEC_Constants.CEC_Product_Details__c, cec_HelpCentreTranslator.getProductionDetail())
										.replace(CEC_Constants.CEC_Product_Name__c, cec_HelpCentreTranslator.getProductName())
										.replace(CEC_Constants.CEC_Barcode_EAN_GTIN__c, cec_HelpCentreTranslator.getBarCode())
										.replace(CEC_Constants.CEC_Pictures_Attachments__c, cec_HelpCentreTranslator.getPictureAttachment())
										.replace(CEC_Constants.CEC_Browse__c, cec_HelpCentreTranslator.getBrowse())
										.replace(CEC_Constants.CEC_How_Often_Do_You_Use_This_Product__c, cec_HelpCentreTranslator.getHowOften())
										.replace(CEC_Constants.CEC_Daily__c, cec_HelpCentreTranslator.getDaily())
										.replace(CEC_Constants.CEC_Weekly__c, cec_HelpCentreTranslator.getCecWeekly())
										.replace(CEC_Constants.CEC_Monthly__c, cec_HelpCentreTranslator.getMonthly())
										.replace(CEC_Constants.CEC_Yearly__c, cec_HelpCentreTranslator.getYearly())
										.replace(CEC_Constants.CEC_Where_Do_You_Usually_Buy_Product__c, cec_HelpCentreTranslator.getWhereDo())
										.replace(CEC_Constants.CEC_Retailer__c, cec_HelpCentreTranslator.getRetailer())
										.replace(CEC_Constants.CEC_Name_Retailer__c, cec_HelpCentreTranslator.getNameRetailer())
										.replace(CEC_Constants.CEC_Online__c, cec_HelpCentreTranslator.getOnline())
										.replace(CEC_Constants.CEC_Name_of_site__c, cec_HelpCentreTranslator.getNameOfSite())
										.replace(CEC_Constants.CEC_Others__c, cec_HelpCentreTranslator.getCecOthers())
										.replace(CEC_Constants.CEC_Name_Shop__c, cec_HelpCentreTranslator.getNameShop())
										.replace(CEC_Constants.CEC_Give_More_Details_To_Respond__c, cec_HelpCentreTranslator.getGiveMoreDetails())
										.replace(CEC_Constants.CEC_Privacy_Policy_Cookies_And_Opt_In__c, cec_HelpCentreTranslator.getPrivacyCookieOpt())
										.replace(CEC_Constants.CEC_Age_Check__c, cec_HelpCentreTranslator.getAgeCheck())
										.replace(CEC_Constants.CEC_Marketing_Consent_For_Newsletter__c, cec_HelpCentreTranslator.getMarkentingConsent())
										.replace(CEC_Constants.CEC_Submit__c, cec_HelpCentreTranslator.getSubmit())
										.replace(CEC_Constants.CEC_Error_Form_Submission__c, cec_HelpCentreTranslator.getErrorFormSubmission())
										.replace(CEC_Constants.CEC_Error_Required_Field__c, cec_HelpCentreTranslator.getErrorRequiredField())
										.replace(CEC_Constants.CEC_HelpText_Production_Code__c, cec_HelpCentreTranslator.getHelpTextProductionCode())
										.replace(CEC_Constants.CEC_Production_Code__c, cec_HelpCentreTranslator.getCecProductionCode())
										.replace(CEC_Constants.CEC_Message_Please_Try_Again__c, cec_HelpCentreTranslator.getPleaseTryAgain())
										.replace(CEC_Constants.CEC_Error_Valid_Email_Address__c, cec_HelpCentreTranslator.getValidEmail()))
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

						/*
						 * try { cecHelpCentreService.updateStatus("Deployed", cecHelpCentre.getId());
						 * response.addObject(CEC_Constants.NAME, "S3 bucket Upload Successful"); }
						 * catch (Exception e) { LOGGER.error("Error updating CECHelpCentre" +
						 * e.getMessage(), e); response.addObject(CEC_Constants.NAME,
						 * "Error while Updating CECHelpCentre"); }
						 */

					} else {
						desPath.toFile().delete();
						response.addObject(CEC_Constants.NAME, "S3 bucket Upload Failed");
					}

				}

			}
			srcPath.toFile().delete();
		}

		return response;

	}

}
