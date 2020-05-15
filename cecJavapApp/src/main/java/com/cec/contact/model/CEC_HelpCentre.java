package com.cec.contact.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CEC_Help_Centre_Configuration__c", schema = "salesforce")
@NamedQuery(name = "CEC_HelpCentre.findByStatus", query = "select c from CEC_HelpCentre c where c.status='Ready For Deployment'")
@NamedQuery(name = "CEC_HelpCentre.updateStatus", query = "update CEC_HelpCentre u set u.status = ?1 , u.herokuPostgresId = ?2 where u.id = ?2")
public class CEC_HelpCentre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "cec_heroku_postgres_id__c")
	private Long herokuPostgresId;

	@Column(name = "cec_aws_file_name__c")
	private String awsFileName;

	@Column(name = "cec_aws_folder__c")
	private String awsFolder;

	@Column(name = "cec_brandcode__c")
	private String brandCode;

	@Column(name = "cec_brand__c")
	private String brand;

	@Column(name = "cec_cookie_information__c")
	private String cookieInformation;

	@Column(name = "cec_country_name__c")
	private String countryName;

	@Column(name = "cec_country__c")
	private String country;

	@Column(name = "cec_enable_captcha__c")
	private boolean enableCaptcha;

	@Column(name = "cec_form_type__c")
	private String formType;

	@Column(name = "cec_locale__c")
	private String locale;

	@Column(name = "cec_market__c")
	private String market;

	@Column(name = "cec_minimum_age_limit__c")
	private Integer minimumAgeLimit;

	@Column(name = "cec_privacy_link__c")
	private String privacyLink;

	@Column(name = "cec_product__c")
	private String product;

	@Column(name = "cec_status__c")
	private String status;

	@Column(name = "cec_redirect_url__c")
	private String redirectUrl;

	@Column(name = "lastmodifiedbyid")
	private String lastmodifiedbyid;

	@Column(name = "name")
	private String helpCentreConfigurationName;

	@Column(name = "cec_cmm_iso_country_code__c")
	private String cecIsoCountryCode;

	@Column(name = "cec_unique_id__c")
	private String uniqueId;

	@Column(name = "systemmodstamp")
	private Date systemmodstamp;

	@Column(name = "createddate")
	private Date createddate;

	@Column(name = "cec_terms_conditions__c")
	private String termsOfUse;
	
	@Column(name = "cec_help_centre_language__c")
	private String cecHelpCentrelanguage;

	public CEC_HelpCentre() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHerokuPostgresId() {
		return herokuPostgresId;
	}

	public void setHerokuPostgresId(Long herokuPostgresId) {
		this.herokuPostgresId = herokuPostgresId;
	}

	public String getAwsFileName() {
		return awsFileName;
	}

	public void setAwsFileName(String awsFileName) {
		this.awsFileName = awsFileName;
	}

	public String getAwsFolder() {
		return awsFolder;
	}

	public void setAwsFolder(String awsFolder) {
		this.awsFolder = awsFolder;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCookieInformation() {
		return cookieInformation;
	}

	public void setCookieInformation(String cookieInformation) {
		this.cookieInformation = cookieInformation;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean isEnableCaptcha() {
		return enableCaptcha;
	}

	public void setEnableCaptcha(boolean enableCaptcha) {
		this.enableCaptcha = enableCaptcha;
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public Integer getMinimumAgeLimit() {
		return minimumAgeLimit;
	}

	public void setMinimumAgeLimit(Integer minimumAgeLimit) {
		this.minimumAgeLimit = minimumAgeLimit;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastmodifiedbyid() {
		return lastmodifiedbyid;
	}

	// new fields

	public String getPrivacyLink() {
		return privacyLink;
	}

	public void setPrivacyLink(String privacyLink) {
		this.privacyLink = privacyLink;
	}

	public String getHelpCentreConfigurationName() {
		return helpCentreConfigurationName;
	}

	public void setHelpCentreConfigurationName(String helpCentreConfigurationName) {
		this.helpCentreConfigurationName = helpCentreConfigurationName;
	}

	public String getCecIsoCountryCode() {
		return cecIsoCountryCode;
	}

	public void setCecIsoCountryCode(String cecIsoCountryCode) {
		this.cecIsoCountryCode = cecIsoCountryCode;
	}

	public void setLastmodifiedbyid(String lastmodifiedbyid) {
		this.lastmodifiedbyid = lastmodifiedbyid;
	}

	public Date getSystemmodstamp() {
		return systemmodstamp;
	}

	public String getTermsOfUse() {
		return termsOfUse;
	}

	public void setTermsOfUse(String termsOfUse) {
		this.termsOfUse = termsOfUse;
	}

	public String getProduct() {
		return product;
	}

	public void setSystemmodstamp(Date systemmodstamp) {
		this.systemmodstamp = systemmodstamp;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getCecHelpCentrelanguage() {
		return cecHelpCentrelanguage;
	}

	public void setCecHelpCentrelanguage(String cecHelpCentrelanguage) {
		this.cecHelpCentrelanguage = cecHelpCentrelanguage;
	}	

}
