package br.com.bossini.pessoal_usjt_ads3anmca_app_helpdesk_viewholder;

import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HelpDeskContract {
    private HelpDeskContract(){

    }

    private static List <Fila> filas;

    static{
        filas = new ArrayList<>();
        filas.add(new Fila (1, "Desktops", R.drawable.ic_computer_black_24dp));
        filas.add(new Fila (2, "Telefonia", R.drawable.ic_phone_in_talk_black_24dp));
        filas.add(new Fila (3, "Redes", R.drawable.ic_network_check_black_24dp));
        filas.add(new Fila (4, "Servidores", R.drawable.ic_poll_black_24dp));
        filas.add(new Fila (5, "Novos projetos", R.drawable.ic_new_releases_black_24dp));
    }

    public static String insertFilas (){
        //teste na branch andre
        String template = "INSERT INTO %s (%s, %s, %s) VALUES (%d, '%s', %d);";
        StringBuilder sb = new StringBuilder("");
        for (Fila fila : filas){
            sb.append(
              String.format(
                      Locale.getDefault(),
                      template,
                      FilaContract.TABLE_NAME,
                      FilaContract.COLUMN_NAME_ID,
                      FilaContract.COLUMN_NAME_NOME,
                      FilaContract.COLUMN_NAME_ICON_ID,
                      fila.getId(),
                      fila.getNome(),
                      fila.getIconId()
              )
            );
        }
        return sb.toString();
    }


    public static class ChamadoContract implements BaseColumns{
        public static final String TABLE_NAME = "tb_chamado";
        public static final String COLUMN_NAME_ID = "id_chamado";
        public static final String COLUMN_NAME_DESCRICAO = "descricao";
        public static final String COLUMN_NAME_STATUS = "status";
        public static final String COLUMN_NAME_DT_ABERTURA = "dt_abertura";
        public static final String COLUMN_NAME_DT_FECHAMENTO = "dt_fechamento";
    }

    public static class FilaContract implements BaseColumns{
        public static final String TABLE_NAME = "tb_fila";
        public static final String COLUMN_NAME_ID = "id_fila";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_ICON_ID = "icon_id";
    }

    public static String createTableFila (){
        String template = "CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER)";
        return
                String.format(
                    template,
                    FilaContract.TABLE_NAME,
                    FilaContract.COLUMN_NAME_ID,
                    FilaContract.COLUMN_NAME_NOME,
                    FilaContract.COLUMN_NAME_ICON_ID
                );
    }

    public static String createTableChamado(){
        String template =
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER, %s INTEGER, %s TEXT, %s INTEGER, FOREIGN KEY (%s) REFERENCES %s (%s))";
        return
                String.format(
                        template,
                        ChamadoContract.TABLE_NAME,
                        ChamadoContract.COLUMN_NAME_ID,
                        ChamadoContract.COLUMN_NAME_DESCRICAO,
                        ChamadoContract.COLUMN_NAME_DT_ABERTURA,
                        ChamadoContract.COLUMN_NAME_DT_FECHAMENTO,
                        ChamadoContract.COLUMN_NAME_STATUS,
                        FilaContract.COLUMN_NAME_ID,
                        FilaContract.COLUMN_NAME_ID,
                        FilaContract.TABLE_NAME,
                        FilaContract.COLUMN_NAME_ID
                );
    }
}
