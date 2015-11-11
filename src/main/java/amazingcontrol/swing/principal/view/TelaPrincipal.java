package amazingcontrol.swing.principal.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import amazingcontrol.swing.produto.action.MenuCadastroProdutoAction;
import amazingcontrol.swing.usuario.action.UsuarioAction;

public class TelaPrincipal extends JFrame {

	public TelaPrincipal() {
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
		
		// adiciona menu de vendas
		menuVendas(menuBar);
		
		// adiciona menu de usuarios
		menuOpcoesUsuario(menuBar);

		return menuBar;
	}

	private void menuVendas(JMenuBar menuBar) {
		JMenu menu;
		JMenuItem menuItem;
		menu = new JMenu("Vendas");
		menuBar.add(menu);

		menuItem = new JMenuItem("Cadastrar de vendas");
		//menuItem.addActionListener(new MenuCadastroProdutoAction(this));
		menu.add(menuItem);

		menuItem = new JMenuItem("Consultar vendas");
		// menuItem.addActionListener(new MenuBairroAction(this));
		menu.add(menuItem);
	}

	private void menuProdutos(JMenuBar menuBar) {
		JMenu menu;
		JMenuItem menuItem;
		menu = new JMenu("Produtos");
		menuBar.add(menu);

		menuItem = new JMenuItem("Cadastrar de produtos");
		menuItem.addActionListener(new MenuCadastroProdutoAction(this));
		menu.add(menuItem);

		menuItem = new JMenuItem("Consultar estoque");
		// menuItem.addActionListener(new MenuBairroAction(this));
		menu.add(menuItem);
	}
	
	private void menuOpcoesUsuario(JMenuBar menuBar) {
		JMenu menu;
		JMenuItem menuItem;
		menu = new JMenu("Opcões de Usuario");
		menuBar.add(menu);

		menuItem = new JMenuItem("usuarios");
		menuItem.addActionListener(new UsuarioAction(this));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Ativar usuario");
		// menuItem.addActionListener(new MenuCadastroUsuarioAction(this));
		menu.add(menuItem);
	}
}
