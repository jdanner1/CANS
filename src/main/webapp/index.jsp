<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>${title}</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://bootswatch.com/readable/bootstrap.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <style>
        body {margin: 2em;}
        #spacer {margin-left: 1.5em; margin-right: 1.5em;}
        .formHeader {display: inline;  margin-right: .8em;}
        table.all { border-collapse:collapse; margin-bottom: 3em; margin-top:2.5em; }
        tr:nth-child(even) { background-color: #DCDCDC; }
        td.allCells { border: .2em ridge black; margin: 2em; padding: 1em; }
        td.header { margin: 2em; padding: 1em; }
    </style>
</head>
<body>
<div class="container-fluid">
    <h2>User Display Exercise - Week 1</h2>
    <h3><a href = "searchUser">Display All Users</a></h3>
    <br /><br />

    <article>
        <fieldset>
            <legend>Filter Users</legend>
            <form action="LoadAreaServlet"

                  method="post"

                  name="searchUser"

                  id="searchUser">


                <input type="submit"
                       value="Submit"
                       class="buttons" />
            </form>
        </fieldset>
    </article>
</div>
</body>
</html>
