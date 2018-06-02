
module.controller('solicitudCtrl', ['$scope', '$http', '$window', '$filter', function ($scope, $http, $window, $filter) {

        var urlBase = "http://busServicios.com:8080/MorganMarketServices/services/solicitud/";
        
        $scope.errores = {};
        $scope.datosFormulario = {};
        $scope.datos = [];
        $scope.catalogo = [];
        $scope.nuevoRegistro = true;
        $scope.panelEditar = false;
        $scope.currentPage = 0;
        $scope.pageSize = 10;

        $scope.estados = [
            {"id": "1", "name": "Activo"},
            {"id": "2", "name": "Inactivo"}
        ];


        $scope.numberOfPages = function () {
            if ($scope.datos) {
                return Math.ceil($scope.datos.length / $scope.pageSize);
            }
            return 1;
        };

      
        $('.modal-backdrop').hide();
        $('#dlgParameterize').modal("hide");
        $('#dlgEspera').modal({backdrop: 'static', keyboard: false});
        $http.get(urlBase + "catalogo/consultar",
                {'Content-Type': 'application/json'
                }).then(function (response) {
            $scope.catalogo = response.data;
            $('#dlgEspera').modal('hide');
        }, function (response) {
            $('#dlgEspera').modal('hide');
            $('#msgConsulta').html('Ha ocurrido un error al consultar las tablas, por favor intente nuevamente');
            $('#dlgConsulta').modal();
        });

        $scope.nuevo = function (item) {
            $scope.datosFormulario = {};
            $scope.panelEditar = true;
            $scope.nuevoRegistro = true;
        };

        $scope.editar = function (item) {
            $scope.datosFormulario = item;
            $scope.panelEditar = true;
            $scope.nuevoRegistro = false;
        };


        $scope.cancelar = function () {
            $scope.datosFormulario = {};
            $scope.panelEditar = false;
        };

        


        $scope.guardar = function () {

            
            //cambiamos el estado a priorizado
            if ($scope.nuevoRegistro) {
                $('#dlgEspera').modal({backdrop: 'static', keyboard: false});
                
                $http.post(urlBase + "registrar/1", $scope.datosFormulario,
                        {'Content-Type': 'application/json'
                        }).then(function (response) {
                    if (response.data.resultado === "OK") {
                        $('#dlgEspera').modal('hide');
                        $('#msgConsulta').html('Transaccion Realizada correctamente');
                        $('#dlgConsulta').modal();
                        $scope.datos.push(response.data)
                        $scope.nuevoRegistro = false;
                        $scope.datosFormulario.detalleSolicitudList=[];
                        
                    }
                    ;
                    $('#dlgEspera').modal('hide');
                }, function (response) {
                    $('#dlgEspera').modal('hide');
                    $('#msgConsulta').html('Ha ocurrido un error al editar la informacion ' + response.data.descripcion);
                    $('#dlgConsulta').modal();
                });
            } else {
                $('#dlgEspera').modal({backdrop: 'static', keyboard: false});
                $http.post(urlBase + "solicitud/radicar/"+$scope.datosFormulario.id, {},
                        {'Content-Type': 'application/json'
                        }).then(function (response) {
                    if (response.data.resultado === "OK") {
                        $('#dlgEspera').modal('hide');
                        $('#msgConsulta').html('Transaccion Realizada correctamente');
                        
                    }
                    ;
                    $('#dlgEspera').modal('hide');
                }, function (response) {
                    $('#dlgEspera').modal('hide');
                    $('#msgConsulta').html('Ha ocurrido un error al editar la informacion ' + response.data.descripcion);
                    $('#dlgConsulta').modal();
                });
            }


        };
        
        


    }]);

