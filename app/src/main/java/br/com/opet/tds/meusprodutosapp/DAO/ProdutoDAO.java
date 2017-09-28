package br.com.opet.tds.meusprodutosapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.opet.tds.meusprodutosapp.Factory.DatabaseFactory;
import br.com.opet.tds.meusprodutosapp.Util.BancoUtil;

/**
 * Created by Zx on 27/09/2017.
 */

public class ProdutoDAO {
    private SQLiteDatabase db;
    private DatabaseFactory banco;

    public ProdutoDAO(Context context) {
        banco = new DatabaseFactory(context);
    }

    public long insereDado(Produto produto) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(BancoUtil.NOME_PRODUTO, produto.getNome());
        valores.put(BancoUtil.DESCRICAO_PRODUTO, produto.getDescricao());
        valores.put(BancoUtil.PRECO_PRODUTO, produto.getPreco());
        valores.put(BancoUtil.PRODUTO_VENDIDO, produto.isVendido() ? 1 : 0);

        resultado = db.insert(BancoUtil.TABELA_PRODUTO, null, valores);
        db.close();

        return resultado;

    }

    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {BancoUtil.ID_PRODUTO, BancoUtil.NOME_PRODUTO, BancoUtil.DESCRICAO_PRODUTO, BancoUtil.PRECO_PRODUTO, BancoUtil.PRODUTO_VENDIDO};
        db = banco.getReadableDatabase();

        cursor = db.query(BancoUtil.TABELA_PRODUTO, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public List<Produto> carregaDadosLista() {
        Cursor cursor = carregaDados();
        List<Produto> produtos = new ArrayList<>();

        try {
            do  {
                Produto produto = new Produto();
                int ID = cursor.getInt(cursor.getColumnIndexOrThrow(BancoUtil.ID_PRODUTO));
                String nome = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.NOME_PRODUTO));
                String descricao = cursor.getString(cursor.getColumnIndexOrThrow(BancoUtil.DESCRICAO_PRODUTO));
                double preco = cursor.getDouble(cursor.getColumnIndexOrThrow(BancoUtil.PRECO_PRODUTO));
                int vendido = cursor.getInt(cursor.getColumnIndexOrThrow(BancoUtil.PRODUTO_VENDIDO));

                produto.setID(ID);
                produto.setNome(nome);
                produto.setDescricao(descricao);
                produto.setPreco(preco);
                if(vendido == 1)
                    produto.setVendido(true);
                else
                    produto.setVendido(false);

                produtos.add(produto);
            }while(cursor.moveToNext());
        } finally {
            cursor.close();
        }

        return produtos;
    }
}