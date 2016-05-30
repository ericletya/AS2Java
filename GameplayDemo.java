import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameplayDemo {
    static Scanner scanner = new Scanner(System.in);
    static Deck deck = new Deck();
    static Card cardOfchoice, cardOnTable;
    static String category, choice2;
    static int cardNum;
    static int choice;
    static ArrayList<Hand> hands;
    static Card magnetite = new MineralCard("Magnetite",6,5.2,"none","moderate","very high");
    public static void main(String[] args) {
        int pNum;
        String name;
        cardOnTable = null;
        int turn = 0;

        pNum = numberOfPlayers();

        hands = generateHands(pNum);

        while (hands.size() > 1){
            for (Hand hand : hands) {
                checkStatus(hands);
                name = hand.getName();
                if (hand.isStatus()) {
                    choice = menu(turn, name);
                    while (choice == 1 || choice == 4) {
                        if (choice == 1){
                        hand.display();
                        }
                        else {
                            assert cardOnTable != null;
                            ((MineralCard) cardOnTable).display(category);
                        }
                        choice = menu(turn, name);
                    }
                    if (choice == 2) {
                        if (turn == 0) {
                            turn1(hand);
                        }
                        else {
                            otherTurn(hand, turn, name);
                        }
                    } else if (choice == 3) {
                        if(deck.getTotalCards() > 0){
                        hand.draw(deck);
                        }
                        hand.setStatus(false);
                    }
                    turn++;
                }
                else {
                    message("Player " + name + " cannot play yet");
                }
            }
            checkNumberOfCards();
        }
        message(hands.get(0).getName() + " has lost");
    }

    public static ArrayList<Hand> generateHands(int number){
        String name;
        ArrayList<Hand> hands = new ArrayList<>();
        for(int i = 1; i <= number; i++){
            name = playerNames(i);
            hands.add(new Hand(deck, name, true));
        }

        return hands;
    }

    public static int menu(int turn, String name){
        String choice;
        int n;
        choice = menuWindow(turn, name);
        switch (choice) {
            case "Show hand":
                n = 1;
                break;
            case "Use a card":
                n = 2;
                break;
            case "Pass":
                n = 3;
                break;
            default:
                n = 4;
                break;
        }
        return n;
    }

    public static void turn1(Hand hand){
        cardOfchoice = chooseCard(hand);
        cardOnTable = cardOfchoice;
        category = categories();
    }

    public static void otherTurn(Hand hand, int turn, String name){
        cardOfchoice = chooseCard(hand);
        if (cardOfchoice instanceof MineralCard){
            while(!((MineralCard) cardOfchoice).compareValues((MineralCard) cardOnTable, category)){
                message("You cannot use this card");
                hand.getCards().add(cardOfchoice);
                choice = menu(turn, name);
            }
            cardOnTable = cardOfchoice;
        }
        else{
            changeStatus(hands);
            switch (cardOfchoice.getName()){
                case "The Mineralogist":
                    category = "Cleavage";
                    break;
                case "The Miner":
                    category = "Economic value";
                    break;
                case "The Petrologist":
                    category = "Crustal abundance";
                    break;
                case "The Gemologist":
                    category = "Hardness";
                    break;
                case "The Geologist":
                    category = categories();
                    break;
                case "The Geophysicist":
                    if (hand.getCards().contains(magnetite)){
                        System.out.println("Do you wish to use magnetite and win the hand?:\n1. Yes\n2. No");
                        if (choice2.equals("Yes")){
                            hand.getCards().clear();
                            hands.remove(hand);
                        }
                        else {
                            category = "Specific gravity";
                        }
                    }
                    else{
                        category = "Specific gravity";
                    }
            }
        }
    }

    public static String categories(){
        String cat;
        ChooseCategoryFrame frame = new ChooseCategoryFrame("Choose category");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        while(!frame.isActionFlag()){
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cat = frame.getChoice();
        return cat;
    }

    public static Card chooseCard(Hand hand){
        Card card;
        ChooseCardFrame frame = new ChooseCardFrame("Choose card", hand.getCards());
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        while(!frame.isActionFlag()){
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cardNum = frame.getChoice();
        card = hand.useCard(cardNum);
        return card;
    }

    public static void checkStatus(ArrayList<Hand> hands){
        int count = 0;
        for (Hand hand : hands) {
            if (hand.isStatus()) {
                count++;
            }
        }
        if (count == 1){
            changeStatus(hands);
        }
    }

    public static void changeStatus(ArrayList<Hand> hands){
        for (Hand hand : hands){
            hand.setStatus(true);
        }
    }

    public static void checkNumberOfCards(){
        for (Hand hand: hands){
            if (hand.getCards().size() == 0){
                hands.remove(hand);
            }
        }
    }

    public static int numberOfPlayers(){
        int choice;
        JFrame frame = new NumberFrame("Number of players");
        createFrame(frame);
        while(!((NumberFrame) frame).isActionFlag()){
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        choice = ((NumberFrame) frame).getChoice();
        return choice;
    }

    public static String playerNames(int playerNum){
        String name;
        JFrame frame = new NameFrame("Player names", String.valueOf(playerNum));
        createFrame(frame);
        while(!((NameFrame) frame).isActionFlag()){
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        name =((NameFrame) frame).getPlayerName();
        return name;
    }

    public static String menuWindow(int turn, String name) {
        String choice;
        JFrame frame = new MenuFrame("Menu" + "(" + name +"'s turn)", turn);
        createFrame(frame);
        while (!((MenuFrame) frame).isActionFlag()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        choice =((MenuFrame) frame).getChoice();
        return choice;
    }

    public static void createFrame(JFrame frame){
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void message(String msg){
        SpecialFrame frame = new SpecialFrame("Warning", msg);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
    public static void ifMagnetite(){

        SpecialFrame frame = new SpecialFrame("Do you wish to use magnetite and win the hand?");
        frame.setSize(300, 100);
        frame.setVisible(true);
        while (!frame.isActionFlag()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        choice2 = frame.getChoice();
    }
}