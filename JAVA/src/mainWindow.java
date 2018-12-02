import javax.swing.*;
import java.awt.*;

public class mainWindow {
    private JFrame mainFrame;
    private JPanel loginPanel;
    private JPanel buttonPanel;

    public mainWindow() {
        createGUI();
    }

    private void createGUI() {
        loginPanel = new JPanel();
        initLoginPanel(loginPanel);
        buttonPanel = new JPanel();
        initButtonPanel(buttonPanel);

        mainFrame = new JFrame("검색하기");
        mainFrame.setSize(800, 600);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(loginPanel, BorderLayout.PAGE_START);
        mainFrame.add(buttonPanel, BorderLayout.CENTER);

    }

    private void initLoginPanel(JPanel loginPanel) {
        JLabel id_text = new JLabel("ID: ");
        JLabel pw_text = new JLabel("PW: ");
        JTextField id_field = new JTextField(10);
        JTextField pw_field = new JTextField(10);
        JButton loginIcon = new JButton("로그인");
        loginPanel.setLayout(new FlowLayout());
        loginPanel.add(id_text);
        loginPanel.add(id_field);
        loginPanel.add(pw_text);
        loginPanel.add(pw_field);
        loginPanel.add(loginIcon);
    }

    private void initButtonPanel(JPanel buttonPanel) {
        JButton search = new JButton("식당 검색");
        JButton res_manage = new JButton("식당 관리");
        JButton admin = new JButton("관리자");
        buttonPanel.add(search);
        buttonPanel.add(res_manage);
        buttonPanel.add(admin);

        search.addActionListener(e-> {
                searchWindow sw = new searchWindow();
        });

        res_manage.addActionListener(e -> {
            RestaurantInformation sw = new RestaurantInformation();
        });
    }



    public static void main(String[] args) {
        mainWindow mw = new mainWindow();
    }
}
