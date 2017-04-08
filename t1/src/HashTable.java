import java.util.ArrayList;
import java.util.HashMap;

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
	private Product productLowerPrice;
	private HashMap<String,Integer> nameKeyMap;

	/**
	 * Constructor
	 */
	public HashTable() {
		this.table = new Entry[SIZE];
		for(int i=0; i<SIZE; i++){
			this.table[i] = null;
		}
		this.productLowerPrice = null;
		this.nameKeyMap = new HashMap<String, Integer>();
	}

	/**
	 *
	 * @return Product
     */
	public Product getProductLowerPrice() {
		return productLowerPrice;
	}

	/**
	 *
	 * @param productLowerPrice
     */
	public void setProductLowerPrice(Product productLowerPrice) {
		this.productLowerPrice = productLowerPrice;
	}

	/**
	 * Atualiza produto com menor preço
	 * @param newProduct
     */
	public void updateProductLowerPrice(Product newProduct){
		if(this.productLowerPrice == null){
			this.productLowerPrice = newProduct;
		}else{
			if(newProduct.getPrice() < this.productLowerPrice.getPrice()){
				this.productLowerPrice = newProduct;
			}
		}
	}

	/**
	 * Encontra produto com menor preço
	 * @return Product
     */
	public Product findProductLowerPrice(){
		Product productLowerPrice = this.productLowerPrice;
		for(int i=0; i<SIZE; i++){
			if(this.table[i] == null){
				continue;
			}
			ArrayList<Product> products = this.table[i].value.inorderTraversal();
			for(int j=0; j<products.size(); j++) {
				if (productLowerPrice == null || productLowerPrice.getPrice() > products.get(j).getPrice()) {
					productLowerPrice = products.get(j);
				}
			}
		}
		return productLowerPrice;
	}
	
	public Product findProductByName(String name){
		if(!this.nameKeyMap.containsKey(name))
			return null;
	
		int key = this.nameKeyMap.get(name);
		if(this.table[key] == null)
			return null;
		
		ProductBinarySearchTree t = this.table[key].value;
		ArrayList<Product> products = t.inorderTraversal();
		for(int i=0; i<products.size(); i++){
			if(products.get(i).getName().equals(name)){
				return products.get(i);
			}
		}	
		return null;		
	}

	/**
	 * Gera chave para a hashtable
	 * @param productId
	 * @return int
     */
	public int generateKey(int productId){
		return productId%13;
	}

	/**
	 * Obtem produto pelo ID
	 * @param productId
	 * @return Product
	 */
	public Product get(int productId){
		int key = this.generateKey(productId);
		if(this.table[key] == null){
			return null;
		}else{
			return this.table[key].value.findProduct(productId);
		}
	}

	/**
	 * Adiciona produto a hashtable
	 * @param p
     */
	public void put(Product p){
		int key = this.generateKey(p.getId());

		//Atualiza produto com o menor preço
		this.updateProductLowerPrice(p);

		//Associa nome do produto com a chave da hashtable
		this.nameKeyMap.put(p.getName(), key);

		//Add
		if(this.table[key] == null){
			ProductBinarySearchTree t = new ProductBinarySearchTree();
			t.insert(p);
			Entry e = new Entry(key, t);
			this.table[key] = e;
		}else{
			this.table[key].value.insert(p);
		}
	}

	/**
	 * Delete produto pelo ID
	 * @param productId
     */
	public void delete(int productId){
		int key = this.generateKey(productId);

		//Remove da hashtable
		if(this.table[key] != null){
			Product p = this.table[key].value.remove(productId);
			//Remove do nameKeyMap
			if(p != null){
				this.nameKeyMap.remove(p.getName());
			}
		}

		//Atualiza produto com menor preço se necessario
		if(this.productLowerPrice.getId() == productId){
			this.productLowerPrice = null;
			Product p = this.findProductLowerPrice();
			this.productLowerPrice = p;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<SIZE; i++){
			if(this.table[i] == null)
				continue;
			ArrayList<Product> list = this.table[i].value.inorderTraversal();
			for(int j=0; j<list.size(); j++){
				sb.append(list.get(j).toString());
				sb.append("\n\n");
			}			
		}
		return sb.toString();
	}
}
