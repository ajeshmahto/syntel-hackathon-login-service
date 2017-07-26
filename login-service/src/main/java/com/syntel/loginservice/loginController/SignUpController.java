package com.syntel.loginservice.loginController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.syntel.domain.Response;
import com.syntel.domain.User;
import com.syntel.repository.SignUpRepository;



@RestController
@RequestMapping("/versatileHealth")
public class SignUpController {
	
	@Autowired
	private SignUpRepository signUpRepository ;
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ResponseEntity<Response> save(@RequestBody User user){
		Response response = new Response();
		if(signUpRepository.findOne(user.getMobileNumber())==null){
			signUpRepository.save(user);
			response.setStatus("SUCCESS");
			response.setResponse(user);
			return new ResponseEntity<Response>(response,HttpStatus.OK);
		}
		response.setStatus("FAIL");
		response.setResponse("Mobile Number already exists");
	    return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable String mobileNumber){
		signUpRepository.delete(mobileNumber);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ResponseEntity<List<User>>  getAll(){
		
		return new ResponseEntity<List<User>>(signUpRepository.findAll(),HttpStatus.OK);
	}
	

}
