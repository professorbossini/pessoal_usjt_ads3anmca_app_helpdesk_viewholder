package br.com.bossini.pessoal_usjt_ads3anmca_app_helpdesk_viewholder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChamadoDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "chamados.db";
    private static final int DB_VERSION = 1;
    public ChamadoDBHelper (Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(HelpDeskContract.createTableFila());
        db.execSQL(HelpDeskContract.createTableChamado());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
