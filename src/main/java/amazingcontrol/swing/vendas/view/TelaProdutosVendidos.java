package amazingcontrol.swing.vendas.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import amazingcontrol.model.ItensVendas;
import amazingcontrol.model.Usuario;
import amazingcontrol.service.ItensVendasService;
import amazingcontrol.swing.principal.view.TelaPrincipal;

public class TelaProdutosVendidos extends JDialog {

	private TelaPrincipal view;
	private JTable itensVendidosJTable;

	// Construtor
	public TelaProdutosVendidos(TelaPrincipal view) {
		this.view = view;
		
		initComponents();
		initPainel();

		setTitle("[A-CONTROL] Cadastro de usuarios");
		setSize(830, 320);
		setResizable(false);
		setLocationRelativeTo(view);
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setModal(true);
		setAlwaysOnTop(true);

		// carrega usuarios ao abrir a tela
		carregarProdutosVendidos();
	}

	// Getters and setters
	public JFrame getView() {
		return view;
	}

	public JTable getUsuariosJTable() {
		return itensVendidosJTable;
	}

	public TableModel getModel() {
		return getUsuariosJTable().getModel();
	}

	public Usuario getUsuario() {
		return view.getUsuario();
	}
	
	// Outros metodos
	private void initComponents() {
		itensVendidosJTable = new JTable(new DefaultTableModel(new Object[0][0], createColumnNames()));
	}

	private Object[] createColumnNames() {
		return new Object[] { "Produto", "Tipo", "Valor Unitario", "Quantidade Vendida", "Valor Total", "Cliente", "Usuario", "Data" };
	}

	private void initPainel() {
		JPanel painel = new JPanel(new GridBagLayout());

		painel.add(new JScrollPane(itensVendidosJTable), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 800, 250));
		
		// configura borda
		painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Produtos vendidos"));

		add(painel);
	}
	
	public void carregarProdutosVendidos() {
		try {
			List<ItensVendas> itensVendidos = new ItensVendasService().listVendas();
			
			DefaultTableModel model;

			model = (DefaultTableModel) itensVendidosJTable.getModel();

			model.getDataVector().clear();

			for (ItensVendas itensVendas: itensVendidos) {
				
				Calendar date = itensVendas.getVenda().getDate();
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				
				String data = sdf.format(date.getTime());
				
				model.addRow(new Object[] { itensVendas.getProduto(), itensVendas.getProduto().getTipo(), 
						itensVendas.getProduto().getValorVenda(), itensVendas.getQuantidade(), itensVendas.getValorTotal(),
						itensVendas.getVenda().getCliente(), itensVendas.getVenda().getUsuario(), data});
			}

			itensVendidosJTable.updateUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
