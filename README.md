# Spring Boot Application
## Problem Statement
Spring Boot application that takes search requests, turns them into ElasticSearch queries and then returns the response from the query.  The search request should be in JSON and take two parameters: interest and minSalary.  The server should then search ElasticSearch for documents that match the search parameters and return the results.  It should return the count of matching documents as well as the first 10 matching documents

## Setting up Elastic Search
The following steps will get ElasticSearch running on your computer:
•	Download ElasticSearch from here: https://www.elastic.co/downloads/elasticsearch
•	Install ElasticSearch by untarring/unzipping in into the directory of your choice.
•	Edit config/elasticsearch.yml and add xpack.security.enabled: false to the file
•	Start ElasticSearch with bin/elasticsearch (or bin\elasticsearch.bat on Windows)
•	Unzip the sample data into a directory of your choice.
•	Load the ES mapping using curl: curl -X PUT http://localhost:9200/employees -H 'Content-Type: application/json' -d @employees-mapping.json
•	Load the test data with curl: curl -o /dev/null -X POST http://localhost:9200/_bulk -H 'Content-Type: application/json' --data-binary @employees.jsons. (Windows version: curl -o nul -X POST http://localhost:9200/_bulk -H 'Content-Type: application/json' --data-binary @employees.jsons)

## Running the Application
1. Build the project: `mvn clean install`
2. Run the application: `java -jar target/elasticsearch-*.jar`