/*
The purpose of this function is to determine the page's last modified date
and place it on the web page footer.  The code removes all data elements
other than the date.
*/


function getRevisedDate()   {

    // Declare all variables
    var dateObject;
    var dateYear;
    var dateMonth;
    var dateDay;
    var yearString;
    var monthString;
    var dayString;
    var awesomeDate;
    var displayMessage;

    // Create a Date Object set to the last modifed date
    dateObject = new Date(document.lastModified);

    // Get full year (as opposed to last two digits only)
    dateYear = dateObject.getFullYear();

    // Get month and correct it (getMonth() returns 0 to 11)
    dateMonth = dateObject.getMonth() + 1;
    // Get day within month
    dateDay = dateObject.getDate();

    // Convert year, month and date to strings
    yearString = new String(dateYear);
    monthString = new String(dateMonth);
    dayString = new String(dateDay);

    // Add leading zeros to month and date when required
    if ( monthString.length == 1 ) monthString = "0" + monthString;
    if ( dayString.length == 1 ) dayString = "0" + dayString;

    // Combine year, month and date into desired format
    awesomeDate = yearString + "-" + monthString + "-" + dayString;

    //Build output message with desired text formatting
    displayMessage = "Last Updated: " + awesomeDate;

    //Display revised date on site
    document.write( displayMessage );
}
