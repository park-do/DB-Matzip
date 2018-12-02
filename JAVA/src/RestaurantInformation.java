import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Nov 30 14:55:22 KST 2018
 */



/**
 * @author leejongha
 */
public class RestaurantInformation {
	public static int res_id = -1;
	public RestaurantInformation(int res_id) {
		this.res_id = res_id;
		String resInfo = DBSQLHandler.GetInstance().GetRestaurantInformation(res_id);
		String name = resInfo.split("\\|")[0];
		String rate = resInfo.split("\\|")[1];
		String category = resInfo.split("\\|")[2];
		initComponents(name, rate, category);
	}

	private void initComponents(String name, String rate, String category) {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - leejongha
		Info = new JFrame();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		textArea1 = new JTextArea();
		textArea3 = new JTextArea();
		label1 = new JLabel();
		label2 = new JLabel();
		list1 = new JList();

		//======== Info ========
		{
			Info.setTitle("Restaurant Information");
			Container InfoContentPane = Info.getContentPane();
			InfoContentPane.setLayout(null);

			//---- button1 ----
			button1.setText("\ub9ac\ubdf0 \uc791\uc131");
			InfoContentPane.add(button1);
			button1.setBounds(380, 135, 85, 50);
			button1.addActionListener(e->{
				new Review();
			});

			//---- button2 ----
			button2.setText("\ucfe0\ud3f0 \uc0ac\uc6a9");
			InfoContentPane.add(button2);
			button2.setBounds(380, 205, 85, 45);
			button2.addActionListener(e-> {
				new Coupon();
			});

			//---- button3 ----
			button3.setText("\uc608\uc57d");
			InfoContentPane.add(button3);
			button3.setBounds(380, 270, 85, 45);
			button3.addActionListener(e->{
				new Reservation();
			});

			InfoContentPane.add(textArea1);
			textArea1.setBounds(20, 50, 225, 65);
			textArea1.setText(name);
			InfoContentPane.add(textArea3);
			textArea3.setBounds(275, 55, 185, 60);
			textArea3.setText("평점 : " + rate + " 카테고리 : " + category);

			//---- label1 ----
			label1.setText("\uc2dd\ub2f9 \uc815\ubcf4");
			label1.setFont(new Font("\uad74\ub9bc", Font.BOLD, 20));
			InfoContentPane.add(label1);
			label1.setBounds(25, 15, 145, 30);

			//---- label2 ----
			//label2.setText("\uce74\ud14c\uace0\ub9ac");
			//label2.setFont(new Font("\uad74\ub9bc", Font.BOLD, 20));
			//InfoContentPane.add(label2);
			//label2.setBounds(280, 20, 145, 30);
			InfoContentPane.add(list1);
			list1.setBounds(20, 135, 345, 180);

			ArrayList<String> reviews = DBSQLHandler.GetInstance().GetReviews(res_id);
			list1.setListData(reviews.toArray());

			//list1.setListData(new String[]{"haha", "hoho"});

			InfoContentPane.setPreferredSize(new Dimension(490, 385));
			Info.pack();
			Info.setLocationRelativeTo(Info.getOwner());
			Info.setVisible(true);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - leejongha
	private JFrame Info;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JTextArea textArea1;
	private JTextArea textArea3;
	private JLabel label1;
	private JLabel label2;
	private JList list1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
