'use strict';

angular.module('pokemonApp').controller('LoginController',
	[ 'LoginService', '$scope', function(LoginService, $scope) {

		var self = this;
		self.login = {};

		self.createLogin = createLogin;
		self.updateLogin = updateLogin;
		self.editLogin = editLogin;
		self.login = login;
		self.reset = reset;

		self.successMessage = '';
		self.errorMessage = '';
		self.done = false;

		self.onlyIntegers = /^\d+$/;
		self.onlyNumbers = /^\d+([,.]\d+)?$/;

		function createLogin(login) {
			console.log('About to create login');
			LoginService.createLogin(login)
				.then(
					function(response) {
						console.log('Login created successfully');
						self.successMessage = 'Login created successfully';
						self.errorMessage = '';
						self.done = true;
						self.login = {};
						$scope.myForm.$setPristine();
					},
					function(errResponse) {
						console.error('Error while creating Login');
						self.errorMessage = 'Error while creating Login: ' + errResponse.data.errorMessage;
						self.successMessage = '';
					}
			);
		}

		function login(login) {
			console.log('About to login');
			LoginService.login(login)
				.then(
					function(response) {
						console.log('Login successfully');
						self.successMessage = 'Login successfully';
						self.errorMessage = '';
						self.done = true;
						self.login = response;
						$scope.myForm.$setPristine();
					},
					function(errResponse) {
						console.error('Error while Login');
						self.errorMessage = 'Error while Login: ' + errResponse.data.errorMessage;
						self.successMessage = '';
					}
			);
		}

		function updateLogin(login, id) {
			console.log('About to update Login');
			LoginService.updateLogin(login, id)
				.then(
					function(response) {
						console.log('Login updated successfully');
						self.successMessage = 'Login updated successfully';
						self.errorMessage = '';
						self.done = true;
						$scope.myForm.$setPristine();
					},
					function(errResponse) {
						console.error('Error while updating Login');
						self.errorMessage = 'Error while updating Login ' + errResponse.data;
						self.successMessage = '';
					}
			);
		}

		function editLogin(id) {
			self.successMessage = '';
			self.errorMessage = '';
			LoginService.getLogin(id).then(
				function(login) {
					self.login = login;
				},
				function(errResponse) {
					console.error('Error while removing Login ' + id + ', Error :' + errResponse.data);
				}
			);
		}

		function reset() {
			self.successMessage = '';
			self.errorMessage = '';
			self.login = {};
			$scope.myForm.$setPristine(); //reset Form
		}
	}
	]);