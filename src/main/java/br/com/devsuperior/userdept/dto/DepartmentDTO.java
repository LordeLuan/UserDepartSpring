package br.com.devsuperior.userdept.dto;

import br.com.devsuperior.userdept.entity.Department;

public class DepartmentDTO {

	private Long idDTO;
	private String nameDTO;
	
	public DepartmentDTO() {}

	public DepartmentDTO(Long idDTO, String nameDTO) {
		this.idDTO = idDTO;
		this.nameDTO = nameDTO;
	}

	public Department convertDtoToEntity() {
		return new Department(getIdDTO(),
						getNameDTO());
	}
	
	public Long getIdDTO() {
		return idDTO;
	}

	public void setIdDTO(Long idDTO) {
		this.idDTO = idDTO;
	}

	public String getNameDTO() {
		return nameDTO;
	}

	public void setNameDTO(String nameDTO) {
		this.nameDTO = nameDTO;
	}

	
	
}
