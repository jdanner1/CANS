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
                <li><a href="new-account.jsp"><span class="glyphicon glyphicon-user icons"></span>Sign Up</a></li>
                <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in icons"></span>Login</a></li>
            </ul>
        </div>
    </div>
    <div class="panel panel-info">
        <div class="panel-heading"><h3>What is Advanced Text Vocalizer?</h3></div>
        <div class="panel-body">
            <p class="bigger">There are many advanced technologies making their way into every day life but often we are not in control.  This site was built to demonstrate practical applications of advanced technology that is not difficult to work with.  This site provides the ability to generate audio of spoken language for any text you provide.  You can choose from 10 language options and even email yourself the results.  This is made possible by leveraging IBM's Watson artificial intelligence.</p>
            <br />
            <p class="bigger">The uses for this are only limited by your imagination.  You could use it to record the message for your voicemail, build your own audio book, learn a new language or just check pronunciation.  You could use it as a voice over to give a robotic twist to your youtube video.  Take the wheel and see what you can create with easy to use AI in your hands.</p>
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
