# John Danner Individual Project

### Problem Statement

Many people throughout the world enjoy using the website craigslist.org.  They appreciate the ability to post for free and many exchanges occur in win-win fashion.  It shines particularly for situations where shipping is impractical.  The primary down side of this site is competition; generally folks that post use the 'first come first served' approach when selecting a responder to work with.    

This is where CANS comes in!  Get an edge by letting the Craigslist Advanced Notification System watch for posting you care about and when one arrives you will be notified by your choice of email or text.  Be the first to reply more often without wasting time monitoring the site.  The site will allow users to register, then create as many notifications as desired, by location and category.  To align with the mission of craigslist this service will be offered for free but each user's notifications will be tracked to permit customer-specific advertising in the future.  Advertisers will enjoy the ability to build an understanding of CANS customers' interests and current needs so targeted marketing efforts are more successful.



### Project Technologies/Techniques  - Retained Temporarily as a Guide

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: create/read/update/delete (crud) of all data
  * User role: create trail, create trail report, edit data they have entered previously
  * All: anyone can view trail information (no login)
* Database
  * MySQL
  * Store users and roles
  * Store all data for the trails and reports
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * NOAA for weather conditions at a trail location, including snow depth
* CSS 
  * Bootstrap or Materialize
* Data Validation
  * Bootstrap Validator for front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Hosting
  * AWS
* Independent Research Topic/s
  * CI tools in AWS
  * Materialize
  * Google Maps API
  * Hibernate Validation
  * Hibernat Search
* Project Lombok to eliminate boilerplate code like getters/setters/equals
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA


### Design

* [Screen Design](Project_Documentation/Individual_Project_Screens.pdf)
* [Application Flow](DesignDocuments/applicationFlow.md)
* [Database Design](DesignDocuments/databaseDiagram.png)

### [Project Plan](Project_Documentation/Individual Project Plan.docx)

### [Development Journal](Journal.md)
