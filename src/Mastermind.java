import Utils.ConsoleColor;
import java.util.Arrays;
import java.util.Random;


public class Mastermind {
    private String[] colors = {"R", "G", "Y", "B", "M", "C"};
    private String[] keyColor;
    private int nbCharComb = 4;
    private String answer = "";

    Mastermind() {
        //générer la combinaison
        this.getRandomComb();
        System.out.println("combinaison de l'ordi:"+Arrays.toString(this.keyColor)+" Couleurs possibles:"+Arrays.toString(colors));
    }

    private void getRandomComb()
    {
        this.keyColor = new String[this.nbCharComb];
        //je choisis une couleur au hasard 4 fois dans le tableau colors et je rentre dans keyColor
        for(int n = 0; n < this.nbCharComb ; n++)
        {
            this.keyColor[n] = this.getRandomIndex();
        }
    }

    // Permet de generer une clé aléatoire à partir du tableau colors
    public String getRandomIndex()
    {
        Random generator = new Random();
        return colors[generator.nextInt(colors.length)];
    }

    public String testCombination(String comb)
    {
        String[] combChar = comb.split("");
        String combCharTamponPourEviterLesDoublonsSaGrandMere = comb;

        //va renvoyer O O - -
        this.answer = "";

        //COMPTE LES BONNES ET MAUVAISES REPONSES
        int answerO = 0;
        int answerT = 0;

        for(int i = 0; i<this.keyColor.length; i++)
        {
            var indexSearch = combCharTamponPourEviterLesDoublonsSaGrandMere.indexOf(this.keyColor[i]);
            //BONNE REPONSE
            if (this.keyColor[i].equals(combChar[i])) {
                answerO += 1;
            //MAUVAISE REPONSE/ RECHERCHE AUSSI DANS VARIABLE TAMPON POUR EVITER LES DOUBLONS
            } else if (indexSearch < 0 && combCharTamponPourEviterLesDoublonsSaGrandMere.indexOf(this.keyColor[i]) < 0) {
                answerT += 1;
            //SI MAL PLACE JE SUPPRIME DE MA VARIABLE TAMPON POUR EVITER LE PROBLEME DE DOUBLON
            } else {
                combCharTamponPourEviterLesDoublonsSaGrandMere = combCharTamponPourEviterLesDoublonsSaGrandMere.replaceFirst(this.keyColor[i], "");
            }

        }
        this.answer = this.getAnswerString(answerO, answerT) ;
        return this.getAnswer();
    }

    //dit quand le jeu s'arrête
    public boolean win() {
        if (this.getAnswer().equals("O O O O ")){
            System.out.println(ConsoleColor.GREEN_BRIGHT+"Vous avez trouvé bravo!"+ConsoleColor.RESET);
            return true;
        } else {
            return false;
        }
    }

    // renvoie la réponse de l'ordinateur "O O O O " ou " O X X -"
    private String getAnswerString(int nbO, int nbT)
    {
        String response = "";
        int nbX = this.nbCharComb - nbO - nbT;
        response = this.getNbChar("O", nbO);
        response += this.getNbChar("X", nbX);
        response += this.getNbChar("-", nbT);

        return response;
    }

    //renvoie une chaine de caractere contenant c , nb fois
    private String getNbChar(String c, int nb)
    {
        String pile = "";
        for (int i = 0; i < nb ; i++) {
            pile += c+" ";
        }
        return pile;
    }

    //retourne la liste des caractères acceptés en fonction de la propriété colors et du nombre de char souhaité
    public String getMatcheRegex()
    {
        String colors = "";
        for (int i = 0; i < this.colors.length; i++) {colors += this.colors[i];}
        return "^["+colors+"]{"+this.getNbCharComb()+"}$";
    }

    public String getKeyColor()
    {
        return Arrays.toString(this.keyColor);
    }

    private String getAnswer() {
        return answer;
    }

    public int getNbCharComb() {
        return this.nbCharComb;
    }
}