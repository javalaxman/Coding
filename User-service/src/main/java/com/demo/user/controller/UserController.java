package com.demo.user.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.exception.handle.DataNotFoundException;
import com.demo.generatepdf.PdfGenerator;
import com.demo.user.model.Flight;
import com.demo.user.model.User;
import com.demo.user.service.UserService;

@RestController
public class UserController {
	
	private static final int HttpEntity = 0;

	//PdfGenerator PdfGenerator=new PdfGenerator();
	@Autowired
	UserService userService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/book")
	public User bookFlight(@RequestBody User user) {
		return userService.create(user);
	}
	
	@PostMapping("/book1")
	public User bookFlight1(@RequestBody User user) {
		System.out.println("user controller");
		HttpEntity<User> entity=new HttpEntity(user);
		ResponseEntity<User> userDetails= restTemplate.exchange("http://localhost:9091/api/v3/flight/bookFlight",
				                      HttpMethod.POST,
				                      entity,
				                      new ParameterizedTypeReference<User>() {
									});
									
									   if(userDetails.getBody()!=null) 
									  PdfGenerator.generatePdf(userDetails.getBody());
									 		return userDetails.getBody();
	}
	
	@GetMapping("/searchFlight/{fromDate}/{toDate}")
	public ResponseEntity<List<Flight>>searchFlight(@PathVariable String fromDate,@PathVariable String toDate){
	//	HttpEntity<null> entity=new HttpEntity(user);
		return restTemplate.exchange("http://localhost:9091/api/v3/flight/search/"+fromDate+"/"+toDate,
				HttpMethod.GET,null,
				new ParameterizedTypeReference<List<Flight>>() {
				});
	}
	
	@DeleteMapping("/deleteTicket/{pnr}")
	public User deleteTicket(@PathVariable String pnr) {
		return userService.deleteTicket(pnr);
	}
	
	@GetMapping("/viewTicket/{pnr}")
	public User getFlight(@PathVariable String pnr) throws Exception {
		return userService.viewTicket(pnr);
	}
	
	@GetMapping("/download/{pnrnum}")
    public ResponseEntity<InputStreamResource> downloadPdf(@PathVariable String pnrnum) throws DataNotFoundException {
        String path = "C:\\MyFolder\\User-service\\src\\main\\resources\\templates\\tickets\\"
                + pnrnum + ".pdf";
     try    
      {
            File file = new File(path);
            HttpHeaders respHeaders = new HttpHeaders();
            MediaType mediaType = MediaType.parseMediaType("application/pdf");
            respHeaders.setContentType(mediaType);
            respHeaders.setContentLength(file.length());
            respHeaders.setContentDispositionFormData("attachment", file.getName());
            InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
            return new ResponseEntity<InputStreamResource>(isr, respHeaders, HttpStatus.OK);
        } catch (Exception e) {
            String message = "Ticket " + pnrnum + ".pdf is not there to download ";
            throw new DataNotFoundException(message);

 

            // return new
            // ResponseEntity<InputStreamResource>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
