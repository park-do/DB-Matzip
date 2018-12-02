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
		// Generated using JFormDesigner Evaluation license - leejongha
		scrollPane1 = new JScrollPane();
		list1 = new JList();
		button1 = new JButton();
		list2 = new JList();
		label2 = new JLabel();
		label3 = new JLabel();

		//======== this ========
		setTitle("Reservation");
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(list1);
		}
		contentPane.add(scrollPane1);
		scrollPane1.setBounds(115, 5, 260, 125);

		//---- button1 ----
		button1.setText("\uc608\uc57d \ud558\uae30");
		contentPane.add(button1);
		button1.setBounds(25, 225, 350, 30);
		contentPane.add(list2);
		list2.setBounds(115, 145, 260, 65);

		//---- label2 ----
		label2.setText("\uc608\uc57d \uc2dc\uac04");
		label2.setFont(new Font("\ub098\ub214\uace0\ub515 ExtraBold", Font.BOLD, 16));
		contentPane.add(label2);
		label2.setBounds(30, 160, 100, 35);

		//---- label3 ----
		label3.setText("\uc2dd\ub2f9 \ubaa9\ub85d");
		label3.setFont(new Font("\ub098\ub214\uace0\ub515 ExtraBold", Font.BOLD, 16));
		contentPane.add(label3);
		label3.setBounds(25, 40, 100, 35);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		pack();
		setLocationRelativeTo(getOwner());
		setVisible(true);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - leejongha
	private JScrollPane scrollPane1;
	private JList list1;
	private JButton button1;
	private JList list2;
	private JLabel label2;
	private JLabel label3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
