import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class Main {
    public static void main(String[] args) {
        Autopark autopark = new Autopark();
        JFrame frame = new JFrame("Autopark Interface");
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel(autopark);
        frame.add(panel);
        frame.setVisible(true);
    }
}
