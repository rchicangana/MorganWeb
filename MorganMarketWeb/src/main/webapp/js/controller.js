'use strict';


/* Controllers */
var module = angular.module('mercadoMorgan.controllers', []);

//We already have a limitTo filter built-in to angular,
//let's make a startFrom filter
module.filter('startFrom', function () {
    return function (input, start) {
        if (!input || !input.length) {
            return;
        }
        start = +start; //parse to int
        return input.slice(start);
    };
});

module.filter('truncate', function () {
    return function (text, length, end) {
        if (isNaN(length))
            length = 10;

        if (end === undefined)
            end = "...";

        if (text.length <= length || text.length - end.length <= length) {
            return text;
        } else {
            return String(text).substring(0, length - end.length) + end;
        }

    };
});

module.controller('welcomeCtrl', ['$scope', '$http', '$window', function ($scope, $http, $window) {
    $scope.login = true;
    
}]);

