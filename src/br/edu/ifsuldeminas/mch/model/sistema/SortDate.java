package br.edu.ifsuldeminas.mch.model.sistema;

public class SortDate extends NumberOnLetters {

	
	private String mes[] = { "", "janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto",
			"setembro", "outubro", "novembro", "dezembro" };
	
	private Integer convertionStringInNumber = new Integer(0);
	
	
	public String sortDate(String date) {

		String convertionDate = "";
		String[] dateSplit = date.split("/");
		
		int dia = this.convertionStringInNumber.valueOf(dateSplit[0]);
		int mes = this.convertionStringInNumber.valueOf(dateSplit[1]);
		int ano = this.convertionStringInNumber.valueOf(dateSplit[2]);

		return convertionDate += this.inWords(dia) + " de " + this.mes[mes] + " de "
				+ this.inWords(ano);
		
	}
	
}
