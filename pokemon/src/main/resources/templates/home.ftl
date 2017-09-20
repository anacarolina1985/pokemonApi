<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Pokemon Team </span></div>
        <div class="panel-body">
            <div>Team Planner</div>
            <div><button type="button" ng-click="ctrl.login" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Login</button></div>
            <div><button type="button" ng-click="ctrl.createLogin" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Create Login</button></div>
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
            </div>
        </div>
    </div>                
</div>