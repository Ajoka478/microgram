import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String gameChoice;
        do {
            System.out.println("+_________________________________+");
            System.out.println("Choose a game: hard or easy?");
            gameChoice = scan.nextLine();
        } while (!gameChoice.matches("^[a-z][a-z ]*[a-z]?$"));
        switch (gameChoice) {
            case "hard":
                playRockPaperScissorsHard();
                break;
            case "easy":
                playRockPaperScissorsEasy();
                break;
            default:
                System.out.println("Wrong command");
        }
    }

    private static void playRockPaperScissorsEasy() {
        int win = 0, tie = 0, lose = 0, winN = 0, loseN = 0, tieN = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String playerMove;
            do {
                System.out.println("+_________________________________+");
                System.out.println("Make a move! (rock/paper/scissors)");
                playerMove = scanner.nextLine().toLowerCase(Locale.ROOT);
            } while (!playerMove.matches("^[a-z][a-z ]*[a-z]?$"));

            Random random = new Random();
            int randomNumber = random.nextInt(3);
            String computerMove;
            if (randomNumber == 0) {
                computerMove = String.valueOf(Figure.ROCK).toLowerCase();
            } else if (randomNumber == 1) {
                computerMove = String.valueOf(Figure.PAPER).toLowerCase();
            } else {
                computerMove = String.valueOf(Figure.SCISSORS).toLowerCase();
            }
            System.out.println("Computer chose " + computerMove + "!");
            if (playerMove.equals(computerMove)) {
                System.out.println("It's a draw!");
                tie++;
            } else if (playerWins(playerMove, computerMove)) {
                System.out.println("Player wins!");
                win++;
                break;
            } else {
                System.out.println("Computer wins!");
                lose++;
                break;
            }
        }
        winN += win;
        loseN += lose;
        tieN += tie;
        System.out.println("+_____________________________________________________+");
        System.out.println("| Win | Loss | Draw | # of games | Percentage of wins |");
        System.out.println("|_____+______ +______+____________+____________________|");
        int round = winN + loseN + tieN;
        float percentage;
        try {
            percentage = winN / loseN;
            System.out.printf("| %-4s| %-5s| %-5s| %-11s| %.02f percent", winN, loseN, tieN, round, percentage);
        } catch (ArithmeticException e) {
            percentage = 100.00F;
            System.out.printf("| %-4s| %-5s| %-5s| %-11s| %.02f percent", winN, loseN, tieN, round, percentage);
        }
    }

    static boolean playerWins(String playerMove, String computerMove) {
        if (playerMove.equals("rock")) {
            return computerMove.equals("scissors");
        } else if (playerMove.equalsIgnoreCase("paper")) {
            return computerMove.equals("rock");
        } else {
            return computerMove.equalsIgnoreCase("paper");
        }
    }

    static void playRockPaperScissorsHard() {
        int win = 0, tie = 0, lose = 0, winN = 0, loseN = 0, tieN = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String playerMove;
            do {
                System.out.println("+_________________________________+");
                System.out.println("Make a move! (rock/paper/scissors/lizard/spock)");
                playerMove = scanner.nextLine().toLowerCase(Locale.ROOT);
            } while (!playerMove.matches("^[a-z][a-z ]*[a-z]?$"));

            Random random = new Random();
            int randomNumber = random.nextInt(5);
            String computerMove = null;
            switch (randomNumber) {
                case 0:
                    computerMove = String.valueOf(Figure.ROCK).toLowerCase();
                    break;
                case 1:
                    computerMove = String.valueOf(Figure.PAPER).toLowerCase();
                    break;
                case 2:
                    computerMove = String.valueOf(Figure.SCISSORS).toLowerCase();
                    break;
                case 3:
                    computerMove = String.valueOf(Figure.LIZARD).toLowerCase();
                    break;
                case 4:
                    computerMove = String.valueOf(Figure.SPOCK).toLowerCase();
                    break;
                default:
                    System.out.println();
            }
            System.out.println("Computer chose " + computerMove + "!");
            if (playerMove.equals(computerMove)) {
                System.out.println("It's a draw!");
                tie++;
            } else if (playerWinsHard(playerMove, computerMove)) {
                System.out.println("Player wins!");
                win++;
                break;
            } else {
                System.out.println("Computer wins!");
                lose++;
                break;
            }
        }

        winN += win;
        loseN += lose;
        tieN += tie;
        System.out.println("+_____________________________________________________+");
        System.out.println("| Win | Loss | Draw | # of games | Percentage of wins |");
        System.out.println("|_____+______ +______+____________+____________________|");
        int round = winN + loseN + tieN;
        float percentage;
        try {
            percentage = winN / loseN;
            System.out.printf("| %-4s| %-5s| %-5s| %-11s| %.02f percent", winN, loseN, tieN, round, percentage);
        } catch (
                ArithmeticException e) {
            percentage = 100.00F;
            System.out.printf("| %-4s| %-5s| %-5s| %-11s| %.02f percent", winN, loseN, tieN, round, percentage);
        }
    }

    static boolean playerWinsHard(String playerMove, String computerMove) {
        if (playerMove.equals("rock")) {
            return computerMove.equals("scissors") || computerMove.equals("lizard");
        } else if (playerMove.equalsIgnoreCase("paper")) {
            return computerMove.equals("rock") || computerMove.equals("spock");
        } else if (playerMove.equalsIgnoreCase("lizard")) {
            return computerMove.equals("paper") || computerMove.equals("spock");
        } else if (playerMove.equalsIgnoreCase("spock")) {
            return computerMove.equals("scissors") || computerMove.equals("rock");
        } else {
            return computerMove.equalsIgnoreCase("paper") || computerMove.equals("lizard");
        }
    }
}
