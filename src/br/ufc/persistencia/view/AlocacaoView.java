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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import br.ufc.persistencia.view.field.FieldInteger;
import br.ufc.persistencia.view.field.StringField;

public class AlocacaoView {

	private JFrame frmAlocacaoDePesquisadores;
	private JTextField txtId;
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
		
		FieldInteger integer = new FieldInteger();
		StringField string = new StringField();
		
		frmAlocacaoDePesquisadores = new JFrame();
		frmAlocacaoDePesquisadores.setBounds(100, 100, 608, 432);
		frmAlocacaoDePesquisadores.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAlocacaoDePesquisadores.getContentPane().setLayout(null);
		
		JPanel pnlProjeto = new JPanel();
		pnlProjeto.setLayout(null);
		pnlProjeto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.RED));
		pnlProjeto.setBounds(44, 47, 517, 62);
		frmAlocacaoDePesquisadores.getContentPane().add(pnlProjeto);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(12, 12, 70, 15);
		pnlProjeto.add(lblId);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(94, 12, 70, 15);
		pnlProjeto.add(lblNome);
		
		txtId = new JTextField();
		txtId.addKeyListener(integer);
		txtId.setColumns(10);
		txtId.setBounds(13, 29, 70, 19);
		pnlProjeto.add(txtId);
		
		txtNome = new JTextField();
		txtNome.addKeyListener(string);
		txtNome.setColumns(10);
		txtNome.setBounds(94, 30, 365, 19);
		pnlProjeto.add(txtNome);
		
		JList<String> list = new JList<String>();
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.RED));
		list.setBounds(44, 143, 444, 99);
		frmAlocacaoDePesquisadores.getContentPane().add(list);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBuscar.setIcon(new ImageIcon("./images/icons/magnifier (1).png"));
		btnBuscar.setBounds(464, 23, 41, 25);
		pnlProjeto.add(btnBuscar);
		
		JLabel lblProjeto = new JLabel("Projeto");
		lblProjeto.setFont(new Font("Dialog", Font.BOLD, 14));
		lblProjeto.setBounds(45, 20, 70, 15);
		frmAlocacaoDePesquisadores.getContentPane().add(lblProjeto);
		
		JLabel lblPesquisadores = new JLabel("Pesquisadores");
		lblPesquisadores.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPesquisadores.setBounds(44, 125, 137, 15);
		frmAlocacaoDePesquisadores.getContentPane().add(lblPesquisadores);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnAdicionar.setIcon(new ImageIcon("./images/icons/plus (2).png"));
		btnAdicionar.setBounds(140, 333, 40, 32);
		frmAlocacaoDePesquisadores.getContentPane().add(btnAdicionar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = list.getSelectedValue().toString();
				if (!list.isSelectionEmpty()) {
					
				}
			}
		});
		btnExcluir.setIcon(new ImageIcon("./images/icons/bin.png"));
		btnExcluir.setBounds(510, 178, 40, 32);
		frmAlocacaoDePesquisadores.getContentPane().add(btnExcluir);
		
		JPanel pnlPesquisador = new JPanel();
		pnlPesquisador.setLayout(null);
		pnlPesquisador.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, Color.RED));
		pnlPesquisador.setBounds(44, 254, 517, 62);
		frmAlocacaoDePesquisadores.getContentPane().add(pnlPesquisador);
		
		JLabel lblIdPesq = new JLabel("ID");
		lblIdPesq.setBounds(12, 12, 70, 15);
		pnlPesquisador.add(lblIdPesq);
		
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
		txtNomePesq.setBounds(94, 30, 365, 19);
		pnlPesquisador.add(txtNomePesq);
		
		JButton btnBuscaPesq = new JButton("");
		btnBuscaPesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBuscaPesq.setIcon(new ImageIcon("./images/icons/magnifier (1).png"));
		btnBuscaPesq.setBounds(464, 23, 41, 25);
		pnlPesquisador.add(btnBuscaPesq);
		
		txtHoras = new JTextField();
		txtHoras.addKeyListener(integer);
		txtHoras.setBounds(58, 346, 70, 19);
		frmAlocacaoDePesquisadores.getContentPane().add(txtHoras);
		txtHoras.setColumns(10);
		
		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setBounds(58, 328, 70, 15);
		frmAlocacaoDePesquisadores.getContentPane().add(lblHoras);
	}
}
