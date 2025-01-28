// Class representing an Item in the inventory
class Item {
    String itemName;
    int itemID;
    int quantity;
    double price;
    Item next;

    Item(String itemName, int itemID, int quantity, double price) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

// Class to manage inventory operations
class Inventory {
    private Item head;

    // Add an item at the beginning
    public void addAtBeginning(String itemName, int itemID, int quantity, double price) {
        Item newItem = new Item(itemName, itemID, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addAtEnd(String itemName, int itemID, int quantity, double price) {
        Item newItem = new Item(itemName, itemID, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Add an item at a specific position
    public void addAtPosition(String itemName, int itemID, int quantity, double price, int position) {
        Item newItem = new Item(itemName, itemID, quantity, price);
        if (position == 0) {
            addAtBeginning(itemName, itemID, quantity, price);
            return;
        }
        Item temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Remove an item based on Item ID
    public void removeByItemID(int itemID) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemID == itemID) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemID != itemID) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item with ID " + itemID + " not found.");
            return;
        }
        temp.next = temp.next.next;
    }

    // Update the quantity of an item by Item ID
    public void updateQuantity(int itemID, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemID == itemID) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemID + " not found.");
    }

    // Search for an item based on Item ID or Item Name
    public void searchItem(String itemName, int itemID) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemID == itemID || temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: Name=" + temp.itemName + ", ID=" + temp.itemID + ", Quantity=" + temp.quantity + ", Price=" + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Calculate and display the total value of inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    // Sort the inventory based on Item Name or Price in ascending order
    public void sortInventory(boolean sortByPrice) {
        if (head == null || head.next == null) {
            return;
        }
        head = mergeSort(head, sortByPrice);
    }

    private Item mergeSort(Item head, boolean sortByPrice) {
        if (head == null || head.next == null) {
            return head;
        }
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSort(head, sortByPrice);
        Item right = mergeSort(nextOfMiddle, sortByPrice);
        return sortedMerge(left, right, sortByPrice);
    }

    private Item sortedMerge(Item a, Item b, boolean sortByPrice) {
        if (a == null) return b;
        if (b == null) return a;

        Item result;
        if ((sortByPrice && a.price <= b.price) || (!sortByPrice && a.itemName.compareToIgnoreCase(b.itemName) <= 0)) {
            result = a;
            result.next = sortedMerge(a.next, b, sortByPrice);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, sortByPrice);
        }
        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display the inventory
    public void displayInventory() {
        Item temp = head;
        System.out.println("Inventory:");
        while (temp != null) {
            System.out.println("Name=" + temp.itemName + ", ID=" + temp.itemID + ", Quantity=" + temp.quantity + ", Price=" + temp.price);
            temp = temp.next;
        }
    }
}

// Main class to test inventory operations
public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addAtBeginning("Item1", 101, 5, 50.0);
        inventory.addAtEnd("Item2", 102, 10, 30.0);
        inventory.addAtPosition("Item3", 103, 8, 20.0, 1);
        inventory.displayInventory();

        inventory.removeByItemID(102);
        inventory.displayInventory();

        inventory.updateQuantity(103, 15);
        inventory.displayInventory();

        inventory.searchItem("Item1", -1);

        inventory.calculateTotalValue();

        inventory.sortInventory(false); // Sort by Item Name
        inventory.displayInventory();

        inventory.sortInventory(true); // Sort by Price
        inventory.displayInventory();
    }
}