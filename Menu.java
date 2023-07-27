import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItems;

    public Menu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Sabun", 5000));
        menuItems.add(new MenuItem("Sampo", 10000));
        menuItems.add(new MenuItem("Kipas", 50000));
        menuItems.add(new MenuItem("Ayam", 20000));
        menuItems.add(new MenuItem("Sapi", 100000));
    }

    public void displayMenu() {
        int index = 1;
        for (MenuItem item : menuItems) {
            System.out.print(index + ". " + item.getName() + " - Rp. " + item.getPrice());
            System.out.println();
            index++;
        }
    }

    public MenuItem getMenuItem(int choice) {
        if (choice >= 1 && choice <= menuItems.size()) {
            return menuItems.get(choice - 1);
        }
        return null;
    }
}
