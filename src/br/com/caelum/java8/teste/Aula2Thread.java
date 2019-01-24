package br.com.caelum.java8.teste;

public class Aula2Thread {
	public static void main(String[] args) {
		System.out.println(":::::::::::::::::::::::::::: thread sem l�mbda");
		new Thread(new Runnable() {

		    @Override
		    public void run() {
		        System.out.println("Executando um Runnable");
		    }

		}).start();
		
		System.out.println(":::::::::::::::::::::::::::: thread com l�mbda");
		//o compilador sabe que Thread recebe um Runnable, e que esse s� tem um m�todo, o run(), logo, � perfeito
		//para se usar l�mbda
		new Thread(() -> System.out.println("Executando um Runnable")).start();
	}

}
