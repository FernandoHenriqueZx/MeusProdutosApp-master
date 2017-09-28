package br.com.opet.tds.meusprodutosapp.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.opet.tds.meusprodutosapp.DAO.Produto;
import br.com.opet.tds.meusprodutosapp.DAO.ProdutoDAO;
import br.com.opet.tds.meusprodutosapp.R;

public class CadastrarProdutoActivity extends Activity {

    private EditText editNome;
    private Spinner spinnerDescricao;
    private EditText editPreco;
    private CheckBox checkVendido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);

        editNome = (EditText) findViewById(R.id.editNome);
        spinnerDescricao = (Spinner) findViewById(R.id.spinnerDescricao);
        editPreco = (EditText) findViewById(R.id.editPreco);
        checkVendido = (CheckBox) findViewById(R.id.checkVendido);
    }

    public void salvarProduto(View v){
        ProdutoDAO produtoDAO = new ProdutoDAO(this);
        Produto produto = new Produto();
        produto.setNome(editNome.getText().toString());
        produto.setDescricao(spinnerDescricao.getSelectedItem().toString());
        produto.setPreco(Double.parseDouble(editPreco.getText().toString()));
        produto.setVendido(checkVendido.isChecked());

        long resultado = produtoDAO.insereDado(produto);

        if(resultado > 0){
            exibirMensagem("Cadastro realizado com sucesso!");
        }
        else{
            exibirMensagem("Erro ao cadastrar o item.");
        }
    }

    private void exibirMensagem(String mensagem){
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}
