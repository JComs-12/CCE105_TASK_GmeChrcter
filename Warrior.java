package coms;

import javax.swing.JOptionPane;

class Warrior extends character {
    public Warrior(String name) {
        super(name, 100, 15, 30, 3); // hp, normal dmg, special dmg, mana
    }

    @Override
    public void attack(character enemy) {
        enemy.hp -= attackDamage;
        JOptionPane.showMessageDialog(null, name + " used Sword Smash! -" + attackDamage + " HP");
    }

    @Override
    public void SpecialSkill(character enemy) {
        enemy.hp -= specialDamage;
        JOptionPane.showMessageDialog(null, name + " used Celestial Destroyer Sword! -" + specialDamage + " HP");
    }
}
