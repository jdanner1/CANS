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
                <c:if test="${role.roleName eq 'admin'}">
                    <li><a href="DeleteUsers">Delete Users</a></li>
                    <li><a href="DeleteVocalizations">Delete Vocalizations</a></li>
                </c:if>

                <li><a href="History">History</a></li>
                <li><a href="EditProfile">Edit Profile</a></li>
                <li><a href="index.jsp">Exit</a></li>
            </ul>

        </div>
    </div>
</nav>


<div class="row">
    <div class="col-sm-1"></div>

    <form class="form-horizontal col-sm-8"
          id="vocalization-form"
          name="vocalization-form"
          action="HomeAction"
          method="post">

        <div class="form-group">
            <label class="control-label col-sm-3">Text</label>
            <div class="col-sm-9">
                <!--<input class="form-control" type="<textarea name="main-input" id="main-input" cols="30" rows="10"></textarea>" />  -->
                <textarea name="main-input" autofocus="autofocus" placeholder="Enter the text you wish to vocalize here." rows="10" cols="66" required></textarea>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-3">Language</label>
            <div class="col-sm-9">
                <select class="form-control" name="language" required>
                    <option disabled selected value>Select One</option>
                    <option value="pt-BR_IsabelaVoice">Brazilian Portuguese</option>
                    <option value="es-ES_LauraVoice">Castilian Spanish</option>
                    <option value="fr-FR_ReneeVoice">French</option>
                    <option value="de-DE_BirgitVoice">German</option>
                    <option value="it-IT_FrancescaVoice">Italian</option>
                    <option value="ja-JP_EmiVoice">Japanese</option>
                    <option value="es-LA_SofiaVoice">Latin American Spanish</option>
                    <option value="es-US_SofiaVoice">North American Spanish</option>
                    <option value="en-GB_KateVoice">UK English</option>
                    <option value="en-US_AllisonVoice">US English</option>
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
