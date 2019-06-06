package Teste;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import Questoes.Questao16;
import Questoes.RwTries;



public class Teste {
	public static void main(String args[]) throws Exception {
	
		Questao16 q16 = new Questao16();
		FileInputStream file = new FileInputStream("/Users/Cliente/Desktop/Arquivomovel.txt");
		InputStreamReader in = new InputStreamReader(file);
		BufferedReader stringD = new BufferedReader(in);
		
		RwTries rw = new RwTries();
		q16.construirRwTrie(stringD,rw);
		System.out.println(rw.getValue("death play"));
		
		Scanner s1 = new Scanner(System.in);
		System.out.println("Digite 1,2 ou 2");
		int op = s1.nextInt();
		System.out.println("Digite a palavra");
		String resposta =  s1.nextLine();
		
		if(op == 1)System.out.println(rw.keysWithPrefix(resposta));
		if(op==2)System.out.println(rw.longestPrefixOf(resposta));
		if(op==3)System.out.println(rw.keysThatMatch(resposta));
		
		
	}
}


/*		TESTE QUESTÃO 16
 * Na classe Questao16 o método "contruieRwTrie" constrói a trie recebendo os nomes dos filmes, convertendo-os para um caractere equivalente, 
 * como dito na questão, ou '?'. 
 * A trie é chaveada pelo nome normalizado e valorado pelo seu nome real.
 * Testes:
 * resposta = de;
 * Console --> [de eso no se habla, de noche vienes? esmeralda, dead, dead ahead, dead aim, dead awake..]
 * 				null
 *              []
 * resposta = death playyy
 * Console -->  null
				death play
				[]
 * Para KeysThatMatch
 * resposta =de
	Console -->[dead ahead, dead awake, dead badge, dead sleep, dead tides, dear santa, death game, de

 */


