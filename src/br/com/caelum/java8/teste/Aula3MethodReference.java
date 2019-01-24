package br.com.caelum.java8.teste;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.*;
public class Aula3MethodReference {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do c�digo");
		palavras.add("caelum");
		
		/*
		 * � muito comum escrevermos lambdas curtos, que simplesmente 
		 * invocam um �nico m�todo. � o exemplo de s -> s.length(). Dada uma 
		 * String, invoque e retorne o m�todo length. Por esse motivo, 
		 * h� uma forma de escrever esse tipo de lambda de uma forma ainda 
		 * mais reduzida. Em vez de fazer:
		 */
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		
		//Fazemos uma refer�ncia ao m�todo (method reference):
		palavras.sort(Comparator.comparing(String::length));
		
		/*
		 * S�o equivalentes nesse caso! Sim, � estranho ver String::length e 
		 * dizer que � equivalente a um lambda, pois n�o h� nem a -> e nem os 
		 * par�nteses de invoca��o ao m�todo. Por isso � chamado de method reference. 
		 * Ela pode ficar ainda mais curta com o import static:
		 */
		palavras.sort(comparing(String::length)); //� ncess�rio importar import static java.util.Comparator.*;
		/*Nota-se que � muito semelhante ao lambda (linha21)
		 * Elas ambas geram a mesma fun��o: dada um String, invoca o m�todo length e devolve este Integer. 
		 * As duas ser�o avaliadas/resolvidas (evaluated) para Functions equivalentes.
		 */
		
		//...Outro exemplo
		palavras.forEach(s -> System.out.println(s));
		palavras.forEach(System.out::println);
	}

}
