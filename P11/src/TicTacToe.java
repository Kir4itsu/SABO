import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame implements ActionListener {
    private JButton[][] buttons = new JButton[3][3];
    private JLabel statusLabel;
    private boolean playerOneTurn = true;

    public TicTacToe() {
        setTitle("Tic-Tac-Toe");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));
        initializeButtons(boardPanel);
        add(boardPanel, BorderLayout.CENTER);

        statusLabel = new JLabel("Giliran Pemain Satu");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void initializeButtons(JPanel panel) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[row][col].setFocusPainted(false);
                buttons[row][col].addActionListener(this);
                panel.add(buttons[row][col]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (clickedButton.getText().equals("")) {
            if (playerOneTurn) {
                clickedButton.setText("X");
                statusLabel.setText("Giliran Pemain Dua");
            } else {
                clickedButton.setText("O");
                statusLabel.setText("Giliran Pemain Satu");
            }
            clickedButton.setEnabled(false); // Nonaktifkan tombol setelah diklik
            playerOneTurn = !playerOneTurn;
            checkForWinner();
        }
    }

    private void checkForWinner() {
        // Cek baris dan kolom
        for (int i = 0; i < 3; i++) {
            if (checkThree(buttons[i][0], buttons[i][1], buttons[i][2]) ||
                checkThree(buttons[0][i], buttons[1][i], buttons[2][i])) {
                return;
            }
        }

        // Cek diagonal
        if (checkThree(buttons[0][0], buttons[1][1], buttons[2][2]) ||
            checkThree(buttons[0][2], buttons[1][1], buttons[2][0])) {
            return;
        }

        // Cek apakah seri
        boolean draw = true;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().equals("")) {
                    draw = false;
                    break;
                }
            }
        }
        if (draw) {
            JOptionPane.showMessageDialog(this, "Seri!");
            resetBoard();
        }
    }

    private boolean checkThree(JButton b1, JButton b2, JButton b3) {
        if (!b1.getText().equals("") && b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText())) {
            String winner = b1.getText();
            JOptionPane.showMessageDialog(this, winner + " menang!");
            resetBoard();
            return true;
        }
        return false;
    }

    private void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
                buttons[row][col].setEnabled(true); // Aktifkan lagi tombolnya
            }
        }
        playerOneTurn = true; // Reset giliran ke pemain satu
        statusLabel.setText("Giliran Pemain Satu");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToe::new);
    }
}
