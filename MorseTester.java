//Jennifer Morin
//COS225 5/1/2024
//In order to use the scanner class I used https://www.w3schools.com/java/java_files_read.asp
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class MorseTester {
    public static void main(String[] args) {

        MorseTree myTree = new MorseTree();
        TreeNode<String> tempPlace = myTree.myRoot;
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
                tempPlace= myTree.myRoot;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.print("File did not open\n");
        }
        System.out.print("Post-Order: ");
        myTree.treePostOrder();
        System.out.println("");
        System.out.print("Pre-Order: ");
        myTree.treePreOrder();
        System.out.println("");
        System.out.println("English to Morse Code:"+myTree.translateEtoM("thequickfox",myTree));
        System.out.println("Morse Code to English:"+myTree.translateMtoE("-|oooo|o|--o-|oo-|oo|-o-o|-o-|oo-o|---|-oo-|", myTree));
    }
}
