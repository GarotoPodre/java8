package br.com.caelum.java8.teste;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Aula6 {
	
	public static void main(String[] args) {
		
		LocalDate hoje =LocalDate.now();
		System.out.println(hoje);
		
		LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);
		LocalDate birthDay = LocalDate.of(1976, 9, 12);
		
		int anos = hoje.getYear() - birthDay.getYear();
		System.out.println(anos);
		
		System.out.println("::::::::::::::::::");
		Period periodo = Period.between(birthDay,hoje);
		System.out.println(periodo);
		
		System.out.println("::::::::::::::::::");
		System.out.println(periodo.getYears());
		System.out.println(periodo.getMonths());
		System.out.println(periodo.getDays());
		
		System.out.println("::::::::::::::::::");
		
		System.out.println("Hoje menos 1 ano :"+hoje.minusYears(1));
		System.out.println("Hoje menos 4 meses :"+hoje.minusMonths(4));
		System.out.println("Hoje menos 2 dias :"+hoje.minusDays(2));

		System.out.println("Hoje mais 1 ano :"+hoje.plusYears(1));
		System.out.println("Hoje mais 4 meses :"+hoje.plusMonths(4));
		System.out.println("Hoje menos 2 dias :"+hoje.plusDays(2));
		
		System.out.println("::::::::::::::::::");		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate proximasOlimpiadas = olimpiadasRio.plusYears(4);
		String valorFormatado = proximasOlimpiadas.format(formatador);
		System.out.println(valorFormatado);
				
		System.out.println("::::::::::::::::::");
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatadorComHoras=DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm:ss");
		System.out.println(agora.format(formatadorComHoras));
				
		System.out.println("::::::::::::::::::");
		YearMonth anoEMes = YearMonth.of(2015, Month.JANUARY);
		System.out.println(anoEMes);
		
		System.out.println("Mês de nascimento >"+Month.of(9));

		System.out.println("::::::::::::::::::");
		LocalTime intervalo = LocalTime.of(11, 30);
		System.out.println("Hora do almoço :"+intervalo);
		
		
	}

}
