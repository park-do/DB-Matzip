import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sat Dec 01 00:20:19 KST 2018
 */



/**
 * @author Mun
 */
public class AdminRes extends JPanel {
	public AdminRes() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mun
		frame1 = new JFrame();
		label2 = new JLabel();
		label3 = new JLabel();
		scrollPane1 = new JScrollPane();
		textArea1 = new JTextArea();
		label4 = new JLabel();
		scrollPane2 = new JScrollPane();
		textArea2 = new JTextArea();
		label5 = new JLabel();
		comboBox2 = new JComboBox();
		button2 = new JButton();
		label1 = new JLabel();
		comboBox1 = new JComboBox();
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
				"[]"));

			//---- label2 ----
			label2.setText("Register Restaurant");
			frame1ContentPane.add(label2, "cell 1 1");

			//---- label3 ----
			label3.setText("Restaurant Name");
			frame1ContentPane.add(label3, "cell 1 2");

			//======== scrollPane1 ========
			{
				scrollPane1.setViewportView(textArea1);
			}
			frame1ContentPane.add(scrollPane1, "cell 2 2");

			//---- label4 ----
			label4.setText("Restaurant Location");
			frame1ContentPane.add(label4, "cell 1 3");

			//======== scrollPane2 ========
			{
				scrollPane2.setViewportView(textArea2);
			}
			frame1ContentPane.add(scrollPane2, "cell 2 3");

			//---- label5 ----
			label5.setText("Select Category");
			frame1ContentPane.add(label5, "cell 1 4");
			frame1ContentPane.add(comboBox2, "cell 2 4");
			comboBox2.addItem("한식");
			comboBox2.addItem("양식");
			comboBox2.addItem("일식");
			comboBox2.addItem("중식");
			comboBox2.addItem("동남아식");
			comboBox2.addItem("맥시칸");
			comboBox2.addItem("치킨");

			//---- button2 ----
			button2.setText("OK");
			frame1ContentPane.add(button2, "cell 5 4");

			button2.addActionListener(e->{
				String resname = textArea1.getText();
				int location = Integer.parseInt(textArea2.getText());
				String category = comboBox2.getSelectedItem().toString();
				if(DBSQLHandler.GetInstance().AddRestaurant(resname,category,location) == 1)
				{
					JOptionPane.showMessageDialog(null, "추가 성공!");
					frame1.setVisible(false);
					frame1.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "추가 실패");
				}
			});

			//---- label1 ----
			label1.setText("Remove Restaurant");
			frame1ContentPane.add(label1, "cell 1 6");
			frame1ContentPane.add(comboBox1, "cell 1 7");
			resList = DBSQLHandler.GetInstance().SearchRestaurant("","","");
			for(RestaurantInfoClass res:resList)
			{
				comboBox1.addItem(res);
			}

			//---- button1 ----
			button1.setText("OK");
			frame1ContentPane.add(button1, "cell 5 7");
			frame1.pack();
			frame1.setLocationRelativeTo(frame1.getOwner());

			button1.addActionListener(e->{
				if(DBSQLHandler.GetInstance().DeleteRestaurant(((RestaurantInfoClass)comboBox1.getSelectedItem()).res_id)==1)
				{
					JOptionPane.showMessageDialog(null, "삭제 성공!");
					frame1.setVisible(false);
					frame1.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "삭제 실패");
				}
			});

			frame1.setVisible(true);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	ArrayList<RestaurantInfoClass> resList = new ArrayList<>();

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mun
	private JFrame frame1;
	private JLabel label2;
	private JLabel label3;
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
	private JLabel label4;
	private JScrollPane scrollPane2;
	private JTextArea textArea2;
	private JLabel label5;
	private JComboBox comboBox2;
	private JButton button2;
	private JLabel label1;
	private JComboBox comboBox1;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
