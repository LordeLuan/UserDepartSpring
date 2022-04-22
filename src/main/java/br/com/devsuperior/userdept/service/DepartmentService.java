package br.com.devsuperior.userdept.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.devsuperior.userdept.dto.DepartmentDTO;
import br.com.devsuperior.userdept.entity.Department;
import br.com.devsuperior.userdept.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	
	public List<DepartmentDTO> findAll(){
//		Salva as entidades que retornaram do banco numa lista
		List<Department> listDeparts = repository.findAll();
//		Instancia uma lista de obj DTO
		List<DepartmentDTO> listDepartsDTO = new ArrayList<DepartmentDTO>();
//		Percorre todo o array de entidades e adiciona cada entidade na lista de DTO, após converte-la em DTO
		for (Department departs : listDeparts) {
			listDepartsDTO.add(departs.getDTO());
		}
		return listDepartsDTO;
	}
	
	public DepartmentDTO insertDepartment(@RequestBody DepartmentDTO dto) {
//		Converte o objeto DTO passado no parametro para a entidade
		Department depart = dto.convertDtoToEntity();
//		Insere a entidade no banco
		Department departResponse = repository.save(depart);
//		Converte a entidade inserida no banco para DTO
		return  departResponse.getDTO();
		
	}
	
}
