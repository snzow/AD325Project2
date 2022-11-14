package characterclasses;

public class Character implements CharacterInterface{

    double health;
    double alignment;

    String name;


    public Character(String n, int h, int w, double a){
        name = n;
        health = h*w;
        alignment = a;
    }
    @Override
    public void modHealth(double val) {
        health += val;
    }

    @Override
    public void modAlignment(double val) {
        alignment += val;
    }

    public double getHealth(){
        return health;
    }

    public double getAlignment(){
        return alignment;
    }

    public String toString(){
        return ("Name: " + name + " | Health: " + health + " | Alignment: " + alignment);
    }
}
