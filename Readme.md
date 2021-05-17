

# == Note ==
(c) Laxmi Somni 

All tests are build using standard packaging solution: Maven. & could be centrally deployed using standard POM.XML Test are written in Cucumber BDD fashion

#### System Requirements: 
Chrome Version 90.0.* {In case of Chrome you'll need to unzip chromedriver located in driverDir folder}
If you're having Chrome 81.0+ then you'll need to replace chromedriver with  chromedriver_81 in driverDir folder.
Latest chromeDriver can be downloaded from:
https://chromedriver.chromium.org/downloads
 
OS: Mac OS X or Win 8

Java 8 SDK

## To Run the Tests

#### Option1 (preferred)
a) Import Maven Dependencies 

b) Check the BDD Feature files located at:

```> src/test/resources/features```

b) In IntelliJ Go to **src> test> runners> RunCucumberIT** 

c) Right click and Run

#### Option2

a) From commandline invoke `mvn clean test` 
#### Option3

a) From commandline invoke `mvn clean test` 
b) Install cucumber plugin for your IDE of choice (viz- IntelliJ)
b) Open the BDD Feature files & Right click and select Run on the feature:
```> src/test/resources/features```

Note:

The Test Runner will create Cucumber report at below folder `target/cucumber-html-report`

Also, a interactive Donut report will be created in ${project.build.directory}/donut


## Test Approach & Future enhancements

Enhancements that could be added
a) To enable screen recording of entire run.
b) Adding EventFiring WebDriver
c) Adding Retry listner
d) Adding Stream APIs

## Test Result Snapshot:
<img width="1116" alt="Screen Shot 2021-05-17 at 01 12 54" src="https://user-images.githubusercontent.com/7977484/118417682-24ec5e80-b6ad-11eb-919c-46761b291916.png">

Please feel free to get back to me on the below email:
`laxmi.somni@gmail.com`

Many Thanks