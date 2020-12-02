package br.com.lucassouza.sts.pjpaguepouco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.lucassouza.sts.pjpaguepouco.dominio.entidades.Carro;


public class bdmycar extends SQLiteOpenHelper {
    public bdmycar(Context context) {
        super(context, "DADOS", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_carro = "CREATE TABLE CARRO( CODIGO INTEGER PRIMARY KEY AUTOINCREMENT, CITYGASOLINA TEXT, CITYETANOL TEXT );";

        db.execSQL(sql_carro);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql_carro = "DROP TABLE IF EXISTS CARRO;";

        db.execSQL(sql_carro);
        onCreate(db);
    }

    public String Inserecarro(Carro carro){
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues dados_carros = new ContentValues();

            dados_carros.put("CITYGASOLINA", carro.getCITYGASOLINA());
            dados_carros.put("CITYETANOL", carro.getCITYETANOL());

            db.insertOrThrow("CARRO", null, dados_carros);
            db.close();
        }catch (SQLException K){
            return "erro == > " + K;
        }

        return "Sucesso";
    }
    public String Updatecarro(Carro carro){
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues dados_carros = new ContentValues();

            dados_carros.put("CITYGASOLINA", carro.getCITYGASOLINA());
            dados_carros.put("CITYETANOL", carro.getCITYETANOL());

            db.update("CARRO", dados_carros, null, null);
            db.close();
        }catch (SQLException K){
            return "erro == > " + K;
        }

        return "Atualizado";
    }

    public String Buscarcarro(){
        try{
            Carro carro = new Carro();
            String sql_busca_carro = "SELECT CITYGASOLINA, CITYETANOL FROM CARRO;";
            SQLiteDatabase db = getReadableDatabase();
            Cursor c = db.rawQuery(sql_busca_carro, null);
            c.moveToFirst();

            do{
                if (c.getCount() > 0){
                    carro.setCITYGASOLINA(c.getString(c.getColumnIndexOrThrow("CITYGASOLINA")));
                    carro.setCITYETANOL(c.getString(c.getColumnIndexOrThrow("CITYETANOL")));
                    db.close();
                    c.close();
                    return  ""+ carro.getCITYGASOLINA().toString()+ " " + carro.getCITYETANOL().toString()+ "";
                }
            }
            while(c.moveToNext());

            db.close();
            c.close();
        }catch (SQLException k){
            return ""+k;
        }
       return "";
    }
}
