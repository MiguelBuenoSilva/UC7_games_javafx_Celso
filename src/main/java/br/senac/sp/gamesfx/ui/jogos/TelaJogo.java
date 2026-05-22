package br.senac.sp.gamesfx.ui.jogos;

import br.senac.sp.gamesfx.data.repository.JogoRepository;
import br.senac.sp.gamesfx.model.Jogo;
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

import javax.swing.*;
import java.time.LocalDate;

public class TelaJogo {

    private TextField tfId = new TextField();
    private TextField tfTitulo = new TextField();
    private TextField tfValor = new TextField();
    private ComboBox<String> comboPlataforma = new ComboBox<>();
    private ComboBox<String> comboEstudio = new ComboBox<>();
    private DatePicker dpDataLancamento = new DatePicker();
    private CheckBox cbFinalizado = new CheckBox("Finalizado");

    public TelaJogo(Jogo jogo){
        tfId.setText(String.valueOf(jogo.getId()));
        tfTitulo.setText(jogo.getTitulo());
        tfValor.setText(String.valueOf(jogo.getPreco()));
        comboPlataforma.setValue(jogo.getPlataforma());
        comboEstudio.setValue(jogo.getEstudio());
        dpDataLancamento.setValue(jogo.getDataLancamento());
        cbFinalizado.setSelected(jogo.isFinalizado());
    }

    public TelaJogo(){}

    public void criarTela(Stage stagePai){

        Stage stage = new Stage();
        stage.initOwner(stagePai);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Cadastro de Jogo");

        // Criar um BorderPane
        BorderPane raiz = new BorderPane();

        raiz.setTop(criarPainelTitulo());
        raiz.setCenter(criarFormulario());
        raiz.setBottom(criarPainelBotoes(stage));

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
        tfId.setEditable(false);
        tfId.setDisable(true);

        Label lblTitulo = new Label("Título:");
        tfTitulo.setPromptText("Ex. Super Mario World");

        Label lblPlataforma = new Label("Plataforma:");
        comboPlataforma.setItems(plataformas);

        Label lblEstudio =  new Label("Estúdio:");
        comboEstudio.setItems(estudios);

        Label lblValor = new Label("Valor:");
        tfValor.setPromptText("Ex. 9,99");

        Label lblDataLancamento = new Label("Data lançamento:");


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

    private HBox criarPainelBotoes(Stage stage){
        HBox painelBotoes = new HBox(20);
        painelBotoes.setStyle("-fx-background-color: #69cfcf");
        painelBotoes.setPadding(new Insets(10));
        painelBotoes.setAlignment(Pos.CENTER_RIGHT);

        Button btnSalvar = new Button();
        Image imgSalvar = new Image(getClass().getResourceAsStream("/imagens/save32.png"));
        ImageView ivSalvar = new ImageView(imgSalvar);
        btnSalvar.setGraphic(ivSalvar);
        btnSalvar.setTooltip(new Tooltip("Salvar dados do jogo"));

        btnSalvar.setOnAction(evento ->{
            Jogo jogo = new Jogo();
            jogo.setTitulo(tfTitulo.getText());
            jogo.setPlataforma(comboPlataforma.getValue());
            jogo.setEstudio(comboEstudio.getValue());
            jogo.setDataLancamento(dpDataLancamento.getValue());
            jogo.setCategoria("Jogo");
            jogo.setFinalizado(cbFinalizado.isSelected());
            jogo.setPreco(Double.parseDouble(tfValor.getText()));

            // Criar o repositório para enviar o jogo
            JogoRepository repository = new JogoRepository();

            if (tfId.getText().equals("")){
                repository.salvar(jogo);
            } else {
                jogo.setId(Integer.parseInt(tfId.getText()));
                repository.editar(jogo);
            }

//            JOptionPane.showMessageDialog(
//                    null,
//                    "Jogo cadastrado com sucesso!",
//                    "Erro!",
//                    JOptionPane.ERROR_MESSAGE
//            );

            int resposta = JOptionPane.showConfirmDialog(
                    null,
                    "Jogo cadastrado com sucesso!\nDeseja cadastrar outro jogo?",
                    "Cadastro",
                    JOptionPane.YES_NO_OPTION
            );

            if (resposta != 0){
                stage.close();
            }

            limparCampos();

        });

        Button btnCancelar = new Button();
        Image imgCancelar =  new Image(getClass().getResourceAsStream("/imagens/cancel32.png"));
        ImageView ivCancelar = new ImageView(imgCancelar);
        btnCancelar.setGraphic(ivCancelar);

        painelBotoes.getChildren().addAll(btnSalvar, btnCancelar);

        return painelBotoes;
    }

    private void limparCampos() {

        tfTitulo.clear();
        tfId.clear();
        tfValor.clear();
        comboEstudio.setValue("");
        comboPlataforma.setValue("");
        cbFinalizado.setSelected(false);
        dpDataLancamento.setValue(LocalDate.now());
        tfTitulo.requestFocus();

    }


}
