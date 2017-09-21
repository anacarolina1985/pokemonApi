<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Login Register</span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="login.successMessage">{{login.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="login.errorMessage">{{login.errorMessage}}</div>
	            <form ng-submit="login.createLogin()" name="myForm" class="form-horizontal">
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="name">Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="login.model.name" id="name" class="name form-control input-sm" placeholder="Enter your Name" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="mail">E-mail</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="login.model.email" id="email" class="email form-control input-sm" placeholder="Enter your Email" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Username</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="login.model.username" id="uname" class="username form-control input-sm" placeholder="Enter your Username" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>
	                
					<div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="pass">Password</label>
	                        <div class="col-md-7">
	                            <input type="password" ng-model="login.model.password" id="pass" class="password form-control input-sm" placeholder="Enter your Password" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="Register" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="login.cancel()" class="btn btn-warning btn-sm" >Back</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
</div>