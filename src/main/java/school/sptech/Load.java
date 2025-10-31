package school.sptech;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class Load {

    private String urlBanco;
    private String usuario;
    private String senha;

    private String query = "INSERT INTO aluno (nome) VALUES (?)";


    public Load() {
        try (InputStream input = getClass().getResourceAsStream("/application.properties")) {
            Properties props = new Properties();
            props.load(input);

            urlBanco = props.getProperty("db.url");
            usuario = props.getProperty("db.username");
            senha = props.getProperty("db.password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String carregamentoEmLote(List<String> dados, int tamanhoLote) {
        try (Connection conexao = DriverManager.getConnection(urlBanco, usuario, senha);
             PreparedStatement insercao = conexao.prepareStatement(query)) {

            conexao.setAutoCommit(false);

            for (int i = 0; i < dados.size(); i++) {
                String nome = dados.get(i); // ex: Maria

                // substitui o primeiro “?” da query
                insercao.setString(1, nome); // insercao.setString(1, "Maria");
                insercao.addBatch();

                if ((i + 1) % tamanhoLote == 0) {
                    insercao.executeBatch();
                }
            }

            insercao.executeBatch();
            conexao.commit();

            return "Lote inserido com sucesso!";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro no carregamento em lote: " + e.getMessage();
        }
    }
}