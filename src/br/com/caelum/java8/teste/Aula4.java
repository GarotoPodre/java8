package br.com.caelum.java8.teste;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.modelo.Curso;

public class Aula4 {
	
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		cursos.forEach(s ->System.out.println(s));
	}

}
