package de.atruvia.spiele.nimspiel;

import de.atruvia.spiele.Spiel;

import java.util.Scanner;

public class NimSpielImpl implements Spiel {

    private final Scanner scanner = new Scanner(System.in);
    private int steine;
    private int zug;

    public NimSpielImpl() {
        this.steine = 23;
    }

    @Override
    public void spielen() {
        while(! isGameover()) {
            playRound();
        }
    }

    private void playRound() {
        spielerzug();
        computerzug();
    }

    private void spielerzug() {

        while(true) {
            System.out.printf("Es gibt %s Steine. Bitte nehmen Sie 1,2 oder 3.\n", steine);
            zug = scanner.nextInt();
            if(zug >=1 && zug <= 3) break;
            System.out.println("Ungueltiger Zug");

        }
        terminiereZug("Mensch");
    }

    private void computerzug() {

        terminiereZug("Computer");
    }

    private void terminiereZug(String playerName) {
        updateBoard();
        printGameoverMessageIfGameisOver(playerName);
    }

    private void printGameoverMessageIfGameisOver(final String playerName) {
        if(isGameover()) {
            System.out.println(playerName + " hat verloren");
        }
    }

    private void updateBoard() {
        steine -= zug;
    }

    private boolean isGameover(){
        return steine < 1;
    }
}
