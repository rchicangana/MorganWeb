'use strict';


// Declare app level module which depends on filters, and services
var module=angular.module('mercadoMorganLogin', [
  'ngRoute',
  'mercadoMorganLogin.controllers'
]);
module.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login', {templateUrl: 'partials/login.html', controller: 'loginCtrl'});
  $routeProvider.when('/logout', {templateUrl: 'partials/login.html', controller: 'logoutCtrl'});
  $routeProvider.otherwise({redirectTo: '/login'}); 
}]);
