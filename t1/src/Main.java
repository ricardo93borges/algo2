import java.util.Scanner;

/**
 * Created by ricardo on 26/03/17.
 */
public class Main {
	
	static HashTable table = new HashTable();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opt = 1;

		while (opt != 0) {
			System.out.println("Digite: " + "\n 1- Para cadastrar um produto"
					+ "\n 2- Para buscar um produto pelo código" + "\n 3- Para buscar um produto pelo nome"
					+ "\n 4- Para remover um produto" + "\n 5- Para exibir o produto mais barato"
					+ "\n 6- Para Exibir todos os produtos" + "\n 0- Para sair \n");

			if (scanner.hasNextInt()) {
				opt = scanner.nextInt();
			} else {
				opt = 0;
				System.out.println("Opção inválida.\nEncerrando.");
				scanner.close();
			}

			switch (opt) {
				case 1:
					addProduct();
					break;
				case 2:
					getProductById();
					break;
				case 3:
					getProductByName();
					break;
				case 4:
					deleteProduct();
					break;
				case 5:
					getProductByPrice();
					break;
				case 6:
					getAllProducts();
					break;
				case 0:
					System.out.println("Fim.");
					break;
				default:
					System.out.println("Opção inválida.");
					break;
			}
		}

	}

	public static void addProduct() {
		Scanner s = new Scanner(System.in);
		
		int id;
		String name;
		int category;
		double price;
		
		System.out.println("\nCadastrar produto:");
		
		while(!s.hasNextInt()){
			System.out.println("\nInforme o código (número inteiro acima de zero):\n");
		}		
		id = s.nextInt();
		
		while(!s.hasNext()){
			System.out.println("\nInforme o nome:\n");
		}		
		name = s.next();
		
		while(!s.hasNextInt()){
			System.out.println("\nInforme o número da categoria:\n");
		}		
		category = s.nextInt();
		
		while(!s.hasNextDouble()){
			System.out.println("\nInforme o preço:\n");
		}		
		price = s.nextDouble();
		
		Product p = table.get(id);
		if(p == null){
			Product product = new Product(id, name, category, price);
			table.put(product);
		}else{
			System.out.println("\nJá existe um produto com este código:\n");
		}
	}

	public static void getProductById() {

	}

	public static void getProductByName() {

	}

	public static void deleteProduct() {

	}

	public static void getProductByPrice() {

	}

	public static void getAllProducts() {

	}
}
