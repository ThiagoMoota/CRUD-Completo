package br.com.fiap.main;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Cliente;

import java.sql.Connection;
import java.util.ArrayList;

public class TesteClienteCRUD {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        Cliente cliente = new Cliente();
        // Criando 1o cliente
        cliente.setIdCliente(1);
        cliente.setNomeCliente("Yuri Alberto");
        cliente.setPlaca("JKK1990");
        System.out.println(clienteDAO.inserir(cliente));
        // Criando 2o cliente
        cliente.setIdCliente(2);
        cliente.setNomeCliente("Roger Guedes");
        cliente.setPlaca("JKK1990");
        System.out.println(clienteDAO.inserir(cliente));
        // Criando 3o cliente
        cliente.setIdCliente(3);
        cliente.setNomeCliente("Rodrigo Garro");
        cliente.setPlaca("JKK1990");
        System.out.println(clienteDAO.inserir(cliente));
        // Criando 4o cliente
        cliente.setIdCliente(4);
        cliente.setNomeCliente("Cássio");
        cliente.setPlaca("JKK1990");
        System.out.println(clienteDAO.inserir(cliente));
        // Alterando um cliente
        cliente.setIdCliente(3);
        cliente.setNomeCliente("Garrinho");
        cliente.setPlaca("JKK1990");
        System.out.println(clienteDAO.alterar(cliente));
        // Excluindo um cliente
        cliente.setIdCliente(2);
        System.out.println(clienteDAO.excluir(cliente));
        // Listando todos os clientes
        ArrayList<Cliente> resultado = clienteDAO.listarTodos();
        if (resultado != null){
            for (Cliente cliente1 : resultado) {
                System.out.printf("Id: %d \nNome: %s \nPlaca: %s \n", cliente1.getIdCliente(),cliente1.getNomeCliente(),cliente1.getPlaca());
            }
        }
        ConnectionFactory.fecharConexao(con);
    }
}
