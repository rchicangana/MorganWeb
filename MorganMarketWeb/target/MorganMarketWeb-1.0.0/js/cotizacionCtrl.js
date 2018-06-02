
module.controller('cotizacionCtrl', ['$scope', '$http', '$window', '$filter', function ($scope, $http, $window, $filter) {

        var urlBase = "http://busServicios.com:8080/MorganMarketServices/services/solicitud/";
        
        $scope.errores = {};
        $scope.datos = [];
        $scope.datosFormulario = {};
        $scope.currentPage = 0;
        $scope.pageSize = 10;

        

        $scope.numberOfPages = function () {
            if ($scope.datos) {
                return Math.ceil($scope.datos.length / $scope.datos);
            }
            return 1;
        };

        $('.modal-backdrop').hide();
        $('#dlgParameterize').modal("hide");
        $('#dlgEspera').modal({backdrop: 'static', keyboard: false});
        $http.get(urlBase + "cotizacio/consultar",
                {'Content-Type': 'application/json'
                }).then(function (response) {
            $scope.tablas = response.data;
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
            $scope.datosFormulario.synEstado = item.synEstado;
        };


        $scope.cancelar = function () {
            $scope.datosFormulario = {};
            $scope.panelEditar = false;
        };

        $scope.editarDato = function (item) {
            $scope.nuevoRegistroDato = false;
            $scope.dato = item;
        };

        $scope.nuevoDato = function () {
            $scope.nuevoRegistroDato = true;
            $scope.dato = {};
        };


        $scope.guardar = function () {

            var error = false;
            $scope.errores = {};

            if ($('#synNomtab').val() == "") {
                $scope.errores.synPriori = "Debe ingresar nombre para la tabla";
                error = true;
            }

            if ($('#synDestab').val() == "") {
                $scope.errores.synVigenc = "Debe ingresar el nombre de la tabla";
                error = true;
            }

            

            if (error) {
                return;
            }
            //cambiamos el estado a priorizado
            if ($scope.nuevoRegistro) {
                $('#dlgEspera').modal({backdrop: 'static', keyboard: false});
                
                $http.post(urlBase + "guardar", $scope.datosFormulario,
                        {'Content-Type': 'application/json'
                        }).then(function (response) {
                    if (response.data.resultado === "OK") {
                        $('#dlgEspera').modal('hide');
                        $('#msgConsulta').html('Transaccion Realizada correctamente');
                        $('#dlgConsulta').modal();
                        $scope.tablas.push(response.data)
                        $scope.nuevoRegistro = false;
                        $scope.datosFormulario.syngenDatosgenList=[];
                        
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
                $http.post(urlBase + "editar", $scope.datosFormulario,
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
        
        $scope.guardarDato = function () {

            var error = false;
            $scope.errores.dato = {};

            if ($('#synCoddat').val() == "") {
                $scope.errores.dato.synCoddat = "Debe ingresar un identificador para el dato";
                error = true;
            }

           if ($('#synDesdat').val() == "") {
                $scope.errores.dato.synDesdat = "Debe ingresar un nombre para el dato";
                error = true;
            }

            


            if (error) {
                return;
            }
            //cambiamos el estado a priorizado
            if ($scope.nuevoRegistroDato) {
                $('#dlgEspera').modal({backdrop: 'static', keyboard: false});
                $scope.dato.synNomtab = $scope.datosFormulario.synNomtab;
                $http.post(urlBaseDatos + "guardar", $scope.dato,
                        {'Content-Type': 'application/json'
                        }).then(function (response) {
                    if (response.data.resultado === "OK") {
                        $('#dlgEspera').modal('hide');
                        $('#msgConsulta').html('Transaccion Realizada correctamente');
                        $('#dlgConsulta').modal();
                        $scope.dato = response.data;
                        if(!$scope.datosFormulario.syngenDatosgenList){
                            $scope.datosFormulario.syngenDatosgenList = [];
                        }
                        $scope.datosFormulario.syngenDatosgenList.unshift(response.data);
                        $('#myModalNorm').modal('hide');
                    }
                    $('#dlgEspera').modal('hide');
                }, function (response) {
                    $('#dlgEspera').modal('hide');
                    $('#msgConsulta').html('Ha ocurrido un error al editar la informacion ' + response.data.descripcion);
                    $('#dlgConsulta').modal();
                });
            } else {
                $('#dlgEspera').modal({backdrop: 'static', keyboard: false});
                $http.post(urlBaseDatos + "editar", $scope.dato,
                        {'Content-Type': 'application/json'
                        }).then(function (response) {
                    if (response.data.resultado === "OK") {
                        $('#dlgEspera').modal('hide');
                        $('#msgConsulta').html('Transaccion Realizada correctamente');
                        $('#dlgConsulta').modal();
                        $('#myModalNorm').modal('hide');
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

