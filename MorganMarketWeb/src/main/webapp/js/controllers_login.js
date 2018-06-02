'use strict';
/* Controllers */
var module = angular.module('mercadoMorganLogin.controllers', []);



module.controller('loginCtrl', ['$scope', '$http', function ($scope, $http) {


        $scope.login = function () {
            $('#dlgEspera').modal({backdrop: 'static', keyboard: false});
            $http.post('./webresources/autenticar',$scope.datosFormulario,
                {'Content-Type': 'application/json'})
            .then(function (response) {
                if(response.data.codigo==="OK"){
                    window.location.href = './index.html';
                } else {
                    $('#msgConsulta').html(response.data.mensaje);
                    $('#dlgConsulta').modal();
                }
                $('#dlgEspera').modal('hide');
        }, function (response) {
            $('#dlgEspera').modal('hide');
            $('#msgConsulta').html(response.data.mensaje);
            $('#dlgConsulta').modal();
        });
            
        };

    }]);

module.controller('logoutCtrl', ['$scope', '$http', function ($scope, $http) {

        $http['delete']('./webresources/autenticar', {}
        ).success(function (data, status, headers, config) {
            window.location.href = './login.html';
        }).error(function (data, status, headers, config) {
            $('#msgConsulta').html('Fallo el ingreso, por favor verifique e intente nuevamente');
            $('#dlgConsulta').modal();
        });

    }]);

