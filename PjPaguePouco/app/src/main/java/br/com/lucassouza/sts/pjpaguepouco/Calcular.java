package br.com.lucassouza.sts.pjpaguepouco;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import br.com.lucassouza.sts.pjpaguepouco.dominio.entidades.Carro;



public class Calcular extends AppCompatActivity {
    public static final String EXTRA_ETANOL_PRECO = "ETANOL_PRICE";
    public static final String EXTRA_GASOLINA_PRECO = "GAS_PRICE";
    public static final String EXTRA_ETANOL_MEDIA = "ETANOL_MILAGE";
    public static final String EXTRA_GASOLINA_MEDIA = "GAS_MILAGE";
    private EditText etanolpreco;
    private EditText gasolinapreco;
    private EditText etanolmedia;
    TextView consumocalc;
    private EditText gasolinamedia;
    private Button veriicarBtn , consumobtn;
    public Carro carro;
    public bdmycar BDmycar;
    String carro_recebe, valorum = "", valordois = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular);
        etanolpreco = findViewById(R.id.etanol_preco);
        etanolmedia = findViewById(R.id.etanol_media);
        gasolinapreco = findViewById(R.id.gasolina_preco);
        gasolinamedia = findViewById(R.id.gasolina_media);
        veriicarBtn = findViewById(R.id.btn_verificar);
        consumocalc= findViewById(R.id.descoconsumo);
        consumobtn =findViewById(R.id.consumo);
      
        Conexao();
       

        try {
            Intent intent = getIntent();
            final String gasolinaconumocity = intent.getStringExtra("GASOLINACONSUMOCITY");
            final String etanolconumocity = intent.getStringExtra("ETANOLCONSUMOCITY");
            final String gasolinaconumoestra = intent.getStringExtra("GASOLINACONSUMOESTRA");
            final String etanolconumoestra = intent.getStringExtra("ETANOLCONSUMOESTRA");
            if (gasolinaconumocity.length() > 0){
                final AlertDialog.Builder  builder = new AlertDialog.Builder(Calcular.this);
                CharSequence[] itens = new CharSequence[3];//cria array de 3 caompos e cada um ganha uma valor
                itens[0] = "Urbano";
                itens[1] = "Estrada";
                itens[2] = "Cancelar";

                builder.setTitle(R.string.opcao1_tela_pesquisa).setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (i==0){//
                            gasolinamedia.setText(gasolinaconumocity.toString().replace(",","."));
                            etanolmedia.setText(etanolconumocity.toString().replace(",","."));
                        }else if(i==1){//
                            gasolinamedia.setText(gasolinaconumoestra.toString().replace(",","."));
                            etanolmedia.setText(etanolconumoestra.toString().replace(",","."));
                        }else{
                            return;
                        }

                    }
                });
                AlertDialog dialog = builder.create();//cria o alerta
                dialog.show();//exibi o alerta
                consumocalc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(Calcular.this, PesquisaVeicullo.class);
                        startActivity(intent);

                    }
                });
                consumobtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(Calcular.this, PesquisaVeicullo.class);
                        startActivity(intent);
                    }
                });
                veriicarBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (Validar()) {
                            PassarResultado();
                        }
                    }
                });
            }

        }catch (Exception e){
               try {
                   if (carro_recebe.toString().equals("")){

                   }else{
                       gasolinamedia.setText(valorum.toString().replace(",","."));
                       etanolmedia.setText(valordois.toString().replace(",","."));
                   }


                   consumocalc.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {

                           Intent intent = new Intent(Calcular.this, PesquisaVeicullo.class);
                           startActivity(intent);

                       }
                   });
                   consumobtn.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {

                           Intent intent = new Intent(Calcular.this, PesquisaVeicullo.class);
                           startActivity(intent);
                       }
                   });
                   veriicarBtn.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           if (Validar()) {
                               PassarResultado();
                           }
                       }
                   });
               }catch (SQLException k){

                   consumocalc.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {

                           Intent intent = new Intent(Calcular.this, PesquisaVeicullo.class);
                           startActivity(intent);

                       }
                   });
                   consumobtn.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {

                           Intent intent = new Intent(Calcular.this, PesquisaVeicullo.class);
                           startActivity(intent);
                       }
                   });
                   veriicarBtn.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           if (Validar()) {
                               PassarResultado();
                           }
                       }
                   });
               }
        }

    }

    public void Conexao(){
        try {
            carro = new Carro();
            BDmycar = new bdmycar(Calcular.this);
            carro_recebe = BDmycar.Buscarcarro();
            if (carro_recebe.toString().equals("")){
            }else{
                String carrosplit  = carro_recebe.toString();
                String[] divisao = carrosplit.toString().split(" ");
                valorum = divisao[0].toString();
                valordois =  divisao[1].toString();
            }
        }catch (SQLException j){
            Toast.makeText(Calcular.this, "==>"+ j, Toast.LENGTH_SHORT).show();
        }
    }
    private void PassarResultado() {
        Intent intent = new Intent(this, Exibir.class);

        EditText etanolPrice =  findViewById(R.id.etanol_preco);
        EditText gasPrice = findViewById(R.id.gasolina_preco);
        EditText etanolMilage = findViewById(R.id.etanol_media);
        EditText gasMilage =  findViewById(R.id.gasolina_media);

        intent.putExtra(EXTRA_ETANOL_PRECO, etanolPrice.getText().toString());
        intent.putExtra(EXTRA_GASOLINA_PRECO, gasPrice.getText().toString());
        intent.putExtra(EXTRA_ETANOL_MEDIA, etanolMilage.getText().toString());
        intent.putExtra(EXTRA_GASOLINA_MEDIA, gasMilage.getText().toString());
        startActivity(intent);
    }
    private boolean Validar() {

        boolean verificarerro = true;

        if (etanolpreco.getText().toString().length() == 0 || etanolpreco.getText().toString().equals("0") || Float.parseFloat(etanolpreco.getText().toString()) < 1) {
            etanolpreco.setError(getString(R.string.erro_etanol));
            verificarerro = false;
        }

        if (gasolinapreco.getText().toString().length() == 0 || gasolinapreco.getText().toString().equals("0") || Float.parseFloat(gasolinapreco.getText().toString()) < 1) {
            gasolinapreco.setError(getString(R.string.erro_gasolina));
            verificarerro = false;
        }

        if (etanolmedia.getText().toString().length() == 0 || etanolmedia.getText().toString().equals("0")|| Float.parseFloat(etanolmedia.getText().toString()) < 1) {
            etanolmedia.setError(getString(R.string.erro_media_etanol));
            verificarerro = false;
        }

        if (gasolinamedia.getText().toString().length() == 0 || gasolinamedia.getText().toString().equals("0")||Float.parseFloat(gasolinamedia.getText().toString()) < 1) {
            gasolinamedia.setError(getString(R.string.erro_media_gasolina));
            verificarerro = false;
        }

        return verificarerro;
    }
}