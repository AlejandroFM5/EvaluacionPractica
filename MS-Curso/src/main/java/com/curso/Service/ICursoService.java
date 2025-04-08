package com.curso.Service;

import java.util.List;

import com.curso.Entity.Curso;

public interface ICursoService {
	public List<Curso> list();
	public Curso find(int id);
	public Curso create(Curso crs);
	public Curso delete(Curso crs);
}
