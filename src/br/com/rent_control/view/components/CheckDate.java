package br.com.rent_control.view.components;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Class that performs checks on dates
 * 
 * @author Ayumi Aoki &lt;ayumi.santana@icomp.ufam.edu.br&gt;
 * @author Marcos William Cardoso dos Santos
 * @see <a href="https://chat.openai.com/">Operações com data</a>
 */

public class CheckDate {

	/**
	 * Method that returns date validation.
	 * 
	 * @param dia The date day.
	 * @param mes The month of date.
	 * @param ano The year of date.
	 * @return boolean true if the date is valid and false if not.
	 */
	public boolean checkDate(int dia, int mes, int ano) {
		if (ehDataValida(dia, mes, ano)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method that checks if the withdrawal date is less than the return date.
	 * 
	 * @param dia1 The date withdrawal day.
	 * @param mes1 The month of withdrawal of the date.
	 * @param ano1 The date withdrawal year.
	 * @param dia2 The date return day.
	 * @param mes2 The date return month.
	 * @param ano2 The date return year.
	 * @return boolean true or false if the withdrawal date is less than the return
	 *         date.
	 */
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

	/**
	 * Method that calculates the difference or day between the withdrawal and
	 * return date.
	 * 
	 * @param dia1 The date withdrawal day.
	 * @param mes1 The month of withdrawal of the date.
	 * @param ano1 The date withdrawal year.
	 * @param dia2 The date return day.
	 * @param mes2 The date return month.
	 * @param ano2 The date return year.
	 * @return int containing the amount of rental days.
	 */
	public int calculateDifferenceDays(int dia1, int mes1, int ano1, int dia2, int mes2, int ano2) {
		if (!ehDataValida(dia1, mes1, ano1) || !ehDataValida(dia2, mes2, ano2)) {
			return -1;
		}

		LocalDate data1 = LocalDate.of(ano1, mes1, dia1);
		LocalDate data2 = LocalDate.of(ano2, mes2, dia2);

		return (int) ChronoUnit.DAYS.between(data1, data2);
	}

	/**
	 * Method that checks if the given date is valid.
	 * 
	 * @param dia The date day.
	 * @param mes The month of date.
	 * @param ano The year of date.
	 * @return boolean true if the date is valid and false if not.
	 */
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
	
	/**
	 * Method that checks if the given date is greater than 18 years.
	 *
	 * @param dia The date day.
	 * @param mes The month of date.
	 * @param ano The year of date.
	 * @return boolean true if the date is greater than 18 years and false if not.
	 */
	public boolean checkAdultAge(int dia, int mes, int ano) {
	    LocalDate dataAtual = LocalDate.now();
	    LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
	    LocalDate dataMaioridade = dataAtual.minusYears(18);

	    return dataNascimento.isBefore(dataMaioridade);
	}
}