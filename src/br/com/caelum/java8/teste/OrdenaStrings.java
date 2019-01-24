package br.com.caelum.java8.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import br.com.caelum.java8.util.ComparadorDeStringPorTamanho;
import br.com.caelum.java8.util.ConsumidorDeString;

public class OrdenaStrings {
	
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		
		Collections.sort(palavras);
		System.out.println(palavras);
		
		Comparator<String>comparator=new ComparadorDeStringPorTamanho();
		palavras.sort(comparator);
		
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		Consumer<String> consumidor = new ConsumidorDeString();
		palavras.forEach(consumidor);
		
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		for(String s :palavras) {
			System.out.println(s);
		}
		
	}

}
