<!DOCTYPE html>
<html lang="en">
<%@ include file="../head-tag.jsp" %>

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
                <li><a href="Home">Home</a></li>
                <li><a href="History">History</a></li>
                <li><a href="index.jsp">Exit</a></li>
            </ul>

        </div>
    </div>
</nav>

<div class="row">
    <div class="col-sm-1"></div>
    <form class="form-horizontal col-sm-8"
          method="post"
          name="edit-account"
          id="edit-account"
          action="EditProfileAction">

        <div class="form-group">
            <label class="control-label col-sm-3">First Name</label>
            <div class="col-sm-9">
                <input class="form-control" type="text" autofocus="autofocus" placeholder="${user.firstName}" name="firstName"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-3">Last Name</label>
            <div class="col-sm-9">
                <input class="form-control" type="text" placeholder="${user.lastName}" name="lastName"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-3">Password</label>
            <div class="col-sm-9">
                <input class="form-control" type="password" placeholder="${user.password}" name="password" />
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-3">Email</label>
            <div class="col-sm-9">
                <input class="form-control" type="text" placeholder="${user.email}" name="email" />
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-3">Status</label>
            <div class="col-sm-9">
                <select class="form-control" name="status">
                    <option disabled selected value>Select One</option>
                    <option value="A">Active</option>
                    <option value="D">Deleted</option>
                </select>
            </div>
        </div>

        <div class="col-sm-3"></div>
        <div class="col-sm-9">
            <input type="submit"
                   value="Submit"
                   class="buttons form-button" />

            <span id="spacer01"></span>

            <input type="reset"
                   value="Reset"
                   class="buttons form-button" />
        </div>

    </form>
    <div class="col-sm-3"></div>
</div>

<%@ include file="../footer.jsp" %>
