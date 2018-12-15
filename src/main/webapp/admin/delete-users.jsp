<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="title" value="Search Results" />
<%@ include file="../head-tag.jsp" %>

<div class="container-fluid">
    <nav class="navbar navbar-inverse">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a href="mailto:support@daycare.com?Subject=Customer%20Inquiry"
           target="_top"
           class="navbar-brand">SUPPORT@DAYCARE</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav navbar-right">
            <li><a href="Home">Home</a></li>
            <li><a href="index.jsp">Exit</a></li>
        </ul>
    </div>
    </nav>

    <div class="row deleteList">
        <h2 class="userTable" style="color: white;">Users:</h2>
        <table id="userTable" class="display" cellspacing="0" width="100%">
            <thead>
            <th class="userTable" style="color: white; margin-left: 2em;">UserID</th>
            <th class="userTable" style="color: white; margin-left: 2em;">User Name</th>
            <th class="userTable" style="color: white; margin-left: 2em;">Password</th>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td class="userTable" style="color: white; margin-left: 2em;">${user.userID}</td>
                    <td class="userTable" style="color: white; margin-left: 2em;">${user.userName}</td>
                    <td class="userTable" style="color: white; margin-left: 2em;">${user.password}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="row deleteList">
        <form class="form-horizontal"
              method="post"
              name="delete-user-form"
              id="delete-user-form"
              action="DeleteUserAction">

            <div class="form-group">
                <label class="control-label" style="color: white; margin-left: .5em;">Which User to Delete?</label>
                <br /><br /><br />

                <c:forEach var="user" items="${users}">
                    <div class="col-sm-9">
                        <input class="form-check-input" type="radio" name="userName"  style="color: white;" value="${user.userID}" /><span style="color:white; margin-left: 1em;">${user.userName}</span>
                    </div>

                </c:forEach>
            </div>

            <input type="submit"
                   value="Submit"
                   style="color: black;"
                   class="buttons form-button" />
        </form>
    </div>
</div>

<%@ include file="../footer.jsp" %>
