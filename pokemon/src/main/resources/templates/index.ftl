<!DOCTYPE html>

<html lang="en" ng-app="pokemonApp">
<head>
<title>${title}</title>
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/app.css" rel="stylesheet" />
</head>
<body>
	<div ui-view>
		<div class="generic-container">
	    <div class="panel panel-default">
	        <!-- Default panel contents -->
	        <div class="panel-heading"><span class="lead">Welcome to Team Pokemon! </span></div>
			<div class="panel-body">
		        <div class="formcontainer">
		            <div class="alert alert-success" role="alert" ng-if="login.successMessage">{{login.successMessage}}</div>
		            <div class="alert alert-danger" role="alert" ng-if="login.errorMessage">{{login.errorMessage}}</div>
	                <div class="row">
	                    <div class="form-actions floatRight">
	                    	<button type="button" ng-click="login.signin()" class="btn btn-default btn-sm" >Login</button>
	                        <button type="button" ng-click="login.signup()" class="btn btn-default btn-sm" >Register</button>
	                    </div>
	                </div>
	    	    </div>
			</div>	
	    </div>
	</div>
	</div>
	<script src="js/lib/angular.min.js"></script>
	<script src="js/lib/angular-ui-router.min.js"></script>
	<script src="js/lib/localforage.min.js"></script>
	<script src="js/lib/ngStorage.min.js"></script>
	<script src="js/app/app.js"></script>
	<script src="js/app/TeamService.js"></script>
	<script src="js/app/TeamController.js"></script>
	<script src="js/app/LoginService.js"></script>
	<script src="js/app/LoginController.js"></script>
</body>
</html>