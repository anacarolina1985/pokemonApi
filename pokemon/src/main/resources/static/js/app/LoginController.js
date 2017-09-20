'use strict';

angular.module('pokemonApp').controller('LoginController',
	[ 'LoginService', '$scope', function(LoginService, $scope) {

		var self = this;
		self.model = {};

		self.submit = submit;
		self.createLogin = createLogin;
		self.signup = signup;
		self.reset = reset;

		self.successMessage = '';
		self.errorMessage = '';
		self.done = false;

		self.onlyIntegers = /^\d+$/;
		self.onlyNumbers = /^\d+([,.]\d+)?$/;

		function submit() {
			console.log('Submitting');
			TeamService.login(self.model)
				.then(
					function(response) {
						console.log('Login successfully');
						self.successMessage = 'Login successfully';
						self.errorMessage = '';
						self.done = true;
						self.model = {};
						$scope.myForm.$setPristine();
					},
					function(errResponse) {
						console.error('Error while Login');
						self.errorMessage = 'Error while Login: ' + errResponse.data.errorMessage;
						self.successMessage = '';
					}
			);
		}

		function createLogin() {
			console.log('Create login');
			TeamService.login(self.model)
				.then(
					function(response) {
						console.log('Create Login successfully');
						self.successMessage = 'Create Login successfully';
						self.errorMessage = '';
						self.done = true;
						self.model = {};
						$scope.myForm.$setPristine();
					},
					function(errResponse) {
						console.error('Error while Create Login');
						self.errorMessage = 'Error while Create Login: ' + errResponse.data.errorMessage;
						self.successMessage = '';
					}
			);
		}


		function signup() {
			//do redirect page create Login		
		}

		function reset() {
			self.successMessage = '';
			self.errorMessage = '';
			self.model = {};
			$scope.myForm.$setPristine(); //reset Form
		}
	}


	]);