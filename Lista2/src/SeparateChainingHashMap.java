

public class SeparateChainingHashMap<K,V> implements Map<K, V> {

	Node[] table;
	private int size;
	

	private static class Node {
		Object key;
		Object value;
		Node next;
		
		public Node(Object key, Object value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public SeparateChainingHashMap() {
		this.table = new Node[100];
		size = 0;
	}
	public SeparateChainingHashMap(int len) {
		this.table = new Node[len];
		size = 0;
	}
	@Override
	public void put(K key, V value) {
		Node n = getNode(key);
		if(n == null) {
			int i = hash(key);
			table[i] = new Node(key,value,table[i]);
			this.size++;
			if(this.size/table.length == 8) resize(table.length*2); //aumenta
			
		}
		else {
			n.value = value;
		}
	
	}
	
	@SuppressWarnings("unchecked")
	public V get(K key) {
		Node n = getNode(key);
		return (n!= null)? (V) n.value : null;
	}
	
	private Node getNode(K key) {
		int i = hash(key);
		for(Node n = table[i]; n !=null; n = n.next) {
			if(key.equals(n.key)) return n;
		}
		return null;
	}
	
	private int hash(K key) {
		
		return (key.hashCode() & 0x7fffffff) % table.length;
		//return (Math.abs(key.hashCode())) % table.length;
		
	}

	@Override
	public void remove(K key) {
		int i = hash(key);
		Node tmp = new Node(null,null,table[i]);
		
		for(Node n = tmp; n.next != null;n = n.next) {
			if(key.equals(tmp.next.key)) {
				n.next = n.next.next;
				this.size--;
				if(this.size/table.length == 2) resize(table.length/2);
			}
			break;

		}
		table[i] = tmp.next;
		
		//for(Node n = table[i]; n !=null; n = n.next) {
			//if(key.equals(n.next.key)) n.next = n.next.next;
		//}
		
	}

	@SuppressWarnings("unchecked")
	public void resize(int newlength) {
		
		SeparateChainingHashMap<K,V> tmp = new SeparateChainingHashMap<>();
		for(int i = 0; i<table.length; i++) {
			for(Node n = table[i]; n !=null; n = n.next) {
				tmp.put((K) n.key, (V) n.value);
			}
		}
		table = tmp.table;
		
	}
	
	
	
	/*
	public int resize2(int newlength) {
		
		Node tmp = new Node(null,null,table[i]);
		for()
			for(Node n = tmp; n.next != null;n = n.next) {
				if(key.equals(tmp.next.key)) n.next = n.next.next;
				break;

			}
		return newlength;
	}*/
	
	
	
	
	//aumentar valor m quando length da lista > n/m
	@Override
	public Iterable<K> keys() {
		
		return null;
	}

	@Override
	public boolean contains(K key) {
		
		if (key == null) throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
		
	}
}
