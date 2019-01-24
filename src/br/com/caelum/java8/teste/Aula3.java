package br.com.caelum.java8.teste;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Aula3 {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do c�digo");
		palavras.add("caelum");
		
		System.out.println(palavras);
		
		System.out.println("\n ::: Com m�todos default e lambdas, a ordena��o � escrita de forma mais suscinta :::");
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println(palavras);
		
		System.out.println("\n ::: M�todos default em Comparator :::");
		/*
		 * palavras ordene comparando s.length. Passamos o lambda para 
		 * dizer qual ser� o crit�rio de compara��o desse Comparator
		 */
		palavras.sort(Comparator.comparing(s -> s.length()));
		System.out.println(palavras);
		/*
		 * Dizemos que Comparator.comparing recebe um lambda, mas essa � uma express�o do dia a dia. 
		 * Na verdade, ela recebe uma inst�ncia de uma interface funcional. 
		 * No caso � a interface Function que tem apenas um m�todo, o apply
		 */
	
		/*
		 * O �ltimo c�digo � an�logo a:
		 * 
		 * Function<String, Integer> funcao = s -> s.length();
			Comparator<String> comparador = Comparator.comparing(funcao);
			palavras.sort(comparador);
		 */
		
	}

}
