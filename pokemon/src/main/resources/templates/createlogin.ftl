<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Create Login Pokemon </span></div>
        <div class="panel-body">
            <div>Login Planner</div>
            <form action="ctrl.createLogin"></form>
            <span>Name: </span><input type='text' ng-/>
            <span>Email: </span><input type='text'/>
            <span>Login: </span><input type='text'/>
            <span>Password: </span><input type="password"/>
            
            <div><button type="submit" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Login</button></div>
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
            </div>
        </div>
    </div>                
</div>