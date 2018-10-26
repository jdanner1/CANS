<!DOCTYPE html>
<html lang="en">
<%@ include file="../head-tag.jsp" %>

<script src="../js/getRevisedDate.js" language="javascript" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>

<body>
<div class="container">
    <div class="jumbotron hidden-print">
        <header>
            <h1>Advanced Text Vocalizer - Home</h1>
        </header>
    </div>


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
                <li><a href="history.jsp">History</a></li>
                <li><a href="edit-profile.jsp">Edit Profile</a></li>
                <li><a href="../index.jsp">Exit</a></li>
            </ul>

        </div>
    </div>
</nav>


<div class="row">
    <div class="col-sm-1"></div>

    <form class="form-horizontal col-sm-8"
          id="vocalization-form"
          name="vocalization-form"
          action="http://itins3.madisoncollege.edu/echo.php"
          method="post">

        <div class="form-group">
            <label class="control-label col-sm-3">Text</label>
            <div class="col-sm-9">
                <!--<input class="form-control" type="<textarea name="main-input" id="main-input" cols="30" rows="10"></textarea>" />  -->
                <textarea name="main-input" autofocus="autofocus" placeholder="Enter the text you wish to vocalize here." rows="10" cols="66"></textarea>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-3">Language</label>
            <div class="col-sm-9">
                <select class="form-control" name="language">
                    <option disabled selected value>Select One</option>
                    <option value="portuguese">Brazilian Portuguese</option>
                    <option value="cspanish">Castilian Spanish</option>
                    <option value="french">French</option>
                    <option value="german">German</option>
                    <option value="italian">Italian</option>
                    <option value="japanese">Japanese</option>
                    <option value="laspanish">Latin American Spanish</option>
                    <option value="naspanish">North American Spanish</option>
                    <option value="ukenglish">UK English</option>
                    <option value="usenglish">US English</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-3">Email Sound File?</label>
            <div class="col-sm-9">
                <select class="form-control" name="email">
                    <option disabled selected value>Select One</option>
                    <option value="email">Yes</option>
                    <option value="phone1">No</option>
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
