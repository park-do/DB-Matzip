import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sat Dec 01 00:28:39 KST 2018
 */



/**
 * @author Mun
 */
public class AdminMenu extends JPanel {
	public AdminMenu() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mun
		frame1 = new JFrame();
		label2 = new JLabel();
		label5 = new JLabel();
		comboBox2 = new JComboBox();
		label3 = new JLabel();
		scrollPane1 = new JScrollPane();
		textArea1 = new JTextArea();
		button2 = new JButton();
		label1 = new JLabel();
		label6 = new JLabel();
		comboBox1 = new JComboBox();
		label7 = new JLabel();
		comboBox3 = new JComboBox();
		button1 = new JButton();

		//======== frame1 ========
		{
			frame1.setTitle("Admin");
			Container frame1ContentPane = frame1.getContentPane();
			frame1ContentPane.setLayout(new MigLayout(
				"hidemode 3",
				// columns
				"[fill]" +
				"[81,fill]" +
				"[120,fill]rel" +
				"[22,fill]rel" +
				"[fill]rel" +
				"[0,fill]rel" +
				"[fill]" +
				"[47,fill]",
				// rows
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[]" +
				"[]"));

			//---- label2 ----
			label2.setText("Register Menu");
			frame1ContentPane.add(label2, "cell 1 1");

			//---- label5 ----
			label5.setText("Select Restaurant");
			frame1ContentPane.add(label5, "cell 1 2");
			frame1ContentPane.add(comboBox2, "cell 2 2");

			//---- label3 ----
			label3.setText("Restaurant Name");
			frame1ContentPane.add(label3, "cell 1 3");

			//======== scrollPane1 ========
			{
				scrollPane1.setViewportView(textArea1);
			}
			frame1ContentPane.add(scrollPane1, "cell 2 3");

			//---- button2 ----
			button2.setText("OK");
			frame1ContentPane.add(button2, "cell 4 3");

			//---- label1 ----
			label1.setText("Remove Menu");
			frame1ContentPane.add(label1, "cell 1 5");

			//---- label6 ----
			label6.setText("Select Restaurant");
			frame1ContentPane.add(label6, "cell 1 6");
			frame1ContentPane.add(comboBox1, "cell 2 6");

			//---- label7 ----
			label7.setText("Select Menu");
			frame1ContentPane.add(label7, "cell 1 7");
			frame1ContentPane.add(comboBox3, "cell 2 7");

			//---- button1 ----
			button1.setText("OK");
			frame1ContentPane.add(button1, "cell 4 7");
			frame1.pack();
			frame1.setLocationRelativeTo(frame1.getOwner());
			frame1.setVisible(true);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mun
	private JFrame frame1;
	private JLabel label2;
	private JLabel label5;
	private JComboBox comboBox2;
	private JLabel label3;
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
	private JButton button2;
	private JLabel label1;
	private JLabel label6;
	private JComboBox comboBox1;
	private JLabel label7;
	private JComboBox comboBox3;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
