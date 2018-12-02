import net.miginfocom.swing.MigLayout;

import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Nov 30 16:04:59 KST 2018
 */



/**
 * @author leejongha
 */
public class Reservation extends JFrame {
	public Reservation() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mun
		frame1 = new JFrame();
		label1 = new JLabel();
		scrollPane1 = new JScrollPane();
		textArea1 = new JTextArea();
		label2 = new JLabel();
		scrollPane5 = new JScrollPane();
		textArea3 = new JTextArea();
		label3 = new JLabel();
		scrollPane4 = new JScrollPane();
		textPane1 = new JTextPane();
		button1 = new JButton();

		//======== frame1 ========
		{
			frame1.setTitle("Review");
			Container frame1ContentPane = frame1.getContentPane();
			frame1ContentPane.setLayout(new MigLayout(
					"hidemode 3",
					// columns
					"[fill]" +
							"[fill]" +
							"[fill]" +
							"[92,fill]" +
							"[fill]" +
							"[fill]" +
							"[fill]" +
							"[fill]",
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

			//---- label1 ----
//			label1.setText("\uc2dd\ub2f9\uba85");
//			frame1ContentPane.add(label1, "cell 1 1");
//
//			//======== scrollPane1 ========
//			{
//
//				//---- textArea1 ----
//				textArea1.setText("A\uc2dd\ub2f9");
//				scrollPane1.setViewportView(textArea1);
//			}
//			frame1ContentPane.add(scrollPane1, "cell 2 1 2 1");

			//---- label2 ----
			label2.setText("인원수");
			frame1ContentPane.add(label2, "cell 1 2");

			//======== scrollPane5 ========
			{
				scrollPane5.setViewportView(textArea3);
			}
			frame1ContentPane.add(scrollPane5, "cell 2 2");

			//---- label3 ----
			label3.setText("시간");
			frame1ContentPane.add(label3, "cell 1 4");

			//======== scrollPane4 ========
			{
				scrollPane4.setViewportView(textPane1);
			}
			frame1ContentPane.add(scrollPane4, "cell 1 5 3 1");

			//---- button1 ----
			button1.setText("예약하기");
			frame1ContentPane.add(button1, "cell 6 11");

			button1.addActionListener(e->{
				int nop =  Integer.parseInt(textArea3.getText());
				String time = textPane1.getText();
				if(DBSQLHandler.GetInstance().PutReservation(mainWindow.user_id, RestaurantInformation.res_id, nop, time) == 1)
				{
					JOptionPane.showMessageDialog(null, "예약 성공!");
					frame1.setVisible(false);
					frame1.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "예약 실패");
				}
			});

			frame1.pack();
			frame1.setLocationRelativeTo(frame1.getOwner());
			frame1.setVisible(true);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mun
	private JFrame frame1;
	private JLabel label1;
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
	private JLabel label2;
	private JScrollPane scrollPane5;
	private JTextArea textArea3;
	private JLabel label3;
	private JScrollPane scrollPane4;
	private JTextPane textPane1;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
