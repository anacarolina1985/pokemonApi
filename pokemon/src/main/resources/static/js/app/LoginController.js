'use strict';

angular.module('pokemonApp').controller('LoginController',
	[ 'LoginService', '$scope', '$state', function(LoginService, $scope, $state) {

		var self = this;
		self.model = {};

		self.submit = submit;
		self.createLogin = createLogin;
		self.signup = signup;
		self.signin = signin;
		self.reset = reset;
		self.cancel = cancel;

		self.successMessage = '';
		self.errorMessage = '';
		self.done = false;

		self.onlyIntegers = /^\d+$/;
		self.onlyNumbers = /^\d+([,.]\d+)?$/;

		function submit() {
			console.log('Submitting');
			LoginService.login(self.model)
				.then(
					function(response) {
						console.log('Login successfully');
						self.successMessage = 'Login successfully';
						self.errorMessage = '';
						self.done = true;
						self.model = {};
						$scope.myForm.$setPristine();
						$state.go('team');
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
			LoginService.createLogin(self.model)
				.then(
					function(response) {
						console.log('Create Login successfully');
						self.successMessage = 'Create Login successfully';
						self.errorMessage = '';
						self.done = true;
						self.model = {};
						$scope.myForm.$setPristine();
						$state.go('team');
					},
					function(errResponse) {
						console.error('Error while Create Login');
						self.errorMessage = 'Error while Create Login: ' + errResponse.data.errorMessage;
						self.successMessage = '';
					}
			);
		}

		function signin() {
			$state.go('login');
		}

		function signup() {
			$state.go('loginCreate');
		}

		function cancel() {
			reset();
			$state.go('home');
		}

		function reset() {
			self.successMessage = '';
			self.errorMessage = '';
			self.model = {};
			$scope.myForm.$setPristine(); //reset Form
		}
	}


	]);