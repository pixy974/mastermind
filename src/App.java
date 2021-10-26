import Utils.ConsoleColor;
import java.util.Scanner;
import java.util.regex.*;

public class App
{
    // Cette méthode est appelée automatiquement au lancement de l'application
    public static void main(String[] args) throws Exception {
        // Efface la console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        //System.out.print(ConsoleColor.BLACK);
        //System.out.print("Hello, world!"+ ConsoleColor.BLACK);
        //System.out.print(ConsoleColor.RESET);
        Mastermind mast = new Mastermind();
        Scanner scanner = new Scanner(System.in);
        //System.out.println(mast.getKeyColor());

        while (!mast.win()) {
            System.out.println("Entrez une combinaison de couleur :");
            String choice = scanner.nextLine();
            System.out.println("Vous avez tapé: "+choice);
            String userResponse = choice;
            while (!userResponse.matches("^[RGYBMC]{4}$")) {
                System.out.println("Les valeurs saisies ne sont pas valides, veuillez recommencer: ");
                userResponse = scanner.nextLine();
            }
            System.out.println("résultat: "+mast.testCombination(choice));

        }

        scanner.close();


    }
}
