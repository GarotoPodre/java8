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
		palavras.add("casa do código");
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
		
		//Outro exemplo, com foeEach da interface Iterable. Como Iterable é mãe de Collection, temos acesso a esse método na nossa lista.
		//utilização de classe nested
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
		//exemplo 3 com lâmbda, primeira implementação, sem noome do método, pois só há 1 e sem new, ao invé, usamos ->
		palavras.forEach((String s) -> {
		    System.out.println(s);
		});
		
		System.out.println("::::::::::::::::::: 7 :::::::::::::::::::");
		//exemplo 3 com lâmbda, segunda implementação, como o tipo porque o lâmbda interpreta
		palavras.forEach((s) -> {
		    System.out.println(s);
		});
		
		System.out.println("::::::::::::::::::: 8 :::::::::::::::::::");
		//exemplo 3 com lâmbda, terceira implementação, como só há um parâmtro, nem os parenteses são necessários.
		palavras.forEach(s -> {
		    System.out.println(s);
		});
		
		System.out.println("::::::::::::::::::: 9 :::::::::::::::::::");
		//exemplo 3 com lâmbda, terceira implementação, sem chaves e sem ponto e vírgula, pois só há uma instrução
		palavras.forEach(s -> System.out.println(s));
		
		
		System.out.println("::::::::::::::::::::::::::::::::::::::::::: outro Exemplo, usando comparator, que possui dois parâmetros :::::::::::::::::::::::::::::::::::::::::::");
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
		//Com lãmbda
		palavras.sort((s1, s2) -> {
		    return Integer.compare(s1.length(), s2.length());
		});
		System.out.println(palavras);
		
		
		System.out.println("::::::::::::::::::: 2 :::::::::::::::::::");
		//sem chaves, por só possuir um statement, e coomo o compilador reconhece que há um valor a ser retornado, o return pode ser eliminado.
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println(palavras);
		
		System.out.println("::::::::::::::::::: 3 :::::::::::::::::::");
		//sem chaves, por só possuir um statement, sem compare, subtraindo os valores...(método de resolução)
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