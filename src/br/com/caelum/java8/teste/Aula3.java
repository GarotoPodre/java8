package br.com.caelum.java8.teste;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Aula3 {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		System.out.println(palavras);
		
		System.out.println("\n ::: Com métodos default e lambdas, a ordenação é escrita de forma mais suscinta :::");
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println(palavras);
		
		System.out.println("\n ::: Métodos default em Comparator :::");
		/*
		 * palavras ordene comparando s.length. Passamos o lambda para 
		 * dizer qual será o critério de comparação desse Comparator
		 */
		palavras.sort(Comparator.comparing(s -> s.length()));
		System.out.println(palavras);
		/*
		 * Dizemos que Comparator.comparing recebe um lambda, mas essa é uma expressão do dia a dia. 
		 * Na verdade, ela recebe uma instância de uma interface funcional. 
		 * No caso é a interface Function que tem apenas um método, o apply
		 */
	
		/*
		 * O último código é análogo a:
		 * 
		 * Function<String, Integer> funcao = s -> s.length();
			Comparator<String> comparador = Comparator.comparing(funcao);
			palavras.sort(comparador);
		 */
		
	}

}
