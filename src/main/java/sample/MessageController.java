package sample;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@PostMapping("/message")
	ResponseEntity<Object> create(@Valid @RequestBody Message message, BindingResult result) {
		if(result.hasErrors()) {
			return new ResponseEntity<Object>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
