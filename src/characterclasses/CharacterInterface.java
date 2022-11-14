package characterclasses;

public interface CharacterInterface {


    /**
     * modifies the character's hp, positive values are healing, negative are damage
     * @param val the amount to modify the hp by
     */
    public void modHealth(double val);

    /**
     * modifies the character alignment by the percentage provided.
     * @param val the percentage to change alignment by
     */
    public void modAlignment(double val);

    /**
     * prints the characters stat values
     * @return a string that describes the current values of a characters data fields
     */
    public String toString();

}
