package br.com.devsuperior.userdept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.devsuperior.userdept.dto.UserDTO;
import br.com.devsuperior.userdept.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public List<UserDTO> findAll(){
		List<UserDTO> result = service.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public UserDTO findById(@PathVariable Long id){
		UserDTO result = service.findById(id);
		return result;
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public UserDTO insertUser(@RequestBody UserDTO dto) {
		return service.insertUser(dto);
	}
	
}
