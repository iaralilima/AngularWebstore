(function() {
    
    var app = angular.module('AngularWebstore',['ngResource']);

    var carrinho = {};

    app.factory('ProdutoDAO', function($resource) {
       return $resource('/AngularWebstore/services/produtos',{}, {
          query: {method: 'GET', isArray:true},
          create: {method:'POST'}
       });
    });

    app.controller('ProdutosController', function($scope, ProdutoDAO) {
        this.produtos = ProdutoDAO.query();
    });

    app.factory('CarrinhoDAO', function($resource) {
       return $resource('/AngularWebstore/services/carrinho',{}, {
          query: {method: 'GET', isArray:false},
          create: {method:'POST'},
          limpar: {method:'POST'}
       });
    });

    app.controller('CarrinhoController', function($scope, CarrinhoDAO, ProdutoDAO) {
        this.carrinho = CarrinhoDAO.query();

        this.adicionarProduto = function(produto) {
//            this.carrinho.produtos.push("teste");
            CarrinhoDAO.create(produto);
//          this.carrinho = CarrinhoDAO.query();
//          console.log(this.carrinho.produtos);
//          this.carrinho = CarrinhoDAO.query();
//            this.carrinho.produtos.push(produto);
            console.log(this.carrinho.produtos.push(produto));
        };
        
        this.limparCarrinho = function() {
            CarrinhoDAO.limpar();
            this.carrinho = CarrinhoDAO.query();
        };
    });
    
    
    
})();