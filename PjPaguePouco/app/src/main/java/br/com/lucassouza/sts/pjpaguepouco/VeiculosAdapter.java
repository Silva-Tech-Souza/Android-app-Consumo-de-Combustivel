package br.com.lucassouza.sts.pjpaguepouco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class VeiculosAdapter extends ArrayAdapter<ItemVeiculos> {
     private  final Context context;
     private final ArrayList<ItemVeiculos> elementos;

     public VeiculosAdapter(Context context, ArrayList<ItemVeiculos> elementos){
         super(context,R.layout.item_escolha_lista_veiculos , elementos);
         this.context = context;
         this.elementos = elementos;
     }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowview = inflater.inflate(R.layout.item_escolha_lista_veiculos, parent, false);

        TextView titulo = (TextView) rowview.findViewById(R.id.txttitulo);
        TextView modelo = (TextView)  rowview.findViewById(R.id.txtmodelo);
        TextView gasolinacity = (TextView)  rowview.findViewById(R.id.txtgasoliinacity);
        TextView etanolcity = (TextView)  rowview.findViewById(R.id.txtetanolcity);
        TextView gasonilaestrada = (TextView)  rowview.findViewById(R.id.txtgasoliinaestrada);
        TextView etanolestrada = (TextView)  rowview.findViewById(R.id.txtetanolestrada);

        titulo.setText(elementos.get(position).getTitulo());
        modelo.setText(elementos.get(position).getModelo());
        gasolinacity.setText("Gasolina\n"+elementos.get(position).getCitygasolina()+" km/l");
        etanolcity.setText("Etanol\n"+elementos.get(position).getCityetanol()+" km/l");
        gasonilaestrada.setText("Gasolina\n"+elementos.get(position).getEstradagasolina()+" km/l");
        etanolestrada.setText("Etanol\n"+elementos.get(position).getEstradaEtanol()+" km/l");

        return rowview;
    }


}
