package br.com.caelum.java8.teste;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.*;
public class Aula3MethodReference {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		/*
		 * É muito comum escrevermos lambdas curtos, que simplesmente 
		 * invocam um único método. É o exemplo de s -> s.length(). Dada uma 
		 * String, invoque e retorne o método length. Por esse motivo, 
		 * há uma forma de escrever esse tipo de lambda de uma forma ainda 
		 * mais reduzida. Em vez de fazer:
		 */
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		
		//Fazemos uma referência ao método (method reference):
		palavras.sort(Comparator.comparing(String::length));
		
		/*
		 * São equivalentes nesse caso! Sim, é estranho ver String::length e 
		 * dizer que é equivalente a um lambda, pois não há nem a -> e nem os 
		 * parênteses de invocação ao método. Por isso é chamado de method reference. 
		 * Ela pode ficar ainda mais curta com o import static:
		 */
		palavras.sort(comparing(String::length)); //É ncessário importar import static java.util.Comparator.*;
		/*Nota-se que é muito semelhante ao lambda (linha21)
		 * Elas ambas geram a mesma função: dada um String, invoca o método length e devolve este Integer. 
		 * As duas serão avaliadas/resolvidas (evaluated) para Functions equivalentes.
		 */
		
		//...Outro exemplo
		palavras.forEach(s -> System.out.println(s));
		palavras.forEach(System.out::println);
	}

}
