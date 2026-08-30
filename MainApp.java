package couriermanagementsystem.models;
import couriermanagementsystem.gui.Home;

public class MainApp {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Home home = new Home();
            home.setVisible(true);
        });
    }
}
