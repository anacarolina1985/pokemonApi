'use strict';

angular.module('pokemonApp').factory('LoginService',
	[ '$localStorage', '$http', '$q', 'urls',
		function($localStorage, $http, $q, urls) {

			var factory = {
				getLogin : getLogin,
				createLogin : createLogin,
				updateLogin : updateLogin,
				login : login
			};

			return factory;

			function login(login) {
				$http.post(urls.LOGIN_SERVICE_API, login)
					.then(
						function(response) {
							console.log('Login successfully');
							deferred.resolve(response.data);
						},
						function(errResponse) {
							console.error('Error while login');
							deferred.reject(errResponse);
						}
				);
			}

			function getLogin(id) {
				console.log('Fetching Login with id :' + id);
				var deferred = $q.defer();
				$http.get(urls.LOGIN_SERVICE_API + id)
					.then(
						function(response) {
							console.log('Fetched successfully Login with id :' + id);
							deferred.resolve(response.data);
						},
						function(errResponse) {
							console.error('Error while loading login with id :' + id);
							deferred.reject(errResponse);
						}
				);
				return deferred.promise;
			}

			function createLogin(login) {
				console.log('Creating Login');
				var deferred = $q.defer();
				$http.post(urls.USER_SERVICE_API, login)
					.then(
						function(response) {
							loadAllLogins();
							deferred.resolve(response.data);
						},
						function(errResponse) {
							console.error('Error while creating Login : ' + errResponse.data.errorMessage);
							deferred.reject(errResponse);
						}
				);
				return deferred.promise;
			}

			function updateLogin(login, id) {
				console.log('Updating Login with id ' + id);
				var deferred = $q.defer();
				$http.put(urls.LOGIN_SERVICE_API + id, login)
					.then(
						function(response) {
							loadAllLogins();
							deferred.resolve(response.data);
						},
						function(errResponse) {
							console.error('Error while updating Login with id :' + id);
							deferred.reject(errResponse);
						}
				);
				return deferred.promise;
			}
		}
	]);