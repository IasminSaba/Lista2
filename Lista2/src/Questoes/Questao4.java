package Questoes;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Questao4 {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		FileInputStream file = new FileInputStream("/Users/Cliente/Desktop/Dicionario.txt");
		InputStreamReader in = new InputStreamReader(file);
		BufferedReader stringD = new BufferedReader(in);
		
		String tempD = stringD.readLine();
		String[] dicionario = tempD.split(";");
		int contD = dicionario.length - 1;
		System.out.println("- Palavras do Dicionário:\n");
		for (int i = 0; i <= contD; i++){
			System.out.println(dicionario[i]);
		}
		
		SeparateChainingHashMap<String, Integer> tableSC = new SeparateChainingHashMap<String, Integer>();
		for (int i = 0; i <= contD; i++) {
			tableSC.put(dicionario[i],i);
		}
		
		BufferedReader stringT = new BufferedReader(new InputStreamReader (new FileInputStream ("/Users/Cliente/Desktop/DicionarioPessoal.txt")));
		String tempT = stringT.readLine();
	    String[] textoDiv = tempT.split(" ");
		int contT = textoDiv.length - 1;
		System.out.println("\n- Palavras do Texto:\n");
		for (int i = 0; i <= contT; i++){
			System.out.println(textoDiv[i]);
		}
		
	    stringT.close();
	    
	    //textoDiv = trocaAdj(textoDiv,tableSC);
	    //textoDiv = excluindo(textoDiv,tableSC,contT);
	    textoDiv = adicionando(textoDiv,tableSC,contT);
	    
	    
	    String novoTexto = Arrays.toString(textoDiv);
		novoTexto = novoTexto.substring(1, novoTexto.length() - 1);
		novoTexto = novoTexto.replaceAll(",", "");

		System.out.println("\nTexto corrigido:\n\n" + novoTexto);
	 		
	}

	public static String[] trocaAdj(String[] textoDiv,SeparateChainingHashMap<String, Integer> tableSC) {

		for (int i = 0; i <= 1; i++) {
 			char[] palavraChar = textoDiv[i].toCharArray();
 			//System.out.println(palavraChar);
 			
 			if(tableSC.contains(textoDiv[i])==false) {
 				if (palavraChar.length > 1) {
 					for (int j = 0; j < palavraChar.length - 1; j++) {
 						char temp;
						palavraChar = textoDiv[i].toCharArray();
						temp = palavraChar[j];
						palavraChar[j] = palavraChar[j + 1];
						palavraChar[j + 1] = temp;
						String palavra = String.valueOf(palavraChar);
						
						if (tableSC.contains(palavra) == true)
							textoDiv[i] = palavra;
							//System.out.println(textoDiv[i]);
							break;
							
						
						
 					}
 				}
 			}
 			
 			
 		}
		return textoDiv;
	}

	public static String[] excluindo(String[] textoDiv,SeparateChainingHashMap<String, Integer> tableSC,int contT) {
		
		for (int i = 0; i <= contT; i++) {
 			char[] palavraChar = textoDiv[i].toCharArray();
 			if (tableSC.contains(textoDiv[i]) == false) {
 				if (palavraChar.length > 1) {
 					for (int j = 0; j < palavraChar.length; j++) {
 						palavraChar = textoDiv[i].toCharArray();
 						palavraChar[j] = ' ';
 						String palavra = String.valueOf(palavraChar);
 						palavra = palavra.replaceAll(" ", "");
 						if (tableSC.contains(palavra) == true) {
 							textoDiv[i] = palavra;
								System.out.println(textoDiv[i]);
								break;
 								
 						}
 					}
 				}
 			}
 		}
		
		return textoDiv;
	}

	public static String[] adicionando(String[] textoDiv,SeparateChainingHashMap<String, Integer> tableSC,int contT) {
		for (int i = 0; i <= contT; i++) {
			for (int separador = 0; separador <= textoDiv[i].length(); separador++) {
				if (tableSC.contains(textoDiv[i]) == false) {
					String palavra;
					for (char alfabeto = 'a'; alfabeto <= 'z'; alfabeto++) {
						palavra = "";
						palavra = textoDiv[i].substring(0, separador) + alfabeto + textoDiv[i].substring(separador);
						if (tableSC.contains(palavra) == true) {
							textoDiv[i] = palavra;
							System.out.println(textoDiv[i]);
							break;
						}
					}
				}
			}
		}
		return textoDiv;
	}
}

	

