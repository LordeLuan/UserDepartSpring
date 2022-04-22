package br.com.devsuperior.userdept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.devsuperior.userdept.dto.DepartmentDTO;
import br.com.devsuperior.userdept.service.DepartmentService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	@GetMapping
	public List<DepartmentDTO> findAll(){
		List<DepartmentDTO> result = service.findAll();
		return result;
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public DepartmentDTO insertUser(@RequestBody DepartmentDTO dto) {
		return service.insertDepartment(dto);
	}
}
