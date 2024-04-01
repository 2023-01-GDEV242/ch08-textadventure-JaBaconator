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
    private ArrayList<Items> inventory;

    /**
     * Constructor for objects of class Inventory
     */
    public Inventory() {
        this.inventory = new ArrayList<Items>();
    }

    // prints everything in the inventory
    public void printInventory(boolean player) {
        if( (inventory.size() == 0) && (player == true) ) {
            System.out.println("You don't have anything in your inventory right now.");
        } else if ( (inventory.size() == 0) && (player == false) ) {
            System.out.println("You see nothing to grab.");
        } else {
            for(int i = inventory.size(); i>0; i--) {
                System.out.println(inventory.get(i-1));
            }
        }
    }
    
    public void addItem(Items item) {
        inventory.add(item);
    }
    public void removeItem(Items item) {
        inventory.remove(item);
    }
    public boolean findItem(Items item){ 
        return inventory.contains(item);
    }
    public void swapItem(Items item1, Items item2, int location, ArrayList<Items> arrlist){
        ArrayList<Items> temp = new ArrayList<Items>();
        //add old item to temp array list
        temp.add(item1);
        //replace new item with old item.
        arrlist.set(location, item2);
        //add item1 to personal inventory.
        inventory.add(item1);
    }
}
