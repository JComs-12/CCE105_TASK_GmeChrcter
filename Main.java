package coms;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String nameF = JOptionPane.showInputDialog(null, "Enter Warrior name: ");
        String nameM = JOptionPane.showInputDialog(null, "Enter Mage name: ");

        if (nameF == null || nameM == null) return; // exit if canceled

        character fighter = new Warrior(nameF);
        character mage = new Mage(nameM);

        // battle loop
        while (fighter.isAlive() && mage.isAlive()) {
            if (!takeTurn(fighter, mage)) break; // return false if canceled
            if (!mage.isAlive()) break;
            if (!takeTurn(mage, fighter)) break;
            JOptionPane.showMessageDialog(null,
                    fighter.getStatus() + "\n" + mage.getStatus());
        }

        if (fighter.isAlive() && mage.isAlive()) {
            JOptionPane.showMessageDialog(null, "Battle ended by player.");
        } else {
            String winner = fighter.isAlive() ? fighter.name : mage.name;
            JOptionPane.showMessageDialog(null, "Winner: " + winner + "!");
        }
    }

    // handles one character's turn
    private static boolean takeTurn(character attacker, character defender) {
        String choice = JOptionPane.showInputDialog(null,
                attacker.name + "'s Turn\n" +
                "1. Attack (" + attacker.attackDamage + " dmg)\n" +
                "2. Special Skill (" + attacker.specialDamage + " dmg, Mana: " + attacker.mana + ")\n" +
                "Choose action: ");

        if (choice == null) return false; // cancel → end game

        switch (choice) {
            case "1": attacker.attack(defender); break;
            case "2":
                if (attacker.mana > 0) {
                    attacker.SpecialSkill(defender);
                    attacker.mana--;
                } else {
                    JOptionPane.showMessageDialog(null, attacker.name + " has no Mana left! Turn skipped.");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice! " + attacker.name + " missed the turn.");
        }
        return true;
    }
}
