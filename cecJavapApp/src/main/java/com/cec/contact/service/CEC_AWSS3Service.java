package com.cec.contact.service;

import java.io.File;


public interface CEC_AWSS3Service {

	boolean uploadFile(File file,String awsFolderName);	 
	
	public byte[] downloadFile(final String keyName);

}
