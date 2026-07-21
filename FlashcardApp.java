import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FlashcardApp extends JFrame {
    private ArrayList<Flashcard> flashcards;
    private int currentIndex = 0;
    private JLabel questionLabel;
    private JLabel answerLabel;

    static class Flashcard {
        String question;
        String answer;

        Flashcard(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }
    }

    public FlashcardApp() {
        setTitle("Flashcard Quiz App");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        flashcards = new ArrayList<>();
        flashcards.add(new Flashcard("What is the main feature of Java?", "Platform Independence (Write Once, Run Anywhere)"));
        flashcards.add(new Flashcard("What does JVM stand for?", "Java Virtual Machine"));
        flashcards.add(new Flashcard("Which keyword is used to inherit a class in Java?", "extends"));

        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));

        answerLabel = new JLabel("", SwingConstants.CENTER);
        answerLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        answerLabel.setForeground(Color.BLUE);

        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        centerPanel.add(questionLabel);
        centerPanel.add(answerLabel);

        JButton showAnswerBtn = new JButton("Show Answer");
        JButton nextBtn = new JButton("Next");
        JButton prevBtn = new JButton("Previous");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevBtn);
        buttonPanel.add(showAnswerBtn);
        buttonPanel.add(nextBtn);

        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        showAnswerBtn.addActionListener(e -> answerLabel.setText(flashcards.get(currentIndex).answer));
        
        nextBtn.addActionListener(e -> {
            if (currentIndex < flashcards.size() - 1) {
                currentIndex++;
                updateCard();
            }
        });

        prevBtn.addActionListener(e -> {
            if (currentIndex > 0) {
                currentIndex--;
                updateCard();
            }
        });

        updateCard();
    }

    private void updateCard() {
        questionLabel.setText("Q: " + flashcards.get(currentIndex).question);
        answerLabel.setText("Click 'Show Answer' to reveal");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FlashcardApp().setVisible(true));
    }
}
