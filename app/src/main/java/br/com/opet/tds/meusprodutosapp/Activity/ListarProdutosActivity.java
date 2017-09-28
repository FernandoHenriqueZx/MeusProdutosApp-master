package br.com.opet.tds.meusprodutosapp.Activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.opet.tds.meusprodutosapp.Adapter.ProdutoAdapter;
import br.com.opet.tds.meusprodutosapp.DAO.Produto;
import br.com.opet.tds.meusprodutosapp.DAO.ProdutoDAO;
import br.com.opet.tds.meusprodutosapp.R;

public class ListarProdutosActivity extends Activity {


    private ListView listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);

        listaProdutos = (ListView) findViewById(R.id.listProdutos);
        ProdutoDAO produtoDAO = new ProdutoDAO(this);
        List<Produto> produtos = produtoDAO.carregaDadosLista();
        ProdutoAdapter myAdapter = new ProdutoAdapter(this,R.layout.item_produto,produtos);
        listaProdutos.setAdapter(myAdapter);
    }
}
