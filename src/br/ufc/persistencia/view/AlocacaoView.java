package br.ufc.persistencia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import br.ufc.persistencia.Entity.Funcionario;
import br.ufc.persistencia.Entity.Projeto;
import br.ufc.persistencia.dao.FuncionarioDao;
import br.ufc.persistencia.dao.ProjetoDao;
import br.ufc.persistencia.view.field.FieldInteger;
import br.ufc.persistencia.view.field.StringField;

public class AlocacaoView {

	private JFrame frmAlocacaoDePesquisadores;
	private JTextField txtNome;
	private JTextField txtIdPesq;
	private JTextField txtNomePesq;
	private JTextField txtHoras;

	/**
	 * Launch the application.
	 */
	public void open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlocacaoView window = new AlocacaoView();
					window.frmAlocacaoDePesquisadores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlocacaoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ProjetoDao projDAO = new ProjetoDao();
		FuncionarioDao funcDAO = new FuncionarioDao();
		
		FieldInteger integer = new FieldInteger();
		StringField string = new StringField();
		
		frmAlocacaoDePesquisadores = new JFrame();
		frmAlocacaoDePesquisadores.setBounds(100, 100, 534, 432);
		frmAlocacaoDePesquisadores.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAlocacaoDePesquisadores.getContentPane().setLayout(null);
		
		JList<String> list = new JList<String>();
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.RED));
		list.setBounds(44, 293, 444, 99);
		frmAlocacaoDePesquisadores.getContentPane().add(list);
		
		JPanel pnlProjeto = new JPanel();
		pnlProjeto.setLayout(null);
		pnlProjeto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.RED));
		pnlProjeto.setBounds(44, 47, 444, 62);
		frmAlocacaoDePesquisadores.getContentPane().add(pnlProjeto);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 12, 70, 15);
		pnlProjeto.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.addKeyListener(string);
		txtNome.setColumns(10);
		txtNome.setBounds(12, 31, 365, 19);
		pnlProjeto.add(txtNome);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto projeto;
				
				if (!txtNome.getText().equals("")) {
					projeto = projDAO.buscar(txtNome.getText());
					if (projeto == null) {
						JOptionPane.showMessageDialog(null, "Projeto não encontrado");
						txtNome.setText("");
						list.setListData(new String[0]);
					} else {
						txtNome.setText(projeto.getNome());
						list.setListData(projDAO.pesquisadores(projeto.getNome()));
					}
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon("./images/icons/magnifier (1).png"));
		btnBuscar.setBounds(382, 24, 41, 25);
		pnlProjeto.add(btnBuscar);
		
		JLabel lblProjeto = new JLabel("Projeto");
		lblProjeto.setFont(new Font("Dialog", Font.BOLD, 14));
		lblProjeto.setBounds(45, 20, 70, 15);
		frmAlocacaoDePesquisadores.getContentPane().add(lblProjeto);
		
		JLabel lblPesquisadores = new JLabel("Pesquisadores");
		lblPesquisadores.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPesquisadores.setBounds(44, 273, 137, 15);
		frmAlocacaoDePesquisadores.getContentPane().add(lblPesquisadores);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtNome.getText().equals("") && !txtNomePesq.getText().equals("")) {
					projDAO.addPesquisador(txtNome.getText(), txtNomePesq.getText());
				} else {
					JOptionPane.showMessageDialog(null, "Erro");
				}
			}
		});
		btnAdicionar.setIcon(new ImageIcon("./images/icons/plus (2).png"));
		btnAdicionar.setBounds(127, 229, 40, 32);
		frmAlocacaoDePesquisadores.getContentPane().add(btnAdicionar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = list.getSelectedValue().toString();
				if (!list.isSelectionEmpty()) {
					projDAO.removePesquisador(txtNome.getText(), nome);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um pesquisador na lista");
				}
			}
		});
		btnExcluir.setIcon(new ImageIcon("./images/icons/bin.png"));
		btnExcluir.setBounds(182, 229, 40, 32);
		frmAlocacaoDePesquisadores.getContentPane().add(btnExcluir);
		
		JPanel pnlPesquisador = new JPanel();
		pnlPesquisador.setLayout(null);
		pnlPesquisador.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.RED));
		pnlPesquisador.setBounds(44, 150, 444, 62);
		frmAlocacaoDePesquisadores.getContentPane().add(pnlPesquisador);
		
		JLabel lblCpfPesq = new JLabel("CPF");
		lblCpfPesq.setBounds(12, 12, 70, 15);
		pnlPesquisador.add(lblCpfPesq);
		
		JLabel lblNomePesq = new JLabel("Nome");
		lblNomePesq.setBounds(94, 12, 70, 15);
		pnlPesquisador.add(lblNomePesq);
		
		txtIdPesq = new JTextField();
		txtIdPesq.addKeyListener(integer);
		txtIdPesq.setColumns(10);
		txtIdPesq.setBounds(13, 29, 70, 19);
		pnlPesquisador.add(txtIdPesq);
		
		txtNomePesq = new JTextField();
		txtNomePesq.addKeyListener(string);
		txtNomePesq.setColumns(10);
		txtNomePesq.setBounds(94, 30, 285, 19);
		pnlPesquisador.add(txtNomePesq);
		
		JButton btnBuscaPesq = new JButton("");
		btnBuscaPesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtIdPesq.getText().equals("")) {
					Funcionario funcionario;
					funcionario = funcDAO.pesquisador(txtIdPesq.getText());
					if (funcionario != null) {
						txtNomePesq.setText(funcionario.getNome());
					} else {
						JOptionPane.showMessageDialog(null, "Pesquisador não encontrado");
					}
				}
				
			}
		});
		btnBuscaPesq.setIcon(new ImageIcon("./images/icons/magnifier (1).png"));
		btnBuscaPesq.setBounds(386, 23, 41, 25);
		pnlPesquisador.add(btnBuscaPesq);
		
		txtHoras = new JTextField();
		txtHoras.addKeyListener(integer);
		txtHoras.setBounds(45, 242, 70, 19);
		frmAlocacaoDePesquisadores.getContentPane().add(txtHoras);
		txtHoras.setColumns(10);
		
		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setBounds(45, 224, 70, 15);
		frmAlocacaoDePesquisadores.getContentPane().add(lblHoras);
		
		JLabel lblNewLabel = new JLabel("Pesquisador");
		lblNewLabel.setBounds(44, 121, 96, 15);
		frmAlocacaoDePesquisadores.getContentPane().add(lblNewLabel);
	}
}
