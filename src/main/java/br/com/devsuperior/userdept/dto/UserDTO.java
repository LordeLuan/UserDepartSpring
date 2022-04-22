package br.com.devsuperior.userdept.dto;

import br.com.devsuperior.userdept.entity.User;

public class UserDTO {
	
	private Long idDTO;
	private String nameDTO;
	private String emailDTO;
	private DepartmentDTO departmentDTO;
	
	public UserDTO() {}

	public UserDTO(Long idDTO, String nameDTO, String emailDTO, DepartmentDTO departmentDTO) {
		this.idDTO = idDTO;
		this.nameDTO = nameDTO;
		this.emailDTO = emailDTO;
		this.departmentDTO = departmentDTO;
	}
	
	public User convertDtoToEntity() {
		return new User(getIdDTO(),
						getNameDTO(),
						getEmailDTO(),
//						Passando a entidade DepartamentDTO no construtor da entidade, utilizando o metodo de converter o DTO 
//						para entidade do CategoriaDTO
						getDepartmentDTO().convertDtoToEntity());
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

	public String getEmailDTO() {
		return emailDTO;
	}

	public void setEmailDTO(String emailDTO) {
		this.emailDTO = emailDTO;
	}

	public DepartmentDTO getDepartmentDTO() {
		return departmentDTO;
	}

	public void setDepartmentDTO(DepartmentDTO departmentDTO) {
		this.departmentDTO = departmentDTO;
	}



	
}
