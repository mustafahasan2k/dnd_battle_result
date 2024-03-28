// Database for the dnd Enemys V1.0
import java.io.*;
import java.util.*;

public class enemyDatabase {
    private HashMap<String, enemy> enemyMap;
    // Constructor
    public enemyDatabase() {
        enemyMap = new HashMap<>();
        loadDbFile();
    }
    // Setter
    public void addEnemy(String key, enemy enemy) {
        enemyMap.put(key, enemy);
    }
    // Getter
    public enemy getEnemy(String key) {
        return enemyMap.get(key);
    }
    // Delete
    public void deleteEnemy(String key) {
        enemyMap.remove(key);
    }

    // Display 
    public void displayAllEnemies() {
        for (String key : enemyMap.keySet()) {
            enemy e = enemyMap.get(key);
            pLn("Name: " + e.getName() + ", AC: " + e.getAc() + ", HP: " + e.getHp() +
                    ", Proficiency: " + e.getProf() + ", Initative: " + e.getInit() + ", Attack Bonus: " + e.getAttBonus() +
                    ", Weapon Damage: " + e.getWeapDamage() + ", Weapon Bonus Damage: " + e.getWeapDamageBonus());
        }
    }

    // Load the previous entries
    private void loadDbFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("enemiesDatabase.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String name = parts[0].substring(6).trim(); // Remove "Name:" 
                int ac = Integer.parseInt(parts[1].substring(4).trim()); // Remove "AC:" 
                int hp = Integer.parseInt(parts[2].substring(4).trim()); // Remove "HP:" 
                int prof = Integer.parseInt(parts[3].substring(13).trim());// Remove "Proficiency:" 
                int init = Integer.parseInt(parts[4].substring(11).trim()); // Remove "Initative:" 
                int attBonus = Integer.parseInt(parts[5].substring(13).trim()); // Remove "Attack Bonus:" 
                int weapDamage = Integer.parseInt(parts[6].substring(14).trim()); // Remove "Weapon Damage:" 
                int weapDamageBonus = Integer.parseInt(parts[7].substring(20).trim()); // Remove "Weapon Bonus Damage:" 
                enemy loadedEnemy = new enemy(name, ac, hp, prof, init, attBonus, weapDamage, weapDamageBonus);
                enemyMap.put(name, loadedEnemy);
            }
            reader.close();
        } catch (IOException e) {
            pLn("IO Exception");
        }
    }

    // Save the entries at the end of inputs
    private void saveEnemiesToFile() {
        try {
            PrintWriter writer = new PrintWriter("enemiesDatabase.txt");
            for (String key : enemyMap.keySet()) {
                enemy e = enemyMap.get(key);
                writer.println("Name: " + e.getName() + ", AC: " + e.getAc() + ", HP: " + e.getHp() +
                        ", Proficiency: " + e.getProf() + ", Initative: " + e.getInit() + ", Attack Bonus: " + e.getAttBonus() +
                        ", Weapon Damage: " + e.getWeapDamage() + ", Weapon Bonus Damage: " + e.getWeapDamageBonus());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Methods to simplify printing
    public static <Type> void p(Type text) {
        System.out.print(text); 
    }
    public static <Type> void pLn(Type text) {
        System.out.println(text);    
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        enemyDatabase database = new enemyDatabase();
        // User adds enemies
        while (true) {
            pLn("\nMenu:");
            pLn("1. Show all enemies");
            pLn("2. Add a new enemy");
            pLn("3. Delete an enemy");
            pLn("Enter your choice (1/2/3): ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    pLn("\nAll enemies in the database:");
                    database.displayAllEnemies();
                    break;
                case 2:
                    pLn("\nEnter enemy details:");
                    p("Name: ");
                    String name = sc.nextLine();
                    p("AC: ");
                    int ac = sc.nextInt();
                    p("HP: ");
                    int hp = sc.nextInt();
                    p("Proficiency: ");
                    int prof = sc.nextInt();
                    p("Initative: ");
                    int init = sc.nextInt();
                    p("Attack Bonus ");
                    int attBonus = sc.nextInt();
                    p("Weapon Damage (Dice Num): ");
                    int weapDamage = sc.nextInt();
                    p("Weapon Bonus Damage: ");
                    int weapDamageBonus = sc.nextInt();
                    sc.nextLine();
                    enemy newEnemy = new enemy(name, ac, hp, prof, init, attBonus, weapDamage, weapDamageBonus);
                    database.addEnemy(name, newEnemy);
                    database.saveEnemiesToFile();
                    break;
                case 3:
                    pLn("");
                    database.displayAllEnemies();
                    p("\nEnter the name of the enemy to delete: ");
                    String deleteName = sc.nextLine();
                    database.deleteEnemy(deleteName);
                    pLn("Enemy '" + deleteName + "' deleted.");
                    database.saveEnemiesToFile();
                    break;
                default:
                    pLn("Invalid Input. Enter: 1, 2, or 3.");
            }

            p("\nDo you want to continue? (y/n): ");
            String continueChoice = sc.nextLine().toLowerCase();
            if (!continueChoice.equals("y")) {
                break;
            }
        }
    }
}
