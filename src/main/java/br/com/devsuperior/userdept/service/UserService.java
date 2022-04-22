package br.com.devsuperior.userdept.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.devsuperior.userdept.dto.UserDTO;
import br.com.devsuperior.userdept.entity.User;
import br.com.devsuperior.userdept.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<UserDTO> findAll(){
//		Salva as entidades que retornaram do banco numa lista
		List<User> listUser = repository.findAll();
//		Instancia uma lista de obj DTO
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
//		Percorre todo o array de entidades e adiciona cada entidade na lista de DTO, após converte-la em DTO
		for (User users : listUser) {
			listUserDTO.add(users.getDTO());
		}
		return listUserDTO;
	}
	
	public UserDTO findById(@PathVariable Long id) {
//		Faz a consulta no banco, e retorna um objeto do tipo Optional com o resultado da query dentro dela, por isso é utilizado o metodo get
		//para pegar esse user resultado da query
		User entity = repository.findById(id).get();
//		Passa a respota da consulta do banco acima, como construtor de um objeto DTO
		return entity.getDTO();
	}
	
	public UserDTO insertUser(@RequestBody UserDTO dto) {
//		Converte o objeto DTO passado no parametro para a entidade
		User user = dto.convertDtoToEntity();
//		Insere a entidade no banco
		User userResponse = repository.save(user);
//		Converte a entidade inserida no banco para DTO
		return  userResponse.getDTO();
		
	}
}
