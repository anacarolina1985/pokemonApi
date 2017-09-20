'use strict';

angular.module('pokemonApp').factory('HomeService',
	[ '$localStorage', '$http', '$q', 'urls',
		function($localStorage, $http, $q, urls) {

			var factory = {
				home : home
			};

			return factory;

			function home() {
			}
		}
	]);