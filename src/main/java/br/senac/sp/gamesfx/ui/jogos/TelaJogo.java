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

        Scene cena = new Scene(raiz, 500, 400);

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
        );

        VBox formulario = new VBox();

        GridPane gridFormulario = new GridPane();

        // Criar os componentes que serão inseridos no grid
        Label lblId = new Label("ID:");
        tfId = new TextField();
        tfId.setEditable(false);

        Label lblTitulo = new Label("Título:");
        tfTitulo = new TextField();
        tfTitulo.setPromptText("Ex. Super Mario World");

        Label lblPlataforma = new Label("Plataforma:");
        comboPlataforma = new ComboBox<>(plataformas);

        // Adicionar os componentes no Grid
        gridFormulario.add(lblId, 0, 0);
        gridFormulario.add(tfId, 1, 0);
        gridFormulario.add(lblTitulo, 0, 1);
        gridFormulario.add(tfTitulo, 1, 1);
        gridFormulario.add(lblPlataforma, 0, 2);
        gridFormulario.add(comboPlataforma, 1, 2);

        formulario.getChildren().add(gridFormulario);

        return formulario;
    }

}
