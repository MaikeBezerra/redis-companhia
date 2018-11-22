package br.ufc.persistencia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.ufc.persistencia.Entity.Departamento;
import br.ufc.persistencia.Entity.Projeto;
import br.ufc.persistencia.dao.DepartamentoDao;
import br.ufc.persistencia.dao.ProjetoDao;

public class ProjetoView {

	private DepartamentoDao depDAO = new DepartamentoDao();
	private ProjetoDao projDAO = new ProjetoDao();
	private Projeto projeto;
	
	private JFrame frmProjeto;
	private JTextField txtNome;
	private JTextField txtPeriodo;

	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjetoView window = new ProjetoView();
					window.frmProjeto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProjetoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProjeto = new JFrame();
		frmProjeto.setTitle("Projeto");
		frmProjeto.setBounds(100, 100, 450, 177);
		frmProjeto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmProjeto.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(24, 12, 70, 15);
		frmProjeto.getContentPane().add(lblNome);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setBounds(331, 12, 70, 15);
		frmProjeto.getContentPane().add(lblPeriodo);
		
		JLabel lblDepartamento = new JLabel("Departamentos");
		lblDepartamento.setBounds(24, 61, 122, 15);
		frmProjeto.getContentPane().add(lblDepartamento);
		
		txtNome = new JTextField();
		txtNome.setBounds(24, 30, 291, 19);
		frmProjeto.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setBounds(331, 28, 58, 19);
		frmProjeto.getContentPane().add(txtPeriodo);
		txtPeriodo.setColumns(10);
		
		JComboBox<String> cmbBxDepartamento = new JComboBox<String>();
		cmbBxDepartamento.setBounds(24, 74, 291, 24);
		cmbBxDepartamento.setModel(new DefaultComboBoxModel<String>(depDAO.departamentos()));
		frmProjeto.getContentPane().add(cmbBxDepartamento);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			
				if (!txtNome.getText().equals(""))
					projeto = projDAO.buscar(txtNome.getText());
					
				if (projeto == null) {
					JOptionPane.showMessageDialog(null, "Projeto não encontrado");
					txtNome.setText("");
				} else {
					txtNome.setText(projeto.getNome());
					txtPeriodo.setText(Integer.toString(projeto.getPeriodo()));
					Departamento dep = projeto.getDepartamento();
					cmbBxDepartamento.setSelectedItem(dep.getNome());
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon("./images/icons/magnifier (1).png"));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(399, 25, 33, 24);
		frmProjeto.getContentPane().add(btnBuscar);
		
		
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon("./images/icons/save.png"));
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
								
				String nome = txtNome.getText();
				int periodo = Integer.parseInt(txtPeriodo.getText());
				
				String nomeDepartamento = cmbBxDepartamento.getSelectedItem().toString();
				Departamento departamento = new Departamento(nomeDepartamento);
									
				if (!nome.equals("")) {
					projeto = new Projeto(nome, periodo, departamento);
					projDAO.salva(projeto);
					JOptionPane.showMessageDialog(null, "Projeto salvo com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio");
				}
					
			}
		});
		btnSalvar.setBounds(356, 74, 33, 25);
		frmProjeto.getContentPane().add(btnSalvar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtNome.getText().equals("")){
					projDAO.delete(txtNome.getText());
					JOptionPane.showMessageDialog(null, "Projeto excluido");
				} else 
					JOptionPane.showMessageDialog(null, "Preencha o campo Nome");
			}
		});
		btnExcluir.setIcon(new ImageIcon("./images/icons/bin.png"));
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setBounds(399, 73, 33, 25);
		frmProjeto.getContentPane().add(btnExcluir);
	}
}
