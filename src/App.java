import Utils.ConsoleColor;
import java.util.Scanner;

public class App
{
    // Cette méthode est appelée automatiquement au lancement de l'application
    public static void main(String[] args) throws Exception {
        // Efface la console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Mastermind mast = new Mastermind();
        Scanner scanner = new Scanner(System.in);

        //tant que on a pas gagner, on demande une combinaison au joueur
        while (!mast.win()) {
            System.out.println("Entrez une combinaison de couleur :");
            String userResponse = scanner.nextLine();
            //tant que le format n'est pas bon on demande la combinaison au joueur
            while (!userResponse.matches(mast.getMatcheRegex())) {
                System.out.println(ConsoleColor.RED+"Les valeurs saisies ne sont pas valides, veuillez recommencer: "+ConsoleColor.RESET);
                userResponse = scanner.nextLine();
            }
            System.out.println("résultat: "+mast.testCombination(userResponse));
        }
        scanner.close();
    }
}
