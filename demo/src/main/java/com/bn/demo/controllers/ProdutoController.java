package com.bn.demo.controllers;

import com.bn.demo.models.ProdutoModel;
import com.bn.demo.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController//coloca a classe como uma configuracao de endpoint/renderizado posteriormente, de forma com que
//demarca essa classe como fruto de requisicao rest(separado em controler que recebe as req) e nao é criada diversas instancias
@RequestMapping(path = {"/produtos", "/produtos/"})//define as rotas que serao direcionadas À esse repositorio
public class ProdutoController {

    @Autowired//injeta a dependencia da classe marcada, de forma com que ao iniciar, o compilador ja sabe que ela
    //depende da outra classe
    private ProdutoService produtoService;

    @GetMapping//define essa funcao como correspondente em caso de uma requisicao http do tipo GET
        public ResponseEntity<List<ProdutoModel> > buscarTodosOsProdutos(){
          List<ProdutoModel> requeste = produtoService.buscarTodosProdutos();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping//define essa funcao como correspondente em caso de uma requisicao http do tipo post
    public ResponseEntity <ProdutoModel> criarProdutos(@RequestBody ProdutoModel produtoModel){
        ProdutoModel requeste = produtoService.criarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(produtoModel.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(requeste);
    }
    //define essa funcao como correspondente em caso de uma requisicao http do tipo DELETE no endpoint do requestMapping/id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProdutos(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")//define essa funcao como correspondente em caso de uma requisicao http do tipo GET no endpoint do requestMapping/id
    public Optional<ProdutoModel> buscarProdutoPorId(@PathVariable Long id){
        return  produtoService.buscarProdutoId(id);
    }

    @PutMapping("/{id}")//define essa funcao como correspondente em caso de uma requisicao http do tipo POST para insercao de objeto
    // no endpoint do requestMapping/id
    public ResponseEntity <ProdutoModel> atualizarProdutos(@PathVariable Long id, @RequestBody ProdutoModel ProdutoModel){
        ProdutoModel requeste = produtoService.atualizarProduto(id, ProdutoModel);
        return  ResponseEntity.ok().body(requeste);

    }








}
