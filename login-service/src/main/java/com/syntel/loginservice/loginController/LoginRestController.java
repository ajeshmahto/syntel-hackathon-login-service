package com.syntel.loginservice.loginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.syntel.domain.Response;
import com.syntel.domain.User;
import com.syntel.repository.LoginRepository;

@RestController
@RequestMapping("versatileHealth")
public class LoginRestController {
	
	@Autowired
	LoginRepository loginRepository;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<Response>  verifyLogin(@RequestBody User user){
		 Response response = new Response();
		 User userResult = new User();
		 if(loginRepository.findOne(user.getMobileNumber())!=null){
			 userResult=loginRepository.verifyLogin(user.getMobileNumber(), user.getPassword());
			if(userResult!=null){
				response.setStatus("SUCCESS");
				response.setResponse(user);
				return new ResponseEntity<Response>(response,HttpStatus.OK);
			}
		 }
		    response.setStatus("FAIL");
			response.setResponse("User Credential Mismatch");
		    return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping(value="/forgotPassword", method=RequestMethod.POST)
	public ResponseEntity<Response>  forgotPassword(@RequestBody User user){
		 Response response = new Response();
		 User userResult = new User();
		 if((userResult = loginRepository.findOne(user.getMobileNumber()))!=null){
				response.setStatus("SUCCESS");
				response.setResponse(user);
				return new ResponseEntity<Response>(response,HttpStatus.OK);
		   }
		    response.setStatus("FAIL");
			response.setResponse("No user found");
		    return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
		
	}
	

}
