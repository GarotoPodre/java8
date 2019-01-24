package br.com.caelum.java8.teste;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import br.com.caelum.modelo.Curso;

public class Aula4Stream {

		
		public static void main(String[] args) {
			List<Curso> cursos = new ArrayList<Curso>();
			cursos.add(new Curso("Python", 45));
			cursos.add(new Curso("JavaScript", 150));
			cursos.add(new Curso("Java 8", 113));
			cursos.add(new Curso("C", 55));
			
			//Method reference
			cursos.sort(Comparator.comparingInt(Curso::getAlunos));
			
			//Ou com lambda... cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
			
			System.out.println("\n::::::::::::::::::::::::1::::::::::::::::::::::::::");
			cursos.forEach(s ->System.out.println(s));
			/*
			 *E se quisermos fazer outras tarefas com essa coleção de cursos? 
			 *Por exemplo, filtrar apenas os cursos com mais de 100 alunos. 
			 *Poderíamos fazer um loop que, dado o critério desejado seja atendido, 
			 *adicionamos este curso em uma nova lista, a lista filtrada.
			 *No Java 8, podemos fazer de uma forma muito mais interessante. 
			 *Há como invocar um filter. Para sua surpresa, esse método não se 
			 *encontra em List, nem em Collection, nem em nenhuma das interfaces 
			 *já conhecidas. Ela está dentro de uma nova interface, a Stream. 
			 *Você pode pegar um Stream de uma coleção simplesmente invocando 
			 *cursos.stream(): 
			 *
			 *O que fazemos com ele? O Stream devolvido por esse método tem uma dezena
			 * de métodos bastante úteis. O primeiro é o filter, que recebe um predicado 
			 * (um critério), que deve devolver verdadeiro ou falso, dependendo se você 
			 * deseja filtrá-lo ou não. Utilizaremos um lambda para isso:
			 */
			System.out.println("\n::::::::::::::::::::::::2::::::::::::::::::::::::::");
			Stream<Curso> stream=cursos.stream().filter(c-> c.getAlunos() >100);
			stream.forEach(c ->System.out.println(c.getNome()));
			
			/*
			 * podemos eliminar essa variável temporária, fazendo tudo em uma mesma linha:
			 */
			
			System.out.println("\n::::::::::::::::::::::::3::::::::::::::::::::::::::");
			cursos.stream()
				.filter(c -> c.getAlunos() >100)
				.forEach(c ->System.out.println(c.getNome()));
			
			/*
			 * E se quisermos, dados esses cursos filtrados no nosso fluxo (Stream) de objetos, 
			 * um novo fluxo apenas com a quantidade de alunos de cada um deles? Utilizamos o map:
			 * 
			 * Se você reparar, esse map não devolve um Stream<Curso>, e sim um Stream<Integer>! 
			 * Faz sentido. Podemos concatenar a invocação ao forEach para imprimirmos os dados:
			 */
			System.out.println("\n::::::::::::::::::::::::4::::::::::::::::::::::::::");
			cursos.stream()
				.filter(c -> c.getAlunos() >100)
				.map(c ->c.getAlunos())
				.forEach(x -> System.out.println(x));
			
			/*
			 *Aproveitamos para recapitular o que já vimos: temos a oportunidade de usar o recurso de method 
			 *references duas vezes. Tanto pra invocação de getAlunos quanto a do println. Vamos alterar: 
			 */
			/*
				 * O lambda passado para o filter não pode ser representado como um method reference, pois não é uma simples 
				 * invocação de um único método: ele compara com um número. Pode ser que, no começo, você prefira os lambdas, 
				 * pela sintaxe ser utilizada mais frequentemente. Com o tempo, verá que o method reference não impõe problema 
				 * de legibilidade algum, muito pelo contrário.
				 * Outro ponto que podemos notar: nem vimos qual é o tipo de interface que Map recebe! É uma Function, mas 
				 * repare que usamos o lambda e nem foi necessário conhecer a fundo quais eram os parâmetros que ele recebia. 
				 * Foi natural. É claro que, com o tempo, é importante que você domine essa nova API, 
				 * mesmo que acabe utilizando majoritariamente as interfaces como lambdas.
				 */
			System.out.println("\n::::::::::::::::::::::::5::::::::::::::::::::::::::");
				cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .map(Curso::getAlunos)
				   .forEach(System.out::println);
				
			
			/*
			 * Trabalhar com Streams vai ser frequente no seu dia a dia. Há um cuidado a ser tomado: com os tipos primitivos. 
			 * Quando fizemos o map(Curso::getAlunos), recebemos de volta um Stream<Integer>, que acaba fazendo o autoboxing dos ints. 
			 * Isto é, utilizará mais recursos da JVM. Claro que, se sua coleção é pequena, o impacto será irrisório. Mas é possível 
			 * trabalhar só com ints, invocando o método mapToInt:
			 */
				
			/*
			 * Em uma única linha de código, pegamos todos os cursos, filtramos os que tem mais de 100 e somamos todos os alunos. 
			 * Há também versões para double e long de Streams primitivos. Até mesmo o Comparator.comparing possui versões como Comparator.comparingInt, 
			 * que recebe uma IntFunction e não necessita do boxing. Em outras palavras, todas as interfaces funcionais do novo pacote java.util.functions 
			 * possuem versões desses tipos primitivos.
			 * Stream não é uma List, não é uma Collection. E se quisermos obter uma coleção depois do processamento de um Stream?
			 */
				
			System.out.println("\n::::::::::::::::::::::::6::::::::::::::::::::::::::");
			cursos.stream()
			   .filter(c -> c.getAlunos() > 100)
			   .mapToInt(Curso::getAlunos)
			   .sum();
			   
				
				
		}
}
