'use strict';


// Declare app level module which depends on filters, and services
var module=angular.module('mercadoMorgan', [
  'ngRoute',
  'ui.bootstrap',
  'mercadoMorgan.controllers'
]);
module.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/tablagen', {templateUrl: 'partials/solicitud.html', controller: 'solicitudCtrl'});
  $routeProvider.when('/welcome', {templateUrl: 'partials/bienvenida.html', controller: 'welcomeCtrl'});
  $routeProvider.otherwise({redirectTo: '/welcome'}); 
}]);


