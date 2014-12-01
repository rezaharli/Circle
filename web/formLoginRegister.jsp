
<ul class="tabs">
    <li class="col-md-4 col-sm-4">
        <a href="#tablogin" class="icon-item">
            <i class="fa ">Login</i>
        </a> <!-- /.icon-item -->
    </li>
    <li class="col-md-4 col-sm-4">
        <a href="#tabregist" class="icon-item">
            <i class="fa">Register</i>
        </a> <!-- /.icon-item -->
    </li>
</ul> <!-- /.tabs -->
<div class="col-md-12 col-sm-12">
    <div id="tablogin" class="col-md-6"> 
        <form action="Login" method="post" style="margin-top: 30px;">
            <fieldset>
                <input type="text" id="username" name="username" placeholder="Username">
            </fieldset>
            <fieldset>
                <input type="password" id="password" name="password" placeholder="Password">
            </fieldset>
            <fieldset>
                <input type="submit" name="submit" value="Submit" id="submit" class="button">
            </fieldset>
        </form>
    </div>
    <div id="tabregist" class="col-md-6"> 
        <form action="Register" method="post" style="margin-top: 30px;">
            <fieldset>
                <input type="text" id="fullname" name="fullname" placeholder="Full Name">
            </fieldset>
            <fieldset>
                <input type="text" id="username" name="username" placeholder="Username">
            </fieldset>
            <fieldset>
                <input type="password" id="password" name="password" placeholder="Password">
            </fieldset>
            <fieldset>
                <input type="email" name="email" id="email" placeholder="Email">
            </fieldset>
            <fieldset>
                <input type="submit" name="submit" value="Submit" id="submit" class="button">
            </fieldset>
        </form>
    </div>
</div> <!-- /.col-md-12 -->