// Create a Human class with strength, stealth, and intelligence attributes with a default value of 3 and a health attribute with a default of 100

// Add the attack(Human) method that reduces the health of the attacked human by the strength of the current human.

package com.objectmaster;

public class Human {
    protected String c = this.getClass().getSimpleName();
    protected int strength;
    protected int stealth;
    protected int intelligence;
    protected int health;
    protected String playerName;
    protected static int nSamurais = 0;

    public Human(String name) {
        this.strength = 3;
        this.stealth = 3;
        this.intelligence = 3;
        this.health = 100;
        this.playerName = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void attack(Human human) {
        if (human == this) {
            System.out.println(String.format(
                    "%s, you cannot attack your own self. Seek therapy and then go attack other players in the game.",
                    this.playerName));
        } else {
            human.health -= this.strength;
            System.out.println(String.format("%s lost %d health after an attack by %s.", human.playerName,
                    this.strength, this.playerName));

        }
    }

    public static int getNumSamurais() {
        return nSamurais;
    }

    public static void addSamurai() {
        nSamurais++;
    }

    public static void removeSamurai() {
        nSamurais--;
    }

    protected int getMaxHealth(Human human) {
        int healthAllowed = 0;
        int defaultHealth = 100;
        switch (human.c) {
        // case "Human":
        // defaultHealth = 100;
        // healthAllowed = defaultHealth - human.health;
        // break;
        case "Wizard":
            defaultHealth = 50;
            healthAllowed = defaultHealth - human.health;
            break;
        // case "Ninja":
        // defaultHealth = 50;
        // healthAllowed = defaultHealth - human.health;
        // break;
        case "Samurai":
            defaultHealth = 200;
            healthAllowed = defaultHealth - human.health;
            break;
        default:
            defaultHealth = 100;
            healthAllowed = defaultHealth - human.health;
            break;
        }
        return healthAllowed;
    }
}