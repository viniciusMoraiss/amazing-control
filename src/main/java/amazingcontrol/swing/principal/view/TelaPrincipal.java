package amazingcontrol.swing.principal.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import amazingcontrol.model.Usuario;
import amazingcontrol.swing.cliente.action.NovoClienteAction;
import amazingcontrol.swing.cliente.action.TelaClienteAction;
import amazingcontrol.swing.fornecedor.action.NovoFornecedorAction;
import amazingcontrol.swing.fornecedor.action.TelaFornecedorAction;
import amazingcontrol.swing.produto.action.NovoProdutoAction;
import amazingcontrol.swing.produto.action.TelaProdutoAction;
import amazingcontrol.swing.usuario.action.NovoUsuarioAction;
import amazingcontrol.swing.usuario.action.TelaAlterarSenhaUsuarioAction;
import amazingcontrol.swing.usuario.action.TelaUsuarioAction;
import amazingcontrol.swing.vendas.action.TelaVendasAction;

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
		
		// todos os cadastros
		menuCadastros(menuBar);
		
		// todas as consultas
		menuConsulta(menuBar);

		/*
		// adiciona menu de produtos
		menuProdutos(menuBar);

		// adiciona menu de fornecedores
		menuOpcoesFornecedores(menuBar);
		
		// menu clientes
		menuClientes(menuBar);
		*/
		
		// menu vendas
		menuOpcoesVendas(menuBar);
		
		// adiciona menu de usuarios
		menuOpcoesUsuario(menuBar);
		
		return menuBar;
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
		menuItem.addActionListener(new TelaProdutoAction(this));
		menu.add(menuItem);
	}
	
	/**
	 * Monta menu de produtos
	 * @param menuBar
	 */
	private void menuCadastros(JMenuBar menuBar) {
		JMenu menu;
		JMenuItem menuItem;
		menu = new JMenu("Cadastros");
		menuBar.add(menu);
		
		
		menuItem = new JMenuItem("Cadastrar de usuarios");
		menuItem.addActionListener(new NovoUsuarioAction(null));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Cadastrar de fornecedores");
		menuItem.addActionListener(new NovoFornecedorAction(null));
		menu.add(menuItem);

		menuItem = new JMenuItem("Cadastrar de produtos");
		menuItem.addActionListener(new NovoProdutoAction(null));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Cadastrar de clientes");
		menuItem.addActionListener(new NovoClienteAction(null));
		menu.add(menuItem);
	}
	
	/**
	 * Monta menu de consultas
	 * @param menuBar
	 */
	private void menuConsulta(JMenuBar menuBar) {
		JMenu menu;
		JMenuItem menuItem;
		menu = new JMenu("Consultas");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Consultar de Fornecedor");
		menuItem.addActionListener(new TelaFornecedorAction(this));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Consultar de Produtos");
		menuItem.addActionListener(new TelaProdutoAction(this));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Consultar de Clientes");
		menuItem.addActionListener(new TelaClienteAction(this));
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Consultar de Usuarios ");
		menuItem.addActionListener(new TelaClienteAction(this));
		menu.add(menuItem);
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
		
		/*
		menuItem = new JMenuItem("Consulta usuarios");
		menuItem.addActionListener(new TelaUsuarioAction(this));
		menu.add(menuItem);
		*/

		menuItem = new JMenuItem("Alterar minha senha");
		menuItem.addActionListener(new TelaAlterarSenhaUsuarioAction(this));
		menu.add(menuItem);
	}
	
	/**
	 * Monta menu com opções de clientes
	 * @param menuBar
	 */
	private void menuClientes(JMenuBar menuBar) {
		JMenu menu;
		JMenuItem menuItem;
		menu = new JMenu("Clientes");
		menuBar.add(menu);

		menuItem = new JMenuItem("Cadastrar novo cliente");
		menuItem.addActionListener(new TelaClienteAction(this));
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
	
	/**
	 * Monta menu de vendas
	 * @param menuBar
	 */
	private void menuOpcoesVendas(JMenuBar menuBar) {
		JMenu menu;
		JMenuItem menuItem;
		menu = new JMenu("Vendas");
		menuBar.add(menu);

		menuItem = new JMenuItem("Vender");
		menuItem.addActionListener(new TelaVendasAction(usuario));
		menu.add(menuItem);
	}
}
