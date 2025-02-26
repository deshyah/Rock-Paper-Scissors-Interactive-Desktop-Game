package src;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {

    JPanel mainPnl;
    JPanel buttonPnl;
    JPanel statsPnl;
    JPanel displayPnl;

    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;

    JLabel playerWinsLbl;
    JTextField playerWinsTF;
    JLabel computerWinsLbl;
    JTextField computerWinsTF;
    JLabel tiesLbl;
    JTextField tiesTF;

    JTextArea displayTA;
    JScrollPane scroller;

    ImageIcon rockIcon;
    ImageIcon paperIcon;
    ImageIcon scissorsIcon;

    int playerWins = 0;
    int computerWins = 0;
    int ties = 0;

    Random rnd = new Random();

    /**
     * Constructor for the RockPaperScissorsFrame class.
     * Initializes the GUI components and sets up the layout.
     */
    public RockPaperScissorsFrame() {
        // **Main Frame Setup**
        setTitle("Rock Paper Scissors Game");
        setSize(550, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // **Main Panel Setup**
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        // **Create Panels**
        createButtonPanel();
        createStatsPanel();
        createDisplayPanel();

        // **Add Panels to Main Panel**
        mainPnl.add(statsPnl, BorderLayout.NORTH);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
        mainPnl.add(buttonPnl, BorderLayout.SOUTH);

        // **Add Main Panel to Frame**
        add(mainPnl);
        setVisible(true);
    }

    /**
     * Creates the button panel with Rock, Paper, Scissors, and Quit buttons.
     * Each button is associated with an ActionListener to handle user input.
     */
    private void createButtonPanel() {
        // **Button Panel Setup**
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1, 4));
        buttonPnl.setBorder(new TitledBorder(new EtchedBorder(), "Choices"));

        // **Icon Loading**
        try {
            rockIcon = new ImageIcon("src/rock.png");
            paperIcon = new ImageIcon("src/paper.png");
            scissorsIcon = new ImageIcon("src/scissors.png");
        } catch (Exception e) {
            System.out.println("Images not found.  Check the path!");
        }

        // **Button Creation**
        rockBtn = new JButton("Rock", rockIcon);
        paperBtn = new JButton("Paper", paperIcon);
        scissorsBtn = new JButton("Scissors", scissorsIcon);
        quitBtn = new JButton("Quit");

        // **Add ActionListeners**
        rockBtn.addActionListener((ActionEvent ae) -> {
            playGame("Rock");
        });
        paperBtn.addActionListener((ActionEvent ae) -> {
            playGame("Paper");
        });
        scissorsBtn.addActionListener((ActionEvent ae) -> {
            playGame("Scissors");
        });
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        // **Add Buttons to Panel**
        buttonPnl.add(rockBtn);
        buttonPnl.add(paperBtn);
        buttonPnl.add(scissorsBtn);
        buttonPnl.add(quitBtn);
    }

    /**
     * Creates the statistics panel to display the number of player wins,
     * computer wins, and ties.
     */
    private void createStatsPanel() {
        // **Stats Panel Setup**
        statsPnl = new JPanel();
        statsPnl.setLayout(new GridLayout(3, 2));
        statsPnl.setBorder(new TitledBorder(new EtchedBorder(), "Statistics"));

        // **Labels and Text Fields**
        playerWinsLbl = new JLabel("Player Wins:");
        playerWinsTF = new JTextField("0");
        playerWinsTF.setEditable(false);

        computerWinsLbl = new JLabel("Computer Wins:");
        computerWinsTF = new JTextField("0");
        computerWinsTF.setEditable(false);

        tiesLbl = new JLabel("Ties:");
        tiesTF = new JTextField("0");
        tiesTF.setEditable(false);

        // **Add Components to Panel**
        statsPnl.add(playerWinsLbl);
        statsPnl.add(playerWinsTF);
        statsPnl.add(computerWinsLbl);
        statsPnl.add(computerWinsTF);
        statsPnl.add(tiesLbl);
        statsPnl.add(tiesTF);
    }

    /**
     * Creates the display panel containing the text area where the game results
     * are displayed.
     */
    private void createDisplayPanel() {
        // **Display Panel Setup**
        displayPnl = new JPanel();
        displayTA = new JTextArea(10, 25);
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }

    /**
     * Plays a single game of Rock Paper Scissors.
     *
     * @param playerChoice The choice made by the player (Rock, Paper, or Scissors).
     */
    private void playGame(String playerChoice) {
        String computerChoice;
        int computerInt = rnd.nextInt(3);

        switch (computerInt) {
            case 0:
                computerChoice = "Rock";
                break;
            case 1:
                computerChoice = "Paper";
                break;
            default:
                computerChoice = "Scissors";
                break;
        }

        String result = determineWinner(playerChoice, computerChoice);
        displayTA.append(result + "\n");
    }

    /**
     * Determines the winner of the game and updates the statistics.
     *
     * @param playerChoice   The choice made by the player.
     * @param computerChoice The choice made by the computer.
     * @return A string describing the result of the game.
     */
    private String determineWinner(String playerChoice, String computerChoice) {
        String result = "";

        if (playerChoice.equals(computerChoice)) {
            ties++;
            tiesTF.setText(String.valueOf(ties));
            result = "Tie! Both chose " + playerChoice;
        } else if (playerChoice.equals("Rock") && computerChoice.equals("Scissors")) {
            playerWins++;
            playerWinsTF.setText(String.valueOf(playerWins));
            result = "Rock breaks scissors (Player wins)";
        } else if (playerChoice.equals("Paper") && computerChoice.equals("Rock")) {
            playerWins++;
            playerWinsTF.setText(String.valueOf(playerWins));
            result = "Paper covers Rock (Player wins)";
        } else if (playerChoice.equals("Scissors") && computerChoice.equals("Paper")) {
            playerWins++;
            playerWinsTF.setText(String.valueOf(playerWins));
            result = "Scissors cut Paper (Player wins)";
        } else {
            computerWins++;
            computerWinsTF.setText(String.valueOf(computerWins));
            result = computerChoice + " beats " + playerChoice + " (Computer Wins)";
        }

        return result;
    }

    /**
     * Main method to start the Rock Paper Scissors game.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RockPaperScissorsFrame());
    }
}