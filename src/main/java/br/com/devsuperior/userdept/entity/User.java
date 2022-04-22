package br.com.devsuperior.userdept.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.devsuperior.userdept.dto.UserDTO;

@Entity
// Definindo nome da tabela
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
	private Long id;
	private String name;
	private String email;
//	Associação entre entidades
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	public User() {}
	
	public User(Long id, String name, String email, Department department) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
	}

	public UserDTO getDTO() {
//		Passa as informações que estão na entidade para o DTO no construtor do mesmo
		return new UserDTO(getId(),
						getName(),
						getEmail(),
						getDepartment().getDTO());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
