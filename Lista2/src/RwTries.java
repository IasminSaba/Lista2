import java.util.LinkedList;
import java.util.Queue;



public class RwTries<V> {

	private static final int r = 256;
	private Node root = new Node();
	
	private static class Node{
		Object value;
		Node[] next;
		
		public Node () {
			next = new Node[r];
		}
	}
	
	public void put(String key, V value) {
		root = put(root, key, value, 0);
	}
	
	private Node put(Node r, String str, V value, int i) {
		if(r == null) r = new Node();
		if(i == str.length()) {
			r.value = value; 
			return r;
		} else {
			char ch = str.charAt(i);
			r.next[ch]= put(r.next[ch], str, value, i+1);
		}
		return r;
	}
	
	public Node get(Node r, String key, int i) {
		if(key==null) return null;
		if(i == key.length()) return r;
		char ch = key.charAt(i);
		return get(r.next[ch], key, i+1);
	}
	
	@SuppressWarnings("unchecked")
	private V getValue(Node r, String key, int i) {
		if(key==null) return null;
		if(i == key.length()) 
			return (V) r.value;
		char ch = key.charAt(i);
		
		return getValue(r.next[ch], key, i+1);
	}
	
	public V gettValue(String key) {
		return getValue(root,key,0);
	}
	
	public Iterable<String> keys(){
		Queue<String> queue = new LinkedList<>();
		collect(root,queue,"");
		return queue;
	}
	
	
	public Iterable<String> teste(String st){
		Queue<String> queue = new LinkedList<>();
		collect(root,queue,st);
		return queue;
	}
	
	public Iterable<String> keysWithPrefix (String prefix) {
		Node r = get(root,prefix,0);
		Queue<String> queue = new LinkedList<>();
		collect(r,queue,prefix);
		return queue;
	}
	
	public String longestPrefixOf(String str) {
		int i = search(root,str,0,0);
		return str.substring(0,i);
		
	}
	
	private int search(Node r,String query, int d, int length) {
		
		if(r == null)return length;
		if(r.value != null)length = d;
		if(d == query.length())return length;
		
		char ch = query.charAt(d);
		return search(r.next[ch],query,d+1,length);
		
	}
	/*
	public String keysThatMatch(String s) {
		return keysThatMatch(root,s,"",0,0);
	}
	
	public String keysThatMatch(Node r, String s, String total,int d,int length) {
		
		if(r == null) return total;
		if(d == s.length()) return total;
		
		String string = null;
		char ch = s.charAt(d);
		char y = r.next[d];
		if(ch == '.') string = string + y;
		if(ch == y) string = string + y;
		else 
			return null;
		return string;
		//return getValue(r.next[ch], key, i+1);
	}*/
	private void collect(Node r,Queue<String> queue, String str) {
		
		if(r!=null) {
			if(r.value != null) queue.add(str);
			for(char i = 0;i<r.next.length;i++) collect(r.next[i],queue,str+i);	
		}	
	}
	
	
	private void collectMy(Node r, Queue<String> queue, String str,String ori,int d,LinkedList<Node> words) {
		if(r!=null) {
			//if(r.value != null) queue.add(str);
			
			String t = str.substring(ori.length(), str.length());
			if((words!=null) && (str.length()==d)) {
				words.add(get(root,str,0));
				queue.add(str);
			}
			if((t.length() == d) && r.value != null) queue.add(str); 
			for(char i = 0;i<r.next.length;i++) {
				collectMy(r.next[i],queue,str+i,ori,d,words);	
			}
		}	
	}
	public Iterable<String> Teste(Node r,Queue<String> queue,String pre,int d, String sub) {
		//Node r = get(root,pre,0);
		if(pre.length() == d)return queue;
		char ch = pre.charAt(d);
	
		if(ch == '.') {
			
			Queue<String> queue1 = new LinkedList<>();
			queue = queue1;
			collectMy(r,queue,sub,sub,pre.length()-d,null);
			return queue;
			
		}
		//Queue<String> queue = new LinkedList<>();
		//collectMy(root,queue,pre,pre.length());
		
		return Teste(r,queue,pre,d+1,sub);
		 
		
	}
	public Iterable<String> keysThatMatch(String pre){
		Queue<String> queue = new LinkedList<>();
		int count=0;
		String sub=null;
		for(char i = 0;i<pre.length();i++) {
			int d = pre.charAt(i);
			
			if((d=='.') && i==0) {
				for(i=1;i<pre.length();i++) {
					d = pre.charAt(i);
					if(d != '.')break;
					count++;
				}
				
				sub = pre.substring(count+1, pre.length());
				LinkedList<Node> words = new LinkedList<>();
				collectMy(root,queue,"","",count+1,words);
				Queue<String> queue1 = new LinkedList<>();
				//System.out.println(sub);
				System.out.println(queue);
				for(int u = 0;u<words.size();u++) {
					String s = queue.poll();
					s = s + sub;
					System.out.println(s);
					//Node f = words.pollFirst();
					if(get(root,s,0)!=null)queue1.add(s);
					
				}
				return queue1;
				//break;
			}
			if(d=='.') {
				sub = pre.substring(0, count);
				break;
			}
			count++;
		}
		
		System.out.println(sub);
		Node r = get(root,sub,0);
		return Teste(r,queue,pre,0,sub);
	}
	 public V getValue(String str) {
		 return getValue(root,str,0);
	 }
    
	public static void main(String[] args) {
		RwTries<String> rwt = new RwTries<String>();
		rwt.put("Aufi", "Austin");
		rwt.put("Teresa","Teresa");
		rwt.put("Auf", "August");
		rwt.put("Aufin", "aunfin");
		rwt.put("Augio", "maria");
		rwt.put("Augiov", "Augiov");
	
		//System.out.println(rwt.keysWithPrefix("Au"));
		
		//System.out.println(rwt.longestPrefixOf("Aufiista"));
		//rwt.here("..f");
		System.out.println(rwt.keysThatMatch("...i"));
	//	System.out.println(rwt.keysThatMatch(".uf"));
		//System.out.println(rwt.getValue("Au"));
		
	}
}
