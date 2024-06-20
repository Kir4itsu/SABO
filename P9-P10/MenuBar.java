import javax.swing.*;
import java.awt.*;

public class MenuBar extends JFrame {

    private JMenuBar menu;
    private JMenu file, help;
    private JMenuItem newMenu, openMenu, exitMenu, helpMenu;

    public MenuBar() {
        Container container = getContentPane();

        menu = new JMenuBar(); // Create new menubar.
        file = new JMenu("File"); // Create "File" menu.
        help = new JMenu("Help"); // Create "Help" menu.
        newMenu = new JMenuItem("New"); // Create "New" item.
        openMenu = new JMenuItem("Open"); // Create "Open" item.
        exitMenu = new JMenuItem("Exit"); // Create "Exit" item.
        helpMenu = new JMenuItem("Help"); // Create "Help" item.

        setJMenuBar(menu); // Set MenuBar.
        menu.add(file); // Add into menu.
        menu.add(help); // Add into menu.

        file.add(newMenu); // Add into file.
        file.add(openMenu);
        file.addSeparator(); // Add separator.
        file.add(exitMenu);

        help.add(helpMenu);

        setLayout(new FlowLayout()); // Set container's layout using FlowLayout
        setSize(300, 200); // Set Sizes.
        setVisible(true);
    }

    public static void main(String[] args) {
        MenuBar tampilan = new MenuBar(); // Show by creating new object.
    }
}
