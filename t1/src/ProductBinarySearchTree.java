import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Created by ricardo on 26/03/17.
 */
public class ProductBinarySearchTree {

	public static class Node {

        public Node father;
        public Node left;
        public Node right;
        public Product element;

        public Node(Product element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }
	
	public Node root;
	
	public ProductBinarySearchTree(Node root) {
        this.root = root;
    }

    public ProductBinarySearchTree() {
        this.root = null;
    }

    public void insert(Product element){
        if(this.root == null){
        	Node newNode = new Node(element);
            this.root = newNode;
        }else {
            this.insert(element, this.root, this.root);
        }
    }
    
    private void insert(Product element, Node node, Node parent){
        if(node == null){
            Node newNode = new Node(element);
            newNode.father = parent;
            if(element.compareTo(parent.element) == -1){
                parent.left = newNode;
            }else{
                parent.right = newNode;
            }
        }else{
        	if(element.compareTo(parent.element) == -1){
                insert(element, node.left, node);
            }else{
                insert(element, node.right, node);
            }
        }
    }
    
    public ArrayList<Product> inorderTraversal() {
    	ArrayList<Product> products = new ArrayList<Product>();   
        if(this.root !=null){
        	this.inorderTraversal(products, this.root);
        }
        return products;
    }
 
    public void inorderTraversal(ArrayList<Product> products, Node p){
        if(p.left!=null)
        	inorderTraversal(products,p.left);
 
        products.add(p.element);
 
        if(p.right!=null)
        	inorderTraversal(products,p.right);
    }

    public Product findProduct(int id){
        Node n = this.find(id, this.root);
        if(n == null){
        	return null;
        }
        return n.element;
    }
    
    public Node find(int id){
        return this.find(id, this.root);
    }

    private Node find(int id, Node node){
        if(node == null){
            return null;
        }
        Node answer = node;
        if(id == node.element.getId()){
            answer = node;
        }else if(id < node.element.getId()){
            answer = find(id, node.left);
        }else{
            answer = find(id, node.right);
        }
        return answer;
    }

    public void remove(int id, Node root){
        Node target = this.find(id);
        if(target == null){
            return;
        }

        if(target.left == null && target.right == null){//Target has no children
            if(target.father.left.element.compareTo(target.element) == 0){
                target.father.left = null;
            }else{
                target.father.right = null;
            }
        }else if(target.left != null && target.right == null){//Target has left child
        	if(target.father.left.element.compareTo(target.element) == 0){
                target.father.left = target.left;
            }else{
                target.father.right = target.left;
            }
        }else if(target.left == null && target.right != null){//Target has right child
        	if(target.father.left.element.compareTo(target.element) == 0){
                target.father.left = target.right;
            }else{
                target.father.right = target.right;
            }
        }else{//Target has chidren
        	Product min = minValue(target.right);
            target.element = min;
            this.remove(min.getId(), target.right);
        }
    }

    public Product minValue(Node root) {
        if (root.left == null) {
            return root.element;
        } else {
            return this.minValue(root.left);
        }
    }
	
}
