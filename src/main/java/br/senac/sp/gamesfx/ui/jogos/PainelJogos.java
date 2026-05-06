package br.senac.sp.gamesfx.ui.jogos;

import br.senac.sp.gamesfx.model.Jogo;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class PainelJogos {

    public VBox criarPainelJogos(){

        VBox painelJogos = new VBox();
        painelJogos.setPadding(new Insets(5, 20, 20, 20));
        painelJogos.setStyle("-fx-background-color: #0d253e");

        // Título do painel jogos
        Label lblTitulo = new Label("Listagem de Jogos");
        lblTitulo.setStyle("-fx-font-size: 24;-fx-text-fill: #ffffff;-fx-font-weight: bold");

        // Linha abaixo do label
        Separator linha = new Separator();

        // Tabela com a lista de jogos
        TableView<Jogo> tabelaJogos = new TableView<>();

        // Criar colunas da tabela
        TableColumn<Jogo, Integer> colunaId = new TableColumn<>("ID");
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaId.setPrefWidth(50);

        TableColumn<Jogo, String> colunaTitulo = new TableColumn<>("TÍTULO");
        colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colunaTitulo.setPrefWidth(400);

        TableColumn<Jogo, String> colunaPlataforma = new TableColumn<>("PLATAFORMA");
        colunaPlataforma.setCellValueFactory(new PropertyValueFactory<>("plataforma"));
        colunaPlataforma.setPrefWidth(200);

        // Adicionar as colunas na tabela
        tabelaJogos.getColumns().addAll(colunaId, colunaTitulo, colunaPlataforma);

        // Adicionar o label no painel
        painelJogos.getChildren().addAll(lblTitulo, linha, tabelaJogos);

        return painelJogos;
    }

}
