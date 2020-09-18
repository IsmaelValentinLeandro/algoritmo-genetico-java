package br.unisul.pck01;

import java.util.ArrayList;
import java.util.Random;

public class AlgGenetico {
	
	private ArrayList<Cromossomo> populacao;
	private int qtdPopulacao;
	
	public AlgGenetico(int qtdPopulacao)
	{
		this.populacao = new ArrayList<Cromossomo>();
		this.qtdPopulacao = qtdPopulacao;
	}
	
	public Cromossomo start(int _qtdTeste, double _qtdCrossover, double _qtdMutacao)
	{
		geraPopulacaoInicial();
		for (int i=0; i<_qtdTeste; i++) 
		{
			populacao = crossover(_qtdCrossover);
			mutacao(this.populacao, _qtdMutacao);
		}		
		return retornaMaiorCromossomo();
	}
	
	private void geraPopulacaoInicial()
	{
		for (int i=0; i<this.qtdPopulacao; i++)
		{
			Cromossomo c = new Cromossomo();
			c.funcao();
			populacao.add(c);
		}
	}
	
	private ArrayList<Cromossomo>  crossover( double qtdPorcentagem)
	{
		int corteAux =0;
		int corte1   = 0;
		int corte2   = 0;
		Cromossomo pai1 = null;
		
		Random r = new Random();
		
		int qtdCrossover = (int)(populacao.size() * qtdPorcentagem);

		//System.out.println("QUANTIDADE CROSSOVER "+qtdCrossover);
		
		for (int x=0; x<qtdCrossover; x++)
		{
			corte1 = r.nextInt(36);
			corte2 = r.nextInt(36);
			
			if (corte1 > corte2)
			{
				corteAux = corte1;
				corte1 = corte2;
				corte2 = corteAux;
			}
						
			Cromossomo filho1 = new Cromossomo();
			Cromossomo filho2 = new Cromossomo();
			
			if (corte1 ==0 || corte2 == 0 || corte1 == corte2)
				x--;
			else
			{
				if (pai1 == null)
				{
					pai1 = populacao.get(x);
				}
				else
				{
					//System.out.println("LOOP "+x);
					
					for (int i=0; i<36; i++)
					{
						if (i > corte1 && i < corte2)
						{
							filho2.listaBit[i] = pai1.listaBit[i];
							filho1.listaBit[i] = populacao.get(x).listaBit[i];
						}
						else
						{
							filho1.listaBit[i] = pai1.listaBit[i];
							filho2.listaBit[i] = populacao.get(x).listaBit[i];
						}
					}
					filho1.funcao();
					filho2.funcao();
					populacao.add(filho1);
					populacao.add(filho2);
					pai1 = null;
				}
			}			
		}
		
		sort(populacao);
		
		// Faz o corte na população
		
		ArrayList<Cromossomo> list = new ArrayList<Cromossomo>();
		
		for (int i=0; i<qtdPopulacao; i++)
			list.add(populacao.get(i));
		
		return list;
	}
	
	// Faz a ordenação simples (Selection Sort) dos cromossomos
	private ArrayList<Cromossomo> sort(ArrayList<Cromossomo> list) {
		Cromossomo aux;  
        for (int i = 0; i < list.size(); i++){  
             for (int j = i+1; j < list.size(); j++){  
                  if (list.get(i).valorFuncao < list.get(j).valorFuncao){  
                       aux = list.get(i);  
                       list.set(i, list.get(j));  
                       list.set(j, aux);  
                  }  
             }  
        }     
        
        return list;
    }
	
	// Efetua a mutação do cromossomo
	private void mutacao(ArrayList<Cromossomo> populacao, double _qtdMutacao)
	{
		Random r = new Random();
		
		int percentMutacao   = 0; 
		int posicaoDaMutacao = 0;
		
		// Pega a porcentagem da populaçao afetada
		int qtdAfetados = (int)(populacao.size() * _qtdMutacao);
		
		// Caso for 0 ele faz a mutação em pelo menos um
		qtdAfetados = (qtdAfetados==0)? 1: qtdAfetados;
		
		// Randomiza a busca dos afetados
		ArrayList<Integer> posicoes = geraVetor(qtdAfetados, r);
		
		//System.out.println("Quantidade de mutação: "+posicoes.size());
		
		for (Integer v : posicoes) {

			// Mutação vai atingir de 1 a 5 posições no nos bits do cromossomo
			percentMutacao = r.nextInt(5);
			
			// Se a mutação for zero ele vai atingir no mínimo 3
			percentMutacao = (percentMutacao == 0)? 3 : percentMutacao;

			// Se o valor fo 0 ele vai ser acrescido 1 ao menos
			percentMutacao = (percentMutacao==0)? 3: percentMutacao;
			
			// Faz o for paragerar a mutação
			for (int i=0; i<percentMutacao; i++) 
			{
				// Randomiza a mutação no array de bits
				posicaoDaMutacao = r.nextInt(36);
				
				// Efetua a mutação
				populacao.get(v.intValue()).listaBit[posicaoDaMutacao]  = (populacao.get(v.intValue()).listaBit[posicaoDaMutacao]  == 0)? 1: 0;
			}		
			
		}
	}
	
	private Cromossomo retornaMaiorCromossomo()
	{
		this.sort(this.populacao);
		return this.populacao.get(0);
	}
	
	// Método auxiliar da mutação
	private ArrayList<Integer> geraVetor(int qtdAfetados, Random r)
	{
		ArrayList<Integer> vetor = new ArrayList<Integer>();
		Integer row = 0;
		for (int i=0; i<qtdAfetados; i++)
		{
			row = r.nextInt(this.populacao.size());
			if (!vetor.contains(row))
				vetor.add(row);
		}
		return vetor;
	}
	
}
