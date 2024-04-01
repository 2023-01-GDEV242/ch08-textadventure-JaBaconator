/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Inventory playerInven = new Inventory();
    public HashMap<Room, Inventory> roomInventories;
    
    /**
     * 
     *
     *
     */
    public static void main(String[] args)
    {
        Game g = new Game();
        g.play();
        
    }
    
    
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office, parkinglot, library, classroom, highway, cafe, gym, lock_room, advising, arts, planetarium, moon, observatory, lab2, kitchen, limbo;
        
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        classroom = new Room("in a classroom");
        office = new Room("in the computing admin office");
        parkinglot = new Room("in the parking lot");
        library = new Room("in the library");
        
        //Newer rooms
        highway = new Room("outside on the highway");
        cafe = new Room("in a cafeteria");
        gym = new Room("in the campus gym");
        lock_room = new Room("locked in a locker room");
        advising = new Room("waiting in the torture chamber known as advising and counseling");
        arts = new Room("in the arts building");
        planetarium = new Room("in the planetarium");
        observatory = new Room("in the observatory");
        moon = new Room("ON THE MOON!?");
        lab2 = new Room("in the science lab");
        kitchen = new Room("in the kitchen");
        limbo = new Room("in Limbo. What does death feel like?");
        
        // create room inventories
        // and create player inventory - No longer here
        Inventory outsideInven = new Inventory();
        Inventory theaterInven = new Inventory();
        Inventory pubInven = new Inventory();
        Inventory labInven = new Inventory();
        Inventory officeInven = new Inventory();
        Inventory libraryInven = new Inventory();
        Inventory classroomInven = new Inventory();
        Inventory parkinglotInven = new Inventory();
        
        //New inventories
        Inventory highwayInven = new Inventory();
        Inventory cafeInven = new Inventory();
        Inventory gymInven = new Inventory();
        Inventory lock_roomInven = new Inventory();
        Inventory advisingInven = new Inventory();
        Inventory artsInven = new Inventory();
        Inventory planetariumInven = new Inventory();
        Inventory observatoryInven = new Inventory();
        Inventory moonInven = new Inventory();
        Inventory lab2Inven = new Inventory();
        Inventory kitchenInven = new Inventory();
        Inventory limboInven = new Inventory();
        
        //give items for rooms and player
        outsideInven.addItem("someone's_purse");
        parkinglotInven.addItem("quarter");
        parkinglotInven.addItem("quarter");
        parkinglotInven.addItem("quarter");
        pubInven.addItem("glass_mug");
        officeInven.addItem("yearbook");
        officeInven.addItem("lockbox_key");
        labInven.addItem("test_tube");
        labInven.addItem("test_tube");
        labInven.addItem("test_tube");
        labInven.addItem("alien_speciman");
        labInven.addItem("beaker");
        classroomInven.addItem("blue_calculator");
        classroomInven.addItem("pink_calculator");
        classroomInven.addItem("gray_calculator");
        classroomInven.addItem("someone's_homework");
        classroomInven.addItem("someone_else's_homework");
        classroomInven.addItem("dull_pencil");
        classroomInven.addItem("empty_pen");
        classroomInven.addItem("whiteboard_eraser");
        libraryInven.addItem("Merium-Webster_Dictionary-By_Merium_and_Webster");
        libraryInven.addItem("50_Shades_of_White:A_Rightous_Parody_of_50_Shades_of_Grey-By_Jacob_Rispoli");
        libraryInven.addItem("The_Lord_of_the_Rings:The_Complete_Story-By_J.R.R.Tolkien");
        libraryInven.addItem("Star_Wars:The_Clone_Wars,A_'brief'_2,000_page_summary_of_every_season-By_George_Lucas");
        libraryInven.addItem("Peace_and_War:Stories_of_WWII-Some_Historian_Somewhere");
        libraryInven.addItem("The_History_of_the_World:A_'brief'_13,500_page_summary,_starting_with_micro-organisms!-A_Crazier_Historian_Somewhere");
        libraryInven.addItem("An_introduction_to_Micro-Organisms-Some_Biologist_Somewhere");
        libraryInven.addItem("Guide_for_Dummies:Zombie_Survival_Guide-By_Artemis");
        libraryInven.addItem("A_Hitchhikers_Guide_to_the_Galaxy-By_A_Hitchhiker,_who_lives_in_a_galaxy_far_far_away");
        libraryInven.addItem("Eggs_for_Javaheads-By_Professor_Crosbie");
        libraryInven.addItem("Java_for_Eggheads-By_Professor_Crosbie");
        libraryInven.addItem("A_cookbook_for_Java_Eggheads-By_Professor_Crosbie");
        
        //give items to players.
        artsInven.addItem("paint_brush");
        artsInven.addItem("clay_wire");
        cafeInven.addItem("cafeteria_tray");
        cafeInven.addItem("stale_bread");
        cafeInven.addItem("old_smelly_lunchable"); 
        lab2Inven.addItem("syringe");
        lab2Inven.addItem("purple_stuff");
        lab2Inven.addItem("dead_body");
        pubInven.addItem("alcohol");
        pubInven.addItem("lighter");
        kitchenInven.addItem("rag");
        kitchenInven.addItem("knife");
        gymInven.addItem("baseball_bat");
        gymInven.addItem("shorts");
        gymInven.addItem("sports_bra");
        lock_roomInven.addItem("socks");
        lock_roomInven.addItem("socks");
        lock_roomInven.addItem("socks");
        lock_roomInven.addItem("socks");
        lock_roomInven.addItem("socks");
        lock_roomInven.addItem("socks");
        lock_roomInven.addItem("socks");
        lock_roomInven.addItem("socks");
        lock_roomInven.addItem("socks");
        lock_roomInven.addItem("socks");
        lock_roomInven.addItem("socks");
        lock_roomInven.addItem("socks");
        labInven.addItem("computer_chip");
        labInven.addItem("computer_chip");
        
        
        //Setting up room inventories
        outside.setInventory(outsideInven);
        theater.setInventory(theaterInven);
        pub.setInventory(pubInven);
        lab.setInventory(labInven);
        classroom.setInventory(classroomInven);
        office.setInventory(officeInven);
        parkinglot.setInventory(parkinglotInven);
        library.setInventory(libraryInven);
        
        
        //setting up the inventories 2.0!!
        highway.setInventory(highwayInven);
        cafe.setInventory(cafeInven);
        gym.setInventory(gymInven);
        lock_room.setInventory(lock_roomInven);
        advising.setInventory(advisingInven);
        arts.setInventory(artsInven);
        planetarium.setInventory(planetariumInven);
        observatory.setInventory(observatoryInven);
        moon.setInventory(moonInven);
        lab2.setInventory(lab2Inven);
        kitchen.setInventory(kitchenInven);
        limbo.setInventory(limboInven);
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", classroom);
        outside.setExit("west", pub);
        outside.setExit("north", parkinglot);

        theater.setExit("west", outside);
        theater.setExit("south", arts);
        theater.setExit("east", library);

        pub.setExit("east", outside);
        pub.setExit("west", library);
        pub.setExit("south", cafe);
        
        library.setExit("secret", outside);
        library.setExit("east", pub);
        library.setExit("north", planetarium);
        library.setExit("west", theater);
        library.setExit("vent", gym);
        
        classroom.setExit("north", outside);
        classroom.setExit("south", lab);
        classroom.setExit("west", cafe);
        classroom.setExit("east", arts);
        
        lab.setExit("north", classroom);
        lab.setExit("east", office);

        office.setExit("west", lab);
        office.setExit("secret", outside);
        office.setExit("east", advising);
        
        parkinglot.setExit("south", outside);
        parkinglot.setExit("north", highway);
        parkinglot.setExit("west", observatory);
        
        //setting up room exits part 2
        highway.setExit("south", parkinglot);
        highway.setExit("elevator?", moon);
        
        advising.setExit("west", office);
        advising.setExit("secret", moon);
        
        arts.setExit("north", theater);
        arts.setExit("west", classroom);
        
        cafe.setExit("north", pub);
        cafe.setExit("south", kitchen);
        cafe.setExit("east", classroom);
        cafe.setExit("west", gym);
        
        gym.setExit("west", lock_room);
        gym.setExit("south", lab2);
        gym.setExit("east", cafe);
        gym.setExit("vent", library);
        
        kitchen.setExit("west", lab2);
        kitchen.setExit("north", cafe);
        
        //science lab
        lab2.setExit("north", gym);
        lab2.setExit("east", kitchen);
        
        lock_room.setExit("locked", planetarium);
        
        planetarium.setExit("south", library);
        planetarium.setExit("east", observatory);
        
        observatory.setExit("west", planetarium);
        observatory.setExit("east", parkinglot);
        observatory.setExit("secret", outside);
        
        moon.setExit("secret", limbo);
        
        limbo.setExit("secret", limbo);
        
        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println("This game is rated M for Mature AND rated R, it's that gruesome.");
        System.out.println("No REAL people were hurt in the making or playing of this game. Fake people. That's up to you.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
                
            case TAKE:
                takeItem(command);
                break;
                
            case EXAMINE:
                viewInventory(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    private void takeItem(Command command) {
        if( !( command.hasSecondWord() ) ) {
            System.out.println("Take what?");
            return;
        }
        String item = command.getSecondWord();
        Inventory currentInventory = currentRoom.getInventory();
        if(currentInventory.findItem(item) == true) {
            System.out.println("You've picked up " + item);
            currentInventory.removeItem(item);
            playerInven.addItem(item);
        } else {
            System.out.println("I didn't find that item");
        }
    }
    private void viewInventory(Command command) {
        if(!( command.hasSecondWord() ) ) {
            System.out.println("View your inventory or examine the room?");
            return;
        }
        String examine = command.getSecondWord().toLowerCase();
        Inventory currentInventory = currentRoom.getInventory();
        if(examine.equals("player")){
            System.out.println("Here's your inventory:");
            playerInven.printInventory(true);
        } else if(examine.equals("room")){
            System.out.println("Here's whats in the room:");
            currentInventory.printInventory(false);
        } else {
            System.out.println("I didn't get that. Your options are player, or room.");
        }
    }
}
