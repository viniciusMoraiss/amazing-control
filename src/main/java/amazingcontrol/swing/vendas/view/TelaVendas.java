package amazingcontrol.swing.vendas.view;

import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dialog.ModalityType;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import amazingcontrol.swing.view.utils.CustomizeView;

//public class VendasView extends JFrame {

public class TelaVendas extends JFrame {
	private JTextField txtCodigo, txtQuantidade, txtTotal;

	private JLabel lblCodigo, lblQuantidade, lblTotal;

	private JButton btnAdicionar;

	public TelaVendas() {
		super();

		initComponents();
		initPainel();
		// initListeners();

		setTitle(("[A-CONTROL] Vendas"));
		setSize(630, 470);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	/*
	 * getters and setters dos labels
	 */

	public JLabel getLblCodigo() {
		return lblCodigo;
	}

	public JLabel getLblQuantidade() {
		return lblQuantidade;
	}

	public JLabel getLblTotal() {
		return lblTotal;
	}

	public void setLblCodigo(JLabel lblCodigo) {
		this.lblCodigo = lblCodigo;
	}

	public void setLblQuantidade(JLabel lblQuantidade) {
		this.lblQuantidade = lblQuantidade;
	}

	public void setLblTotal1(JLabel lblCodigo) {
		this.lblCodigo = lblCodigo;
	}

	public JTextField getTxtCodigo() {
		return txtCodigo;
	}

	public JTextField getTxtQuantidade() {
		return txtQuantidade;
	}

	public JTextField getTxtTotal() {
		return txtTotal;
	}

	public void setTxtCodigo(JTextField txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public void setTxtQuantidade(JTextField txtQuantidade) {
		this.txtQuantidade = txtQuantidade;
	}

	public void setTxtTotal1(JTextField txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}

	public void setBtnAdicionar(JButton btnAdicionar) {
		this.btnAdicionar = btnAdicionar;
	}

	private void initComponents() {

		lblCodigo = new JLabel("Codigo", SwingConstants.LEFT);
		txtCodigo = new JTextField(10);
		CustomizeView.labelsAndInputs(lblCodigo, txtCodigo);

		lblQuantidade = new JLabel("Quantidade", SwingConstants.LEFT);
		txtQuantidade = new JTextField(10);
		CustomizeView.labelsAndInputs(lblQuantidade, txtQuantidade);

		lblTotal = new JLabel("Total", SwingConstants.LEFT);
		txtTotal = new JTextField(10);
		CustomizeView.labelsAndInputs(lblTotal, txtTotal);

		btnAdicionar = new JButton("Adicionar");

	}

	private void initPainel() {
		JPanel painel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);

		constraints.gridx = 0; // coluna
		constraints.gridy = 0; // linha
		painel.add(lblCodigo, constraints);

		constraints.gridx = 1; // coluna
		painel.add(txtCodigo, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1; // linha
		painel.add(lblQuantidade, constraints);

		constraints.gridx = 1;
		painel.add(txtQuantidade, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2; // linha
		painel.add(lblTotal, constraints);

		constraints.gridx = 1;
		painel.add(txtTotal, constraints);

		constraints.gridx = 1;
		painel.add(btnAdicionar, constraints);

		painel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Vendas"));

		add(painel);

	}

}
