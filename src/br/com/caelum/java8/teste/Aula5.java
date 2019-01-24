package br.com.caelum.java8.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.caelum.modelo.Curso;

public class Aula5 {
	
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		/*
		 * Os Streams possibilitam trabalhar com dados de uma maneira funcional. Normalmente, s�o dados e objetos 
		 * que v�m de uma collection do Java. Por que n�o adicionaram esses m�todos diretamente nas Collections? 
		 * Justo para n�o ser dependente delas, n�o ter efeitos colaterais e n�o entupir de m�todos as interfaces.
		 * Vamos conhecer outros m�todos interessantes dos Streams. Um exemplo seria: quero um curso que tenha mais 
		 * de 100 alunos! Pode ser qualquer um deles. H� o m�todo findAny
		 */
		
				cursos.stream()
				   .filter(c -> c.getAlunos() > 100)
				   .findAny();
		/*
		 * O que ser� que devolve o findAny? Um Curso? N�o! Um Optional<Curso>.
		 * Optional � uma importante nova classe do Java 8. � com ele que poderemos trabalhar de uma maneira mais 
		 * organizada com poss�veis valores null. Em vez de ficar comparando if(algumaCoisa == null), o Optional 
		 * j� fornece uma s�rie de m�todos para nos ajudar nessas situa��es. Por que o findAny utiliza esse recurso? 
		 * Pois pode n�o haver nenhum curso com mais de 100 alunos! Nesse caso, o que seria retornado? null? 
		 * uma exception?
		 * Vamos ver as vantagens de se trabalhar com Optional. Primeiro vamos atribuir o resultado do findAny a uma vari�vel:
		 */
		Optional<Curso> optional = cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .findAny();
		/*
		 * Dado um Optional, podemos pegar seu conte�do invocando o get. Ele vai devolver o Curso que queremos. 
		 * Mas e se n�o houver nenhum? Uma exception ser� lan�ada.
		 */
			Curso curso = optional.get();
		/*
		 * H� m�todos mais interessantes. O orElse diz que ele deve devolver o curso que existe dentro desse optional, ou ent�o o que foi 
		 * passado como argumento:Curso curso = optional.orElse(null);
		 * Nesse caso ou ele devolve o curso encontrado, ou null, caso nenhum seja encontrado. Mesmo assim, ainda n�o est� t�o interessante. 
		 * H� como evitar tanto o null, quanto as exceptions, quanto os ifs. O m�todo ifPresent executa um lambda (um Consumer) no caso de 
		 * existir um curso dentro daquele optional:
		 * 
		   optional.ifPresent(c -> System.out.println(c.getNome()));
		 Claro que, no dia a dia, n�o ter�amos a vari�vel tempor�ria curso. Podemos fazer isso:
		 */

		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .findAny()
		   .ifPresent(c -> System.out.println(c.getNome()));
		/*
		 * Outros m�todos devolvem Optional nos Streams. Um deles � o average em IntStream. Por que? Pois pode n�o existir nenhum 
		 * element, e a� a m�dia poderia realizar uma divis�o por zero.
		 * Voc� vai encontrar Optional n�o somente na API de Streams. Vale a pena conhecer e utiliz�-la no seu pr�prio c�digo e entidades.	
		 */
	
		
		/*
		 * Gerando uma cole��o a partir de um Stream
		 * Invocar m�todos no stream de uma cole��o n�o altera o conte�do da cole��o original. Ele n�o gera efeitos colaterais. Como ent�o obter 
		 * uma cole��o depois de alterar um Stream?
		 * Tentar fazer List<Curso> novaLista = lista.stream().filter(...) n�o compila, pois um Stream n�o � uma cole��o. Para fazer algo parecido 
		 * com isso, utilizamos o m�todo collect, que coleta elementos de um Stream para produzir um outro objeto, como uma cole��o.
		 * O m�todo Collect recebe um Collector, uma interface n�o t�o trivial de se implementar. Podemos usar a classe Collectors (repare o s no final), 
		 * cheio de factory methods que ajudam na cria��o de coletores. Um dos coletores mais utilizados � o retornado por Collectors.toList():
		 */
		
		List<Curso> resultados = cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .collect(Collectors.toList());
		System.out.println(resultados);
		
		/*
		 * Pronto! � atrav�s dos coletores que podemos "retornar" de um Stream para uma Collection. Certamente poderia ter usado a mesma vari�vel, a 
		 * List<Curso> cursos que temos:
		 * 
		 * 		cursos = cursos.stream()
   					.filter(c -> c.getAlunos() > 100)
   					.collect(Collectors.toList());
		 */
		
		/*
		 * Um exemplo mais complicado? Podemos gerar mapas! Queremos um mapa que, dado o nome do curso, o valor atrelado � a quantidade alunos. 
		 * Um Map<String, Integer>. Utilizamos o Collectors.toMap. Ele recebe duas Functions. A primeira indica o que vai ser a chave, e a 
		 * segunda o que ser� o valor:


			Map mapa = cursos 
			.stream() 
			.filter(c -> c.getAlunos() > 100) 
			.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
			
			Os Streams foram desenhados de uma forma a tirar proveito da programa��o funcional. Se voc� utiliz�-los da forma que vimos por aqui, 
			eles nunca gerar�o efeitos colaterais. Isso �, apenas o stream ser� alterado, e nenhum outro objeto ser� impactado. Dada essa premissa, 
			podemos pedir para que nosso stream seja processado em paralelo. Ele mesmo vai decidir quantas threads usar e fazer todo o trabalho, 
			utilizando APIs mais complicadas (como a de fork join) para ganhar performance. Para fazer isso, basta utilizar parallelStream() em vez de stream()!

			Tome cuidado. Para streams pequenos, o custo de cuidado dessas threads e manipular os dados entre elas � alto e pode ser bem mais lento que o Stream tradicional.
		 */
		
		//Calcule a quantidade m�dia de alunos de todos os seus cursos utilizando a API de Stream.

		//				VER OPINI�O DO INSTRUTOR
		//Uma poss�vel solu��o �:

		cursos.stream()
		    .mapToInt(c -> c.getAlunos())
		    .average();
		
	}
	
	

}
