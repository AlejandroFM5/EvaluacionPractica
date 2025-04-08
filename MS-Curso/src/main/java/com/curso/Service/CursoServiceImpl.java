package com.curso.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.Entity.Curso;
import com.curso.Repository.ICursoRepository;

@Service
public class CursoServiceImpl implements ICursoService{
	
	@Autowired
	private ICursoRepository repository;

	@Override
	public List<Curso> list() {
		return repository.findAll();
	}

	@Override
	public Curso find(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Curso create(Curso crs) {
		return repository.save(crs);
	}

	@Override
	public Curso delete(Curso crs) {
		Curso auxCrs = this.find(crs.getId());
		if(auxCrs!=null) {
			repository.delete(crs);
			return crs;
		}
		return null;
	}

}
