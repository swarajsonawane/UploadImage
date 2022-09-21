package uploadImage;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Spec {
	public static RequestSpecification request1() {
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io").addHeader("Content-Type", "multipart/form-data").build();
		return req;
		}
	
	public static ResponseSpecification response1() {
		ResponseSpecification res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return res;
		}

}
