package br.senac.sp.gamesfx.ui.jogos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.UTFDataFormatException;
import java.nio.channels.IllegalBlockingModeException;
import java.time.LocalDate;

public class TelaJogo {

    private TextField tfId;
    private TextField tfTitulo;
    private TextField tfValor;
    private ComboBox<String> comboPlataforma;
    private ComboBox<String> comboEstudio;
    private DatePicker dpDataLancamento;
    private CheckBox cbFinalizado;

    public void criarTela(Stage stagePai){

        Stage stage = new Stage();
        stage.initOwner(stagePai);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Cadastro de Jogo");

        // Criar um BorderPane
        BorderPane raiz = new BorderPane();

        raiz.setTop(criarPainelTitulo());
        raiz.setCenter(criarFormulario());
        raiz.setBottom(criarPainelBotoes());

        Scene cena = new Scene(raiz, 500, 500);

        stage.setScene(cena);
        stage.setResizable(false);
        stage.showAndWait();

    }

    private HBox criarPainelTitulo(){
        HBox painelTitulo = new HBox(20);
        painelTitulo.setPadding(new Insets(20, 0, 20, 20));
        painelTitulo.setStyle("-fx-background-color: #1b3f4c");
        painelTitulo.setAlignment(Pos.CENTER_LEFT);

        // Imagem do título
        Image image = new Image(getClass().getResourceAsStream("/imagens/add16.png"));
        ImageView imageView = new ImageView(image);

        // Texto do título
        Label lblTitulo = new Label("Cadastro de Jogos");
        lblTitulo.setStyle("-fx-text-fill: #ffffff;-fx-font-size: 22; -fx-font-weight: bold");

        // Adiciona os componentes no HBox
        painelTitulo.getChildren().addAll(imageView, lblTitulo);

        return painelTitulo;
    }

    private VBox criarFormulario(){

        ObservableList<String> plataformas = FXCollections.observableArrayList(
                "Super Nintendo", "Mega Drive", "PC", "PlayStation 1", "XBox-360"
        ); // Hardcoded

        ObservableList<String> estudios = FXCollections.observableArrayList(
                "Konami", "Capcom", "Rare", "Nintendo", "Sega", "UbiSoft"
        );

        VBox formulario = new VBox();
        formulario.setPadding(new Insets(50));

        GridPane gridFormulario = new GridPane(6, 6);
        gridFormulario.setGridLinesVisible(false);
        gridFormulario.setPadding(new Insets(30));
        gridFormulario.setStyle("-fx-border-width: 2; -fx-border-color: #1b3f4c; -fx-border-radius: 8");

        // Criar os componentes que serão inseridos no grid
        Label lblId = new Label("ID:");
        tfId = new TextField();
        tfId.setEditable(false);

        Label lblTitulo = new Label("Título:");
        tfTitulo = new TextField();
        tfTitulo.setPromptText("Ex. Super Mario World");

        Label lblPlataforma = new Label("Plataforma:");
        comboPlataforma = new ComboBox<>(plataformas);

        Label lblEstudio =  new Label("Estúdio:");
        comboEstudio = new ComboBox<>(estudios);

        Label lblValor = new Label("Valor:");
        tfValor = new TextField();
        tfValor.setPromptText("Ex. 9,99");

        Label lblDataLancamento = new Label("Data lançamento:");
        dpDataLancamento = new DatePicker(LocalDate.of(2006, 9, 14));

        cbFinalizado = new CheckBox("Finalizado");

        // Adicionar os componentes no Grid
        gridFormulario.add(lblId, 0, 0);
        gridFormulario.add(tfId, 1, 0);
        gridFormulario.add(lblTitulo, 0, 1);
        gridFormulario.add(tfTitulo, 1, 1);
        gridFormulario.add(lblPlataforma, 0, 2);
        gridFormulario.add(comboPlataforma, 1, 2);
        gridFormulario.add(lblEstudio, 0, 3);
        gridFormulario.add(comboEstudio, 1, 3);
        gridFormulario.add(lblValor, 0, 4);
        gridFormulario.add(tfValor, 1, 4);
        gridFormulario.add(lblDataLancamento, 0, 5);
        gridFormulario.add(dpDataLancamento, 1, 5);
        gridFormulario.add(cbFinalizado, 1, 6);


        formulario.getChildren().add(gridFormulario);

        return formulario;
    }

    private HBox criarPainelBotoes(){
        HBox painelBotoes = new HBox();

        Button btnSalvar = new Button("Salvar");
        Button btnCancelar = new Button("Cancelar");

        painelBotoes.getChildren().addAll(btnSalvar, btnCancelar);

        return painelBotoes;
    }

}
