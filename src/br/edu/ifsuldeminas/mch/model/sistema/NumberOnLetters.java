package br.edu.ifsuldeminas.mch.model.sistema;

public abstract class  NumberOnLetters {

	private static String[] NUMBERS_IN_WORDS = { "zero", "um", "dois", "tres", "quatro", "cinco", "seis", "sete",
			"oito", "nove", "dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezecete", "dezoi",
	"dezenove" };
	private static String[] TENS_IN_WORDS = { "", "", "vinte", "trinta", "quatenta", "cinquenta", "sessenta", "setenta",
			"oitenta", "noventa" };
	private static String[] HUNDREDS_IN_WORDS = { "", "cem", "duzentos", "trezentos","quatrocentos","quinhentos","seicentos","setecentos","oitocentos","novecentos" };
	private static String[] THOUSANDS_IN_WORDS = { "", "mil"};

	public String inWords(int i) {
		int milhar = i / 1000;
		int centena = (i % 1000) / 100;
		int dezena = (i % 100) / 10;
		int unidade = i % 10;

		String conversion = "";

		if (dezena == 1) {
			unidade = ((dezena * 10) + unidade);
			dezena = 0;
		}

		if (milhar > 0) {
			
			conversion += THOUSANDS_IN_WORDS[milhar];
			
			if(centena > 0 || dezena >0 || unidade > 0)
				conversion += " e ";
			

		}

		if (centena > 0) {
			conversion += " ";
			conversion += HUNDREDS_IN_WORDS[centena];
			
			if( dezena >0 || unidade > 0)
				conversion += "to e ";

		}

		if (dezena > 0) {
		
			conversion += TENS_IN_WORDS[dezena];
			
			if( unidade > 0)
				conversion += " e ";

		}

		if (unidade > 0) {
			
			conversion += NUMBERS_IN_WORDS[unidade];

		}
		
		if(i == 0){
			conversion += NUMBERS_IN_WORDS[i];
		}

		return conversion;
	}

}
