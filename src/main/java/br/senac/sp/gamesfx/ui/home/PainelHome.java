package br.senac.sp.gamesfx.ui.home;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PainelHome {

    public VBox criarPainelHome(){

        // Painel principal, representa a tela toda
        VBox painelPrincipal = new VBox();
        painelPrincipal.setAlignment(Pos.TOP_CENTER);
        painelPrincipal.setStyle("-fx-background-color: #0d253e");
        painelPrincipal.setPadding(new Insets(5, 20, 20, 20));

        // Painel de título
        VBox painelTitulo = new VBox();
        painelTitulo.setStyle("-fx-background-color: transparent");
        Label lblTitulo = new Label("Seja Bem-vindo!");
        lblTitulo.setStyle("-fx-font-size: 24;-fx-font-weight: bold; -fx-text-fill: #ffffff");
        painelTitulo.getChildren().addAll(lblTitulo, new Separator());

        VBox painelLogo = new VBox();
        painelLogo.setAlignment(Pos.CENTER);
        painelLogo.setStyle("-fx-background-color: transparent");

        // Imagem da aplicação
        Image imgLogo = new Image(getClass().getResourceAsStream("/imagens/ghost.png"));
        ImageView ivLogo = new ImageView(imgLogo);
        ivLogo.setScaleX(1.0);
        ivLogo.setScaleY(1.0);

        VBox.setVgrow(painelLogo, Priority.ALWAYS);

        // Textos com o nome e descrição da aplicação
        Label lblNomeApp = new Label("GameAdmin PRO");
        lblNomeApp.setStyle("-fx-font-weight: bold;-fx-font-size: 36;-fx-text-fill: #ffffff");

        Label lblDescApp = new Label("Software para gestão de jogos | Versão 1.0");
        lblDescApp.setStyle("-fx-font-weight: regular;-fx-font-size: 18;-fx-text-fill: #ffffff");

        // Criar o painel de contatos
        VBox painelContatos = new VBox(5);
        painelContatos.setStyle("-fx-background-color: #69cfcf;-fx-border-width: 2;-fx-border-color: blue;-fx-border-radius: 16;-fx-background-radius: 16");
        painelContatos.setMaxWidth(600);
        painelContatos.setPadding(new Insets(20));
        VBox.setMargin(painelContatos, new Insets(30, 10, 30, 10));

        Label lblTituloEmail = new Label("E-mail para suporte:");
        lblTituloEmail.setStyle("-fx-font-size: 18;-fx-font-weight: bold");
        Label lblEmail = new Label("suporte@gameapp.com.br");
        Label lblTituloTelefone = new Label("Telefone para suporte:");
        lblTituloTelefone.setStyle("-fx-font-size: 18;-fx-font-weight: bold");
        Label lblTelefone = new Label("(11)99999-0001");

        painelContatos.getChildren().addAll(
                lblTituloEmail,
                lblEmail,
                lblTituloTelefone,
                lblTelefone
        );

        Label lblDesenvolvidoPor = new Label("Desenvolvido por CelSoft - 2026");
        lblDesenvolvidoPor.setStyle("-fx-font-weight: bold;-fx-font-size: 22; -fx-text-fill: #ffffff");

        painelLogo.getChildren().addAll(ivLogo, lblNomeApp, lblDescApp, painelContatos, lblDesenvolvidoPor);

        painelPrincipal.getChildren().addAll(
                painelTitulo,
                painelLogo
        );

        return painelPrincipal;
    }

}
