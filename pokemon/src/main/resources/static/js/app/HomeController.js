'use strict';

angular.module('pokemonApp').controller('HomeController',
	[ 'HomeService', '$scope', function(HomeService, $scope) {

		var self = this;

		self.login = login;
		self.createLogin = createLogin;

		self.successMessage = '';
		self.errorMessage = '';
		self.done = false;

		self.onlyIntegers = /^\d+$/;
		self.onlyNumbers = /^\d+([,.]\d+)?$/;

		function createLogin() {
			console.log('Go to to create login');
			$location.path("/login");
		}


		function createLogin() {
			console.log('Go to to create login');
			$location.path("/createlogin");
		}






	}
	]);