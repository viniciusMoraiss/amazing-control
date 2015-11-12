package amazingcontrol.swing.view.utils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

public class PopupMouseAdapter extends MouseAdapter {

	private JPopupMenu menu;

	public PopupMouseAdapter(JPopupMenu menu) {
		super();
		this.menu = menu;
	}

	public void mousePressed(MouseEvent evt) {
		if (evt.isPopupTrigger()) {
			menu.show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}

	public void mouseReleased(MouseEvent evt) {
		if (evt.isPopupTrigger()) {
			menu.show(evt.getComponent(), evt.getX(), evt.getY());
		}
	}
}