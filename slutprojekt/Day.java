package slutprojekt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Day extends JPanel implements ActionListener {
	private JTextField tf;
	private JPanel activityPanel;
	private JPanel bottomPanel;

	Day(LocalDate date, boolean highlight, int widthSize, int heightSize) {
		super();
		JLabel weekday = new JLabel(date.getDayOfWeek().toString());
		String dateString = date.getMonth().toString() + " " + date.getDayOfMonth();
		JLabel dateLabel = new JLabel(dateString);
		JButton button = new JButton("Add Activity");
		tf = new JTextField(12);
		Color color = Color.LIGHT_GRAY;

		tf.setMinimumSize(tf.getPreferredSize());
		tf.setMaximumSize(tf.getPreferredSize());
		tf.setAlignmentX(CENTER_ALIGNMENT);

		weekday.setAlignmentX(CENTER_ALIGNMENT);
		dateLabel.setAlignmentX(CENTER_ALIGNMENT);

		button.setAlignmentX(CENTER_ALIGNMENT);
		button.addActionListener(this);

		activityPanel = new JPanel();
		activityPanel.setLayout(new BoxLayout(activityPanel, BoxLayout.PAGE_AXIS));
		activityPanel.setMinimumSize(new Dimension(widthSize, 500));
		activityPanel.setMaximumSize(new Dimension(widthSize, 500));
		activityPanel.setPreferredSize(new Dimension(widthSize, 500));
		activityPanel.setAlignmentX(CENTER_ALIGNMENT);
		activityPanel.setBackground(color);

		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));
		bottomPanel.setMinimumSize(new Dimension(widthSize, 150));
		bottomPanel.setMaximumSize(new Dimension(widthSize, 150));
		bottomPanel.setPreferredSize(new Dimension(widthSize, 150));
		bottomPanel.setAlignmentX(CENTER_ALIGNMENT);
		bottomPanel.setBackground(color);

		if (highlight) {
			color = Color.cyan;
		}

		super.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		super.setMinimumSize(new Dimension(widthSize, heightSize));
		super.setMaximumSize(new Dimension(widthSize, heightSize));
		super.setPreferredSize(new Dimension(widthSize, heightSize));
		super.setBackground(color);
		super.add(Box.createRigidArea(new Dimension(0, 7)));
		super.add(weekday);
		super.add(dateLabel);
		super.add(Box.createRigidArea(new Dimension(0, 10)));
		super.add(activityPanel);
		super.add(bottomPanel);
		bottomPanel.add(tf);
		bottomPanel.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JLabel l = new JLabel(tf.getText());
		activityPanel.add(l);
		activityPanel.add(Box.createRigidArea(new Dimension(0, 3)));
		tf.setText("");
		activityPanel.validate();
	}
}