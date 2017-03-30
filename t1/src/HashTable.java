
public class HashTable {
	
	private class Entry{
		private int key;
		private ProductBinarySearchTree value;
		
		public Entry(int key, ProductBinarySearchTree value) {
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public ProductBinarySearchTree getValue() {
			return value;
		}		
	}
	
	private final static int SIZE = 13;
	private Entry[] table;
	
	public HashTable() {
		this.table = new Entry[SIZE];
		for(int i=0; i<SIZE; i++){
			this.table[i] = null;
		}
	}

	public Product get(int key){
		//TODO
	}
	
	public void put(Product p){
		int key = p.getId()%13;	
		//TODO
	}
	
}
