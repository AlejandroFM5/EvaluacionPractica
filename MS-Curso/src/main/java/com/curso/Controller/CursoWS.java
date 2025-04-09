package com.curso.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.Entity.Curso;
import com.curso.Service.CursoServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/curso")
public class CursoWS {

	@Autowired
	private CursoServiceImpl service;
	
	@GetMapping("/lista")
	public ResponseEntity<?> listOfCurso(){
		List<Curso> list = service.list();
		if(list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@PostMapping("/nuevo")
	public ResponseEntity<?> createNewCurso(@RequestBody Curso crs){
		Curso auxCrs = service.find(crs.getIdCurso());
		if(auxCrs == null) {
			service.create(crs);
			return ResponseEntity.status(HttpStatus.OK).body(crs);
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> deleteCurso(@RequestBody Curso crs){
		Curso auxCrs = service.find(crs.getIdCurso());
		if(auxCrs!=null) {
			if(service.delete(crs)!=null) {
				return ResponseEntity.status(HttpStatus.OK).body(crs);
			}else {ResponseEntity.status(HttpStatus.BAD_REQUEST).build();}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
