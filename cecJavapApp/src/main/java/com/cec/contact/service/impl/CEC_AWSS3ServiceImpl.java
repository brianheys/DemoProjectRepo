package com.cec.contact.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.cec.contact.service.CEC_AWSS3Service;

@Service
public class CEC_AWSS3ServiceImpl implements CEC_AWSS3Service {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(CEC_AWSS3ServiceImpl.class);
 
    @Autowired
    private AmazonS3 amazonS3;    
    
    
    private final String defaultBaseFolder = System.getenv("AWS_S3_PATH");
    
  
    private final String bucketName = System.getenv("AWS_S3_BUCKET");
 
    @Async
    public boolean uploadFile(final File file,String awsFolderName) {
        LOGGER.info("File upload in progress.");
        try {            
            uploadFileToS3Bucket(bucketName, file,awsFolderName);
            LOGGER.info("File upload is completed.");
            file.delete(); 
            return true;// To remove the file locally created in the project folder.
        } catch (final AmazonServiceException ex) {
            LOGGER.info("File upload is failed.");
            LOGGER.error("Error= {} while uploading file.", ex.getMessage());
        }catch(Exception e) {
        	LOGGER.info("File upload is failed.");
            LOGGER.error("Error= {} while uploading file.", e.getMessage());
        	
        }
		return false;
    }    
 
   
    private void uploadFileToS3Bucket(final String bucketName, final File file,final String awsFolderName) {
        final String fileName = defaultBaseFolder+awsFolderName+"/"+file.getName();
        LOGGER.info("Uploading file with name= " + fileName);
        final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,fileName, file);
        amazonS3.putObject(putObjectRequest);
    }
    
    @Async
    public byte[] downloadFile(final String keyName) {
        byte[] content = null;
        LOGGER.info("Downloading an object with key= " + keyName);
        final S3Object s3Object = amazonS3.getObject(bucketName, keyName);
        final S3ObjectInputStream stream = s3Object.getObjectContent();
        try {
            content = IOUtils.toByteArray(stream);
            LOGGER.info("File downloaded successfully.");
            s3Object.close();
        } catch(final IOException ex) {
            LOGGER.info("IO Error Message= " + ex.getMessage());
        }
        return content;
    }
    
 
    
   

}

