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
			 *E se quisermos fazer outras tarefas com essa cole��o de cursos? 
			 *Por exemplo, filtrar apenas os cursos com mais de 100 alunos. 
			 *Poder�amos fazer um loop que, dado o crit�rio desejado seja atendido, 
			 *adicionamos este curso em uma nova lista, a lista filtrada.
			 *No Java 8, podemos fazer de uma forma muito mais interessante. 
			 *H� como invocar um filter. Para sua surpresa, esse m�todo n�o se 
			 *encontra em List, nem em Collection, nem em nenhuma das interfaces 
			 *j� conhecidas. Ela est� dentro de uma nova interface, a Stream. 
			 *Voc� pode pegar um Stream de uma cole��o simplesmente invocando 
			 *cursos.stream(): 
			 *
			 *O que fazemos com ele? O Stream devolvido por esse m�todo tem uma dezena
			 * de m�todos bastante �teis. O primeiro � o filter, que recebe um predicado 
			 * (um crit�rio), que deve devolver verdadeiro ou falso, dependendo se voc� 
			 * deseja filtr�-lo ou n�o. Utilizaremos um lambda para isso:
			 */
			System.out.println("\n::::::::::::::::::::::::2::::::::::::::::::::::::::");
			Stream<Curso> stream=cursos.stream().filter(c-> c.getAlunos() >100);
			stream.forEach(c ->System.out.println(c.getNome()));
			
			/*
			 * podemos eliminar essa vari�vel tempor�ria, fazendo tudo em uma mesma linha:
			 */
			
			System.out.println("\n::::::::::::::::::::::::3::::::::::::::::::::::::::");
			cursos.stream()
				.filter(c -> c.getAlunos() >100)
				.forEach(c ->System.out.println(c.getNome()));
			
			/*
			 * E se quisermos, dados esses cursos filtrados no nosso fluxo (Stream) de objetos, 
			 * um novo fluxo apenas com a quantidade de alunos de cada um deles? Utilizamos o map:
			 * 
			 * Se voc� reparar, esse map n�o devolve um Stream<Curso>, e sim um Stream<Integer>! 
			 * Faz sentido. Podemos concatenar a invoca��o ao forEach para imprimirmos os dados:
			 */
			System.out.println("\n::::::::::::::::::::::::4::::::::::::::::::::::::::");
			cursos.stream()
				.filter(c -> c.getAlunos() >100)
				.map(c ->c.getAlunos())
				.forEach(x -> System.out.println(x));
			
			/*
			 *Aproveitamos para recapitular o que j� vimos: temos a oportunidade de usar o recurso de method 
			 *references duas vezes. Tanto pra invoca��o de getAlunos quanto a do println. Vamos alterar: 
			 */
			/*
				 * O lambda passado para o filter n�o pode ser representado como um method reference, pois n�o � uma simples 
				 * invoca��o de um �nico m�todo: ele compara com um n�mero. Pode ser que, no come�o, voc� prefira os lambdas, 
				 * pela sintaxe ser utilizada mais frequentemente. Com o tempo, ver� que o method reference n�o imp�e problema 
				 * de legibilidade algum, muito pelo contr�rio.
				 * Outro ponto que podemos notar: nem vimos qual � o tipo de interface que Map recebe! � uma Function, mas 
				 * repare que usamos o lambda e nem foi necess�rio conhecer a fundo quais eram os par�metros que ele recebia. 
				 * Foi natural. � claro que, com o tempo, � importante que voc� domine essa nova API, 
				 * mesmo que acabe utilizando majoritariamente as interfaces como lambdas.
				 */
			System.out.println("\n::::::::::::::::::::::::5::::::::::::::::::::::::::");
				cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .map(Curso::getAlunos)
				   .forEach(System.out::println);
				
			
			/*
			 * Trabalhar com Streams vai ser frequente no seu dia a dia. H� um cuidado a ser tomado: com os tipos primitivos. 
			 * Quando fizemos o map(Curso::getAlunos), recebemos de volta um Stream<Integer>, que acaba fazendo o autoboxing dos ints. 
			 * Isto �, utilizar� mais recursos da JVM. Claro que, se sua cole��o � pequena, o impacto ser� irris�rio. Mas � poss�vel 
			 * trabalhar s� com ints, invocando o m�todo mapToInt:
			 */
				
			/*
			 * Em uma �nica linha de c�digo, pegamos todos os cursos, filtramos os que tem mais de 100 e somamos todos os alunos. 
			 * H� tamb�m vers�es para double e long de Streams primitivos. At� mesmo o Comparator.comparing possui vers�es como Comparator.comparingInt, 
			 * que recebe uma IntFunction e n�o necessita do boxing. Em outras palavras, todas as interfaces funcionais do novo pacote java.util.functions 
			 * possuem vers�es desses tipos primitivos.
			 * Stream n�o � uma List, n�o � uma Collection. E se quisermos obter uma cole��o depois do processamento de um Stream?
			 */
				
			System.out.println("\n::::::::::::::::::::::::6::::::::::::::::::::::::::");
			cursos.stream()
			   .filter(c -> c.getAlunos() > 100)
			   .mapToInt(Curso::getAlunos)
			   .sum();
			   
				
				
		}
}
