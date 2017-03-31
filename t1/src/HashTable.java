
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
	
	public int generateKey(int productId){
		return productId%13;	
	}
	
	public HashTable() {
		this.table = new Entry[SIZE];
		for(int i=0; i<SIZE; i++){
			this.table[i] = null;
		}
	}

	public Product get(int productId){
		int key = this.generateKey(productId);
		if(this.table[key] == null){
			return null;
		}else{
			return this.table[key].value.findProduct(productId);
		}
	}
	
	public void put(Product p){
		int key = this.generateKey(p.getId());	
		if(this.table[key] == null){
			ProductBinarySearchTree t = new ProductBinarySearchTree();
			t.insert(p);
			Entry e = new Entry(key, t);
		}else{
			this.table[key].value.insert(p);
		}
	}
	
}
