var app = angular.module('pokemonApp', [ 'ui.router', 'ngStorage' ]);

app.constant('urls', {
	BASE : 'http://localhost:8080/PokemonApp',
	TEAM_SERVICE_API : 'http://localhost:8080/PokemonApp/api/v1/pokemon/team/',
	LOGIN_SERVICE_API : 'http://localhost:8080/PokemonApp/api/v1/pokemon/login/',
	API_SERVICE_API : 'http://localhost:8080/PokemonApp/api/v1/pokemon/api/',
	PARAM_SERVICE_API : 'http://localhost:8080/PokemonApp/api/v1/pokemon/param_config/'
});

app.config([ '$stateProvider', '$urlRouterProvider',
	function($stateProvider, $urlRouterProvider) {

		$stateProvider
			.state('home', {
				url : '/',
				controller : 'LoginController',
				controllerAs : 'login'
			})
			.state('login', {
				url : '/login',
				templateUrl : 'partials/login',
				controller : 'LoginController',
				controllerAs : 'login'
			})
			.state('loginCreate', {
				url : '/loginCreate',
				templateUrl : 'partials/loginCreate',
				controller : 'LoginController',
				controllerAs : 'login'
			})
			.state('team', {
				url : '/team',
				templateUrl : 'partials/team',
				controller : 'TeamController',
				controllerAs : 'team',
				resolve: {
                    teams: function ($q, TeamService) {
                        console.log('Load all teams');
                        var deferred = $q.defer();
                        TeamService.loadAllTeams().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            })
			.state('teamDetail', {
				url : '/team/:id',
				templateUrl : 'partials/teamDetail',
				controller : 'TeamController',
				controllerAs : 'team',
			});

		$urlRouterProvider.otherwise('/');
	} ]);