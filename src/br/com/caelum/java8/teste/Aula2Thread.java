package br.com.caelum.java8.teste;

public class Aula2Thread {
	public static void main(String[] args) {
		System.out.println(":::::::::::::::::::::::::::: thread sem lâmbda");
		new Thread(new Runnable() {

		    @Override
		    public void run() {
		        System.out.println("Executando um Runnable");
		    }

		}).start();
		
		System.out.println(":::::::::::::::::::::::::::: thread com lâmbda");
		//o compilador sabe que Thread recebe um Runnable, e que esse só tem um método, o run(), logo, é perfeito
		//para se usar lâmbda
		new Thread(() -> System.out.println("Executando um Runnable")).start();
	}

}
