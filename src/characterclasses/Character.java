package characterclasses;

public class Character implements CharacterInterface{

    double health;
    double alignment;



    @Override
    public void modHealth(double val) {
        health += val;
    }

    @Override
    public void modAlignment(double val) {
        alignment += val;
    }
}
