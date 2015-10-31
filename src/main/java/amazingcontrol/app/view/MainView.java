package amazingcontrol.app.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainView extends JFrame {

	public MainView() {
		super("[A-CONTROL] Controle de estoque");

		initComponents();

		setSize(750, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initComponents() {
		setJMenuBar(createMenu());
	}

	private JMenuBar createMenu() {
		JMenuBar menuBar;
		menuBar = new JMenuBar();
		// adiciona menu de produtos
		menuProdutos(menuBar);
		
		// adiciona menu de vendass
		menuVendas(menuBar);

		return menuBar;
	}

	private void menuVendas(JMenuBar menuBar) {
		JMenu menu;
		JMenuItem menuItem;
		menu = new JMenu("Vendas");
		menuBar.add(menu);

		menuItem = new JMenuItem("Cadastrar de produtos");
		// menuItem.addActionListener(new MenuClienteAction(this));
		menu.add(menuItem);

		menuItem = new JMenuItem("Consultar estoque");
		// menuItem.addActionListener(new MenuBairroAction(this));
		menu.add(menuItem);
	}

	private void menuProdutos(JMenuBar menuBar) {
		JMenu menu;
		JMenuItem menuItem;
		menu = new JMenu("Produtos");
		menuBar.add(menu);

		menuItem = new JMenuItem("Cadastrar de produtos");
		// menuItem.addActionListener(new MenuClienteAction(this));
		menu.add(menuItem);

		menuItem = new JMenuItem("Consultar estoque");
		// menuItem.addActionListener(new MenuBairroAction(this));
		menu.add(menuItem);
	}

}
