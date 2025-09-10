package br.com.fiap.main;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Carro;

import java.sql.Connection;
import java.util.ArrayList;

public class TesteRead {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();
        CarroDAO carroDAO = new CarroDAO(con);
        ArrayList<Carro> resultado = carroDAO.listarTodos();
        if (resultado != null) {
            for (Carro carro : resultado) {
                System.out.println("Placa: " + carro.getPlaca());
                System.out.println("Cor: " + carro.getCor());
                System.out.println("Descrição: " + carro.getDescricao());
                System.out.println();
            }
        }
        ConnectionFactory.fecharConexao(con);
    }
}
