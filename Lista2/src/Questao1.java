
public class Questao1 {

	celula[] polinomio;
	
	public Questao1(int tam) {
		this.polinomio = new celula[tam];
	}
	
	public class celula{
		 int coeficiente;
		 int expoente;
	}
	
	void add() {
		celula p1 = new celula();
		p1.coeficiente = 2;
		p1.expoente = 4;
		polinomio[0] = p1;
		celula p3 = new celula();
		p3.coeficiente = 3;
		p3.expoente = 5;
		polinomio[1] = p3;
			
	}
	
	void add2() {
		celula p1 = new celula();
		p1.coeficiente = 2;
		p1.expoente = 4;
		polinomio[0] = p1;
		celula p3 = new celula();
		p3.coeficiente = 1;
		p3.expoente = 1;
		polinomio[1] = p3;
		
			
		
	}
	
	
	public celula[] multiplica(celula[] l2) {
		
		celula[] l3 = new celula[l2.length + this.polinomio.length];
		celula[] p2;
		celula[] p1;
		
		
		if(l2.length > this.polinomio.length) {
			p2 = l2;
			p1 = polinomio;
		}else {
			p2 = polinomio;
			p1 = l2;
		}
		int i =0;
		while(i<p2.length) {
			
			if(i>=p1.length) {
				celula p = new celula();
				p.coeficiente = p2[i].coeficiente;
				p.expoente = p2[i].expoente;
				l3[i] = p;
			}
				
			for(int u = 0; u<p1.length;u++) {
				celula p = new celula();
				p.coeficiente = p2[i].coeficiente * p1[u].coeficiente;
				p.expoente = p2[i].expoente * p1[u].expoente;
				l3[i] = p;
				i++;
			}
			i++;
		}
		
		
		celula[] p3 = new celula[l3.length];
		for(int x =0;i<l3.length;i++) {
		
			if(l3[x]!=null) {
				celula p = new celula();
				int hash = hash(l3[x].expoente,l3);
				if(p3[hash]!=null)
					p.coeficiente = p3[hash].coeficiente + l3[x].coeficiente;
				else
					p.coeficiente = l3[x].coeficiente;
				p.expoente = l3[x].expoente; 
				l3[hash] = p;
			}
		}
		for(int x =0;x<l3.length;x++) {
			System.out.println(p3[x]);
		}
		
		return p3;
	}
	
	public int hash(int expoente, celula[] l) {
		return expoente % l.length;
	}
	public static void main(String[] args)  {
		
		//Questao1 q1 = new Questao1(2);
		//Questao1 q2 = new Questao1(2);
		//q1.add();
		//q2.add2();
		
		//q/2.multiplica(q2.polinomio);
		String s = "iasmin";
		System.out.println(s.subSequence(2, 3));
		int h = hash(s);
		System.out.println(h);
		int y = questao3("iasmin","ffsaiasminjfa");
		System.out.println(y);
		
		
	}
	
	
	
	public static int questao3(String p, String str) {
		int hashP = hash(p);
		int N = str.length();
		int k = p.length();
		
		for(int i=0;k<N && i>=0;i++) {
			int ini = i;
			int fim = k + i;
			System.out.println("herehere");
			String substring = str.substring(ini, fim);
			
			int hashSub = hash(substring);
			if(hashSub == hashP) {
				
				if(substring.equals(p)) {
					return ini;
				}
			}
		}
		return -1;
	}
	
	public static int hash(String str) {
		int hash = 0;
		for(int i=0;i<str.length();i++) 
			hash = (str.charAt(i) + (31 * hash)) % str.length();
		return hash;
	}
}

















