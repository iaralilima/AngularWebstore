(function() {
    
    var app = angular.module('AngularWebstore',['ngResource']);

    app.factory('ProdutoDAO', function($resource) {
       return $resource('/AngularWebstore/services/produtos',{}, {
          query: {method: 'GET', isArray:true},
          create: {method:'POST'}
       });
    });

    app.controller('ProdutosController', function($scope, ProdutoDAO) {
        this.produtos = ProdutoDAO.query();
        console.log(this.produtos[1]);
    });

})();