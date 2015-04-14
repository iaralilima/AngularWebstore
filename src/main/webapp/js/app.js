var app = angular.module('HelloAngular',['ngResource']);

app.factory('ContatoDAO', function($resource) {
   return $resource('/BaseRestAngular/services/contatos',{}, {
      query: {method: 'GET', isArray:true},
      create: {method:'POST'}
   });
});

app.controller('PrimeiroController' , function($scope, ContatoDAO) {
  $scope.mensagem = 'Funcionou!';  
  $scope.contatos = ContatoDAO.query();
  
  $scope.adicionarContato = function() {
    $scope.contatos.push($scope.contato);
    ContatoDAO.create($scope.contato);
    $scope.contato = {};
  }

});