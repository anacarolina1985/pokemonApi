<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Login </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="login.successMessage">{{login.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="login.errorMessage">{{login.errorMessage}}</div>
	            <form ng-submit="login.submit()" name="myForm" class="form-horizontal">
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="login.model.username" id="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="pass">Name</label>
	                        <div class="col-md-7">
	                            <input type="password" ng-model="login.model.password" id="pass" class="password form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="Login" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="login.signup()" class="btn btn-warning btn-sm" >Cadastrar</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
</div>