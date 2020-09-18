package br.unisul.pck01;

import java.util.Random;

public class Cromossomo {
	
	public int[] listaBit;
	public int valorFuncao;
	
	public Cromossomo()
	{
		this.listaBit = new int[36];
		this.valorFuncao = 0;
		
		geraCromossomo(36);
	}
	
	public Cromossomo(Cromossomo c)
	{
		this.listaBit = c.listaBit;
		this.valorFuncao = c.valorFuncao;
	}
	
	public void setCromossomo(Cromossomo cromossomo) {
		this.listaBit = cromossomo.listaBit;
	}
	
	public void geraCromossomo(int qtdBit)
	{
		Random r = new Random();
		for (int i=0; i<listaBit.length; i++)
			listaBit[i] = r.nextInt(2);
	}
	
	public String toString()
	{
		String txt = "";
		for (int i=0; i<listaBit.length; i++) txt = txt+listaBit[i];
		return txt;
	}
	
	public void funcao()
	{
		this.valorFuncao = 9 + 	 (this.listaBit[2 -1]  * this.listaBit[5 -1]) 	- (this.listaBit[23 -1] * this.listaBit[14 -1]) +
								 (this.listaBit[24 -1] * this.listaBit[4 -1]) 	- (this.listaBit[21 -1] * this.listaBit[10 -1]) +
								 (this.listaBit[36 -1] * this.listaBit[15 -1]) 	- (this.listaBit[11 -1] * this.listaBit[26 -1]) +
								 (this.listaBit[16 -1] * this.listaBit[17 -1]) 	+ (this.listaBit[3 -1]  * this.listaBit[33 -1]) +
								 (this.listaBit[28 -1] * this.listaBit[19 -1]) 	+ (this.listaBit[12 -1] * this.listaBit[34 -1]) -
								 (this.listaBit[31 -1] * this.listaBit[32 -1]) 	- (this.listaBit[22 -1] * this.listaBit[25 -1]) +
								 (this.listaBit[35 -1] * this.listaBit[27 -1]) 	- (this.listaBit[29 -1] * this.listaBit[7 -1])  +
								 (this.listaBit[8 -1]  * this.listaBit[13 -1]) 	- (this.listaBit[6 -1]  * this.listaBit[9 -1])  +
								 (this.listaBit[18 -1] * this.listaBit[20 -1]) 	- (this.listaBit[1 -1]  * this.listaBit[30 -1]) +
								 (this.listaBit[23 -1] * this.listaBit[24 -1]) 	+ (this.listaBit[21 -1] * this.listaBit[15 -1]) +
								 (this.listaBit[26 -1] * this.listaBit[16 -1]) 	+ (this.listaBit[31 -1] * this.listaBit[12 -1]) +
								 (this.listaBit[25 -1] * this.listaBit[19 -1]) 	+ (this.listaBit[7 -1]  * this.listaBit[8 -1])  +
								 (this.listaBit[9 -1]  * this.listaBit[18 -1]) 	+ (this.listaBit[1 -1]  * this.listaBit[33 -1]);
	}
	
}
