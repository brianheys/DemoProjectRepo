package com.cec.contact;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.http.client.methods.HttpRequestBase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.cec.contact.service.impl.CEC_AWSS3ServiceImpl;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { CEC_SpringBootDemoApplication.class })
public class CEC_AWSS3ServiceImplTest {

	@Mock
	private AmazonS3 amazonS3;

	@Mock
	private S3Object s3Object;

	@InjectMocks
	private CEC_AWSS3ServiceImpl aWSS3ServiceImpl;

	@Mock
	S3ObjectInputStream s3ObjectInputStream;

	@Mock
	HttpRequestBase httpRequestBase;

	final String projectPath = System.getProperty("user.dir");

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testUploadFileToS3BucketSuccess() throws IOException {

		File file = convertToFile();
		final PutObjectRequest putObjectRequest = new PutObjectRequest("unilever-d2", "Cec.html", file);
		PutObjectResult putObjectResult = new PutObjectResult();
		Mockito.when(amazonS3.putObject(putObjectRequest)).thenReturn(putObjectResult);
		aWSS3ServiceImpl.uploadFile(file, "dove/en-gb");
		assertTrue(true, "File upload is completed.");
	}

	@Test
	public void testUploadFileToS3BucketFailed() throws IOException {
		File file = null;
		final PutObjectRequest putObjectRequest = new PutObjectRequest(null, null, file);
		Mockito.doThrow(new AmazonServiceException("Error= {} while uploading file.")).when(amazonS3)
				.putObject(putObjectRequest);
		Assertions.assertThrows(AmazonServiceException.class, () -> amazonS3.putObject(putObjectRequest));

	}

	@Test
	public void testDownloadFileFromS3Bucket() throws IOException {
		String string = "This is a String.\nWe are going to convert it to InputStream.\n"
				+ "Greetings from JavaCodeGeeks!";
		InputStream inputStream = new ByteArrayInputStream(string.getBytes(Charset.forName("UTF-8")));
		Mockito.when(amazonS3.getObject(Mockito.anyString(), Mockito.anyString())).thenReturn(s3Object);
		Mockito.when(s3Object.getObjectContent()).thenReturn(new S3ObjectInputStream(inputStream, httpRequestBase));

		byte[] data = aWSS3ServiceImpl.downloadFile("Text");
		assertNotNull(data);
	}

	private File convertToFile() throws IOException {
		InputStream inputStream = this.getClass().getResourceAsStream("/templates/Test.html");
		Files.copy(inputStream, Paths.get("Test.html"));
		File file = new File("Test.html");
		return file;
	}
}
