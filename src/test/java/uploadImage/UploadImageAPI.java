package uploadImage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class UploadImageAPI {

	@Test
	public void uploadImage() throws IOException {
		
		//RestAssured.baseURI = "https://petstore.swagger.io";
		PrintStream add1 = new PrintStream(new FileOutputStream("C:\\Users\\Swaraj Sonawane\\eclipse-workspace\\UploadImageApi\\target\\Post"));
		Response resp = given().spec(Spec.request1())
				//.header("Content-Type", "multipart/form-data")
				.formParams("additionalMetadata", "test1")
				.multiPart("file" , new File("C:/Users/Swaraj Sonawane/Pictures/Screenshot 2022-09-21 112533.png"), "image/png")
				.filter(RequestLoggingFilter.logRequestTo(add1))
				.filter(ResponseLoggingFilter.logResponseTo(add1))
				.when()
				.post("/v2/pet/9223372016900013000/uploadImage");
		
		System.out.println(resp.statusCode());
		System.out.println(resp.prettyPrint());
				
	}
}
