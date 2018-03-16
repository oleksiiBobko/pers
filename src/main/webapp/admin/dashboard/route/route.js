/**
 * 
 */
var app = angular.module("persApp", [ "ngRoute" ]);
app.config(function($routeProvider) {
    $routeProvider.when("/home", {
        templateUrl : "admin/html/home.htm",
    }).when("/users", {
        templateUrl : "admin/html/users.htm",
    }).when("/settings", {
        templateUrl : "html/settings.htm"
    }).otherwise({
        redirectTo: "/home",
    });
});
