import javax.swing.*;
import java.awt.*;

public class searchWindow {
    private JFrame mainFrame;
    private JPanel searchPanel;
    private JPanel resultPanel;
    private JPanel filterPanel;

    public searchWindow() {
        createGUI();
    }

    private void createGUI() {
        searchPanel = new JPanel();
        initSearchPanel(searchPanel);
        resultPanel = new JPanel();
        initResultPanel(resultPanel);
        filterPanel = new JPanel();
        initFilterpanel(filterPanel);

        mainFrame = new JFrame("검색하기");
        mainFrame.setSize(800, 600);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(searchPanel, BorderLayout.PAGE_START);
        mainFrame.add(resultPanel, BorderLayout.CENTER);
        mainFrame.add(filterPanel, BorderLayout.PAGE_END);
    }
    private void initSearchPanel(JPanel searchPanel) {
        JLabel text = new JLabel("레스토랑 이름 입력: ");
        JTextField textField = new JTextField(10);
        JButton searchIcon = new JButton("검색");
        JButton moveButton = new JButton("이동");
        searchPanel.setLayout(new FlowLayout());
        searchPanel.add(text);
        searchPanel.add(textField);
        searchPanel.add(searchIcon);
        searchPanel.add(moveButton);

        searchIcon.addActionListener(e->{
            String keyword = text.getText();

        });
    }
    private void initResultPanel(JPanel resultPanel) {
        JList queryResult = new JList(new String[]{"우리식당","홍콩반점"});
        resultPanel.add(queryResult);
    }
    private void initFilterpanel(JPanel filterPanel) {
        String[] filterList = {"이름 오름차순", "이름 내림차순", "거리 오름차순", "거리 내림차순"};
        JComboBox filterBox = new JComboBox(filterList);
        String[] styleList = {"한식", "중식", "일식", "모두"};
        JComboBox styleBox = new JComboBox(styleList);
        filterPanel.setLayout(new FlowLayout());
        filterPanel.add(filterBox);
        filterPanel.add(styleBox);
    }

    public static void main(String[] args) {
        searchWindow sw = new searchWindow();
    }
}
