# John Danner Individual Project

### Problem Statement

Many people throughout the world enjoy using the website craigslist.org.  They appreciate the ability to post for free and many exchanges occur in win-win fashion.  It shines particularly for situations where shipping is impractical.  The site may appear to be built for non-commercial use but craigslist does offer features that businesses can take advantage of.  However, using the features is not practical for a non-technical user.    

This is where CAPS comes in!  Get an edge by letting the Craigslist Advanced Posting System put your listings out in many cities or under several product categories with the same effort as creating a single post.  Our intention is not to flood the site with repetetive postings.  Instead, we are here to help aspiring entreprenures reach more people with less time at the computer.  Provided here are tools that will help you create, manage and remove postings at any scale.  Our service is not only for business owners and power hobbyists - it can work for folks that need something hard to find who are willing to search without regard to location to find what they need.  It is also well suited for high value items.  Give CAPS a try and see for yourself the power of craigslist's reach without losing all your time to repetetive work.  


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

### [Project Plan](Project_Documentation/Individual_Project_Plan.docx)

### [Development Journal](Journal.md)
