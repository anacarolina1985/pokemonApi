'use strict';

angular.module('pokemonApp').factory('TeamService',
	[ '$localStorage', '$http', '$q', 'urls',
		function($localStorage, $http, $q, urls) {

			var factory = {
				loadAllTeams : loadAllTeams,
				getAllTeams : getAllTeams,
				getTeam : getTeam,
				createTeam : createTeam,
				updateTeam : updateTeam,
				removeTeam : removeTeam
			};

			return factory;

			function loadAllTeams() {
				console.log('Fetching all teams');
				var deferred = $q.defer();
				$http({
					url : urls.TEAM_SERVICE_API,
					method : 'GET',
					headers : {
						'token' : $store.token
					}
				}).then(
					function(response) {
						console.log('Fetched successfully all teams');
						$store.teams = response.data;
						deferred.resolve(response);
					},
					function(errResponse) {
						console.error('Error while loading teams');
						deferred.reject(errResponse);
					}
				);
				return deferred.promise;
			}

			function getAllTeams() {
				return $localStorage.teams;
			}

			function getTeam(id) {
				console.log('Fetching Team with id :' + id);
				var deferred = $q.defer();
				$http.get(urls.TEAM_SERVICE_API + id)
					.then(
						function(response) {
							console.log('Fetched successfully Team with id :' + id);
							deferred.resolve(response.data);
						},
						function(errResponse) {
							console.error('Error while loading Team with id :' + id);
							deferred.reject(errResponse);
						}
				);
				return deferred.promise;
			}

			function createTeam(team) {
				console.log('Creating Team');
				var deferred = $q.defer();
				$http({
					url : urls.TEAM_SERVICE_API,
					method : 'POST',
					data : team,
					headers : {
						'token' : $localStorage.token
					}
				}).then(
					function(response) {
						loadAllTeams();
						deferred.resolve(response.data);
					},
					function(errResponse) {
						console.error('Error while creating Team : ' + errResponse.data.errorMessage);
						deferred.reject(errResponse);
					}
				);
				return deferred.promise;
			}

			function updateTeam(team, id) {
				console.log('Updating Team with id ' + id);
				var deferred = $q.defer();
				$http.put(urls.TEAM_SERVICE_API + id, team)
					.then(
						function(response) {
							loadAllTeams();
							deferred.resolve(response.data);
						},
						function(errResponse) {
							console.error('Error while updating Team with id :' + id);
							deferred.reject(errResponse);
						}
				);
				return deferred.promise;
			}

			function removeTeam(id) {
				console.log('Removing Team with id ' + id);
				var deferred = $q.defer();
				$http.delete(urls.TEAM_SERVICE_API + id)
					.then(
						function(response) {
							loadAllTeams();
							deferred.resolve(response.data);
						},
						function(errResponse) {
							console.error('Error while removing Team with id :' + id);
							deferred.reject(errResponse);
						}
				);
				return deferred.promise;
			}

		}
	]);