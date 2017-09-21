'use strict';

angular.module('pokemonApp').factory('LoginService',
	[ '$localStorage', '$http', '$q', 'urls',
		function($localStorage, $http, $q, urls) {

			var factory = {
				login : login,
				createLogin : createLogin
			};

			return factory;

			function login(login) {
				console.log('Login');
				var deferred = $q.defer();
				$http.post(urls.LOGIN_SERVICE_API, login)
					.then(
						function(response) {
							console.log('Login successfully');
							if(response.data && response.data.data){
								$localStorage.token = response.data.data;
							}
							deferred.resolve(response);
						},
						function(errResponse) {
							console.error('Error while login');
							deferred.reject(errResponse);
						}
				);
				return deferred.promise;
			}

			function createLogin(login) {
				console.log('Creating Login');
				var deferred = $q.defer();
				$http.post(urls.LOGIN_SERVICE_API + 'create', login)
					.then(
						function(response) {
							console.log('Login create successfully');
							if(response.data && response.data.data){
								$localStorage.token = response.data.data;
							}
							deferred.resolve(response);
						},
						function(errResponse) {
							console.error('Error while creating Login : ' + errResponse.data.errorMessage);
							deferred.reject(errResponse);
						}
				);
				return deferred.promise;
			}

		}
	]);