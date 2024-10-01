package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalhesActivity  extends AppCompatActivity {

    private ImageView imagemTopoLocal, imagemBaixaLocal;
    private TextView nomeLocal, descricaoLocal;
    private Button botaoVerNoMapa, botaoAbrirSite, botaoFazerLigacao, botaoSolicitarViagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        imagemTopoLocal = findViewById(R.id.imagemTopoTelaDetalhe);
        imagemBaixaLocal = findViewById(R.id.imagemBaixaTelaDetalhe);
        nomeLocal = findViewById(R.id.tituloTelaDetalhe);
        descricaoLocal = findViewById(R.id.descricaoTelaDetalhe);
        botaoVerNoMapa = findViewById(R.id.botaoVerNoMapa);
        botaoAbrirSite = findViewById(R.id.botaoAbrirSite);
        botaoSolicitarViagem = findViewById(R.id.botaoSolicitarViagem);
        botaoFazerLigacao = findViewById(R.id.botaoFazerLigacao);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        int imagemTopo = intent.getIntExtra("imagemTopo", 0);
        int imagemBaixa = intent.getIntExtra("imagemBaixa", 0);
        String descricao = intent.getStringExtra("descricao");
        String site = intent.getStringExtra("site");
        String telefone = intent.getStringExtra("telefone");
        String endereco = intent.getStringExtra("endereco");

        nomeLocal.setText(nome);
        imagemTopoLocal.setImageResource(imagemTopo);
        imagemTopoLocal.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imagemBaixaLocal.setImageResource(imagemBaixa);
        imagemBaixaLocal.setScaleType(ImageView.ScaleType.CENTER_CROP);
        descricaoLocal.setText(descricao);

        botaoAbrirSite.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
            startActivity(browserIntent);
        });

        botaoFazerLigacao.setOnClickListener(v -> {
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:" + telefone));
            startActivity(dialIntent);
        });

        botaoVerNoMapa.setOnClickListener(v -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(endereco));

            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");

            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            } else {
                startActivity(new Intent(Intent.ACTION_VIEW, gmmIntentUri));
            }
        });

        botaoSolicitarViagem.setOnClickListener(v -> abrirUber(endereco));
    }

    private void abrirUber(String endereco) {
        String url = "https://m.uber.com/ul/?action=setPickup&pickup=my_location&dropoff[formatted_address]=" + Uri.encode(endereco);
        Intent uberIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        if (uberIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(uberIntent);
        } else {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(webIntent);
        }
    }
    }
