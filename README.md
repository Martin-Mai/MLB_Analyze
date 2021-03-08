# MLB_Analyze_Application

# Major Achievement in this application

• Implemented a **statistical analysis application** in **Java** with **Merge Sort**, **Binary
Search**, and **Graph algorithms** for MLB (Major League Baseball), based on 
**100,000+ data** of all players and teams from 1871 to 2015. 

• Produced an optimized and **efficient solution** for fans to evaluate the 
performance and rank the baseball players and baseball teams based on their 
batting success for each season they played

# Introduction
## Purpose

This document will present a detailed description of analysis tool, MLB Analysis. It will explain
the purpose and features of the software, the interfaces, what the software will do, the algorithms
used, and the constraints under which it will operate. This document is intended for potential
developers and also for users of the software.


## Scope

MLB Analysis is a baseball statistics analysis tool, using various sorting, searching, and graphing
algorithms. The software uses a statistic based on our custom made formula (which is discussed
in further detail in section 1.3) to rank the baseball players on their batting success for each
season they played in.

## Definitions, Acronyms, Abbreviations
When analyzing baseball statistics, there are a variety of different acronyms and abbreviations
that are used to represent different statistics. Below there will be a list of different abbreviations
and what they stand for.

## User Interface:
<table>
  <tr>
    <td><img src="https://github.com/Martin-Mai/MLB_Analyze_Application/blob/master/UI/SortTeam.jpg"></td>
    <td><img src="https://github.com/Martin-Mai/MLB_Analyze_Application/blob/master/UI/exampleSearch.jpg"></td>
    <td><img src="https://github.com/Martin-Mai/MLB_Analyze_Application/blob/master/UI/searchPage.jpg"></td>
    <td><img src="https://github.com/Martin-Mai/MLB_Analyze_Application/blob/master/UI/sortPage.jpg"></td>
  </tr>
</table>

##### MLB: Major League Baseball
##### G: Games Played
##### AB: At Bats
##### R: Runs
##### H: Hits
##### 2B: Doubles
##### 3B: Triples
##### HR: Home Runs
##### RBI: Runs Batted In
##### SB: Stolen Bases
##### CS: Caught Stealing
##### BB: Base on Balls
##### IBB: Intentional Base on Balls
##### HBP: Hit by Pitch
##### SH: Sacrifice Hits
##### SF: Sacrifice Flies
##### GIDP: Grounded into Double Play

Using the above statistics, a formula was created to calculate the relative contribution that each
player made during a season, called RCon. RCon was calculated using the following formula,
and is a measure of the expected number of bases contributed by the player along with the
contribution due to runs scored for each plate appearance.

RCon =
((H-2B-3B-HR)+2*2B+3*3B+4*HR+BB+IBB+HBP+SB+0.5*(SH+SF)+R+RBI-CS-2*GIDP)/
(AB+BB+IBB+HBP+SH+SF)

When analyzing RCon, a higher score means that the player has a greater contribution per plate
appearance. If a player does not have a plate appearance in a season, their RCon is scored as
N/A.

## References

### IEEE SRS 2009:

IEEE Recommended Practice for Software Requirements Specifications, Dec-2009. [Online].
Available: http://www.cse.msu.edu/~cse870/IEEEXplore-SRS-template.pdf. [Accessed:
05-Mar-2020].

### Sample SRS:
K. Varvoutas, “Gephi SRS,” Software Requirements Specification for Gephi, Feb-2017.
[Online]. Available: https://gephi.org/users/gephi_srs_document.pdf. [Accessed: 05-Mar-2020].

# Overall Description
## Product Perspective

MLB Analysis is a tool developed for anyone who is interested in either seeing the statistics of
certain players or comparing multiple players against one another, presenting an easy way to
understand. It uses a public data set (in .xlsx format) and supports searching, sorting, and
displaying the players that were on the same team at the same time.
There are existing products that are similar to MLB analyst, such as baseball-reference, however,
This product aims to provide data and statistics in a more meaningful way。
It is written in Java 8 for the back-end and an eclipse object with a GUI was created using
Flutter.

## Product Functions
### Sorting:
#### Sort by first name: 
Sorts all players by their first name, from A-Z or Z-A, depending on which is specified.
#### Sort by last name: 
Sorts all players by their last name, from A-Z or Z-A, depending on which is specified.
#### Sort by batting: 
Sorts all players by their RCon, from highest to lowest or lowest to highest, depending on which is specified.
#### Sort by team name: 
Sorts all players by their team name, from A-Z or Z-A, depending on which is specified.
#### Sort by year: 
Sorts all players by their year, from least to most recent or most to least recent, depending on which is specified.

### Searching:
#### Search by statistic: 
Returns a list of players that match the specified statistic (batting, name, team, etc…).

### Graphing:
#### Graph: 
Creates a directed graph where each vertex (node) is a player and points towards other players on the same team in the same year with a greater RCon score.
#### SCC: 
Finds the strongly connected components (SCC) of the graph.

## User Characteristics
Typical user would be a casual MLB fan who would like to know more about a certain player or group of players.

MLB analysts who would like the data of numerous players presented in an intuitive way in order to make predictions.

Developers who are interested in further developing or maintaining the product.

## Constraints
As specified by the client, the model of the product must be written in Java code, which holds the
logic of the function and the states of MLB analysis application. The classes and functions will
be tested by using the java unit testing method (Junit) to check the correctness of the product. In
addition, JSP(Java Server Page), a html based code program, will be used to create dynamic
content since the baseball data is refreshing and updating the new information.

## Operating Environment
Windows system

## Assumptions and Dependencies
Since MLB Analysis is a PC application written in Java and therefore requires any potential
users to own a compatible PC device.

# Specific Functional Requirements
### Searching for players:
It will open a window that contains a searching bar, the search button as well as the filter.

### Sorting for players: 
It will open a window that contains several sorting options such as sorting by first name, sorting by last name,etc.

## External Interfaces:
MLB Analysis will be in the form of a pc application in Windows systems. It can be connected to the source data file from kaggle.com to load the data.
The GUI will consist of a search bar and will have multiple drop down menus so that the user
can better specify how he wants the desired information to be presented. After clicking the
search bar there will be the results of the search

## Software Interfaces:
As MLB Analysis is a Windows system compatible app, requiring the Windows system and Java
running environment more information can be found in section 2.

## Hardware interfaces:
The system must have at least 300 megabytes for memory.

# Non-Functional requirements:
## Performance Requirements
1. The goal for the response time is less than 1.0 seconds in most cases. Response time is a
very critical attribute of a good pc application. It is important that MLB Analysis will
have no more than 1.0 second response time in most cases, regardless of search
parameters.
2. The app works perfectly in the environment without the internet. The app should load the
data and store it into the memory of the computer, then the user can interact with the
product by the java GUI.
3. The app requires the system to have at least 300 megabytes of RAM. When the app is
running, its CPU usage will be less than 50%, and its memory usage will be less than
50%.
4. The software installed on the operating system must be compatible with its firewall or
antivirus protection.

## Safety Requirements:
MLB can be downloaded and run on different pc devices with Windows systems. In order to
prevent users from facing security threats such as program damage, data loss and information
theft, the developer team will update this software regularly.

## Security Requirements:
MLB Analysis does not have any security requirements as its job is to analyze the statistics of
MLB players and provide searching capabilities for the users based on input. Any users can use
it without any additional permission and privileges.

## Software Quality Attributes:
### Availability: 
MLB Analysis will provide baseball statistics for the users.
### Maintainability: 
The software will be maintained to ensure that it functions properly when it is available to be used.
### Portability: 
The users can access MLB Analyze on different personal computers that have Windows systems .
### Accuracy of Results: 
The application will be designed to output the expected messages based on the user’s requirement. By comparing the information of different objects, the users will know how players rank with respect to each other based on RCon.
### Performance: 
The design will process a considerable dataset and use a variety of efficient algorithms such as quicksort, binary search in Java to produce the output by minimizing run time and memory usage.
### Integrity: 
The MLB analysis will ensure the privacy of the users and not expose confidential information without explicit consent.




