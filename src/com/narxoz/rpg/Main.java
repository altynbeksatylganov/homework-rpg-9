package com.narxoz.rpg;

import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        Hero warrior = new Hero(
                "Aruzhan the Blade",
                120,
                40,
                18,
                9,
                160,
                new Inventory()
        );

        Hero mage = new Hero(
                "Daniyar the Chronomage",
                85,
                100,
                9,
                4,
                90,
                new Inventory()
        );

        List<Hero> party = List.of(warrior, mage);

        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(party);

        System.out.println();
        System.out.println("=== Final VaultRunResult ===");
        System.out.println(result);
    }
}