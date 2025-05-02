//Jennifer Morin
//COS225 5/1/2024
public class TreeNode<T>{

    private T element;
    private TreeNode<T> left;
    private TreeNode<T> right;

    //O(1)
    public TreeNode(T element){
        this.element=element;
    }

    //O(1)
    public T getElement(){
        return element;
    }

    //O(1)
    public TreeNode<T> getLeft(){
        return left;
    }

    //O(1)
    public TreeNode<T> getRight(){
        return right;
    }

    //O(1)
    public void setElement(T element){
        this.element=element;
    }

    //O(1)
    public void setLeft(TreeNode<T> left){
        this.left=left;
    }

    //O(1)
    public void setRight(TreeNode<T> right){
        this.right=right;
    }

    //O(n)
    public void inorder(TreeNode<T> node){
        if (node == null){
            return;
        }
        inorder(node.getLeft());
        System.out.print(node.getElement()+" ");
        inorder(node.getRight());
    }

    //O(n)
    public void preorder(TreeNode<T> node){
        if (node == null){
            return;
        }
        System.out.print(node.getElement()+" ");
        postorder(node.getLeft());
        postorder(node.getRight());
    }

    //O(n)
    public void postorder(TreeNode<T> node){
        if (node == null){
            return;
        }
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.print(node.getElement()+" ");
    }

    //O(n)  Null node = -1; Leaf node =0; Anything else = 1;
    public int height(){
        if (left == null && right == null){
            return 0;
        }
        else if (left != null && right == null){
            return 1 + this.getLeft().height();
        }
        else if (left == null && right != null){
            return 1 + this.getRight().height();
        }
        else{
            return 1 + Math.max(this.getLeft().height(), this.getRight().height());
        }
    }

    //O(n^2)
    public boolean isBalanced(){
        if (left == null && right == null){
            return true;
        }
        else if (left != null && right == null){
            return this.getLeft().height() == 0;
        }
        else if (left == null && right != null){
            return this.getRight().height() == 0;
        }
        else{
            return Math.abs(this.getLeft().height() - this.getRight().height()) <=1 ;
        }
    }

    // O(n)
    public boolean isIn(T target){
        if (this.getElement().equals(target)){
            return true;
        }
        else if(this.getLeft() == null && this.getRight() == null){
            return false;
        }
        else{
            if (this.getRight() != null && this.getLeft() != null){
                return this.getLeft().isIn(target) || this.getRight().isIn(target);
            }
            else if (this.getRight() == null && this.getLeft() != null){
                return this.getLeft().isIn(target);
            }
            else if (this.getRight() != null && this.getLeft() == null){
                return this.getLeft().isIn(target);
            }
            else{
                return false;
            }
        }
    }

    //Best Case: O(1)
    //Worst Case: O(n*logn)
    public void balancedInsert(T element){
        if (this.getLeft()==null){
            this.setLeft(new TreeNode<T>(element));
        }
        else if (this.getRight()==null){
            this.setRight(new TreeNode<T>(element));
        }
        else{
            if (this.getLeft().height() <= this.getRight().height()){
                this.getLeft().balancedInsert(element);
            }
            else {
                this.getRight().balancedInsert(element);
            }
        }
    }

    //Best case: O(1)
    //Worst case: O(n)
    //cutting off a whole branch, cannot remove if element is at the root
    
    public void lossyRemoval(T element){
        if (this.getLeft().getElement().equals(element)){
            this.setLeft(null);
        }
        else if (this.getRight().getElement().equals(element)){
            this.setRight(null);
        }
        else{
            this.getLeft().lossyRemoval(element);
            this.getRight().lossyRemoval(element);
        }
    }

    public String toString(){
        return element.toString();
    }
}


/* 
public class TreeNode<T>{

    private T element;
    private TreeNode<T> left;
    private TreeNode<T> right;

    //O(1)
    public TreeNode(T element){
        this.element=element;
    }

    //O(1)
    public T getElement(){
        return element;
    }

    //O(1)
    public TreeNode<T> getLeft(){
        return left;
    }

    //O(1)
    public TreeNode<T> getRight(){
        return right;
    }

    //O(1)
    public void setElement(T element){
        this.element=element;
    }

    //O(1)
    public void setLeft(TreeNode<T> left){
        this.left=left;
    }

    //O(1)
    public void setRight(TreeNode<T> right){
        this.right=right;
    }

    //O(n)
    public String inorder(TreeNode<T> node){
        String myString="";
        if (node == null){
            return " ";
        }
        inorder(node.getLeft());
        myString+=(node.getElement()+" ");
        inorder(node.getRight());
        return myString;

    }

    //O(n)
    public String preorder(TreeNode<T> node){
        String myString="";
        if (node == null){
            return "";
        }
        myString+=(node.getElement()+" ");
        preorder(node.getLeft());
        preorder(node.getRight());
        return myString;
    }

    //O(n)
    public String postorder(TreeNode<T> node){
        String myString="";
        if (node == null){
            return "";
        }
        else{
            myString+=element;
        }
        System.out.println(element);
        postorder(node.getLeft());
        postorder(node.getRight());
        myString+=(node.getElement()+" ");
        return myString;
    }

    //O(n)  Null node = -1; Leaf node =0; Anything else = 1;
    public int height(){
        if (left == null && right == null){
            return 0;
        }
        else if (left != null && right == null){
            return 1 + this.getLeft().height();
        }
        else if (left == null && right != null){
            return 1 + this.getRight().height();
        }
        else{
            return 1 + Math.max(this.getLeft().height(), this.getRight().height());
        }
    }

    //O(n^2)
    public boolean isBalanced(){
        if (left == null && right == null){
            return true;
        }
        else if (left != null && right == null){
            return this.getLeft().height() == 0;
        }
        else if (left == null && right != null){
            return this.getRight().height() == 0;
        }
        else{
            return Math.abs(this.getLeft().height() - this.getRight().height()) <=1 ;
        }
    }

    // O(n)
    public boolean isIn(T target){
        if (this.getElement().equals(target)){
            return true;
        }
        else if(this.getLeft() == null && this.getRight() == null){
            return false;
        }
        else{
            if (this.getRight() != null && this.getLeft() != null){
                return this.getLeft().isIn(target) || this.getRight().isIn(target);
            }
            else if (this.getRight() == null && this.getLeft() != null){
                return this.getLeft().isIn(target);
            }
            else if (this.getRight() != null && this.getLeft() == null){
                return this.getLeft().isIn(target);
            }
            else{
                return false;
            }
        }
    }

    //Best Case: O(1)
    //Worst Case: O(n*logn)
    public void balancedInsert(T element){
        if (this.getLeft()==null){
            this.setLeft(new TreeNode<T>(element));
        }
        else if (this.getRight()==null){
            this.setRight(new TreeNode<T>(element));
        }
        else{
            if (this.getLeft().height() <= this.getRight().height()){
                this.getLeft().balancedInsert(element);
            }
            else {
                this.getRight().balancedInsert(element);
            }
        }
    }

    //Best case: O(1)
    //Worst case: O(n)
    //cutting off a whole branch, cannot remove if element is at the root
    
    public void lossyRemoval(T element){
        if (this.getLeft().getElement().equals(element)){
            this.setLeft(null);
        }
        else if (this.getRight().getElement().equals(element)){
            this.setRight(null);
        }
        else{
            this.getLeft().lossyRemoval(element);
            this.getRight().lossyRemoval(element);
        }
    }

    public String toString(){
        return element.toString();
    }
}
    */