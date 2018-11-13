package com.kimhank.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/hello")
public class RestTest {

	@GET
	@Produces(MediaType.TEXT_XML)
	public String  testXml() {
		String resource = "<? xml version='1.0' ?>" +
	   " <hello> Hi , This is hello from XML";
		return resource;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String  testJson() {
		String resource = null;
		return resource;
	}
	
//	@GET
//	@Produces(MediaType.TEXT_HTML)
//	public String  testHtml() {
//		String resource = "<h1> Hi, this is hell from HTML";
//		return resource;
//	}
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String  testHtml(@QueryParam("nake") String name, @QueryParam("Card_no") String Card_no, @QueryParam("amount") int amount) {
		String response ;
		if(amount > 100) {
			System.out.println("Amount is Greater than 100 ");
			response = "Card is not approved";
		}else {
			response ="Card is apporved";
		}
		return "<html>" + "<title>" + name + "</title>" + "<body><h1>" + response + "</h1></body>" + "</html>";
				
	}
	
}
