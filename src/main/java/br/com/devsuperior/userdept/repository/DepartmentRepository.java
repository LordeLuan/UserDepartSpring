package br.com.devsuperior.userdept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devsuperior.userdept.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
