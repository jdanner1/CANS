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
        <form class="form-horizontal"
              method="post"
              name="delete-vocalization-form"
              id="delete-vocalization-form"
              action="DeleteVocalizationAction">

            <div class="form-group">
                <label class="control-label" style="color: white; margin-left: .5em;">Which Vocalization to Delete?</label>
                <br /><br /><br />


                <c:forEach var="vocalization" items="${vocalizations}">
                <div class="col-sm-9">
                    <input class="form-check-input" type="checkbox" name="vocalization"  style="color: white;" value="${vocalization.vocalizationID}" /><span style="color: white; margin-left: 1em;">${vocalization.vocalizationID} ${vocalization.createTimestamp} ${vocalization.text}</span>
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
