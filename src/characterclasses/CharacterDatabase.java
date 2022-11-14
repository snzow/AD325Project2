package characterclasses;

import hasheddictionary.HashTable;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CharacterDatabase implements CharacterDatabaseInterface{
    ArrayList<Character> playerBase;
    HashTable hashedPlayerBase;


    public CharacterDatabase(){
        playerBase = new ArrayList<Character>();
        hashedPlayerBase = getHashTable();
    }
    @Override
    public void addCharacter(String name, int height, int weight, double moralAlign) {
        Character temp = new Character(name, height, weight, moralAlign);
        playerBase.add(temp);
        hashedPlayerBase.put(name,playerBase.size()-1);
    }

    @Override
    public void removeCharacter(String name) {
        int temp = (int)hashedPlayerBase.get(name);
        playerBase.set(temp,null);
        hashedPlayerBase.remove(name);
    }

    @Override
    public Character getCharacter(String name) {
        int temp = (int)hashedPlayerBase.get(name);
        return playerBase.get(temp);
    }

    @Override
    public HashTable getHashTable() {
        return new HashTable();
    }

    @Override
    public void printList() {
        System.out.println("Playerbase:");
        int x = 0;
        for(Character i : playerBase){
            if(i == null){
                System.out.println(x + " | null");
                x++;
            }
            else{
                System.out.println(x + " | " + i);
                x++;
            }

        }
    }

    public void printHashTable(){
       hashedPlayerBase.dump();
    }
}
