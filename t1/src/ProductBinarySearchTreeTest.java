import java.util.ArrayList;

public class ProductBinarySearchTreeTest {
	
	
	public ProductBinarySearchTreeTest() {
		ArrayList<Product> products = new ArrayList<>();
		ProductBinarySearchTree t = new ProductBinarySearchTree();
		
		for(int i=1; i<11; i++ ){
			products.add(new Product(i, "p"+i, 1, 1.00));
		}
		
		for(int i=0; i<products.size(); i++ ){
			t.insert(products.get(i));
		}
		
		ArrayList<Product> list = t.inorderTraversal();
		
		for(int i=0; i<list.size(); i++ ){
			System.out.println(list.get(i).getId());
		}
	}
	
}
