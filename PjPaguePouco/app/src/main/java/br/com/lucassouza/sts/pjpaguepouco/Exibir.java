package br.com.lucassouza.sts.pjpaguepouco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import java.text.NumberFormat;
import java.util.Locale;

public class Exibir extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir);
       
            Intent intent = getIntent();
            String etanolpreco = intent.getStringExtra(Calcular.EXTRA_ETANOL_PRECO);
            String gasolinapreco = intent.getStringExtra(Calcular.EXTRA_GASOLINA_PRECO);
            String etanolmedia = intent.getStringExtra(Calcular.EXTRA_ETANOL_MEDIA);
            String gasolinamedia = intent.getStringExtra(Calcular.EXTRA_GASOLINA_MEDIA);
            TextView consumogasolinatxt = findViewById(R.id.txtconsumogasolina);
            TextView consumoetanoltxt = findViewById(R.id.txtconsumoetanol);
            TextView vazio = findViewById(R.id.txtvazio);

            consumogasolinatxt.setText("Relação Etanol/Gasolina:\n");
            consumoetanoltxt.setText("Gasto com Etanol:\n");
            vazio.setText("Gasto com Gasolina:");

            NumberFormat formatonumber = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            formatonumber.setMinimumIntegerDigits(2);
            double etanol = Double.parseDouble(etanolpreco);
            double gasolina = Double.parseDouble(gasolinapreco);

            TextView porcentagemview = findViewById(R.id.porcentagem);
            TextView valoretanolview = findViewById(R.id.ethanol_preco);
            TextView valorgasolinaview = findViewById(R.id.gasolina_preco);

            double porcentagem = etanol / gasolina * 100;
            double etanolconta = etanol / Double.valueOf(etanolmedia.replace(",","."));
            double gasolinaconta = gasolina / Double.valueOf(gasolinamedia.replace(",","."));

            Log.v("VALOR", String.valueOf(etanolconta));
            Log.v("VALOR", String.valueOf(gasolinaconta));

            porcentagemview.setText(String.format("%.2f %%", porcentagem ) + "\n" );
            valoretanolview.setText(formatonumber.format(etanolconta) + "\n" );
            valorgasolinaview.setText(formatonumber.format(gasolinaconta));

            TextView formadeabastercerView = findViewById(R.id.formaabstecer);
            TextView quantoeconomiza = findViewById(R.id.ecomia);

            if (etanolconta < gasolinaconta)
                formadeabastercerView.setText(R.string.abastecaetanol);
            else
                formadeabastercerView.setText(R.string.abastecagasolina);

            double resultante = Math.abs(etanolconta - gasolinaconta);
            quantoeconomiza.setText("Economia de ≅ " + formatonumber.format(resultante));

            Button backButton = findViewById(R.id.btn_voltar);
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Exibir.super.onBackPressed();
                    finish();
                }
            });
    }
}