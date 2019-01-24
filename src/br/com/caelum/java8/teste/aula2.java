package br.com.caelum.java8.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class aula2 {
	
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do c�digo");
		palavras.add("caelum");
		
		//Primeiro passo, ordenar
		System.out.println("::::::::::::::::::: 1 :::::::::::::::::::");
		Collections.sort(palavras);
		System.out.println(palavras);
		
		//Se eu quiser ordenar de outra forma? Pelo tamanho das Strings, por exemplo?
		//** Uso uma classe quem implementa Comparator que devolve 1,-1 e zero e utilizamos
		//essa classe para ordenar:
		System.out.println("::::::::::::::::::: 2 :::::::::::::::::::");
		Comparator<String> comparador = new ComparadorDeStringPorTamanho();
		Collections.sort(palavras, comparador);
		System.out.println(palavras);
		
		//Outro exemplo, com foeEach da interface Iterable. Como Iterable � m�e de Collection, temos acesso a esse m�todo na nossa lista.
		//utiliza��o de classe nested
		//***
		System.out.println("::::::::::::::::::: 3 :::::::::::::::::::");
		Consumer<String> consumidor = new ConsumidorDeString();
		palavras.forEach(consumidor);
		
		System.out.println("::::::::::::::::::: 4 :::::::::::::::::::");
		//jeito antigo de se fazer exemplo 3
		Consumer<String> consumidor2 = new Consumer<String>() {
		    public void accept(String s) {
		        System.out.println(s);
		    }
		};
		palavras.forEach(consumidor2);
	
		System.out.println("::::::::::::::::::: 5 :::::::::::::::::::");
		//um jeito um pouco menos arcaico de se fazer o exemplo 3
		palavras.forEach(new Consumer<String>() {
		    public void accept(String s) {
		        System.out.println(s);
		    }
		});
		System.out.println("::::::::::::::::::: 6 :::::::::::::::::::");
		//exemplo 3 com l�mbda, primeira implementa��o, sem noome do m�todo, pois s� h� 1 e sem new, ao inv�, usamos ->
		palavras.forEach((String s) -> {
		    System.out.println(s);
		});
		
		System.out.println("::::::::::::::::::: 7 :::::::::::::::::::");
		//exemplo 3 com l�mbda, segunda implementa��o, como o tipo porque o l�mbda interpreta
		palavras.forEach((s) -> {
		    System.out.println(s);
		});
		
		System.out.println("::::::::::::::::::: 8 :::::::::::::::::::");
		//exemplo 3 com l�mbda, terceira implementa��o, como s� h� um par�mtro, nem os parenteses s�o necess�rios.
		palavras.forEach(s -> {
		    System.out.println(s);
		});
		
		System.out.println("::::::::::::::::::: 9 :::::::::::::::::::");
		//exemplo 3 com l�mbda, terceira implementa��o, sem chaves e sem ponto e v�rgula, pois s� h� uma instru��o
		palavras.forEach(s -> System.out.println(s));
		
		
		System.out.println("::::::::::::::::::::::::::::::::::::::::::: outro Exemplo, usando comparator, que possui dois par�metros :::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("::::::::::::::::::: 1 :::::::::::::::::::");
		palavras.sort(new Comparator<String>() {
		    public int compare(String s1, String s2) {
		        if (s1.length() < s2.length())
		            return -1;
		        if (s1.length() > s2.length())
		            return 1;
		        return 0;
		    }
		});
		System.out.println(palavras);
		
		System.out.println("::::::::::::::::::: 1 :::::::::::::::::::");
		//Com l�mbda
		palavras.sort((s1, s2) -> {
		    return Integer.compare(s1.length(), s2.length());
		});
		System.out.println(palavras);
		
		
		System.out.println("::::::::::::::::::: 2 :::::::::::::::::::");
		//sem chaves, por s� possuir um statement, e coomo o compilador reconhece que h� um valor a ser retornado, o return pode ser eliminado.
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println(palavras);
		
		System.out.println("::::::::::::::::::: 3 :::::::::::::::::::");
		//sem chaves, por s� possuir um statement, sem compare, subtraindo os valores...(m�todo de resolu��o)
		palavras.sort((s1, s2) -> s1.length() - s2.length());
		System.out.println(palavras);
		
	}
	
	
	
	
}
//**
class ComparadorDeStringPorTamanho implements Comparator<String> {

		public int compare(String s1, String s2) {
	        if(s1.length() < s2.length()) 
	            return -1;
	        if(s1.length() > s2.length()) 
	            return 1;
	        return 0;
	    }

	}
//***
class ConsumidorDeString implements Consumer<String> {
    public void accept(String s) {
        System.out.println(s);
    }
}