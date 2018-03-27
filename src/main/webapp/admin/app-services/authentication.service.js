(function () {
    'use strict';

    angular
        .module('persApp')
        .factory('AuthenticationService', AuthenticationService);

    AuthenticationService.$inject = ['$http', '$cookies', '$rootScope', '$timeout', 'UserService'];
    function AuthenticationService($http, $cookies, $rootScope, $timeout, UserService) {
        var service = {};

        service.Login = Login;
        service.SetCredentials = SetCredentials;
        service.ClearCredentials = ClearCredentials;

        return service;

        function Login(username, password, callback) {
            $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
            $http.defaults.headers.post["Authorization"] = "Form";
            $http({
                url: 'http://localhost:8081/login',
                method: "POST",
                data: 'username=' + username + '&password=' + password
            })
            .then(function(response) {
                    callback(response);
            }, 
            function(response) {
                    console.log('failed ' + response);
            });

        }

        function SetCredentials(response) {

            $rootScope.globals = {
                currentUser: {
                    username: response
                }
            };

        }

        function ClearCredentials() {
            $rootScope.globals = {};
//            $http.get("http://localhost:8081/logout")
//            .then(function(response) {
//                console.log(response);
//            });
        }
    }

})();