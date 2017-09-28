package br.com.opet.tds.meusprodutosapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import br.com.opet.tds.meusprodutosapp.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void carregaItemMenu(View v){
        switch (v.getId()){
            case R.id.btnInserir:
                carregarIntent(CadastrarProdutoActivity.class);
                break;
            case R.id.btnListar:
                carregarIntent(ListarProdutosActivity.class);
                break;
        }
    }

    private void carregarIntent(Class classe){
        Intent intent = new Intent(MainActivity.this,classe);
        startActivity(intent);
    }
}
