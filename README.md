# John Danner Individual Project

### Problem Statement

There are many advanced technologies making their way into every day life but with so much unfamiliar jargon and overly brief explanations from immersed experts it can be overwhelming and off-putting.  This site was built as a demonstration to show how something really advanced can have practical applications in your life and not be difficult to work with.  This site provides the ability to generate audio files with spoken language for any text you provide.  You can choose from 10 different languages, although a few overlap but contain different dialects.  All of this is made possible by leveraging IBM's Watson artificial intelligence.  

The applications for this are only limited by your imagination.  You could use it to record the message for your voicemail, build your own audio book, learn a new language or just check pronunciation.  You could use it as a voice over to give a robotic twist to your youtube video.  Use it to trick your mom into thinking you finally have a girlfriend.  We don't care what you choose; we just want to put the power in your hands to watch with pride as you breathe life into whatever project makes you happy or motivated.  Give it a try and see just how easy using AI can be.     

  


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
