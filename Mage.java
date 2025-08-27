package coms;

import javax.swing.JOptionPane;

class Mage extends character {
    public Mage(String name) {
        super(name, 80, 20, 40, 5); // lower hp, higher dmg, more mana
    }

    @Override
    public void attack(character enemy) {
        enemy.hp -= attackDamage;
        JOptionPane.showMessageDialog(null, name + " cast Galactic Void! -" + attackDamage + " HP");
    }

    @Override
    public void SpecialSkill(character enemy) {
        enemy.hp -= specialDamage;
        JOptionPane.showMessageDialog(null, name + " used Galactic Crusher! -" + specialDamage + " HP");
    }
}
