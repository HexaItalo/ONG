
package view;

import model.Voluntario;
import controller.VoluntarioController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TelaVoluntario extends javax.swing.JFrame {

    JTextField txtNome;
    JTextField txtContato;
    JTextField txtArea;
    JTextField txtDisponibilidade;
    JTable tabela;
    DefaultTableModel modelo;
    VoluntarioController controller;

    public TelaVoluntario() {
        controller = new VoluntarioController();

        setTitle("Cadastro de Voluntários");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNome = new JLabel("Nome:");
        JLabel lblContato = new JLabel("Contato:");
        JLabel lblArea = new JLabel("Área de Atuação:");
        JLabel lblDisponibilidade = new JLabel("Disponibilidade:");

        txtNome = new JTextField();
        txtContato = new JTextField();
        txtArea = new JTextField();
        txtDisponibilidade = new JTextField();

        JButton btnSalvar = new JButton("Salvar");

        lblNome.setBounds(10, 10, 120, 25);
        txtNome.setBounds(150, 10, 350, 25);

        lblContato.setBounds(10, 45, 120, 25);
        txtContato.setBounds(150, 45, 350, 25);

        lblArea.setBounds(10, 80, 120, 25);
        txtArea.setBounds(150, 80, 350, 25);

        lblDisponibilidade.setBounds(10, 115, 120, 25);
        txtDisponibilidade.setBounds(150, 115, 350, 25);

        btnSalvar.setBounds(150, 150, 100, 30);

        add(lblNome); add(txtNome);
        add(lblContato); add(txtContato);
        add(lblArea); add(txtArea);
        add(lblDisponibilidade); add(txtDisponibilidade);
        add(btnSalvar);

        modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Contato");
        modelo.addColumn("Área");
        modelo.addColumn("Disponibilidade");

        tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(10, 200, 650, 350);
        add(scrollPane);

        btnSalvar.addActionListener(e -> salvarVoluntario());
        
        carregarVoluntarios();
    }
    
    private void carregarVoluntarios() {
    for (Voluntario v : controller.listarVoluntarios()) {
        modelo.addRow(new Object[]{
            v.getNome(),
            v.getContato(),
            v.getAreaAtuacao(),
            v.getDisponibilidade()
        });
    }
}

    private void salvarVoluntario() {
        String nome = txtNome.getText();
        String contato = txtContato.getText();
        String area = txtArea.getText();
        String disponibilidade = txtDisponibilidade.getText();

        if (nome.isEmpty() || contato.isEmpty() || area.isEmpty() || disponibilidade.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
            return;
        }

        Voluntario v = new Voluntario(nome, contato, area, disponibilidade);
        controller.adicionarVoluntario(v);
        modelo.addRow(new Object[]{nome, contato, area, disponibilidade});
        limparCampos();
    }

    private void limparCampos() {
        txtNome.setText("");
        txtContato.setText("");
        txtArea.setText("");
        txtDisponibilidade.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaVoluntario().setVisible(true);
        });
    }
}
