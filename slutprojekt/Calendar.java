package slutprojekt;

import javax.swing.*;
import java.time.LocalDate;

public class Calendar {
	Calendar() {
		JFrame frame = new JFrame("Calendar");
		JPanel totalGUI = new JPanel();
		JPanel mainPanel = new JPanel();

		LocalDate todaysDate = LocalDate.now();
		int todaysIndex = todaysDate.getDayOfWeek().getValue();
		LocalDate startDate = todaysDate.minusDays(todaysIndex - 1);

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));

		for (int i = 0; i < 7; i++) {
			LocalDate date = startDate.plusDays(i);
			mainPanel.add(new Day(date, todaysDate.equals(date), 150, 600));
		}

		totalGUI.add(mainPanel);

		frame.setLocationRelativeTo(null);
		frame.setContentPane(totalGUI);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
