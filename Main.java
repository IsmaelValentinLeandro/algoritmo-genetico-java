package br.unisul.pck01;

public class Main {
	
	public static void main(String[] args) {
		
		int populacaoInicial = 100;
		int qtdTestes 		 = 15;
		double porcentagemCrossover = 0.6; //%
		double porcentagemMutacao	= 0.03;//%
		
		//populacao/tamanho do cromossomo
		AlgGenetico gen = new AlgGenetico(populacaoInicial); 
		
		//quantidade de testes/crossover/mutacao
		Cromossomo cromossomo = gen.start(qtdTestes, porcentagemCrossover, porcentagemMutacao); 

		System.out.println("Parâmetros");
		System.out.println("População: "+ populacaoInicial);
		System.out.println("Gerações : "+ qtdTestes);
		System.out.println("Crossover: "+ (100*porcentagemCrossover)+"%");
		System.out.println("Mutação  : "+ (100*porcentagemMutacao)+"%");
		System.out.println("");
		System.out.println("Resultado");
		System.out.println("Cromossomo: "+cromossomo.toString());
		System.out.println("Frequência: [" + cromossomo.valorFuncao + "]");
		
		funcaoMostraPosicaoBotoes(cromossomo);
		
	}
	
	private static void funcaoMostraPosicaoBotoes(Cromossomo cromossomo)
	{
		String txt = "";
		int vlr = 0;
		
		for (int i=0; i<9; i++)
		{
			vlr = 0;
			
			if (cromossomo.listaBit[i] == 1)
				vlr += 8;
			if (cromossomo.listaBit[i+1] == 1)
				vlr += 4;
			if (cromossomo.listaBit[i+2] == 1)
				vlr += 2;
			if (cromossomo.listaBit[i+3] == 1)
				vlr += 1;
				
			txt += "Botão ["+(i+1)+"] = "+ vlr +"\r\n";
			
		}
		
		System.out.println(txt);

	}

}
