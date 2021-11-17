import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static String enterMessage(){
        return scanner.nextLine();
    }

    private static Boolean checkIfContains(String message, String word){
        return message.toLowerCase(Locale.ROOT).contains(word);
    }

    private static String respondToMessage(String message){
        if (checkIfContains(message,"bonjour")){
            return "Bonjour, comment ça va ?";
        }
        if (checkIfContains(message,"aurevoir") || checkIfContains(message,"au revoir")){
            System.out.println("Au revoir");
            System.exit(0);
        }
        if (checkIfContains(message,"et toi") || checkIfContains(message,"et vous")){
            return "Bien, merci !";
        }
        return "Désolé, je n'ai pas compris.";
    }

    public static void main(String[] args){
        while (true){
            System.out.println("Veuillez entrer votre message :");
            System.out.println(respondToMessage(enterMessage()));
        }
    }
}
