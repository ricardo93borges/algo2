import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by ricardo on 26/03/17.
 */
public class Main {

	static HashTable table = new HashTable();

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			int opt = 1;

			while (opt != 0) {
				System.out.println("Digite: " + "\n 1- Para cadastrar um produto"
						+ "\n 2- Para buscar um produto pelo código" + "\n 3- Para buscar um produto pelo nome"
						+ "\n 4- Para remover um produto" + "\n 5- Para exibir o produto mais barato"
						+ "\n 6- Para Exibir todos os produtos" + "\n 0- Para sair \n");

				opt = scanner.nextInt();
					
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
					//scanner.close();
					break;
				default:
					System.out.println("Opção inválida.");
					//scanner.close();
					break;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Opção inválida.\nEncerrando.");
		} catch (Exception e) {
			System.out.println("\nOcorreu um erro:\n" + e.getMessage() + "\n");
		}
	}

	public static void addProduct() {
		try {
			Scanner s = new Scanner(System.in);

			int id;
			String name;
			int category;
			double price;

			System.out.println("\nCadastrar produto:");

			System.out.println("\nInforme o código (número inteiro acima de zero):\n");
			id = s.nextInt();

			System.out.println("\nInforme o nome:\n");
			name = s.next();

			System.out.println("\nInforme o número da categoria:\n");
			category = s.nextInt();

			System.out.println("\nInforme o preço:\n");
			price = s.nextDouble();

			Product p = table.get(id);
			if (p == null) {
				Product product = new Product(id, name, category, price);
				table.put(product);
				System.out.println("\nProduto cadastrado:\n");
			} else {
				System.out.println("\nJá existe um produto com este código:\n");
			}
		} catch (InputMismatchException e) {
			System.out.println("\nInformação inválida:\n");
		} catch (Exception e) {
			System.out.println("\nOcorreu um erro:\n" + e.getMessage() + "\n");
		}
	}

	public static void getProductById() {
		try {
			Scanner s = new Scanner(System.in);
			System.out.println("\nInforme o código:\n");
			int id = s.nextInt();
			Product p = table.get(id);

			if (p == null) {
				System.out.println("\nProduto não encontrado:\n");
			} else {
				System.out.println("\n" + p.toString() + "\n");
			}
		} catch (InputMismatchException e) {
			System.out.println("\nInformação inválida:\n");
		} catch (Exception e) {
			System.out.println("\nOcorreu um erro:\n" + e.getMessage() + "\n");
		}
	}

	public static void getProductByName() {
		try {
			Scanner s = new Scanner(System.in);
			System.out.println("\nInforme o nome:\n");
			String name = s.next();
			Product p = table.findProductByName(name);

			if (p == null) {
				System.out.println("\nProduto não encontrado:\n");
			} else {
				System.out.println("\n" + p.toString() + "\n");
			}
		} catch (InputMismatchException e) {
			System.out.println("\nInformação inválida:\n");
		} catch (Exception e) {
			System.out.println("\nOcorreu um erro:\n" + e.getMessage() + "\n");
		}
	}

	public static void deleteProduct() {

	}

	public static void getProductByPrice() {

	}

	public static void getAllProducts() {

	}
}
