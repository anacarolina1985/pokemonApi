'use strict';

angular.module('pokemonApp').controller('TeamController',
	[ 'TeamService', '$scope', '$state', function(TeamService, $scope, $state) {

		var self = this;
		self.model = {};
		self.teams = getAllTeams();

		self.submit = submit;
		self.getAllTeams = getAllTeams;
		self.createTeam = createTeam;
		self.updateTeam = updateTeam;
		self.removeTeam = removeTeam;
		self.editTeam = editTeam;
		self.reset = reset;

		self.successMessage = '';
		self.errorMessage = '';
		self.done = false;

		self.onlyIntegers = /^\d+$/;
		self.onlyNumbers = /^\d+([,.]\d+)?$/;

		function submit() {
			console.log('Submitting');
			if (self.model.id === undefined || self.model.id === null) {
				console.log('Saving New Team', self.model);
				createTeam(self.model);
			} else {
				updateTeam(self.model, self.model.id);
				console.log('Team updated with id ', self.model.id);
			}
			
			self.teams = getAllTeams();
		}

		function createTeam(team) {
			console.log('About to create team');
			TeamService.createTeam(team)
				.then(
					function(response) {
						console.log('Team created successfully');
						self.successMessage = 'Team created successfully';
						self.errorMessage = '';
						self.done = true;
						self.model = {};
						$scope.myForm.$setPristine();
					},
					function(errResponse) {
						console.error('Error while creating Team');
						if (errResponse.data) {
							if (errResponse.data)
								self.errorMessage = 'Error while creating Team: ' + errResponse.data.errorMessage ? errResponse.data.errorMessage : errResponse.data.message;
							self.successMessage = '';
						}
						
						if(errResponse.data.message && errResponse.data.message.indexof() >= 0){
							$state.go('login');
						}
					}
			);
		}
		
		

		function updateTeam(team, id) {
			console.log('About to update team');
			TeamService.updateTeam(team, id)
				.then(
					function(response) {
						console.log('Team updated successfully');
						self.successMessage = 'Team updated successfully';
						self.errorMessage = '';
						self.done = true;
						$scope.myForm.$setPristine();
					},
					function(errResponse) {
						console.error('Error while updating Team');
						self.errorMessage = 'Error while updating Team ' + errResponse.data;
						self.successMessage = '';
					}
			);
		}


		function removeTeam(id) {
			console.log('About to remove Team with id ' + id);
			TeamService.removeTeam(id)
				.then(
					function() {
						console.log('Team ' + id + ' removed successfully');
					},
					function(errResponse) {
						console.error('Error while removing team ' + id + ', Error :' + errResponse.data);
					}
			);
		}


		function getAllTeams() {
			return TeamService.getAllTeams();
		}

		function editTeam(id) {
			self.successMessage = '';
			self.errorMessage = '';
			TeamService.getTeam(id).then(
				function(team) {
					self.model = team;
				},
				function(errResponse) {
					console.error('Error while removing team ' + id + ', Error :' + errResponse.data);
				}
			);
		}
		function reset() {
			self.successMessage = '';
			self.errorMessage = '';
			self.model = {};
			$scope.myForm.$setPristine(); //reset Form
		}
	}


	]);