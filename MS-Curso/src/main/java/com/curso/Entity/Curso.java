package com.curso.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CURSO")
public class Curso {
	//campos id, nombre, duracionHoras.
	@Id
	private int idCurso;
	private String nombre;
	private int duracionHoras;
	
	public Curso() {
	}

	public Curso(int idCurso, String nombre, int duracionHoras) {
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.duracionHoras = duracionHoras;
	}

	@Override
	public String toString() {
		return "Curso [id=" + idCurso + ", nombre=" + nombre + ", duracionHoras=" + duracionHoras + "]";
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracionHoras() {
		return duracionHoras;
	}

	public void setDuracionHoras(int duracionHoras) {
		this.duracionHoras = duracionHoras;
	}
	
}
