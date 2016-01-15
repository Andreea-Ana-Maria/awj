
var app = angular.module('blog', [ ]);

+app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
    $scope.helloWorld = 'Aplicatii Web cu suport Java!';
  
  var url = "http://localhost:8080/ang";
   $scope.angajati = [];
   $scope.keys = [];
	$scope.obj={};
   $scope.ang = {};
   $scope.editAngaj = {};
 
 
 
   $http.get('http://localhost:8080/ang').then(
     function successCallback(response) {
		$scope.obj=response;
     $scope.angajati = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
   });
 
 
   $scope.addAngaj = function(ang) {
        ang.id = parseInt(ang.id);
        console.log(ang.id);
        $http({
            method: 'POST',
            url: url,
            data: ang
        }).then(function successCallback(response) {
            console.log(response);
            $scope.angajati.push(ang);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteAngaj = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.angajati = $scope.angajati.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateAngaj = function(ang) {
        $scope.editAngaj = ang;
    };


    $scope.updateAngaj = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editAngaj
        }).then(function successCallback(response) {
            $scope.editAngaj = {};
            console.log(response);
            // $scope.angajati.push($scope.editAngaj);
            // done.
        }, function errorCallback(response) {
            $scope.editAngaj = {};
            console.log(response);
        });
    };
    
    
     var url = "http://localhost:8080/prod";
   $scope.produse = [];
   $scope.keys = [];
	$scope.obj={};
   $scope.prod = {};
   $scope.editProduse = {};
 
 
 
   $http.get('http://localhost:8080/prod').then(
     function successCallback(response) {
		$scope.obj=response;
     $scope.produse = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
   });
 
 
   $scope.addProduse = function(prod) {
        prod.id = parseInt(prod.id);
        console.log(prod.id);
        $http({
            method: 'POST',
            url: url,
            data: prod
        }).then(function successCallback(response) {
            console.log(response);
            $scope.produse.push(prod);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteProduse = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.produse = $scope.produse.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateProduse = function(prod) {
        $scope.editProduse = prod;
    };


    $scope.updateProduse = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editProduse
        }).then(function successCallback(response) {
            $scope.editProduse = {};
            console.log(response);
            // $scope.produse.push($scope.editProduse);
            // done.
        }, function errorCallback(response) {
            $scope.editProduse = {};
            console.log(response);
        });
    };
    
    
    
     var url = "http://localhost:8080/stud";
   $scope.studenti = [];
   $scope.keys = [];
	$scope.obj={};
   $scope.stud = {};
   $scope.editStudent = {};
 
 
 
   $http.get('http://localhost:8080/stud').then(
     function successCallback(response) {
		$scope.obj=response;
     $scope.studenti = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
   });
 
 
   $scope.addStudent = function(stud) {
        stud.id = parseInt(stud.id);
        console.log(stud.id);
        $http({
            method: 'POST',
            url: url,
            data: stud
        }).then(function successCallback(response) {
            console.log(response);
            $scope.studenti.push(stud);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteStudent = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.studenti = $scope.studenti.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateStudent = function(stud) {
        $scope.editStudent = stud;
    };


    $scope.updateStudent = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editStudent
        }).then(function successCallback(response) {
            $scope.editStudent = {};
            console.log(response);
            // $scope.studenti.push($scope.editStudent);
            // done.
        }, function errorCallback(response) {
            $scope.editStudent = {};
            console.log(response);
        });
    };
  }]);