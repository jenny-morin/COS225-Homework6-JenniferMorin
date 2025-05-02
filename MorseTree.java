/*MorseTree: 
 Contains an TreeNode representing the root of the Tree containing letters 
 Contains a default constructor to make a null Tree 
 Implement a method that will return a String containing the Pre-order of the Tree 
 Implement a method that will return a String containing the Post-order of the Tree 
 Implement a method that will translate an English string into its Morse code equivalent 
(ignoring case) 
 Implement a method  */
public class MorseTree {
    TreeNode<String> myRoot = new TreeNode<String>("_");

    MorseTree(){
        
    }
    MorseTree(String y){
        myRoot.setElement(y);
    }
   

    public void treePostOrder(){
        myRoot.postorder(myRoot);
    }

    public void treePreOrder(){
        myRoot.preorder(myRoot);
    }

    public void treeInOrder(){
        myRoot.inorder(myRoot);
    }

    public String translateMtoE(String Morse, MorseTree myTree){
        TreeNode<String> mover = myTree.myRoot;
        String output=" ";
        for (int i = 0; i<Morse.length(); i++){
            if (Morse.charAt(i)!='|'){
                if (Morse.charAt(i)=='o'){
                    mover=mover.getLeft();
                }
                else if (Morse.charAt(i)=='-'){
                    mover=mover.getRight();
                }
            }
            else{
                output+=mover.getElement();
                mover=myTree.myRoot;
            }
        }

        return output;
    }

    public String translateEtoM(String English, MorseTree myTree){
        TreeNode<String> mover = myTree.myRoot;
        String output=" ";
        for (int i = 0; i<English.length();i++){
            while (mover.getElement()!=String.valueOf(English.charAt(i)) && mover.getElement()!=null){
                if (mover.getLeft()!=null && mover.getLeft().isIn(String.valueOf(English.charAt(i)))){
                    mover=mover.getLeft();
                    output+="o";
                }
                else if (mover.getRight() != null && mover.getRight().isIn(String.valueOf(English.charAt(i)))){
                    mover=mover.getRight();
                    output+="-";
                }
                else {
                    mover = myTree.myRoot;
                    break;
                }
            }
            output+="|";
    }
        return output;
    }
}
