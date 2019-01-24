package br.com.caelum.modelo;

public class Curso implements Comparable<Curso> {
	 private String nome;
	    private int alunos;

	    public Curso(String nome, int alunos) {
	        this.nome = nome;
	        this.alunos = alunos;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public int getAlunos() {
	        return alunos;
	    }

		@Override
		public String toString() {
			return "Curso [nome=" + nome + ", alunos=" + alunos + "]";
		}

		@Override
		public int compareTo(Curso o) {
			 if (o.getAlunos() < this.alunos)
		            return -1;
		        if (o.getAlunos() > this.alunos)
		            return 1;
		        return 0;
		}
	    
	    
}
