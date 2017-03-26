/**
 * Created by ricardo on 25/03/17.
 */
public class BinaryTree {

    public static class Node {

        public Node father;
        public Node left;
        public Node right;
        public int element;

        public Node(int element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    public Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int element){
        if(this.root == null){
            Node newNode = new Node(element);
            this.root = newNode;
        }else {
            this.insert(element, this.root, null);
        }
    }

    private void insert(int element, Node node, Node parent){
        if(node == null){
            Node newNode = new Node(element);
            newNode.father = parent;
            if(element < parent.element){
                parent.left = newNode;
            }else{
                parent.right = newNode;
            }
        }else{
            if(element < node.element){
                insert(element, node.left, node);
            }else if(element > node.element){
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

    public Node find(int element){
        return this.find(element, this.root);
    }

    private Node find(int element, Node node){
        if(node == null){
            return null;
        }
        Node answer = node;
        if(element == node.element){
            answer = node;
        }else if(element < node.element){
            answer = find(element, node.left);
        }else if(element > node.element){
            answer = find(element, node.right);
        }
        return answer;
    }

    public void remove(int element, Node root){
        Node target = this.find(element, root);
        if(target == null){
            return;
        }

        if(target.left == null && target.right == null){//Target has no children
            if(target.father.left.element == target.element){
                target.father.left = null;
            }else{
                target.father.right = null;
            }
        }else if(target.left != null && target.right == null){//Target has left child
            if(target.father.left.element == target.element){
                target.father.left = target.left;
            }else{
                target.father.right = target.left;
            }
        }else if(target.left == null && target.right != null){//Target has right child
            if(target.father.left.element == target.element){
                target.father.left = target.right;
            }else{
                target.father.right = target.right;
            }
        }else{//Target has chidren
            int min = minValue(target.right);
            target.element = min;
            this.remove(min, target.right);
        }
    }

    public int minValue(Node root) {
        if (root.left == null) {
            return root.element;
        } else {
            return this.minValue(root.left);
        }
    }

}
