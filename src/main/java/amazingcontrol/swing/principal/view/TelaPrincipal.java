package amazingcontrol.swing.principal.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import amazingcontrol.model.Usuario;
import amazingcontrol.swing.principal.action.TelaFornecedorAction;
import amazingcontrol.swing.produto.action.MenuCadastroProdutoAction;
import amazingcontrol.swing.usuario.action.TelaAlterarSenhaUsuarioAction;
import amazingcontrol.swing.usuario.action.TelaUsuarioAction;

/**
 * Classe que representa a tela principal, chamada após o usuario fazer login.
 */
public class TelaPrincipal extends JFrame {

	/**
	 * varivael usuario que representa o usuario logado
	 */
	private Usuario usuario;

	/**
	 * Recebe o usuario logado no parametro. Assim é possivel recuperar o
	 * usuario em outras telas, se necessario
	 * 
	 * @param usuario
	 */
	public TelaPrincipal(Usuario usuario) {
		// configura nome da tela
		super("[A-CONTROL] Controle de estoque");

		// recupera o usuario
		this.usuario = usuario;

		// inicia os componentes
		initComponents();

		// configura o tamanho da janela
		setSize(750, 500);

		// para centralizar no centro da tela
		setLocationRelativeTo(null);

		// sai da aplicação por padrão
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * metodo para recuperar usuario
	 * 
	 * @return
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Inicia os componentes. No caso apenas cria o menu chamando o metodo
	 * privado de criação do menu
	 */
	private void initComponents() {
		setJMenuBar(createMenu());
	}
	
	/**
	 * Metodo que cria o menu
	 * @return menuBar
	 */
	private JMenuBar createMenu() {
		JMenuBar menuBar;
		menuBar = new JMenuBar();

		// adiciona menu de produtos
		menuProdutos(menuBar);

		// adiciona menu de vendas
		menuVendas(menuBar);

		// adiciona menu de usuarios
		menuOpcoesUsuario(menuBar);

		// adiciona menu de fornecedores
		menuOpcoesFornecedores(menuBar);

		return menuBar;
	}
	
	/**
	 * Monta o menu de vendas
	 * @param menuBar
	 */
	private void menuVendas(JMenuBar menuBar) {
		JMenu menu;
		JMenuItem menuItem;
		menu = new JMenu("Vendas");
		menuBar.add(menu);

		menuItem = new JMenuItem("Cadastrar de vendas");
		// menuItem.addActionListener(new MenuCadastroProdutoAction(this));
		menu.add(menuItem);

		menuItem = new JMenuItem("Consultar vendas");
		// menuItem.addActionListener(new MenuBairroAction(this));
		menu.add(menuItem);
	}
	
	/**
	 * Monta menu de produtos
	 * @param menuBar
	 */
	private void menuProdutos(JMenuBar menuBar) {
		JMenu menu;
		JMenuItem menuItem;
		menu = new JMenu("Produtos");
		menuBar.add(menu);

		menuItem = new JMenuItem("Cadastrar de produtos");
		menuItem.addActionListener(new MenuCadastroProdutoAction(this));
		menu.add(menuItem);

		// menuItem = new JMenuItem("Consultar estoque");
		// menuItem.addActionListener(new MenuBairroAction(this));
		// menu.add(menuItem);
	}
	
	/**
	 * Monta menu com opções do usuario
	 * @param menuBar
	 */
	private void menuOpcoesUsuario(JMenuBar menuBar) {
		JMenu menu;
		JMenuItem menuItem;
		menu = new JMenu("Opcões de Usuario");
		menuBar.add(menu);

		menuItem = new JMenuItem("Consulta usuarios");
		menuItem.addActionListener(new TelaUsuarioAction(this));
		menu.add(menuItem);

		menuItem = new JMenuItem("Alterar minha senha");
		menuItem.addActionListener(new TelaAlterarSenhaUsuarioAction(this));
		menu.add(menuItem);
	}
	
	/**
	 * Monta menu de Fornecedores
	 * @param menuBar
	 */
	private void menuOpcoesFornecedores(JMenuBar menuBar) {
		JMenu menu;
		JMenuItem menuItem;
		menu = new JMenu("Fornecedores");
		menuBar.add(menu);

		menuItem = new JMenuItem("Consulta fornecedores");
		menuItem.addActionListener(new TelaFornecedorAction(this));
		menu.add(menuItem);
	}
}
