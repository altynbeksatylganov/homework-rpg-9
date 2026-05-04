package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.ArtifactVisitor;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;

public class WeightCalculator implements ArtifactVisitor {
    private int totalWeight;

    @Override
    public void visit(Weapon weapon) {
        totalWeight += weapon.getWeight();
        System.out.println("[WeightCalculator] Weapon " + weapon.getName()
                + " weighs " + weapon.getWeight() + ". Balanced for combat.");
    }

    @Override
    public void visit(Potion potion) {
        totalWeight += potion.getWeight();
        System.out.println("[WeightCalculator] Potion " + potion.getName()
                + " weighs " + potion.getWeight() + ". Fragile liquid item.");
    }

    @Override
    public void visit(Scroll scroll) {
        totalWeight += scroll.getWeight();
        System.out.println("[WeightCalculator] Scroll " + scroll.getName()
                + " weighs " + scroll.getWeight() + ". Easy to carry.");
    }

    @Override
    public void visit(Ring ring) {
        totalWeight += ring.getWeight();
        System.out.println("[WeightCalculator] Ring " + ring.getName()
                + " weighs " + ring.getWeight() + ". Almost weightless.");
    }

    @Override
    public void visit(Armor armor) {
        totalWeight += armor.getWeight();
        System.out.println("[WeightCalculator] Armor " + armor.getName()
                + " weighs " + armor.getWeight() + ". Heavy defensive gear.");
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}