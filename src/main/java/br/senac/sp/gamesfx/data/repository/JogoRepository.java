package br.senac.sp.gamesfx.data.repository;

import br.senac.sp.gamesfx.data.ConexaoSQLite;
import br.senac.sp.gamesfx.model.Jogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

// Mock -> Fonte dados falso

public class JogoRepository {

    public ObservableList<Jogo> getJogos() {

        String sql = "SELECT * FROM tb_games";

        ObservableList<Jogo> listaJogos = FXCollections.observableArrayList();

        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()){
                Jogo jogo = new Jogo();
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String categoria = rs.getString("categoria");
                String plataforma = rs.getString("plataforma");
                String estudio = rs.getString("estudio");
                double preco = rs.getDouble("preco");
                LocalDate dataLancamento = LocalDate.parse(rs.getString("data_lancamento"));
                boolean isFinalizado = rs.getInt("finalizado") == 1 ? true : false;

                // Popular o objeto jogo com os dados
                jogo.setId(id);
                jogo.setTitulo(titulo);
                jogo.setPlataforma(plataforma);
                jogo.setCategoria(categoria);
                jogo.setPreco(preco);
                jogo.setFinalizado(isFinalizado);
                jogo.setEstudio(estudio);
                jogo.setDataLancamento(dataLancamento);

                listaJogos.add(jogo);
            }

            ConexaoSQLite.fecharConexao();
            return listaJogos;

        } catch (SQLException e) {
            System.out.println("Ocorreu um erro na leitura dos dados.");
            e.printStackTrace();
            return null;
        }

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
            ConexaoSQLite.fecharConexao();
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro na gravação.");
            e.printStackTrace();
        }


    }

    public int getTotalJogos(){
        String sql = "SELECT COUNT(id) as total_games FROM tb_games";

        try {
            PreparedStatement stm = ConexaoSQLite.getConexao().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            rs.next();
            int total = rs.getInt("total_games");
            ConexaoSQLite.fecharConexao();
            return total;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int excluir(int id){
        String sql = "DELETE FROM tb_games WHERE id = ?";

        try {
            PreparedStatement stm = ConexaoSQLite
                    .getConexao()
                    .prepareStatement(sql);

            stm.setInt(1, id);

            int resultado = stm.executeUpdate();

            ConexaoSQLite.fecharConexao();

            return resultado;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

}
