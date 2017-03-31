import java.util.ArrayList;

public class HashTableTest {
	
	
	public HashTableTest() {
		HashTable ht = new HashTable();
		ArrayList<Product> products = new ArrayList<>();
		
		for(int i=1; i<11; i++ ){
			products.add(new Product(i, "p"+i, 1, 1.00));
		}
		
		for(int i=0; i<products.size(); i++ ){
			ht.put(products.get(i));
		}
		
		System.out.println(ht.toString());
	}
	
}
