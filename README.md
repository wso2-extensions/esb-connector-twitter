### Twitter Connector

The Twitter connector allows you to connect to X (formerly Twitter), an online social networking service and microblogging service that enables its users to send and read text-based posts of up to 280 characters, known as 'posts' or 'tweets'. The connector uses the X API v2 (Twitter API v2) to connect to X, create and manage posts, retrieve followers, manage lists, send direct messages, and more.

### Compatibility

| Connector Version | Supported WSO2 MI Version |
|-------------------|---------------------------|
| 4.0.0             | MI 4.4.0                  |

#### Supported Operations

**Post/Tweet Management:**
- Create, delete, like/unlike posts
- Create retweets and quote tweets
- Search posts and retrieve timelines
- Get post details and lookup multiple posts

**User Management:**
- Follow/unfollow users
- Block/unblock and mute/unmute users
- Retrieve user information by ID or username
- Get followers, following lists, and user lookups

**List Management:**
- Create, update, and delete lists
- Get list details and memberships
- Manage list following

**Direct Messages:**
- Send and retrieve direct messages
- Manage direct message conversations

#### API Version

This connector uses **X API v2** (Twitter API v2), which is the current and recommended version. The API supports OAuth 2.0 authentication with automatic token refresh.

### Build

mvn clean install

### How You Can Contribute
You can create a third party connector and publish in WSO2 Store.

https://docs.wso2.com/display/ESBCONNECTORS/Creating+and+Publishing+a+Third+Party+Connector
