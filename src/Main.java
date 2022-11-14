import characterclasses.CharacterDatabase;
import characterclasses.CharacterDatabaseInterface;

public class Main {
    public static void main(String[] args) {

        CharacterDatabaseInterface db = new CharacterDatabase();
        db.addCharacter("FB",30,50,1.0);
        db.addCharacter("Ea", 50,150,0.6);
        db.addCharacter("Daegon", 50,150,0.6);
        db.addCharacter("Gandalf", 200,35,1.0);
        db.printHashTable();
        db.removeCharacter("Daegon");
        db.printHashTable();
        db.printList();
        System.out.println(db.getCharacter("Gandalf"));
        db.getCharacter("Gandalf").modAlignment(-.4);
        db.getCharacter("Gandalf").modHealth(-15);
        db.getCharacter("Gandalf").modHealth(30);
        System.out.println(db.getCharacter("Gandalf"));
    }
}