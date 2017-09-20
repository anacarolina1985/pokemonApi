var app = angular.module('pokemonApp', [ 'ui.router', 'ngStorage' ]);

app.constant('urls', {
	BASE : '<a class="vglnk" href="http://localhost:8080/PokemonApp" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>PokemonApp</span></a>',
	LOGIN_SERVICE_API : '<a class="vglnk" href="http://localhost:8080/PokemonApp/api/login/" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>PokemonApp</span><span>/</span><span>api</span><span>/</span><span>login</span><span>/</span></a>'
});

app.config([ '$stateProvider', '$urlRouterProvider',
	function($stateProvider, $urlRouterProvider) {

		$stateProvider
			.state('home', {
				url : '/',
				templateUrl : 'partials/home',
				controller : 'HomeController',
				controllerAs : 'ctrl',
				resolve : {
					users : function($q, HomeService) {
						console.log('Home');
						var deferred = $q.defer();
						LoginService.llogin().then(deferred.resolve, deferred.resolve);
						return deferred.promise;
					}
				}
			});
		$stateProvider
			.state('login', {
				url : '/login',
				templateUrl : 'partials/login',
				controller : 'LoginController',
				controllerAs : 'ctrl',
				resolve : {
					users : function($q, LoginService) {
						console.log('Login');
						var deferred = $q.defer();
						LoginService.llogin().then(deferred.resolve, deferred.resolve);
						return deferred.promise;
					}
				}
			});
		$stateProvider
			.state('createlogin', {
				url : '/createlogin',
				templateUrl : 'partials/createlogin',
				controller : 'LoginController',
				controllerAs : 'ctrl',
				resolve : {
					users : function($q, LoginService) {
						console.log('Create Login');
						var deferred = $q.defer();
						LoginService.llogin().then(deferred.resolve, deferred.resolve);
						return deferred.promise;
					}
				}
			});
		$urlRouterProvider.otherwise('/');
	} ]);