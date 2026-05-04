package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.ArtifactVisitor;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;

public class CurseDetector implements ArtifactVisitor {
    private int cursedCount;

    @Override
    public void visit(Weapon weapon) {
        boolean cursed = weapon.getAttackBonus() >= 10;
        report(weapon.getName(), cursed, "violent echo around the blade");
    }

    @Override
    public void visit(Potion potion) {
        boolean cursed = potion.getHealing() < 20;
        report(potion.getName(), cursed, "unstable alchemical residue");
    }

    @Override
    public void visit(Scroll scroll) {
        String spell = scroll.getSpellName().toLowerCase();
        boolean cursed = spell.contains("shadow") || spell.contains("doom");
        report(scroll.getName(), cursed, "forbidden spell signature");
    }

    @Override
    public void visit(Ring ring) {
        boolean cursed = ring.getMagicBonus() >= 5;
        report(ring.getName(), cursed, "overcharged ring enchantment");
    }

    @Override
    public void visit(Armor armor) {
        boolean cursed = armor.getDefenseBonus() >= 8;
        report(armor.getName(), cursed, "ancient defensive curse");
    }

    private void report(String artifactName, boolean cursed, String reason) {
        if (cursed) {
            cursedCount++;
            System.out.println("[CurseDetector] WARNING: " + artifactName
                    + " may be cursed: " + reason + ".");
        } else {
            System.out.println("[CurseDetector] " + artifactName + " looks stable.");
        }
    }

    public int getCursedCount() {
        return cursedCount;
    }
}