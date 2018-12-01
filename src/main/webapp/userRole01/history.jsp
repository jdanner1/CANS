<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li><a href="EditProfile">Edit Profile</a></li>
                <li><a href="index.jsp">Exit</a></li>
            </ul>

        </div>
    </div>
</nav>

<div class="container-fluid">
    <h2 style="color: white;">Vocalizations:</h2>
    <br /><br />

    <form class="form-horizontal col-sm-12"
          method="post"
          name="resubmitVocalization"
          id="resubmitVocalization"
          action="ResubmitVocalization">

    <table class="all" id="vocalizationTable">
        <tr>

            <td class="header col-md-2 allCells" style="color: white; font-size: 21px;"><strong>Date Created:</strong></td>
            <td class="header col-md-8 allCells" style="color: white; font-size: 21px;"><strong>Content:</strong></td>
            <td class="header col-md-2 allCells" style="color: white; font-size: 21px;"><strong></strong></td>
        </tr>

        <c:forEach var="currentVocalization" items="${vocalizations}">
        <tr>
            <td class="allCells col-md-2" style="color: white;">${currentVocalization.createTimestamp}</td>
            <td class="allCells col-md-8" style="color: white;">${currentVocalization.text}</td>
            <td class="allCells col-md-2" style="color: black;"><button name="vocalization" type="submit" value="${currentVocalization.vocalizationID}">Regenerate</button></td>
        </tr>
        </c:forEach>
    </table>

</form>
<div class="col-sm-3"></div>


<%@ include file="../footer.jsp" %>
