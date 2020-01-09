##Integration tests for WSO2 ESB Twitter connector

### Pre-requisites:

    - Maven 3.x
    - Java 1.8 

### Tested Platforms:

    - Ubuntu 16.04
    - WSO2 EI 6.4.0
    - java 1.8

##### Steps to follow in setting the Twitter Account.


1. To work with the Twitter API connector, you need to have a Twitter Account. 
   
 2. To access the Twitter API [Register your application](https://dev.twitter.com/apps.) with Twitter to obtain credentials such as consumerKey, consumerSecret , accessToken and accessTokenSecret and make sure you have selected Access permission level to Read, write, and direct messages.
### Steps to follow in setting integration test.

1.Download EI 6.4.0  by navigating to the following [URL](http://wso2.com/products/enterprise-service-bus/#).

2.Copy the EI 6.4.0 zip to the location `Connector_Home/repository/`.

3.Update the 'esb-connector-twitter.properties' file at the location "{TWITTER_CONNECTOR_HOME}/repository" as below

        i) apiUrl                 -	Api URL to access the Twitter API.
       ii) consumerKey            -	The consumer key of the Twitter account.
      iii) consumerSecret         -	The consumer secret of the Twitter account.    
       iv) accessToken            -	The access token of the Twitter account.
        v) accessTokenSecret      -	The access token secret of the Twitter account.
       vi) screenName             -	The screen name of the user for whom to return results for.
       vi) screenName1            -	The screen name of the user for whom to return results for.
      vii) sinceId                -	Returns results with an ID greater than (i.e., more recent than) the specified ID. For example, If there have been more than 800 tweets set as favorite since the specified ID, sinceId will be forced to the oldest ID available.
     viii) maxId                  -	Returns results with an ID less than (i.e., older than) or equal to the specified ID.
       ix) maxId1                 -	Returns results with an ID less than (i.e., older than) or equal to the specified ID.
                                                              

5.Update the twitter properties file at location `<Connector_Home>/src/test/resources/artifacts/ESB/connector/config` as below.
<br/><br/>

| Property | Description |
| ------------- |-------------|
| includeUserEntities |  Whether the user entities node should be returned in the user objector not. If set to false, the user entities node will not be returned.|
| skipStatus | Whether the status should be returned in the user objector not. If set to either true, t or 1, the status will not be returned.|
| includeEmail | Whether the email should be returned in the user objects as a string. If set to true, the email will be returned. |
| sleepTimeEnabled| When set to true, t or 1, will enable sleep time for the user. Sleep time is the time when push or SMS notifications should not be sent to the user.|
| screenName2| The screen name of the user to be blocked. |
| includeEntities| Set to false if you do not want the entities node to be included in the returned user object.|
| cursor| Specify this property if you want the list of IDs to be broken into pages of results. If a value is not specified, a default value of -1 will be assumed, which is the first page. When you specify this property the response from the API will include a previous_cursor and next_cursor to allow paging back and forth.|
| stringifyIds1| Set this to true if you need to have the ids returned as strings.|
| userID|The ID of the user to be blocked.|
| text |The text of your direct message. |
| count|The number of messages to retrieve per page. The number of messages can go up to a maximum of 200. The default value is 20. |
| trimUser|If set to either true, t or 1, each tweet returned in a timeline will include a user object including only the status author's user ID. Omit this property to retrieve the complete user object.|
| contributorDetails|If set to true, this property enhances the contributors details in the status response to include the screen name of the contributor. By default only the user ID of the contributor is included. |
| id1|A comma separated list of tweet IDs of the tweets you need to retrieve details for. You can specify up to 100 comma separated tweet IDs in a single request. |
| id| A comma separated list of tweet IDs of the tweets you need to retrieve details for. You can specify up to 100 comma separated tweet IDs in a single request.|
| map|A comma separated list of tweet IDs of the tweets you need to retrieve details for. You can specify up to 100 comma separated tweet IDs in a single request.|
| excludeReplies|If set to true, this property will prevent replies from appearing in the returned timeline. |
| status|The status. Be sure to URL encode as necessary, and keep the message under 140 characters |
| possiblySensitive|If you upload Tweet media that might be considered sensitive content such as nudity, violence, or medical procedures, you should set this value to true. |
| query | The query to use in the saved search. |
| q|The search query. This is a UTF-8, URL encoded search query with a maximum of 1,000 characters, including operators.|
| page|The page of results to retrieve. |
| lang|Specify the required  ISO 639-1 code, if you need to retrieve tweets of a particular language. For example, specify en to retrieve tweets that are in English. |
| resultType|  Specify the type of search results you prefer to retrieve. The default is mixed. Possible values are mixed, recent or popular.|
| exclude|Setting this equal to hashtags will remove all hashtags from the trends list.|
| latitude|If specified with the long property, the available trend location will be sorted by distance, nearest to furthest to the coordinate pair. The valid range for latitude is -180.0 to +180.0 (West is negative, East is positive) inclusive.|
| longitude |If specified with the lat property the available trend location will be sorted by distance, nearest to furthest, to the co-ordinate pair. The valid range for longitude is -180.0 to +180.0 (West is negative, East is positive) inclusive. |
| resources| A comma separated list of resource families for which you want to retrieve the current rate limit disposition. |
| name|The name for the list.|
| description| The description of the list. |
| sourceScreenName|The screen name of the subject user.|
| targetScreenName| The screen name of the target user.|
| retweets|Set to true to enable retweets from the target user.|
| count| The number of records to retrieve.|

6.Navigate to `{EI_Connector_Home}/` and run the following command.
             `$ mvn clean install -Dskip-tests=false`
