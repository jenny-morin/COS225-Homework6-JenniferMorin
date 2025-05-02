/*MorseTester: 
 Contains a main function that will: 
 Instantiate a MorseTree 
 Fill the MorseTree in a manner of your choosing such that it contains the Morse 
Code (as defined above) 
 Produce the preorder of this Tree 
 Produce the postorder of this Tree 
 Define a string of English text, and translate it to Morse code using MorseTree 
 Using the same string as above, translate it back into English text  */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class MorseTester {
    public static void main(String[] args) {

        MorseTree jennys = new MorseTree();
        TreeNode<String> tempPlace = jennys.myRoot;
        TreeNode<String> temp = new TreeNode<String>(" ");
        try {
            File myFile = new File("MorseLetters.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();

                for (int i =1; i<data.length();i++){
                    if ((data.charAt(i)) =='o'){
                        if (tempPlace.getLeft() != null){
                            tempPlace=tempPlace.getLeft();
                        }
                        else{
                            tempPlace.setLeft(temp);
                            tempPlace=tempPlace.getLeft();
                        }
                    }
                    else if ((data.charAt(i)) =='-'){
                        if (tempPlace.getRight() != null){
                            tempPlace=tempPlace.getRight();
                        }
                        else{
                            tempPlace.setRight(temp);
                            tempPlace=tempPlace.getRight();
                        }
                    }
                
                }
                temp = new TreeNode<String>(" ");
                tempPlace.setElement((String.valueOf(data.charAt(0))));
                tempPlace= jennys.myRoot;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.print("sad");
        }
        System.out.print("Post-Order: ");
        jennys.treePostOrder();
        System.out.println("");
        System.out.print("Pre-Order: ");
        jennys.treePreOrder();
        System.out.println("");
        System.out.println("Morse to English: "+jennys.translateMtoE("-|oooo|o|--o-|oo-|oo|-o-o|-o-|oo-o|---|-oo-|", jennys));
        System.out.println("English to Morse: "+jennys.translateEtoM("thequickfox",jennys));
        
    }
}
