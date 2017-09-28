package br.com.opet.tds.meusprodutosapp.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.opet.tds.meusprodutosapp.DAO.Produto;
import br.com.opet.tds.meusprodutosapp.R;

/**
 * Created by ZX on 13/09/2017.
 */

public class ProdutoAdapter extends ArrayAdapter<Produto> {

    private int resource;
    private List<Produto> produtos;

    public ProdutoAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Produto> objects) {
        super(context, resource, objects);
        this.resource = resource;
        produtos = objects;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        View mView = currentView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(resource,null,false);
        }

        Produto produto = produtos.get(position);

        TextView textID = (TextView) mView.findViewById(R.id.textID);
        TextView textNome = (TextView) mView.findViewById(R.id.textNome);
        TextView textDescricao = (TextView) mView.findViewById(R.id.textDescricao);
        TextView textPreco = (TextView) mView.findViewById(R.id.textPreco);
        TextView textVendido = (TextView) mView.findViewById(R.id.textVendido);

        if(textID != null){
            textID.setText(String.valueOf(produto.getID()));
        }
        if(textNome != null){
            textNome.setText(produto.getNome());
        }
        if(textDescricao != null){
            textDescricao.setText(produto.getDescricao());
        }
        if(textPreco != null){
        textPreco.setText((int) produto.getPreco());
    }
        if(textVendido != null){
            textVendido.setText(String.valueOf(produto.isVendido()));
        }
        return mView;
    }
}
