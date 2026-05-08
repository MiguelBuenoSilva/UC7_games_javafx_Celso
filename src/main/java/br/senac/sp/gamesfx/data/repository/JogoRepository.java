package br.senac.sp.gamesfx.data.repository;

import br.senac.sp.gamesfx.model.Jogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

}
