package com.cec.contact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.cec.contact.constant.CEC_Constants;
 
@Configuration
public class CEC_AWSS3Config {	
 
    
    private String accessKeyId = System.getenv(CEC_Constants.AWS_ACCESS_KEY);
    
    private String secretAccessKey = System.getenv(CEC_Constants.AWS_SECRET_ACCESS);
   
    private String region = System.getenv(CEC_Constants.AWS_S3_REGION);
 
    @Bean
    public AmazonS3 getAmazonS3Cient() {
        final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
        // Get AmazonS3 client and return the s3Client object.
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .build();
    }
}
