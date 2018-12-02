import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Sat Dec 01 00:32:55 KST 2018
 */



/**
 * @author Mun
 */
public class Coupon extends JPanel {
	public Coupon() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mun
		frame1 = new JFrame();
		label2 = new JLabel();
		scrollPane1 = new JScrollPane();
		textArea1 = new JTextArea();
		label1 = new JLabel();
		checkBox1 = new JCheckBox();
		checkBox2 = new JCheckBox();
		checkBox3 = new JCheckBox();
		button1 = new JButton();

		//======== frame1 ========
		{
			frame1.setTitle("Coupon");
			Container frame1ContentPane = frame1.getContentPane();
			frame1ContentPane.setLayout(new MigLayout(
				"hidemode 3",
				// columns
				"[81,fill]" +
				"[fill]" +
				"[120,fill]rel" +
				"[0,fill]rel",
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
				"[]" +
				"[]"));

			//---- label2 ----
			label2.setText("Restaurant");
			frame1ContentPane.add(label2, "cell 1 1");

			//======== scrollPane1 ========
			{
				scrollPane1.setViewportView(textArea1);
			}
			frame1ContentPane.add(scrollPane1, "cell 2 1");

			//---- label1 ----
			label1.setText("\u203bSelect a Coupon");
			frame1ContentPane.add(label1, "cell 1 3");

			list1 = new JList();

			frame1ContentPane.add(list1, "cell 1 4");
			ArrayList<String> coupons = DBSQLHandler.GetInstance().GetCoupons(RestaurantInformation.res_id);
			list1.setListData(coupons.toArray());

//
//			//---- checkBox1 ----
//			checkBox1.setText("Coupon1");
//			frame1ContentPane.add(checkBox1, "cell 1 4");
//
//			//---- checkBox2 ----
//			checkBox2.setText("Coupon2");
//			frame1ContentPane.add(checkBox2, "cell 1 5");
//
//			//---- checkBox3 ----
//			checkBox3.setText("Coupon3");
//			frame1ContentPane.add(checkBox3, "cell 1 6");

			//---- button1 ----
			button1.setText("Buy Coupon");
			frame1ContentPane.add(button1, "cell 1 5");
			frame1.pack();
			frame1.setLocationRelativeTo(frame1.getOwner());
			frame1.setVisible(true);

			button1.addActionListener(e->{
				String selected = list1.getSelectedValue().toString();
				if(DBSQLHandler.GetInstance().BuyCoupon(selected.substring(0,selected.indexOf("|")),mainWindow.user_id) == 1)
				{
					frame1.setVisible(false);
					frame1.dispose();
				}
			});
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mun
	private JFrame frame1;
	private JLabel label2;
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
	private JLabel label1;
	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private JCheckBox checkBox3;
	private JButton button1;
	private JList list1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
