package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.ArtifactVisitor;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;


public class GoldAppraiser implements ArtifactVisitor {
    private int totalValue;

    @Override
    public void visit(Weapon weapon) {
        int price = weapon.getValue() + weapon.getAttackBonus() * 20;
        totalValue += price;
        System.out.println("[GoldAppraiser] Weapon " + weapon.getName()
                + " appraised at " + price + " gold.");
    }

    @Override
    public void visit(Potion potion) {
        int price = potion.getValue() + potion.getHealing() * 5;
        totalValue += price;
        System.out.println("[GoldAppraiser] Potion " + potion.getName()
                + " appraised at " + price + " gold.");
    }

    @Override
    public void visit(Scroll scroll) {
        int price = scroll.getValue() + scroll.getSpellName().length() * 8;
        totalValue += price;
        System.out.println("[GoldAppraiser] Scroll " + scroll.getName()
                + " appraised at " + price + " gold.");
    }

    @Override
    public void visit(Ring ring) {
        int price = ring.getValue() + ring.getMagicBonus() * 50;
        totalValue += price;
        System.out.println("[GoldAppraiser] Ring " + ring.getName()
                + " appraised at " + price + " gold.");
    }

    @Override
    public void visit(Armor armor) {
        int price = armor.getValue() + armor.getDefenseBonus() * 25;
        totalValue += price;
        System.out.println("[GoldAppraiser] Armor " + armor.getName()
                + " appraised at " + price + " gold.");
    }

    public int getTotalValue() {
        return totalValue;
    }
}