import java.util.ArrayList;
/**
 * Write a description of class Inventory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Inventory
{
    //each inventory has an arraylist which 
    //stores string descriptions of items or objects.
    private ArrayList<String> inventory;

    /**
     * Constructor for objects of class Inventory
     */
    public Inventory() {
        this.inventory = new ArrayList<String>();
    }

    // prints everything in the inventory
    public void printInventory() {
        if(inventory.size() == 0) {
            System.out.println("You have nothing in your inventory right now.");
        } else {
            for(int i = inventory.size(); i>0; i--) {
                System.out.println(inventory.get(i));
            }
        }
    }
    
    public void addItem(String item) {
        inventory.add(item);
    }
    public void removeItem(String item) {
        inventory.remove(item);
    }
    
    public void swapItem(String item1, String item2, int location, ArrayList<String> arrlist){
        ArrayList<String> temp = new ArrayList<String>();
        //add old item to temp array list
        temp.add(item1);
        //replace new item with old item.
        arrlist.set(location, item2);
        //add item1 to personal inventory.
        inventory.add(item1);
    }
}
