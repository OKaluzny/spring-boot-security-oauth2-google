'use strict';

// Creating the Angular Controller
app.controller('AppCtrl', function ($http, $scope) {

    $scope.user = {};

    // method for getting user details
    var getUser = function () {
        $http.get('/user').then(function (response) {
            $scope.user = response.data;
            console.log('Logged User : ', response.data);
        }, function (error) {
            $scope.resource = error;
        });
    };
    getUser();

    // method for logout
    $scope.logout = function () {
        $http.post('/logout').then(function (response) {
            $scope.user = {};
            window.location.href = '/';
        }, function (error) {
            console.log("Logout error : ", error);
        });
    };
});
