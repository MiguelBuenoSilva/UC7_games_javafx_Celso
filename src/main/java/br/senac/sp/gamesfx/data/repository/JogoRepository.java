package br.senac.sp.gamesfx.data.repository;

import br.senac.sp.gamesfx.data.ConexaoSQLite;
import br.senac.sp.gamesfx.model.Jogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.SQLException;

// Mock -> Fonte dados falso

public class JogoRepository {

    public ObservableList<Jogo> getJogos() {

        ObservableList<Jogo> listaJogos = FXCollections
                .observableArrayList(
                        new Jogo(1, "nome do jogo", "snes"),
                        new Jogo(2, "nome do jogo", "snes"),
                        new Jogo(3, "nome do jogo", "snes"),
                        new Jogo(4, "nome do jogo", "snes")
                );

        return listaJogos;

    }

    public void salvar(Jogo jogo){

        // Instrução SQL para cadastrar um novo jogo no banco de dados
        String sql = "INSERT INTO tb_games (titulo, plataforma," +
                "estudio, categoria, preco, data_lancamento," +
                "finalizado)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Preparar a instrução SQL para ser enviada para o banco através
        // de uma conexão
        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            stm.setString(1, jogo.getTitulo());
            stm.setString(2, jogo.getPlataforma());
            stm.setString(3, jogo.getEstudio());
            stm.setString(4, jogo.getCategoria());
            stm.setDouble(5, jogo.getPreco());
            stm.setString(6, jogo.getDataLancamento().toString());
            stm.setInt(7, jogo.isFinalizado() ? 1 : 0);
            stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro na gravação.");
            e.printStackTrace();
        }


    }

}
