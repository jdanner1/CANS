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
            <a class="navbar-brand" href="#">SUPPORT@ATV</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="index.jsp">Exit</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="row">
    <div class="col-sm-1"></div>
    <form class="form-horizontal col-sm-8" id="multipleForm" method="post">

        <div class="form-group">
            <label class="control-label col-sm-3">First Name</label>
            <div class="col-sm-9">
                <input class="form-control" type="text" name="first" />
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-3">Last Name</label>
            <div class="col-sm-9">
                <input class="form-control" type="text" name="last" />
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-3">User Name</label>
            <div class="col-sm-9">
                <input class="form-control" type="text" name="user" />
            </div>
        </div>


        <div class="form-group">
            <label class="control-label col-sm-3">Email address</label>
            <div class="col-sm-9">
                <input class="form-control" type="text" name="email" />
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-3">Password</label>
            <div class="col-sm-9">
                <input class="form-control" type="text" name="password" />
            </div>
        </div>

        <div class="col-sm-3"></div>
        <div class="col-sm-9">
            <button id="submit" type="button" class="btn btn-primary form-button" >Submit</button>

            <button type="reset" class="btn btn-primary form-button">Clear</button>
        </div>
    </form>
    <div class="col-sm-3"></div>
</div>

<%@ include file="footer.jsp" %>

