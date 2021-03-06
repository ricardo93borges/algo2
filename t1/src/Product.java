/**
 * Created by ricardo on 26/03/17.
 */
public class Product implements Comparable<Product>{

    private int id;
    private String name;
    private int category;
    private double price;

    public Product(int id, String name, int category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }
    

    @Override
	public int compareTo(Product o) {
    	if (this.id < o.getId()) {
            return -1;
        }
        if (this.id > o.getId()) {
            return 1;
        }
        return 0;
	}
    
	public int compareNameTo(Product o) {
    	return this.name.compareToIgnoreCase(o.getName());
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Código: ");
		sb.append(this.getId());
		sb.append("\nNome: ");
		sb.append(this.getName());
		sb.append("\nCategoria: ");
		sb.append(this.getCategory());
		sb.append("\nPreço: ");
		sb.append(this.getPrice());
		return sb.toString();
	}
    
    
}
