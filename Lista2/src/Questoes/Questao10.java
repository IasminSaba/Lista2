package Questoes;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class Questao10 {

	
	public static void main(String[] args) {
		Random gerador = new Random();
		gerador.nextInt();
		System.out.println(gerador.nextInt(30)); //só somar 1 para iniciar de 1
		SeparateChainingHashMap sh = new SeparateChainingHashMap(10);
		
		for(int i =0;i<1000;i++) {
			int y = gerador.nextInt();
			sh.put(y,"object");
		}
		System.out.println(sh.maximumlengthTable());
		System.out.println(sh.minimumlengthTable());
		
		
	}
	
	
}
/*
Podemos fazer esse método sem o resize e que apresenta os seguintes resultados:
Para 1000: A maior lista possui tamanho 121 e a menor 0;
Para 10000: A maior lista possui tamanho 126 e a menor 0;
Para 100000: A maior lista possui tamanho 130 e a menor 0;
Para 1000000: A maior lista possui tamanho 136 e a menor 0;

Percebe-se que a maior lista difere pouca coisa de um caso para outro. Isso se deve ao aumento no tamanho do array.
Para utilizar o risize do put teria que ser colocado um tamanho fixo que deveria abranger até 1000000 e as listas teriam tamanhos menores.

*/