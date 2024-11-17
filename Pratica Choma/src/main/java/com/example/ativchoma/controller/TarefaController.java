package com.example.ativchoma.controller;
import com.example.ativchoma.model.Tarefa;
import com.example.ativchoma.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("tasks")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    private Tarefa addTarefa(@RequestBody Tarefa tarefa){
        return tarefaService.addTarefa(tarefa);
    }

    @GetMapping("/all")
    private List<List<Tarefa>> getTarefas(){
        return tarefaService.getAllTarefas();
    }

    @GetMapping("/prioridade/{prioridade}") //filtro por prioridade
    private List<Tarefa> getTarefasByPrioridade(@PathVariable String prioridade){
        return tarefaService.getTarefasByPrioridade(prioridade);
    }

    @GetMapping("/dataLimite/{dataLimite}") //filtro por dataFinal
    private List<Tarefa> getTarefasByDataLimite(@PathVariable Date dataFinal){
        return tarefaService.getTarefasByDataLimite(dataFinal);
    }

    @GetMapping("/relatorio") //gera relatorio filtrando por tarefas nao concluidas que sairam da data limite
    private List<List<Tarefa>> getRelatorio(){
        return tarefaService.getRelatorio();
    }

    @PatchMapping("/{id}") //alterar status
    public Tarefa mudarStatus(@PathVariable int id){
        return tarefaService.mudarStatus(id);
    }

    @PatchMapping("/edit/{id}") //editar tarefa
    public Tarefa editarTarefa(@PathVariable int id, @RequestBody Tarefa tarefa){
        return tarefaService.editarTarefa(id, tarefa);
    }

    @DeleteMapping("/{id}") //deletar tarefa
    public void excluirTarefa(@PathVariable int id){
        tarefaService.deletarTarefa(id);
    }
}