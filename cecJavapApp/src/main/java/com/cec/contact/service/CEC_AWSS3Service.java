package com.cec.contact.service;

import java.io.File;

//import org.springframework.web.multipart.MultipartFile;

public interface CEC_AWSS3Service {

	boolean uploadFile(File file,String awsFolderName);	 
	
	public byte[] downloadFile(final String keyName);

}
