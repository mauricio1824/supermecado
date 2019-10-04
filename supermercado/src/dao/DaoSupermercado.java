/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Supermercado;
import java.sql.Date;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDate;

public class DaoSupermercado {
    public static boolean inserir(Supermercado objeto) {
        String sql = "INSERT INTO supermercado (nome_fantasia, razao_social, fundacao, n_funcionarios, valor_bolsa) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome_fantasia());
            ps.setString(2, objeto.getRazao_social());
            ps.setDate(3, Date.valueOf(objeto.getFundacao())); //fazer a seguinte importação: java.sql.Date
            ps.setInt(4, objeto.getN_funcionarios());
            ps.setDouble(5, objeto.getValor_bolsa());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        Supermercado objeto = new Supermercado();
        objeto.setNome_fantasia("Casa do Chimarrão");
        objeto.setRazao_social("Supermercado Casa do Chimarrão");
        objeto.setFundacao(LocalDate.parse("11/01/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy"))); //fazer as seguintes importações: java.time.format.DateTimeFormatter e java.time.LocalDate
        objeto.setN_funcionarios(15);
        objeto.setValor_bolsa(1.50);
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}
