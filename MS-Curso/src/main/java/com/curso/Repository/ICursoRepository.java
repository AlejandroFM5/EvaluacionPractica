package com.curso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.Entity.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Integer>{

}
