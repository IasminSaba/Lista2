
public class LinearProbingHashMap<K, V> implements Map<K, V> {

	private K[] keys;
	private V[] values;
	private int size;
	

	public LinearProbingHashMap(int len) {
		this.keys = (K[]) new Object[len];
		this.values = (V[]) new Object[len];
		size = 0;
	}
	public LinearProbingHashMap() {
		this(397);
	}

	/*
	@Override
	public void put(K key, V value) {
		int i = hash(key);
		
		if(keys[i] == null) {
			keys[i] = key;
			values[i] = value;
			size++;
		}else if(keys[i].equals(key)){
			values[i] = value;
		}else {
			for(int n = 0;n<keys.length;n = (n+1)%keys.length) {
				if(keys[n] == null) {
					keys[i] = key;
					values[i] = value;
					size++;
				}
			}
			
		}
	}
	@Override
	public V get(K key) {
		int i = hash(key);
		
		for(int n = i;n<keys.length;n = (n+1)%keys.length) {
			if(key.equals(keys[n])) {
				return (V) values[n];
			}
		}
		return null;
	}*/
	private int hash(K key) {
		
		return (key.hashCode() & 0x7fffffff) % keys.length;
	}
	
	public void put(K key, V value) {
		int p = hash(key);
		
		while(keys[p] != null && !key.equals(keys[p])) p = (p+1)%keys.length;
		keys[p] = key;
		values[p] = value;
		
		
	}
	
	@Override
	public V get(K key) {
		int p = hash(key);
		
		while(keys[p] != null && !key.equals(keys[p])) p = (p+1)%keys.length;
		return values[p];
	}

	@Override
	public void remove(K key) {
		
		int p = hash(key);
		while(keys[p] != null && !key.equals(keys[p])) p = (p+1)%keys.length;
		values[p] = null;
	}

	public void resize(int newKength) {
		LinearProbingHashMap aux1 = new LinearProbingHashMap();
		
		
		
	}
	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args)  {
		
		char x = 'a';
		char y = 'b';
		
		System.out.println((42.4/10));
		
	}
	

}

