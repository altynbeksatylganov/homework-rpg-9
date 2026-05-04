package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.ArtifactVisitor;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;

public class EnchantmentScanner implements ArtifactVisitor {
    private int magicalFindings;

    @Override
    public void visit(Weapon weapon) {
        magicalFindings++;
        System.out.println("[EnchantmentScanner] " + weapon.getName()
                + " carries a battle aura. Attack bonus: +" + weapon.getAttackBonus());
    }

    @Override
    public void visit(Potion potion) {
        magicalFindings++;
        System.out.println("[EnchantmentScanner] " + potion.getName()
                + " contains restorative energy. Healing: +" + potion.getHealing());
    }

    @Override
    public void visit(Scroll scroll) {
        magicalFindings++;
        System.out.println("[EnchantmentScanner] " + scroll.getName()
                + " stores spell sequence: " + scroll.getSpellName());
    }

    @Override
    public void visit(Ring ring) {
        magicalFindings++;
        System.out.println("[EnchantmentScanner] " + ring.getName()
                + " bends arcane currents. Magic bonus: +" + ring.getMagicBonus());
    }

    @Override
    public void visit(Armor armor) {
        magicalFindings++;
        System.out.println("[EnchantmentScanner] " + armor.getName()
                + " has protective runes. Defense bonus: +" + armor.getDefenseBonus());
    }

    public int getMagicalFindings() {
        return magicalFindings;
    }
}