<!DOCTYPE html>
<html lang="en">
<%@ include file="head-tag.jsp" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="mailto:support@atv.com?Subject=Customer%20Inquiry"
               target="_top"
               class="navbar-brand">SUPPORT@ATV</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="index.jsp">Exit</a></li>
            </ul>
        </div>
    </div>
</nav>

    <div class="row">
    <h3 style="color:white;text-align:center;">Login failed, please try again.</h3>
    </div>

<div class="row">
    <div class="col-sm-1"></div>
    <form class="form-horizontal col-sm-8"
          id="login2"
          method="post"
          name="login2"
          action="j_security_check">

        <div class="form-group">
            <label class="control-label col-sm-3">User Name</label>
            <div class="col-sm-9">
                <input class="form-control" autofocus="autofocus" type="text" name="j_username" />
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-3">Password</label>
            <div class="col-sm-9">
                <input class="form-control" type="password" name="j_password" />
            </div>
        </div>

        <div class="col-sm-3"></div>
        <div class="col-sm-9">
            <input type="submit"
                   value="Log In"
                   class="buttons form-button" />
        </div>
    </form>
</div>

<%@ include file="footer.jsp" %>

