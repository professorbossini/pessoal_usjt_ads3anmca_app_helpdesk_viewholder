package br.com.bossini.pessoal_usjt_ads3anmca_app_helpdesk_viewholder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChamadoArrayAdapter extends ArrayAdapter <Chamado> {

    public ChamadoArrayAdapter (Context context, List<Chamado> chamados){
        super(context, -1, chamados);
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    LayoutInflater.from(getContext());
            convertView =
                    inflater.inflate(R.layout.item_de_lista, parent, false);
        }
        Chamado chamadoDaVez = getItem(position);

        ImageView filaIconImageView =
                convertView.findViewById(R.id.filaIconImageView);
        TextView descricaoChamadoNaListTextView =
                convertView.findViewById(R.id.descricaoChamadoNaListTextView);
        TextView dataAberturaTextView =
                convertView.findViewById(R.id.dataAberturaTextView);
        TextView dataFechamentoTextView =
                convertView.findViewById(R.id.dataFechamentoTextView);
        TextView statusChamadoTextView =
                convertView.findViewById(R.id.statusChamadoTextView);
        filaIconImageView.setImageResource(
                chamadoDaVez.
                        getFila().
                        getIconId()
        );
        descricaoChamadoNaListTextView.setText(chamadoDaVez.getDescricao());
        dataAberturaTextView.
                setText(DateHelper.format(chamadoDaVez.getDataAbertura()));
        if (chamadoDaVez.getDataFechamento() != null){
            dataFechamentoTextView.setText(
                    DateHelper.format(chamadoDaVez.getDataFechamento())
            );
        }
        statusChamadoTextView.setText(chamadoDaVez.getStatus());
        return convertView;
    }
}
