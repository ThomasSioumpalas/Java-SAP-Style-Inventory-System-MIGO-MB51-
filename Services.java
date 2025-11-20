import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Services {


    public static void saveToFile(String filename, String line) {
        try (FileWriter writer = new FileWriter("src/myfile.txt", true)) {
            writer.write(line);
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int readNextId() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/myfile.txt"));
            if (lines.isEmpty()) {
                return 1;
            }
            String last = lines.get(lines.size() - 1).trim();
            if (last.isEmpty()) {
                return 1;
            }
            String[] parts = last.split("\\s+");
            String onlyDigits = parts[0].replaceAll("\\D+", "");
            int lastId = Integer.parseInt(onlyDigits);
            return lastId + 1;
        } catch (Exception e) {
            return 1;
        }
    }


    public static void deleteLineById(int idToDelete) {
        try {
            Path path = Paths.get("src/myfile.txt");
            List<String> lines = Files.readAllLines(path);

            String idString = "Id:" + idToDelete;
            boolean removed = lines.removeIf(line -> line.startsWith(idString));

            if (!removed) {
                System.out.println("This line was already deleted.");
            }

            Files.write(path, lines);
        } catch (IOException e) {
            System.out.println("Error deleting line: " + e.getMessage());
        }
    }


    public static void searchByName(String description) {
        try {
            Path path = Paths.get("src/myfile.txt");
            List<String> lines = Files.readAllLines(path);

            String searchKey = description.replace("*", "").toLowerCase();
            boolean found = false;

            for (String line : lines) {
                if (line.toLowerCase().contains(searchKey)) {
                    System.out.println(line);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No entries found for: " + description);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static List<String> readInventoryLines() {
        try {
            Path path = Paths.get("src/myfile.txt");
            return Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void showInventoryWithPrices(List<String> lines) {
        double grandTotal = 0.0;
        System.out.println("Inventory with prices:");

        for (String line : lines) {
            if (line.isBlank()) continue;

            String material = extractMaterial(line);
            double amount = extractAmount(line);

            Prices priceEnum = Prices.fromMaterial(material);
            if (priceEnum == null) {
                System.out.println("No price found for material: " + material);
                continue;
            }

            double unitPrice = priceEnum.getPrice();
            double lineCost = unitPrice * amount;
            grandTotal += lineCost;

            System.out.println(
                    "Material: " + material +
                            " | Amount: " + amount +
                            " | Unit price: " + unitPrice +
                            " | Line cost: " + lineCost + "Euros"
            );
        }

        System.out.println("Total value of inventory: " + grandTotal);
    }

    protected static String extractMaterial(String line) {
        return line.split("\\|")[1].split(":")[1].trim();
    }

    private static double extractAmount(String line) {
        return Double.parseDouble(line.split("\\|")[2].split(":")[1].trim());
    }

}