package characterclasses;

import hasheddictionary.HashTable;

public interface CharacterDatabaseInterface {

    /**
     * adds a character to the database
     * @param name the characters name
     * @param height the characters height
     * @param weight the characters weight
     * @param moralAlign the characters moral alignment
     */
    public void addCharacter(String name, int height, int weight, double moralAlign);

    /**
     * removes a character from the database
     * @param name the characters name
     */
    public void removeCharacter(String name);

    /**
     * returns a character from the database
     * @param name the name of the character
     * @return the character object associated with the name
     */
    public Character getCharacter(String name);

    /**
     * creates a hashtable for the database
     * @return a new hashtable
     */
    public HashTable getHashTable();

    /**
     * prints the list of players
     */
    public void printList();

    /**
     * prints the hashtable of players
     */
    void printHashTable();
}
