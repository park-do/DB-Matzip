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
    public static int user_id = -1;
    private void initLoginPanel(JPanel loginPanel) {
        JLabel id_text = new JLabel("ID: ");
        JLabel pw_text = new JLabel("PW: ");
        JTextField id_field = new JTextField(10);
        JTextField pw_field = new JTextField(10);
        JButton loginIcon = new JButton("로그인");
        loginIcon.addActionListener(e-> {
            int result = DBSQLHandler.GetInstance().TryLogin(id_field.getText(), pw_field.getText());
            if(result == -1)
            {
                JOptionPane.showMessageDialog(null, "아이디 또는 패스워드 오류");
            }
            else
            {
                user_id = result;
                id_text.setText(id_field.getText()+"님 환영합니다");
                id_field.setVisible(false);
                pw_text.setVisible(false);
                pw_field.setVisible(false);
            }
        });
        loginPanel.setLayout(new FlowLayout());
        loginPanel.add(id_text);
        loginPanel.add(id_field);
        loginPanel.add(pw_text);
        loginPanel.add(pw_field);
        loginPanel.add(loginIcon);
    }

    JButton res_manage;
    JButton admin;
    private void initButtonPanel(JPanel buttonPanel) {
        JButton search = new JButton("식당 검색");
        res_manage = new JButton("식당 관리");
        admin = new JButton("관리자");
        buttonPanel.add(search);
        buttonPanel.add(res_manage);
        buttonPanel.add(admin);

        search.addActionListener(e-> {
                searchWindow sw = new searchWindow();
        });

        res_manage.addActionListener(e -> {
            // RestaurantInformation sw = new RestaurantInformation();
        });
    }



    public static void main(String[] args) {
        mainWindow mw = new mainWindow();
    }
}
