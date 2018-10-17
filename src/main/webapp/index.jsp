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
                <li><a href="new-account.jsp"><span class="glyphicon glyphicon-user icons"></span>Sign Up</a></li>
                <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in icons"></span>Login</a></li>
            </ul>
        </div>
    </div>
    <div class="panel panel-info">
        <div class="panel-heading"><h3>What is Advanced Text Vocalizer?</h3></div>
        <div class="panel-body">
            <p class="bigger">There are many advanced technologies making their way into every day life but often we are not in control.  This site was built as a demonstration to show how something really advanced can have practical applications in your life and not be difficult to work with.  This site provides the ability to generate audio files with spoken language for any text you provide.  You can choose from 10 different languages, although a few overlap but contain different dialects.  All of this is made possible by leveraging IBM's Watson artificial intelligence.</p>
            <p class="bigger">The applications for this are only limited by your imagination.  You could use it to record the message for your voicemail, build your own audio book, learn a new language or just check pronunciation.  You could use it as a voice over to give a robotic twist to your youtube video.  Use it to trick your mom into thinking you finally have a girlfriend.  We don't care what you choose; we just want to put the power of AI in your hands.  Give it a try and see just how easy it can be.</p>
        </div>
    </div>

        <div class="panel panel-primary">
            <div class="panel-heading"><h4>Give it a try!</h4></div>
            <div class="panel-body">
                <div class="row panel2">
                    <p class="bigger">
                        <span>We collect only the minimal information to provide our service and we share it with no one.  Registration takes only a minute and our service is free.</span>
                    </p>
                </div>
                <div class="row">
                    <p>
                        <span>&nbsp; &nbsp;</span>
                        <a href="new-account.jsp" class="btn btn-success whitetext" role="button">Sign Up</a>
                    </p>
                </div>
            </div>
        </div>

</nav><%@ include file="footer.jsp" %>
