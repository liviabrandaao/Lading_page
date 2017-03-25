angulaAppModulo.config(function($routeProvider, $locationProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'index.html'
        })
        .when('/cadastro', {
            templateUrl: 'cadastro.html'
        });
       
});