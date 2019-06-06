import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Teste {
	public static void main(String args[]) throws Exception {
	
		Questao16 q16 = new Questao16();
		FileInputStream file = new FileInputStream("/Users/Cliente/Desktop/Arquivomovel.txt");
		InputStreamReader in = new InputStreamReader(file);
		BufferedReader stringD = new BufferedReader(in);
		
		RwTries rw = new RwTries();
		q16.metodo(stringD,rw);
		
		System.out.println(rw.getValue("death play"));
		
		Scanner s1 = new Scanner(System.in);
		System.out.println("Digite a palavra");
		String resposta =  s1.nextLine();
		System.out.println(rw.keysWithPrefix(resposta));
		System.out.println(rw.longestPrefixOf(resposta));
		System.out.println(rw.keysThatMatch(resposta));
		
		
	}
}
