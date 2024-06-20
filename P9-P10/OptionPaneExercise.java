import javax.swing.JOptionPane;

public class OptionPaneExercise {

    public OptionPaneExercise(String name) {
        JOptionPane.showMessageDialog(null, "From now on your Name Is: " + name);
        // Show a dialog message containing a name that came from its parameter constructor.
    }

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Insert Name: ");
        // Create an input dialog that inputs a name.
        // Create an input dialog that shows a name input.
        OptionPaneExercise ead = new OptionPaneExercise(name);
    }
}
