package br.com.lucassouza.sts.pjpaguepouco;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import java.util.ArrayList;
import br.com.lucassouza.sts.pjpaguepouco.dominio.entidades.Carro;

public class PesquisaVeicullo extends AppCompatActivity {

    Button btnpesquisa;
    EditText txtpesquisa;
    private static final String[] NOMES_TTITULO = {
            //2020 - onix
            "Onix 2020",
            "Onix 2020",
            "Onix 2020",
            "Onix 2020",
            "Onix 2020",
            "Onix 2020",
            "Onix 2020",
            //2019 - onix
            "Onix 2019",
            "Onix 2019",
            "Onix 2019",
            "Onix 2019",
            "Onix 2019",
            "Onix 2019",
            "Onix 2019",
            "Onix 2019",
            "Onix 2019",
            "Onix 2019",
            //2020- hb20
            "HB20 2020",
            "HB20 2020",
            "HB20 2020",
            "HB20 2020",
            "HB20 2020",
            "HB20 2020",
            //2019- hb20
            "HB20 2019",
            "HB20 2019",
            "HB20 2019",
            "HB20 2019",
            "HB20 2019",
            "HB20 2019",
            "Ka 2020",
            "Ka 2020",
            "Ka 2020",
            "Ka 2019",
            "Ka 2019",
            "Ka 2019",
            "Ka 2019",
            "Ka 2019",
            "Ka 2019",
            "Ka 2019",
            "Ka 2019",
            "Ka 2019",
            "Ka 2019",
            "Gol 2020",
            "Gol 2020",
            "Gol 2020",
            "Gol 2019",
            "Gol 2019",
            "Gol 2019",
            "Kwid 2018",
            "Kwid 2018",
            "Kwid 2018",
            "Fiat Argo 2018",
            "Fiat Argo 2018",
            "Fiat Argo 2018",
            "Fiat Argo 2018",
            "Fiat Argo 2018",
            "Fiat Argo 2018",
            "Fiat Argo 2018",
            "Fiat Argo 2018",
            "Peugeot 208",
            "VW Polo 2018",
            "VW Polo 2018",
            "VW Polo 2018",
            "VW Polo 2018",
            "Fiat Uno 2017",
            "Fiat Uno 2017",
            "Fiat Uno 2017",
            "Fiat Uno 2017",
            "Fiat Uno 2017",
            "Palio 2017",
            "Palio 2017",
            "Palio 2017",
            "Palio 2016",
            "Palio 2016",
            "Palio 2016",
            "Palio 2016",
            "Fox 2017",
            "Fox 2017",
            "Fox 2017",
            "Fox 2017",
            "Fox 2017",
            "Fox 2018",
            "Fox 2018",
            "Gol 2018",
            "Gol 2018",
            "Gol 2018",
            "Gol 2018",
            "Gol 2018",
            "Gol 2018",
            "Gol 2017",
            "Gol 2017",
            "Onix 2018",
            "Onix 2018",
            "Onix 2018",
            "Onix 2018",
            "Onix 2018",
            "Onix 2018",
            "Onix 2018",
            "Onix 2018",
            "Onix 2018",
            "Onix 2017",
            "Onix 2017",
            "Onix 2017",
            "Onix 2017",
            "Onix 2017",
            "Onix 2017",
            "Onix 2017",
            "Onix 2017",
            "Strada 2017",
            "Strada 2017",
            "Strada 2017",
            "Strada 2017",
            "Strada 2017",
            "Strada 2017",
            "Strada 2017",
            "Strada 2017",
            "Strada 2017",
            "Strada 2018",
            "Strada 2018",
            "Strada 2018",
            "Strada 2018",
            "Strada 2018",
            "Strada 2018"

};
    private static final String[] NOMES_MODELO = {
            //2020 - onix
            "Joy 1.0",
            "Joy Black 1.0",
            "LT 1.0",
            "Turbo",
            "Turbo AT",
            "LTZ 1.0 Turbo",
            "Premier 1.0 Turbo AT",
            //2019 - onix
            "Joy 1.0",
            "LT 1.0",
            "LT 1.4",
            "Advantage 1.4 AT",
            "Effect 1.4",
            "LTZ 1.4",
            "LT 1.4 AT",
            "Activ 1.4",
            "LTZ 1.4 AT",
            "Activ 1.4 AT",
            //2020 - hb20
            "1.0 Sense",
            "1.0 Vision",
            "1.0 Evolution",
            "1.6 Vision",
            "1.6 Vision (AUT)",
            "1.6 Launch Edition (AUT)",
            //2019- hb20
            "1.0 Unique",
            "1.0 Comfort Plus",
            "1.0 Copa do Mundo",
            "1.0 Turbo Comfort Plus",
            "1.6 1 Million (AUT)",
            "1.6 Comfort Plus (AUT)",
            "1.0",
            "1.5",
            "1.5 (AUT)",
            "1.0 S",
            "1.0 SE",
            "1.0 SE Plus",
            "1.5 Freestyle",
            "1.5 Freestyle (AUT)",
            "1.5 SE",
            "1.5 SE (AUT)",
            "1.5 SE Plus",
            "1.5 SE Plus (AUT)",
            "1.5 Titanium (AUT)",
            "1.0 MPI",
            "1.6 MSI",
            "1.6 MSI (AUT)",
            "1.0 MPI",
            "1.6 MSI",
            "1.6 MSI (AUT)",
            "Life 1.0",
            "Zen 1.0",
            "Intense 1.0",
            "Drive 1.0 Firefly",
            "Drive 1.3 Firefly",
            "Drive 1.3 Firefly GSR",
            "HGT 1.8 E-Torq",
            "HGT 1.8 E-Torq AT6",
            "HGT Mopar 1.8 AT6",
            "Precision 1.8 E-Torq",
            "Precision 1.8 E-Torq AT6",
            "Active 1.2",
            "Polo 1.0",
            "Polo 1.6",
            "Comfortline 1.0 TSI",
            "Highline 1.0 TSI",
            "Attractive 1.0",
            "Way 1.0 Firefly",
            "Way 1.3",
            "Way 1.3 Firefly Dualogic",
            "Sporting 1.3 Firefly",
            "Attractive 1.0 Evo",
            "Attractive 1.4 Evo",
            "Essence 1.6 16V",
            "Fire 1.0",
            "Fire Way 1.0",
            "Attractive 1.0 Evo",
            "Attractive 1.4 Evo",
            "Trendline 1.6",
            "Track 1.0",
            "Comfortline 1.0",
            "Highline 1.6 16V I-Motion",
            "Run 1.6",
            "connect 1.6 I-Motion",
            "Trendline 1.0",
            "1.0 MPI City",
            "1.0 MPI Track",
            "1.0 MPI Trendline",
            "1.6 MSI Comfortline",
            "1.6 MSI Comfortline I-Motion",
            "1.6 MSI Trendline",
            "1.0 MPI City",
            "1.0 MPI Trendlin",
            "1.0 Eco Joy",
            "1.0 Eco LT",
            "1.4 Eco Activ",
            "1.4 Eco Activ (AUT)",
            "1.4 Eco LT",
            "1.4 Eco LT (AUT)",
            "1.4 Eco LTZ",
            "1.4 Eco LTZ (AUT)",
            "1.4 Effect",
            "1.0 Eco Joy",
            "1.0 Eco LT",
            "1.4 Eco Activ",
            "1.4 Eco Activ (AUT)",
            "1.4 Eco LT",
            "1.4 Eco LT (AUT)",
            "1.4 Eco LTZ",
            "1.4 Eco LTZ (AUT)",
            "Working 1.4 CS",
            "Working 1.4 CE",
            "Working 1.4 CD",
            "Hard Working 1.4 CS",
            "Hard Working 1.4 CE",
            "Hard Working 1.4 CD",
            "Adventure 1.8 CE",
            "Adventure 1.8 Dualogic",
            "Adventure 1.8 CD",
            "Working 1.4",
            "Hard Working 1.4",
            "Hard Working 1.4 (Cabine estendida)",
            "Hard Working 1.4 (Cabine dupla)",
            "Adventure 1.8 (Cabine estendida)",
            "Adventure 1.8 (Cabine dupla)"

};
    private static final String[] NOMES_GASOLINA_CITY = {
            //2020 - onix
            "12.8",
            "12.8",
            "12,9",
            "13,7",
            "12",
            "13,7",
            "12",
            //2019 - onix
            "12,9",
            "12,9",
            "12,4",
            "11,6",
            "12,4",
            "12,4",
            "11,6",
            "12,2",
            "11,6",
            "11,1",
            //2020 - hb20
            "12,8",
            "12,8",
            "12,8",
            "12,5",
            "11,5",
            "11,5",
            //2019- hb20
            "12,5",
            "12,5",
            "12,5",
            "11,6",
            "9,9",
            "9,9",
            "13,4",
            "12,9",
            "11",
            "13,4",
            "13,4",
            "13,4",
            "11,9",
            "11,1",
            "12,9",
            "11",
            "12,9",
            "11",
            "10,9",
            "13,3",
            "11,1",
            "11,1",
            "12,9",
            "11",
            "11",
            "14,9",
            "14,9",
            "14,9",
            "14,2",
            "12,9",
            "12,7",
            "11,4",
            "9,9",
            "9,9",
            "11,5",
            "10,1",
            "13,9",
            "12,9",
            "12",
            "11,6",
            "11,6",
            "13,1",
            "13,1",
            "12,9",
            "13,2",
            "12,9",
            "10,8",
            "10,8",
            "10,1",
            "12,3",
            "11,9",
            "10,8",
            "10,8",
            "10,4",
            "12,3",
            "12,3",
            "10,4",
            "10,4",
            "11,2",
            "12,9",
            "12,9",
            "12,9",
            "12,9",
            "11",
            "11,1",
            "11",
            "11,6",
            "10,3",
            "12,9",
            "12,9",
            "12,4",
            "11,2",
            "12,5",
            "11,7",
            "12,5",
            "11,7",
            "11,5",
            "12,9",
            "12,9",
            "12,4",
            "11,2",
            "12,5",
            "11,7",
            "12,5",
            "11,7",
            "10,3",
            "10,3",
            "10,3",
            "10,3",
            "10,3",
            "10,3",
            "10,3",
            "9,8",
            "9,8",
            "9,8",
            "10,3",
            "10,3",
            "10,3",
            "10,3",
            "9,8",
            "9,8"


};
    private static final String[] NOMES_ETANOL_CITY = {
            //2020 - onix
            "8.7",
            "8.7",
            "8.7",
            "9,6",
            "8,6",
            "9,6",
            "8,6",
            //2019 - onix
            "8,7",
            "8,8",
            "8,5",
            "7,9",
            "8,5",
            "8,5",
            "7,9",
            "8,3",
            "7,9",
            "7,6",
            //2020 - hb20
            "9,1",
            "9,1",
            "9,1",
            "8,6",
            "7,8",
            "7,8",
            //2019 - hb20
            "8,5",
            "8,5",
            "8,5",
            "8,2",
            "7,1",
            "7,1",
            "9,2",
            "8,4",
            "7,8",
            "9,2",
            "9,2",
            "9,2",
            "8,4",
            "7,4",
            "8,4",
            "7,8",
            "8,4",
            "7,8",
            "7,6",
            "9,1",
            "7,8",
            "7,7",
            "8,8",
            "7,6",
            "7,6",
            "10,3",
            "10,3",
            "10,3",
            "9,9",
            "9,2",
            "8,9",
            "7,8",
            "7,0",
            "7,0",
            "8,0",
            "7,1",
            "9,6",
            "8,8",
            "8,2",
            "8",
            "8",
            "9,2",
            "9,2",
            "9,2",
            "9,3",
            "9,2",
            "7,3",
            "7,4",
            "6,9",
            "10",
            "8,2",
            "7,3",
            "7,4",
            "7,4",
            "8,6",
            "8,6",
            "7,4",
            "7,4",
            "7,8",
            "8,8",
            "8,8",
            "8,8",
            "8,8",
            "7,6",
            "7,7",
            "7,6",
            "7,7",
            "8,2",
            "8,9",
            "8,8",
            "8,3",
            "7,7",
            "8,6",
            "7,9",
            "8,6",
            "7,9",
            "7,9",
            "8,9",
            "8,8",
            "8,3",
            "7,7",
            "8,6",
            "7,9",
            "8,6",
            "7,9",
            "7",
            "7",
            "7",
            "7",
            "7",
            "7",
            "6,7",
            "6,7",
            "6,7",
            "7",
            "7",
            "7",
            "7",
            "6,7",
            "6,7"


};
    private static final String[] NOMES_GASOLINA_ESTRA = {
            //2020 - onix
            "15.2",
            "15.2",
            "15.3",
            "17",
            "15,7",
            "17",
            "15,7",
            //2019 - onix
            "15,6",
            "15,3",
            "14,9",
            "14",
            "14,9",
            "14,9",
            "14",
            "13,7",
            "14",
            "12,7",
            //2020 - hb20
            "14,6",
            "14,6",
            "14,6",
            "14,7",
            "13,9",
            "13,9",
            //2019 - hb20
            "14,1",
            "14,1",
            "14,1",
            "14,3",
            "12,5",
            "12,5",
            "15,5",
            "15",
            "14,2",
            "15,5",
            "15,5",
            "15,5",
            "14,4",
            "13,2",
            "14,8",
            "14,2",
            "14,8",
            "14,2",
            "14",
            "14,4",
            "13,6",
            "13,6",
            "14,5",
            "13,1",
            "13,1",
            "15,6",
            "15,6",
            "15,6",
            "15,1",
            "14,3",
            "14,4",
            "13,3",
            "12,8",
            "12,8",
            "13,8",
            "13,2",
            "15,5",
            "14,3",
            "13,9",
            "14,1",
            "14,1",
            "14,5",
            "15,1",
            "14",
            "13,7",
            "14",
            "13,5",
            "13,6",
            "11,9",
            "15",
            "14,6",
            "13,5",
            "13,6",
            "11,8",
            "13,5",
            "13,5",
            "11,6",
            "11,8",
            "12,7",
            "14,2",
            "14,5",
            "14,5",
            "14,5",
            "13,1",
            "13,1",
            "13,1",
            "13,9",
            "14,5",
            "15,3",
            "15,3",
            "13,8",
            "12,6",
            "14,9",
            "13,9",
            "14,9",
            "13,9",
            "13,6",
            "15,3",
            "15,3",
            "13,8",
            "12,6",
            "14,9",
            "13,9",
            "14,9",
            "13,9",
            "10,9",
            "10,9",
            "10,9",
            "10,9",
            "10,9",
            "10,9",
            "11,1",
            "11,1",
            "11,1",
            "10,9",
            "10,9",
            "10,9",
            "10,9",
            "11,1",
            "11,1"

};
    private static final String[] NOMES_ETANOL_ESTRA = {
            //2020 - onix
            "10.5",
            "10.5",
            "10.5",
            "12",
            "10,9",
            "12,2",
            "10,9",
            //2019 - onix
            "10,9",
            "10,5",
            "10,3",
            "9,7",
            "10,3",
            "10,3",
            "9,7",
            "9,4",
            "9,7",
            "8,7",
            //2020 - hb20
            "10,1",
            "10,1",
            "10,1",
            "10,3",
            "9,8",
            "9,8",
            //2019 - hb20
            "9,9",
            "9,9",
            "9,9",
            "10,1",
            "9,4",
            "9,4",
            "10,7",
            "10,3",
            "10,1",
            "10,7",
            "10,7",
            "10,7",
            "9,9",
            "9,4",
            "10,3",
            "10,1",
            "10,3",
            "10,1",
            "10,1",
            "10,1",
            "9,5",
            "9,6",
            "10,3",
            "9,2",
            "9,2",
            "10,8",
            "10,8",
            "10,8",
            "10,7",
            "10,2",
            "10,0",
            "9,2",
            "9,1",
            "9,1",
            "9,6",
            "9,5",
            "10,7",
            "10",
            "9,5",
            "9,8",
            "9,8",
            "10,4",
            "10,4",
            "10,1",
            "10",
            "10,1",
            "9,4",
            "9,6",
            "8,2",
            "13,9",
            "10",
            "9,4",
            "9,3",
            "8,2",
            "9,3",
            "9,3",
            "8,1",
            "8,2",
            "9",
            "10,1",
            "10,3",
            "10,3",
            "10,3",
            "9,2",
            "11,1",
            "9,2",
            "9,6",
            "12,9",
            "10,6",
            "10,5",
            "9,4",
            "8,6",
            "10,2",
            "9,6",
            "10,2",
            "9,6",
            "9,6",
            "10,6",
            "10,5",
            "9,4",
            "8,6",
            "10,2",
            "9,6",
            "10,2",
            "9,6",
            "7,6",
            "7,6",
            "7,6",
            "7,6",
            "7,6",
            "7,6",
            "7,5",
            "7,5",
            "7,5",
            "7,7",
            "7,6",
            "7,7",
            "7,6",
            "7,5",
            "7,5"
};

    public Carro carro;
    public bdmycar BDmycar;
    String carro_recebe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_veicullo);
        btnpesquisa = findViewById(R.id.btn_pesquisa);
        txtpesquisa = findViewById(R.id.edtpesquisa);
       
        Conexao();
        
        ListView lista = findViewById(R.id.listveiculos);
        final ArrayList<ItemVeiculos> veiculosadd = addVeiculos();
        final ArrayAdapter adapter = new VeiculosAdapter(PesquisaVeicullo.this, veiculosadd);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int e, long l) {
                AlertDialog.Builder  builder = new AlertDialog.Builder(PesquisaVeicullo.this);
                CharSequence[] itens = new CharSequence[3];//cria array de 3 caompos e cada um ganha uma valor
                itens[0] = "Preço mais Economico";
                itens[1] = "Definir como meu Veículo";
                itens[2] = "Cancelar";
                builder.setTitle(R.string.opcao1_tela_pesquisa).setItems(itens, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (i==0){//
                            ItemVeiculos veiculoslist = veiculosadd.get(e);
                            Intent intent = new Intent(PesquisaVeicullo.this, Calcular.class);
                            intent.putExtra("GASOLINACONSUMOCITY", veiculoslist.getCitygasolina());
                            intent.putExtra("ETANOLCONSUMOCITY", veiculoslist.getCityetanol());
                            intent.putExtra("GASOLINACONSUMOESTRA", veiculoslist.getEstradagasolina());
                            intent.putExtra("ETANOLCONSUMOESTRA", veiculoslist.getEstradaEtanol());
                            startActivity(intent);
                            finish();
                        }else if(i==1){//
                            if (carro_recebe.toString().equals("")){
                                ItemVeiculos veiculoslist = veiculosadd.get(e);
                                carro.setCITYGASOLINA(veiculoslist.getCitygasolina());
                                carro.setCITYETANOL(veiculoslist.getCityetanol());
                                String resultado =  BDmycar.Inserecarro(carro);
                                Intent intent = new Intent(PesquisaVeicullo.this, Calcular.class);
                                startActivity(intent);
                                finish();
                            }else{
                                try {
                                    ItemVeiculos veiculoslist = veiculosadd.get(e);
                                    carro.setCITYGASOLINA(veiculoslist.getCitygasolina());
                                    carro.setCITYETANOL(veiculoslist.getCityetanol());
                                    String resultado =  BDmycar.Updatecarro(carro);
                                    Toast.makeText(PesquisaVeicullo.this, "" + resultado, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(PesquisaVeicullo.this, Calcular.class);
                                    startActivity(intent);
                                    finish();
                                }catch (SQLException s){
                                    Toast.makeText(PesquisaVeicullo.this, "" + s, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }else{
                            return;
                        }

                    }
                });
                AlertDialog dialog = builder.create();//cria o alerta
                dialog.show();//exibi o alerta
            }
        });

        btnpesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListView lista2 = findViewById(R.id.listveiculos);
                ArrayList<ItemVeiculos> veiculosadd2 = addVeiculosfiltro(txtpesquisa.getText().toString());
                ArrayAdapter adapter2 = new VeiculosAdapter(PesquisaVeicullo.this, veiculosadd2);
                adapter2.clear();
                adapter2.notifyDataSetChanged();
                lista2 = findViewById(R.id.listveiculos);
                veiculosadd2 = addVeiculosfiltro(txtpesquisa.getText().toString());
                adapter2 = new VeiculosAdapter(PesquisaVeicullo.this, veiculosadd2);
                lista2.setAdapter(adapter2);

            }
        });
    }

    public void Conexao(){
        try {
            carro = new Carro();
            BDmycar = new bdmycar(PesquisaVeicullo.this);
            carro_recebe = BDmycar.Buscarcarro();
        }catch (SQLException j){
            Toast.makeText(PesquisaVeicullo.this, "==>"+ j, Toast.LENGTH_SHORT).show();
        }
    }


    private ArrayList<ItemVeiculos> addVeiculos(){
        ArrayList<ItemVeiculos> veiculos = new ArrayList<>();
        for (int x = NOMES_TTITULO.length; x>0; x--){
            String[] titulofiltro = NOMES_TTITULO[x-1].toString().split(" ");
            try {
                for (int z = titulofiltro.length; z>0; z--) {
                    if (NOMES_TTITULO[x - 1].toLowerCase().equals(titulofiltro[x-1].toLowerCase())) {
                        ItemVeiculos e = new ItemVeiculos(NOMES_TTITULO[x - 1], NOMES_MODELO[x - 1], NOMES_GASOLINA_CITY[x - 1], NOMES_ETANOL_CITY[x - 1], NOMES_GASOLINA_ESTRA[x - 1], NOMES_ETANOL_ESTRA[x - 1]);
                        veiculos.add(e);
                    }else{

                    }
                }
            }catch (Exception j){
                ItemVeiculos e = new ItemVeiculos(NOMES_TTITULO[x-1], NOMES_MODELO[x-1], NOMES_GASOLINA_CITY[x-1], NOMES_ETANOL_CITY[x-1],NOMES_GASOLINA_ESTRA[x-1], NOMES_ETANOL_ESTRA[x-1]);
                veiculos.add(e);
            }
        }
        return veiculos;
    }
    private ArrayList<ItemVeiculos> addVeiculosfiltro(String filtro){
        ArrayList<ItemVeiculos> veiculos = new ArrayList<>();
        String[] palavrafiltro = filtro.toString().split(" ");
        if (filtro.length()<=0){
            for (int x = NOMES_TTITULO.length; x>0; x--){
                String[] titulofiltro = NOMES_TTITULO[x-1].toString().split(" ");
                try {
                    for (int z = titulofiltro.length; z>0; z--) {
                        if (NOMES_TTITULO[x - 1].toLowerCase().equals(titulofiltro[x-1].toLowerCase())) {
                            ItemVeiculos e = new ItemVeiculos(NOMES_TTITULO[x - 1], NOMES_MODELO[x - 1], NOMES_GASOLINA_CITY[x - 1], NOMES_ETANOL_CITY[x - 1], NOMES_GASOLINA_ESTRA[x - 1], NOMES_ETANOL_ESTRA[x - 1]);
                            veiculos.add(e);
                        }else{

                        }
                    }
                }catch (Exception j){
                    ItemVeiculos e = new ItemVeiculos(NOMES_TTITULO[x-1], NOMES_MODELO[x-1], NOMES_GASOLINA_CITY[x-1], NOMES_ETANOL_CITY[x-1],NOMES_GASOLINA_ESTRA[x-1], NOMES_ETANOL_ESTRA[x-1]);
                    veiculos.add(e);
                }
            }
        }else{
            for (int x = NOMES_TTITULO.length; x>0; x--){
                for (int y = palavrafiltro.length; y > 0; y--){
                    String[] titulofiltro = NOMES_TTITULO[x-1].toString().split(" ");
                    String[] modelofiltro = NOMES_MODELO[x-1].toString().split(" ");
                    for (int z = titulofiltro.length; z>0; z--) {
                        if (palavrafiltro[y - 1].toLowerCase().equals(titulofiltro[z - 1].toLowerCase())) {
                            ItemVeiculos e = new ItemVeiculos(NOMES_TTITULO[x - 1], NOMES_MODELO[x - 1], NOMES_GASOLINA_CITY[x - 1], NOMES_ETANOL_CITY[x - 1], NOMES_GASOLINA_ESTRA[x - 1], NOMES_ETANOL_ESTRA[x - 1]);
                            veiculos.add(e);
                        }
                    }
                    for (int w = modelofiltro.length; w > 0; w--) {
                        if (palavrafiltro[y - 1].toLowerCase().equals(modelofiltro[w - 1].toLowerCase())) {
                            ItemVeiculos e = new ItemVeiculos(NOMES_TTITULO[x - 1], NOMES_MODELO[x - 1], NOMES_GASOLINA_CITY[x - 1], NOMES_ETANOL_CITY[x - 1], NOMES_GASOLINA_ESTRA[x - 1], NOMES_ETANOL_ESTRA[x - 1]);
                            veiculos.add(e);
                        }
                    }
                }
            }
        }

        return veiculos;
    }
}