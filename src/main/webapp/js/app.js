(function() {
    
    var app = angular.module('AngularWebstore',['ngResource', 'ngRoute']);
    var carrinho = {};
    app.config(function($routeProvider, $locationProvider) {
       $locationProvider.html5Mode({
               enabled: true,
               requireBase: true
       });
       
       $routeProvider
               .when('/', {
                   templateUrl:'views/index.html'
                })
                .when('/produtos', {
                    templateUrl:'views/produtos.html',
                    controller:'ProdutosController'
                })
                .when('/carrinho', {
                    templateUrl:'views/carrinho.html',
                    controller:'CarrinhoController'
                })
                .otherwise ({ redirectTo: '/' });
    });

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
          CarrinhoDAO.create(produto);
          this.carrinho.produtos.push(produto);
        };
        
        this.limparCarrinho = function() {
            CarrinhoDAO.limpar();
            this.carrinho = CarrinhoDAO.query();
        };
        
        $scope.sayHello = function() {
            $scope.greeting = 'Hello ' + $scope.carrinho.produtos.length + '!';
        };
    });
    
    app.directive('produtoTile', function() {
      return {
        restrict: 'A',
        templateUrl: "inc/produto-tile.html"
      };
    });
    
})();
