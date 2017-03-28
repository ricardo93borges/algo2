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
            this.insert(element, this.root, null);
        }
    }
    
    private void insert(Product element, Node node, Node parent){
        if(node == null){
            Node newNode = new Node(element);
            newNode.father = parent;
            if(element.getId() < parent.element.getId()){
                parent.left = newNode;
            }else{
                parent.right = newNode;
            }
        }else{
            if(element.getId() < node.element.getId()){
                insert(element, node.left, node);
            }else if(element.getId() > node.element.getId()){
                insert(element, node.right, node);
            }
        }
    }
    
    public void preorder(Node root) {
        if(root !=  null) {
            System.out.printf("%d ",root.element);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public Node find(Product element){
        return this.find(element, this.root);
    }

    private Node find(Product element, Node node){
        if(node == null){
            return null;
        }
        Node answer = node;
        if(element == node.element){
            answer = node;
        }else if(element.getId() < node.element.getId()){
            answer = find(element, node.left);
        }else if(element.getId() > node.element.getId()){
            answer = find(element, node.right);
        }
        return answer;
    }

    public void remove(Product element, Node root){
        Node target = this.find(element, root);
        if(target == null){
            return;
        }

        if(target.left == null && target.right == null){//Target has no children
            if(target.father.left.element.getId() == target.element.getId()){
                target.father.left = null;
            }else{
                target.father.right = null;
            }
        }else if(target.left != null && target.right == null){//Target has left child
            if(target.father.left.element.getId() == target.element.getId()){
                target.father.left = target.left;
            }else{
                target.father.right = target.left;
            }
        }else if(target.left == null && target.right != null){//Target has right child
            if(target.father.left.element.getId() == target.element.getId()){
                target.father.left = target.right;
            }else{
                target.father.right = target.right;
            }
        }else{//Target has chidren
        	Product min = minValue(target.right);
            target.element = min;
            this.remove(min, target.right);
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
