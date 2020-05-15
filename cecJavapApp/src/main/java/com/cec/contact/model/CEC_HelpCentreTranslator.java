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

	@Column(name = "cec_name_retailer__c")
	private String nemeRetailer;

	@Column(name = "cec_pictures_attachments__c")
	private String pictureAttachment;

	
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


	public String getNemeRetailer() {
		return nemeRetailer;
	}


	public void setNemeRetailer(String nemeRetailer) {
		this.nemeRetailer = nemeRetailer;
	}


	public String getPictureAttachment() {
		return pictureAttachment;
	}


	public void setPictureAttachment(String pictureAttachment) {
		this.pictureAttachment = pictureAttachment;
	}

	

}
