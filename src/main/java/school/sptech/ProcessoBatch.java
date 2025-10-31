package school.sptech;

import java.util.List;

public class ProcessoBatch {

    //Método “orquestrador”
    public void executar() {
        int qtdLote = 100;

        Extract extracao = new Extract();
        List<String> dados = extracao.extracao();

        Load carregamento = new Load();
        carregamento.carregamentoEmLote(dados, qtdLote);
    }
}
