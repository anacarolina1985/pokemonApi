var app = angular.module('pokemonApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/PokemonApp',
    TEAM_SERVICE_API : 'http://localhost:8080/PokemonApp/api/v1/pokemon/team',
    LOGIN_SERVICE_API : 'http://localhost:8080/PokemonApp/api/v1/pokemon/login'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('login', {
                url: '/',
                templateUrl: 'partials/login',
                controller:'LoginController',
                controllerAs:'login'
            })
            .state('home', {
                url: '/team',
                templateUrl: 'partials/team',
                controller:'TeamController',
                controllerAs:'team',
                resolve: {
                    teams: function ($q, TeamService) {
                        console.log('Load all teams');
                        var deferred = $q.defer();
                        TeamService.loadAllTeams().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

