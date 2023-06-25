package br.com.rent_control.view.components;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 
 * @author Ayumi Aoki Santana
 * @author Marcos William Cardoso dos Santos
 *
 */

public class CheckDate {

	private int dia;
	private int mes;
	private int ano;

	public boolean checkDate(int dia, int mes, int ano) {
		if (ehDataValida(dia, mes, ano)) {
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;

			return true;
		} else {
			return false;
		}
	}

	public boolean checkBiggerDate(int dia1, int mes1, int ano1, int dia2, int mes2, int ano2) {
		if (!ehDataValida(dia1, mes1, ano1) || !ehDataValida(dia2, mes2, ano2)) {
			return false;
		}

		if (ano2 > ano1) {
			return true;
		} else if (ano2 == ano1) {
			if (mes2 > mes1) {
				return true;
			} else if (mes2 == mes1 && dia2 > dia1) {
				return true;
			}
		}

		return false;
	}
	
	public int calculateDifferenceDays(int dia1, int mes1, int ano1, int dia2, int mes2, int ano2) {
	    if (!ehDataValida(dia1, mes1, ano1) || !ehDataValida(dia2, mes2, ano2)) {
	        return -1; 
	    }
	    
	    LocalDate data1 = LocalDate.of(ano1, mes1, dia1);
	    LocalDate data2 = LocalDate.of(ano2, mes2, dia2);
	    
	    return (int) ChronoUnit.DAYS.between(data1, data2);
	}

	private boolean ehDataValida(int dia, int mes, int ano) {
		if (ano < 1 || mes < 1 || mes > 12 || dia < 1) {
			return false;
		}

		int ultimoDiaMes = 31;

		// Define o número máximo de dias para cada mês
		if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			ultimoDiaMes = 30;
		} else if (mes == 2) {
			if (ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0)) {
				ultimoDiaMes = 29;
			} else {
				ultimoDiaMes = 28;
			}
		}

		return dia <= ultimoDiaMes;
	}

	public void proximoDia() {
		dia++;
		if (!ehDataValida(dia, mes, ano)) {
			dia = 1;
			mes++;
			if (!ehDataValida(1, mes, ano)) {
				mes = 1;
				ano++;
			}
		}
	}
}