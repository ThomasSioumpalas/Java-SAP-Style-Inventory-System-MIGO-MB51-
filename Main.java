import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
          System.out.println("What transaction do you want to use: 1)Migo(Add material) 2)MB51(Show all entries) 3)MB51(Search materials)");
        int userInput = scanner.nextInt();

        if (userInput == 1 ) {
            System.out.println("Tell me the name of the material");
            String userMaterial = scanner.next();
            System.out.println("Tell me the ammount of the material in the invetory");
            double userAmmount = scanner.nextDouble();
            System.out.println("Tell me the date of the material's delivery note");
            int userDate = scanner.nextInt();
                       int nextId = Services.readNextId();
            Migo migo = new Migo(nextId, userMaterial, userAmmount, userDate);
            Services.saveToFile("src/myfile.txt", migo.toLine());
            System.out.println("Saved: " + migo.toLine());

        } else if (userInput == 2) {
            MB51.showAllEntries();
            System.out.println("You want to : 1) Sort by Material  2) Delete an entry  3) Sum up all the costs of your inventory ");
            int action = scanner.nextInt();


            if (action == 1) {
                System.out.println("ASC or DESC");
                String userOrder = scanner.next().toUpperCase();

                List<String> lines = Services.readInventoryLines();

                if (userOrder.equals("ASC")) {
                    lines.sort((a, b) -> Services.extractMaterial(a).compareToIgnoreCase(Services.extractMaterial(b)));
                } else if (userOrder.equals("DESC")) {
                    lines.sort((a, b) -> Services.extractMaterial(b).compareToIgnoreCase(Services.extractMaterial(a)));
                }

                Services.showInventoryWithPrices(lines);

            } else if (action == 2) {
                System.out.println("DELETE entry");
                System.out.println("Provide me with the entry's ID to delete");
                int userDeleteLine = scanner.nextInt();
                Services.deleteLineById(userDeleteLine);
                System.out.println("This line is deleted permanently");

            } else if (action == 3) {
                // no sorting, just read and show
                List<String> lines = Services.readInventoryLines();
                Services.showInventoryWithPrices(lines);
            }

            } else{
            System.out.println("Write the name of the material you are looking for");
            String materialName = scanner.next();
            Services.searchByName(materialName);
        }
    }
}
