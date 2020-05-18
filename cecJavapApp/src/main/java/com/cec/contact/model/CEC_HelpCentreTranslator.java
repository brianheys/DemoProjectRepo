package com.cec.contact.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CEC_Help_Centre_Translation__c", schema = "salesforce")
@NamedQuery(name = "CEC_HelpCentreTranslator.findBySfid", query = "select c from CEC_HelpCentreTranslator c where c.sfid= ?1")

public class CEC_HelpCentreTranslator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;


	@Column(name = "sfid")
	private String sfid;
	
	
	
	
	@Column(name = "cec_privacy_policy_cookies_and_opt_ins__c")
	private String privacyCookieOpt;
	
	@Column(name = "CEC_Enquiry_Type_Option0__c")
	private String enquiryTypeOp0;
	
	
	
	@Column(name = "cec_helptext_production_code__c")
	private String helpTextProductionCode;
	
	@Column(name = "cec_message_please_try_again__c")
	private String pleaseTryAgain;
	
	
	@Column(name = "cec_error_valid_email_address__c")
	private String validEmail;
	
	
	@Column(name = "cec_name_of_site__c")
	private String nameOfSite;
	
	
	@Column(name = "cec_submit__c")
	private String submit;
	
	
	@Column(name = "cec_product_details__c")
	private String productionDetail;
	
	
	@Column(name = "cec_your_details__c")
	private String yourDetails;
	
	
	@Column(name = "cec_enquiry_type__c")
	private String enquiryType;
	
	
	@Column(name = "cec_enquiry_type_option2__c")
	private String enquiryTypeOp2;
	
	
	@Column(name = "cec_error_form_submission__c")
	private String errorFormSubmission;
	
	@Column(name = "cec_enquiry_type_option1__c")
	private String enquiryTypeOp1;
	
	@Column(name = "cec_instruction__c	")
	private String instruction;
	
	@Column(name = "cec_error_required_field__c")
	private String errorRequiredField;
	
	@Column(name = "cec_additional_details__c")
	private String additionalDetail;
	
	@Column(name = "cec_give_more_details_to_respond__c")
	private String giveMoreDetails;
	
	@Column(name = "cec_browse__c")
	private String browse;
	
	@Column(name = "cec_additional_details_option3__c")
	private String additionalDetailOp3;
	
	@Column(name = "cec_additional_details_option2__c")
	private String additionalDetailOp2;
	
	@Column(name = "cec_additional_details_option1__c")
	private String additionalDetailOp1;
	

	@Column(name = "cec_others__c")
	private String cecOthers;

	@Column(name = "cec_weekly__c")
	private String cecWeekly;

	@Column(name = "cec_barcode_ean_gtin__c")
	private String barCode;

	@Column(name = "cec_daily__c")
	private String daily;

	@Column(name = "cec_product_name__c")
	private String productName;

	@Column(name = "cec_first_name__c")
	private String firstName;

	@Column(name = "name")
	private String name;

	@Column(name = "cec_last_name__c")
	private String lastName;

	@Column(name = "cec_production_code__c")
	private String cecProductionCode;

	@Column(name = "cec_how_often_do_you_use_this_product__c")
	private String howOften;

	@Column(name = "cec_email_address__c")
	private String emailAddress;

	@Column(name = "cec_online__c")
	private String online;

	@Column(name = "cec_monthly__c")
	private String monthly;

	@Column(name = "cec_retailer__c")
	private String retailer;

	@Column(name = "cec_name_shop__c")
	private String nameShop;

	@Column(name = "cec_marketing_consent_for_newsletter__c")
	private String markentingConsent;

	@Column(name = "cec_age_check__c")
	private String ageCheck;

	@Column(name = "cec_yearly__c")
	private String yearly;

	@Column(name = "cec_where_do_you_usually_buy_product__c")
	private String whereDo;


	@Column(name = "cec_pictures_attachments__c")
	private String pictureAttachment;
	
	
	@Column(name = "cec_name_retailer__c")
	private String nameRetailer;
	
	

	
	public CEC_HelpCentreTranslator() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSfid() {
		return sfid;
	}


	public void setSfid(String sfid) {
		this.sfid = sfid;
	}


	public String getCecOthers() {
		return cecOthers;
	}


	public void setCecOthers(String cecOthers) {
		this.cecOthers = cecOthers;
	}


	public String getCecWeekly() {
		return cecWeekly;
	}


	public void setCecWeekly(String cecWeekly) {
		this.cecWeekly = cecWeekly;
	}


	public String getBarCode() {
		return barCode;
	}


	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}


	public String getDaily() {
		return daily;
	}


	public void setDaily(String daily) {
		this.daily = daily;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCecProductionCode() {
		return cecProductionCode;
	}


	public void setCecProductionCode(String cecProductionCode) {
		this.cecProductionCode = cecProductionCode;
	}


	public String getHowOften() {
		return howOften;
	}


	public void setHowOften(String howOften) {
		this.howOften = howOften;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getOnline() {
		return online;
	}


	public void setOnline(String online) {
		this.online = online;
	}


	public String getMonthly() {
		return monthly;
	}


	public void setMonthly(String monthly) {
		this.monthly = monthly;
	}


	public String getRetailer() {
		return retailer;
	}


	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}


	public String getNameShop() {
		return nameShop;
	}


	public void setNameShop(String nameShop) {
		this.nameShop = nameShop;
	}


	public String getMarkentingConsent() {
		return markentingConsent;
	}


	public void setMarkentingConsent(String markentingConsent) {
		this.markentingConsent = markentingConsent;
	}


	public String getAgeCheck() {
		return ageCheck;
	}


	public void setAgeCheck(String ageCheck) {
		this.ageCheck = ageCheck;
	}


	public String getYearly() {
		return yearly;
	}


	public void setYearly(String yearly) {
		this.yearly = yearly;
	}


	public String getWhereDo() {
		return whereDo;
	}


	public void setWhereDo(String whereDo) {
		this.whereDo = whereDo;
	}


	

	public String getPictureAttachment() {
		return pictureAttachment;
	}


	public void setPictureAttachment(String pictureAttachment) {
		this.pictureAttachment = pictureAttachment;
	}


	public String getPrivacyCookieOpt() {
		return privacyCookieOpt;
	}


	public void setPrivacyCookieOpt(String privacyCookieOpt) {
		this.privacyCookieOpt = privacyCookieOpt;
	}


	public String getHelpTextProductionCode() {
		return helpTextProductionCode;
	}


	public void setHelpTextProductionCode(String helpTextProductionCode) {
		this.helpTextProductionCode = helpTextProductionCode;
	}


	public String getPleaseTryAgain() {
		return pleaseTryAgain;
	}


	public void setPleaseTryAgain(String pleaseTryAgain) {
		this.pleaseTryAgain = pleaseTryAgain;
	}


	public String getValidEmail() {
		return validEmail;
	}


	public void setValidEmail(String validEmail) {
		this.validEmail = validEmail;
	}


	public String getNameOfSite() {
		return nameOfSite;
	}


	public void setNameOfSite(String nameOfSite) {
		this.nameOfSite = nameOfSite;
	}


	public String getSubmit() {
		return submit;
	}


	public void setSubmit(String submit) {
		this.submit = submit;
	}	


	public String getProductionDetail() {
		return productionDetail;
	}


	public void setProductionDetail(String productionDetail) {
		this.productionDetail = productionDetail;
	}


	public String getYourDetails() {
		return yourDetails;
	}


	public void setYourDetails(String yourDetails) {
		this.yourDetails = yourDetails;
	}


	public String getEnquiryType() {
		return enquiryType;
	}


	public void setEnquiryType(String enquiryType) {
		this.enquiryType = enquiryType;
	}


	public String getEnquiryTypeOp2() {
		return enquiryTypeOp2;
	}


	public void setEnquiryTypeOp2(String enquiryTypeOp2) {
		this.enquiryTypeOp2 = enquiryTypeOp2;
	}


	public String getErrorFormSubmission() {
		return errorFormSubmission;
	}


	public void setErrorFormSubmission(String errorFormSubmission) {
		this.errorFormSubmission = errorFormSubmission;
	}


	public String getEnquiryTypeOp1() {
		return enquiryTypeOp1;
	}


	public void setEnquiryTypeOp1(String enquiryTypeOp1) {
		this.enquiryTypeOp1 = enquiryTypeOp1;
	}


	public String getInstruction() {
		return instruction;
	}


	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}


	public String getErrorRequiredField() {
		return errorRequiredField;
	}


	public void setErrorRequiredField(String errorRequiredField) {
		this.errorRequiredField = errorRequiredField;
	}


	public String getAdditionalDetail() {
		return additionalDetail;
	}


	public void setAdditionalDetail(String additionalDetail) {
		this.additionalDetail = additionalDetail;
	}


	public String getGiveMoreDetails() {
		return giveMoreDetails;
	}


	public void setGiveMoreDetails(String giveMoreDetails) {
		this.giveMoreDetails = giveMoreDetails;
	}


	public String getBrowse() {
		return browse;
	}


	public void setBrowse(String browse) {
		this.browse = browse;
	}


	public String getAdditionalDetailOp3() {
		return additionalDetailOp3;
	}


	public void setAdditionalDetailOp3(String additionalDetailOp3) {
		this.additionalDetailOp3 = additionalDetailOp3;
	}


	public String getAdditionalDetailOp2() {
		return additionalDetailOp2;
	}


	public void setAdditionalDetailOp2(String additionalDetailOp2) {
		this.additionalDetailOp2 = additionalDetailOp2;
	}


	public String getAdditionalDetailOp1() {
		return additionalDetailOp1;
	}


	public void setAdditionalDetailOp1(String additionalDetailOp1) {
		this.additionalDetailOp1 = additionalDetailOp1;
	}


	public String getEnquiryTypeOp0() {
		return enquiryTypeOp0;
	}


	public void setEnquiryTypeOp0(String enquiryTypeOp0) {
		this.enquiryTypeOp0 = enquiryTypeOp0;
	}


	public String getNameRetailer() {
		return nameRetailer;
	}


	public void setNameRetailer(String nameRetailer) {
		this.nameRetailer = nameRetailer;
	}	
	
	
	
}
