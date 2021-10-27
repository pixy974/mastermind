/*import java.util.Arrays;
import java.util.Random;

public class Mastermind {
    private String[] colors = {"R", "G", "Y", "B", "M", "C"};
    private String[] keyColor;
    private String answer;
    Mastermind() {
        //int ind;
        keyColor = new String[4];
        //générer la combinaison
        //je choisis une couleur au hasard 4 fois dans le tableau colors et je rentre dans keyColor
        for(int n = 0; n <= 3 ; n++)
        {
            //ind = (int) (Math.random()*6);
            //this.keyColor[0] = 1;
            // tant que le random renvoie une valeur déjà présente dans le tableau key color, je regénère un random

            String rand = this.getRandomIndex();
            int charaIndex = Arrays.asList(this.keyColor).indexOf(rand);
            while(charaIndex >= 0){

                rand = this.getRandomIndex();
                charaIndex = Arrays.asList(this.keyColor).indexOf(rand);
            }
            this.keyColor[n] = rand;
        }
        System.out.println(""+ Arrays.toString(this.keyColor));
    }

    public String getKeyColor()
    {
        return this.keyColor.toString();
    }

    // Permet de generer une clé aléatoire à partir du tableau colors
    public String getRandomIndex()
    {
        Random generator = new Random();
        int randomIndex = generator.nextInt(colors.length);
        return colors[randomIndex];
    }

    public String testCombination(String comb)
    {
        // Comparer la combinaison de l'ordinateur a celle du joueur char par char
        // S'il y a une corréspondance, on enleve du tableau du joueur
        String[] combChar = comb.split("");

        //va renvoyer O O - -
        this.answer = "";

        System.out.println(Arrays.toString(combChar));

        for(int i = 0; i<this.keyColor.length; i++)
        {
            int charaIndex = Arrays.asList(combChar).indexOf(this.keyColor[i]);
            if (charaIndex >= 0 && i == charaIndex) {
                //combChar = this.removeTheElement(combChar, charaIndex);
                this.answer += "O ";
            } else if (charaIndex >= 0) {
                this.answer += "X ";
            } else {
                this.answer += "- ";
            }
            System.out.println("position de "+(String)this.keyColor[i]+" dans "+Arrays.toString(combChar)+" = "+charaIndex);
        }
        return answer;
    }

    // Function to remove the element
    public String[] removeTheElement(String[] arr, int index)
    {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || index < 0
            || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        String[] anotherArray = new String[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }

    public boolean win() {
        if (this.answer == "O O O O " ){
            return true;
        } else {
            return false;
        }
    }
}*/

