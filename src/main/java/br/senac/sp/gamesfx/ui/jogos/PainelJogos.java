package br.senac.sp.gamesfx.ui.jogos;

import br.senac.sp.gamesfx.data.repository.JogoRepository;
import br.senac.sp.gamesfx.model.Jogo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class PainelJogos {

    private Stage stage;

    public PainelJogos(Stage stage){
        this.stage = stage;
    }

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

        // Ajustar tabela para ocupar todo o espaço
        VBox.setVgrow(tabelaJogos, Priority.ALWAYS);

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

        // Obter os dados que serão exibidos
        JogoRepository repository = new JogoRepository();

        // Adiciona a lista de jogos na tabela
        tabelaJogos.setItems(repository.getJogos());

        // Criar o painel de botões de ação
        HBox painelBotoes = new HBox(30);
        painelBotoes.setPadding(new Insets(20, 0, 0, 0));
        painelBotoes.setAlignment(Pos.BASELINE_RIGHT);
        //painelBotoes.setSpacing(20);

        // Criar os botões
        Button btnAdicionar = criarBotao("Adicionar", "/imagens/add16.png");
        btnAdicionar.setOnAction(e ->{
            TelaJogo telaJogo = new TelaJogo();
            telaJogo.criarTela(stage);
        });

        Button btnEditar = criarBotao("Editar", "/imagens/edit16.png");
        Button btnExibir = criarBotao("Exibir", "/imagens/visual16.png");
        Button btnExcluir = criarBotao("Excluir", "/imagens/delete16.png");

        painelBotoes.getChildren().addAll(btnAdicionar, btnEditar, btnExibir, btnExcluir);

        // Adicionar o label no painel
        painelJogos.getChildren().addAll(lblTitulo, linha, tabelaJogos, painelBotoes);

        return painelJogos;
    }

    private Button criarBotao(String textoBotao, String urlImagem){

        Image image = new Image(getClass().getResourceAsStream(urlImagem));
        ImageView imageView = new ImageView(image);

        imageView.setFitHeight(24);
        imageView.setFitWidth(24);

        Button button = new Button();
        button.setText(textoBotao);
        button.setGraphic(imageView);
        button.setPrefWidth(100);
        button.setPrefHeight(50);

        button.setContentDisplay(ContentDisplay.TOP);

        return button;

    }

}
