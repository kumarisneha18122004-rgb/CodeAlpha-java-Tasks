import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class QuoteGenerator extends JFrame {
    private JLabel quoteLabel;
    private JLabel authorLabel;

    private String[][] quotes = {
        {"Java is to JavaScript what car is to carpet.", "Chris Heilmann"},
        {"Code is like humor. When you have to explain it, it’s bad.", "Cory House"},
        {"First, solve the problem. Then, write the code.", "John Johnson"},
        {"Make it work, make it right, make it fast.", "Kent Beck"},
        {"Simplicity is the soul of efficiency.", "Austin Freeman"}
    };

    public QuoteGenerator() {
        setTitle("Random Quote Generator");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        quoteLabel = new JLabel("", SwingConstants.CENTER);
        quoteLabel.setFont(new Font("Serif", Font.BOLD, 15));

        authorLabel = new JLabel("", SwingConstants.CENTER);
        authorLabel.setFont(new Font("Arial", Font.ITALIC, 13));

        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        centerPanel.add(quoteLabel);
        centerPanel.add(authorLabel);

        JButton newQuoteBtn = new JButton("New Quote");
        newQuoteBtn.addActionListener(e -> displayRandomQuote());

        add(centerPanel, BorderLayout.CENTER);
        add(newQuoteBtn, BorderLayout.SOUTH);

        displayRandomQuote();
    }

    private void displayRandomQuote() {
        Random rand = new Random();
        int index = rand.nextInt(quotes.length);
        quoteLabel.setText("<html><center>\"" + quotes[index][0] + "\"</center></html>");
        authorLabel.setText("- " + quotes[index][1]);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QuoteGenerator().setVisible(true));
    }
}
