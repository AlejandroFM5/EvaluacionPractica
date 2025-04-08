package com.mx.Main.Entity;

public class Estudiante extends Persona{

	private String carrera;

	public Estudiante() {
		super();
	}

	public Estudiante(String carrera) {
		super();
		this.carrera = carrera;
	}

	public Estudiante(int id, String nombre, int edad, String carrera) {
		super(id, nombre, edad);
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Estudiante [carrera=" + carrera + ", toString()=" + super.toString() + ", getId()=" + getId()
				+ ", getNombre()=" + getNombre() + ", getEdad()=" + getEdad() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	
	
}
