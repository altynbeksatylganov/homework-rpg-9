package com.narxoz.rpg.vault;

import com.narxoz.rpg.visitor.WeightCalculator;
import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.combatant.HeroMemento;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.visitor.CurseDetector;
import com.narxoz.rpg.visitor.EnchantmentScanner;
import com.narxoz.rpg.visitor.GoldAppraiser;

import java.util.List;


public class ChronomancerEngine {
    public VaultRunResult runVault(List<Hero> party) {
        if (party == null || party.isEmpty()) {
            System.out.println("No heroes entered the Chronomancer's Vault.");
            return new VaultRunResult(0, 0, 0);
        }

        System.out.println();
        System.out.println("=== Chronomancer's Vault Opens ===");
        System.out.println("Party entering the vault:");
        for (Hero hero : party) {
            System.out.println(" - " + hero);
        }

        Inventory vaultInventory = buildVaultInventory();

        System.out.println();
        System.out.println("=== Visitor Phase: Artifact Appraisal Begins ===");

        GoldAppraiser goldAppraiser = new GoldAppraiser();
        vaultInventory.accept(goldAppraiser);
        System.out.println("Total appraised value: " + goldAppraiser.getTotalValue() + " gold.");

        System.out.println();

        EnchantmentScanner enchantmentScanner = new EnchantmentScanner();
        vaultInventory.accept(enchantmentScanner);
        System.out.println("Magical findings: " + enchantmentScanner.getMagicalFindings());

        System.out.println();

        CurseDetector curseDetector = new CurseDetector();
        vaultInventory.accept(curseDetector);
        System.out.println("Cursed artifacts detected: " + curseDetector.getCursedCount());

        System.out.println();

        WeightCalculator weightCalculator = new WeightCalculator();
        vaultInventory.accept(weightCalculator);
        System.out.println("Total vault inventory weight: " + weightCalculator.getTotalWeight());

        System.out.println("=== Visitor Phase: Artifact Appraisal Ends ===");

        Hero targetHero = party.get(0);
        targetHero.setInventory(vaultInventory.copy());

        Caretaker caretaker = new Caretaker();
        int mementosCreated = 0;
        int restoredCount = 0;

        System.out.println();
        System.out.println("=== Memento Phase: Snapshot Created ===");
        System.out.println("Before snapshot: " + targetHero);
        caretaker.save(targetHero.createMemento());
        mementosCreated++;
        System.out.println("Caretaker now stores snapshots: " + caretaker.size());

        System.out.println();
        System.out.println("=== Vault Trap: Time Fracture Triggered ===");
        targetHero.takeDamage(65);
        targetHero.spendMana(20);
        targetHero.spendGold(75);
        targetHero.setInventory(new Inventory());
        System.out.println("After trap: " + targetHero);

        System.out.println();
        System.out.println("=== Memento Phase: Rewind Begins ===");
        HeroMemento snapshot = caretaker.undo();
        if (snapshot != null) {
            targetHero.restoreFromMemento(snapshot);
            restoredCount++;
            System.out.println("After rewind: " + targetHero);
        } else {
            System.out.println("No snapshot available. Rewind failed.");
        }

        System.out.println("Caretaker now stores snapshots: " + caretaker.size());
        System.out.println("=== Chronomancer's Vault Closes ===");

        return new VaultRunResult(vaultInventory.size(), mementosCreated, restoredCount);
    }

    private Inventory buildVaultInventory() {
        Inventory inventory = new Inventory();

        inventory.addArtifact(new Weapon("Solar Fang", 120, 8, 7));
        inventory.addArtifact(new Potion("Crimson Recovery Flask", 45, 1, 30));
        inventory.addArtifact(new Scroll("Shadow Gate Scroll", 90, 1, "Shadow Gate"));
        inventory.addArtifact(new Ring("Ring of Moon Echoes", 150, 1, 4));
        inventory.addArtifact(new Armor("Aegis of Lost Time", 200, 15, 9));

        return inventory;
    }
}