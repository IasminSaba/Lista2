import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class Questao16 {
	
	
	public static String value = "À Á Â Ã Ä Å Æ Ç È É Ê Ë Ì Í Î Ï Ð Ñ Ò Ó Ô Õ Ö Ø Ù Ú Û Ü Ý Þ ß à á â ã ä å æ ç è é ê ë ì í î ï ð ñ ò ó ô õ ö ø ù ú û ü ý þ ÿ";
		
	
	public void metodo(BufferedReader stringD,RwTries rw) throws IOException {

		try {
		String lines = stringD.readLine();
				
		while(lines!=null) {
			
			String string = stringD.readLine();
			//System.out.println(string);
			String[] temp = string.split(" \\(");
			
			char[] caracteres = temp[0].toCharArray();
			
			String y = "";
				for(int u = 0;u<caracteres.length;u++) {
					y = y+normalizar(caracteres[u]);;
					//System.out.print(normalizar(caracteres[u]));
				}
			System.out.println(y);
			rw.put(y, temp[0]);
			//System.out.println("here"+movies[i]);
			
			lines = stringD.readLine();
		}
		}catch(Exception e) {
			System.out.println();
		}
	}
	
	public String semAcento(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
	
	public char normalizar(char c) {
		int n = (int) c;
		//System.out.print("now"+n+"char" + c+"\n");
		if(n>=65 && n<= 90) {
			n = n + 32;
			return (char) n;
		}
		else if((n<=57 && n>=48) || (n>=97 && n<=122))return c;
		else if(n==146 || n == 145)return 'a';
		else if(n==209)return 'd';
		else if((c=='À') ||  (c == 'Á') || (c=='Â') || (c=='Ã') || 
				(c=='Ä') || (c=='Å') || (c=='Ç')|| (c=='È')|| (c=='É')|| (c=='Ê') || (c=='Ë')|| (c=='Ì')|| (c=='Í') ||(c=='Î')||
				(c=='Ï')|| (c=='Ñ')|| (c=='Ò') ||(c=='Ó')|| (c=='Ô')||(c=='Õ')|| (c=='Ö')  ||(c=='Ù')||
				(c=='Ú')|| (c=='Û') ||(c=='Ü')|| (c=='Ý')|| (c=='à')|| (c=='á')|| (c=='â')|| (c=='ã')||(c=='ä')|| (c=='å')|| (c=='ç')||
				(c=='è')|| (c=='é')|| (c=='ê')|| (c=='ë')|| (c=='ì')|| (c=='í')|| (c=='î')|| (c=='ï')|| (c=='ñ')|| (c== 'ò')||
				(c=='ó')|| (c=='ô') ||(c=='õ')|| (c=='ö')|| (c=='ù')|| (c=='ú') ||(c=='û')|| (c=='ü')|| (c=='ý')|| (c=='ÿ')){
			String sc = "" + c;
			String string = semAcento(sc);
			char[] chars = string.toCharArray();
			n = (int) chars[0];
			if(n>=65 && n<= 90) {
				n = n + 32;
				return (char) n;
			}
			return chars[0];
		}
		else if(c==' ') return c;
		else
			return '?';
		
		
	}
	
}

