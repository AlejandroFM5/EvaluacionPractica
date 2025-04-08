package com.mx.Main;

import java.util.ArrayList;
import java.util.List;

import com.mx.Main.Entity.Estudiante;

public class Main {
	public static void main(String[] args) {
		
		List<Estudiante> list = new ArrayList<Estudiante>();
		
		list.add(new Estudiante(1, "John Doe", 18, "Derecho"));
		list.add(new Estudiante(2, "Jane Doe", 21, "Administracion"));
		list.add(new Estudiante(3, "Tyler Durden", 24, "Economia"));
		list.add(new Estudiante(4, "Alicia", 19, "TI"));
		list.add(new Estudiante(5, "Hector", 20, "Economia"));
		
		list.stream().filter(Estudiante -> Estudiante.getEdad()>20).forEach(System.out::println);
	}
}
