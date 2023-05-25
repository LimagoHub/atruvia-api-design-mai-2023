package de.atruvia.main;

import de.atruvia.client.GameClient;
import de.atruvia.spiele.Spiel;
import de.atruvia.spiele.nimspiel.NimSpielImpl;

public class Main {
    public static void main(String[] args) {

        Spiel spiel = new NimSpielImpl();
        GameClient client = new GameClient(spiel);
        client.go();
    }
}