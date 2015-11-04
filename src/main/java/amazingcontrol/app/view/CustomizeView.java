package amazingcontrol.app.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CustomizeView {

	/*
	 * Metodo para customizar inputs
	 */
	public static void labelsAndInputs(JLabel label, JTextField textField) {
		label.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 14));
		textField.setPreferredSize(new Dimension(200,30));
		textField.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 14));
	}
}