package coms;

abstract class character {
    String name;
    int hp;
    int attackDamage;
    int specialDamage;
    int mana;

    public character(String name, int hp, int attackDamage, int specialDamage, int mana) {
        this.name = name;
        this.hp = hp;
        this.attackDamage = attackDamage;
        this.specialDamage = specialDamage;
        this.mana = mana;
    }

    public abstract void attack(character enemy);
    public abstract void SpecialSkill(character enemy);

    public boolean isAlive() {
        return hp > 0;
    }

    public String getStatus() {
        return name + " [HP: " + (hp > 0 ? hp : 0) + ", Mana: " + mana + "]";
    }
}
