# Journal

This is for more verbose descriptions of the work I am doing, particularly for challenges faced and approaches taken.  Summary points are in the timelog linked below.

[Time Log](TimeLog.md)

### Week 1

I considered a couple project options in this week.  One I thought would be fairly applicable to any job would be to build a payroll system that any small business owner could sign up for and use.  Basically it would be a utility with stnadard pieces of functionality that any payroll system should have.  The second idea was inspired by Paula mentioning that there are java website scrapers and using them could be incorporated into the individual project.  I like using craigslist.org so I think building a site where you can sign up and watch for postings that interest you would be fun and something I would use.  I am leaning this direction now.

### Week 2

This week I took a stab at identifying the screens I would need for my craigslist notification system.  I also set up my repository and created the first few files for tracking my progress.  I also wrote up my problem statement.
  
### Week 3

I showed Paula my screens prior to the checkpoint to see if the rough pictures I had met the intention.  She let me know I would need to include some detail that helps uncover database needs.  I signed up for my development project topic and presentation date and while I chose an interesting topic there will not be any part of the Internet of Things that will be easy/possible to incorporate into my indie project.

### Week 4

After talking my project idea out with Paula in the checkpoint I determined priority one was checking into the ability to scrape craigslist.  In a small amount of time I learned without a doubt that scraping craigslist would not be possible.  They have a strong opposition to this as it provides an unfair advantage and will ban IP addresses caught scraping.  I did see that craigslist offers an API for bulk posting and the site I had been reading about scraping also mentioned that the site offers this.  I found the API documentation and began adjusting the goal of my project.  Instead of finding what folks are after by browsing for new posts I will provide the ability to post in mass.  I reworked all of my existing documents (project plan, problem statment, and screen plan) with the new idea in mind.  

To work towards implementing Hibernate in my project I decided I need my database.  I created the database and 5 tables.  Two of the tables are essentially going to just feed drop down choices (posting categories and areas/cities for where to post) so I populated them. I struggled to load all categories in one shot using the terminal but with a little help from Excel I was able to paste in one insert statement after another.  However to load the Area table in this manner would be impractical as there were 810 records to load.  I decided to build out some of the project structure so I could kick off reading a file of insert statements (also created with help from Excel) from my index page and insert the records into the database as it reads the file.  It took some doing but I got this to work.  I had issues where craigslist includes single quotes in the name of the city so I simply removed them as I hit them.  If this was not a school project I would find out how to load these with the single quote but I don't consider it critical at this time.  I can always go back and update the records.  I also settled from a data perspective when I added a Parent column to data provided by craigslist.  I want to be able to group by state, which is the use of the parent.  The data from cl occasionally includes state int eh area description as the final two characters so I used the 'right' formula to grab the final two characters from that column.  It does not work in many cases so depending on how I use the system I may need to do a lot of clean up but maybe I can focus just on a couple states adn not lose tons of time cleaning up data I may never use.  

After doing much of this I saw that bulk posting is only available to high volume paid users.  I emailed craigslist admins to see if I could acess a test system for educational purposes.  If I do not hear back I may need to simulate a response.  I am in too deep now to start over again.  I probably should have gone with the payroll option.

### Week 5

### Week 6

### Week 7
  
### Week 8

### Week 9

### Week 10

### Week 11

###Week 12

### Week 13

### Week 14

### Week 15

