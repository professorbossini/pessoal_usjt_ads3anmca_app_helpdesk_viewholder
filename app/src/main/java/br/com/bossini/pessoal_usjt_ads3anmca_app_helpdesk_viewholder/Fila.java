package br.com.bossini.pessoal_usjt_ads3anmca_app_helpdesk_viewholder;

import java.io.Serializable;
import java.util.List;

class Fila implements Serializable {
    private String nome;
    private int iconId;

    public Fila (String nome, int iconId){
        setNome(nome);
        setIconId(iconId);
    }

    private List<Chamado> chamados;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
