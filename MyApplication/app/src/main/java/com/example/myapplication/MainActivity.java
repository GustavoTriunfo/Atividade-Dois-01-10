package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Button botaoAudi, botaoJaguar, botaoVolvo;

    private List<Local> locais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoAudi = findViewById(R.id.botaoAudi);
        botaoJaguar = findViewById(R.id.botaoJaguar);
        botaoVolvo = findViewById(R.id.botaoVolvo);

        ImageView audiIcon = findViewById(R.id.logoAudi);
        ImageView jaguarIcon = findViewById(R.id.jaguarLogo);
        ImageView volvoIcon = findViewById(R.id.logoVolvo);

        audiIcon.setOnClickListener(v -> abrirDetalhes(0));

        jaguarIcon.setOnClickListener(v -> abrirDetalhes(1));

        volvoIcon.setOnClickListener(v -> abrirDetalhes(2));

        locais = new ArrayList<>();
        locais.add(new Local("Audi Center Sorocaba", R.drawable.audicenterimagemtopo, R.drawable.audicenterimagembaixa , "Concessionária Audi em Sorocaba, São Paulo", "https://audicentersorocaba.com.br/", "(15) 3141-9000", "Av. Dr. Armando Pannunzio, 1091 - Jardim Vera Cruz, Sorocaba - SP, 18050-000"));
        locais.add(new Local("Maggi Jaguar", R.drawable.maggijaguarimagemtopo, R.drawable.maggijaguarimagembaixa ,"Concessionária Jaguar em Sorocaba, São Paulo", "https://concessionarias.jaguarbrasil.com.br/maggi-sorocaba", "(15) 3141-8040", "Av. Dr. Afonso Vergueiro, 3140 - Vila Augusta, Sorocaba - SP, 18040-000"));
        locais.add(new Local("Maggi Volvo", R.drawable.maggivolvoimagemtopo, R.drawable.maggivolvoimagembaixa ,"Concessionária Volvo em Sorocaba, São Paulo\n", "https://www.maggivolvo.com.br/", "(15) 3141-9850", "Av. Dr. Afonso Vergueiro, 3090 - Vila Lucy, Sorocaba - SP, 18040-000"));

        botaoAudi.setOnClickListener(v -> abrirDetalhes(0));
        botaoJaguar.setOnClickListener(v -> abrirDetalhes(1));
        botaoVolvo.setOnClickListener(v -> abrirDetalhes(2));
    }

    private void abrirDetalhes(int index) {
        Local localSelecionado = locais.get(index);

        Intent intent = new Intent(MainActivity.this, DetalhesActivity.class);
        intent.putExtra("nome", localSelecionado.getNome());
        intent.putExtra("imagemTopo", localSelecionado.getImagemTopo());
        intent.putExtra("imagemBaixa", localSelecionado.getImagemBaixa());
        intent.putExtra("descricao", localSelecionado.getDescricao());
        intent.putExtra("site", localSelecionado.getSite());
        intent.putExtra("telefone", localSelecionado.getTelefone());
        intent.putExtra("endereco", localSelecionado.getEndereco());

        startActivity(intent);
    }
}


