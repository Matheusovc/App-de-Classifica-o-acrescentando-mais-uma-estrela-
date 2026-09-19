package com.example.classificacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * App de Classificacao (RatingBar) - Aula 6 / Desenvolvimento Mobile.
 *
 * Entrega:
 *  - Acrescentar mais uma estrela (agora sao 5 estrelas no total).
 *  - Tratar o problema da "meia estrela": uma meia estrela NAO pode
 *    promover a avaliacao para a categoria seguinte. Por isso 4,5 estrelas
 *    continuam exibindo "Excelente" (e nao "Espetacular"). Somente 5
 *    estrelas cheias resultam em "Espetacular".
 */
public class MainActivity extends AppCompatActivity {

    private RatingBar rtbVotacao;
    private TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rtbVotacao = findViewById(R.id.rtbvotacao);
        txtStatus = findViewById(R.id.txtstatus);

        // Mostra o status inicial (nenhuma estrela selecionada).
        atualizarStatus(rtbVotacao.getRating());

        // Disparado toda vez que o usuario altera a nota na RatingBar.
        rtbVotacao.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                atualizarStatus(rating);
            }
        });
    }

    /**
     * Atualiza o TextView de status de acordo com a nota informada.
     */
    private void atualizarStatus(float rating) {
        txtStatus.setText(getString(R.string.status) + " " + obterStatus(rating));
    }

    /**
     * Converte a nota (rating) da RatingBar no status correspondente.
     *
     * A comparacao usa o "piso" de cada estrela cheia (>= 1.0, >= 2.0 ...),
     * de forma que a meia estrela nunca sobe de categoria:
     *
     *   0,5  -> Selecione uma nota
     *   1,0 a 1,5 -> Regular
     *   2,0 a 2,5 -> Bom
     *   3,0 a 3,5 -> Otimo
     *   4,0 a 4,5 -> Excelente   (4,5 continua "Excelente")
     *   5,0       -> Espetacular (apenas com 5 estrelas cheias)
     */
    private String obterStatus(float rating) {
        if (rating >= 5.0f) {
            return "Espetacular";
        } else if (rating >= 4.0f) {
            return "Excelente";
        } else if (rating >= 3.0f) {
            return "Otimo";
        } else if (rating >= 2.0f) {
            return "Bom";
        } else if (rating >= 1.0f) {
            return "Regular";
        } else {
            return "Selecione uma nota";
        }
    }
}
