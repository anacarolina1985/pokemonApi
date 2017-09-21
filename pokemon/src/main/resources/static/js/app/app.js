var app = angular.module('pokemonApp', [ 'ui.router', 'ngStorage' ]);

app.constant('urls', {
	BASE : 'http://localhost:8080/PokemonApp',
	TEAM_SERVICE_API : 'http://localhost:8080/PokemonApp/api/v1/pokemon/team',
	LOGIN_SERVICE_API : 'http://localhost:8080/PokemonApp/api/v1/pokemon/login'
});

app.config([ '$stateProvider', '$urlRouterProvider',
	function($stateProvider, $urlRouterProvider) {

		$stateProvider
			.state('home', {
				url : '/',
				templateUrl : 'index',
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
				controllerAs : 'team'
			})
			.state('teamDetail', {
				url : '/team/:id',
				templateUrl : 'partials/team',
				controller : 'TeamController',
				controllerAs : 'team',
				
			});

		$urlRouterProvider.otherwise('/');
	} ]);