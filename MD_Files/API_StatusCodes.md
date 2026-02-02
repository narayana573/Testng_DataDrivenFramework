
### 1xx: Informational (Request Received)

| Code | About It |
| --- | --- |
| **100** | **Continue:** The server received the request headers and the client should proceed to send the body. |
| **101** | **Switching Protocols:** Used when moving from HTTP to WebSockets. |
| **102** | **Processing:** The server has received the request but is still working on it (prevents timeouts). |

### 2xx: Success (Action Accepted)

| Code | About It |
| --- | --- |
| **200** | **OK:** The standard success code for most requests. |
| **201** | **Created:** A new resource was successfully created (standard for `POST`). |
| **202** | **Accepted:** Request received but processing isn't finished (Async processing). |
| **203** | **Non-Authoritative Info:** The info returned is from a local/third-party copy, not the original server. |
| **204** | **No Content:** Success, but there is no data to return in the response body (common for `DELETE`). |
| **205** | **Reset Content:** Tells the client to clear the view/form that sent the request. |
| **206** | **Partial Content:** Used for "Range" requests (e.g., downloading a large file in chunks). |

### 3xx: Redirection (Further Action Needed)

| Code | About It |
| --- | --- |
| **300** | **Multiple Choices:** There are several options for the resource (e.g., different file formats). |
| **301** | **Moved Permanently:** The URL has changed forever. |
| **302** | **Found (Temporary Redirect):** The URL is temporarily somewhere else. |
| **304** | **Not Modified:** The cached version you have is still good; no need to re-download. |
| **307** | **Temporary Redirect:** Similar to 302, but ensures the HTTP method doesn't change. |
| **308** | **Permanent Redirect:** Similar to 301, but ensures the HTTP method doesn't change. |

### 4xx: Client Error (User/Tester Side Issue)

| Code | About It |
| --- | --- |
| **400** | **Bad Request:** Syntax error or invalid request data. |
| **401** | **Unauthorized:** User lacks valid authentication credentials (Identity). |
| **403** | **Forbidden:** User is known but does not have permission for this resource (Access). |
| **404** | **Not Found:** The endpoint or resource ID does not exist. |
| **405** | **Method Not Allowed:** Using the wrong verb (e.g., `POST` instead of `GET`). |
| **406** | **Not Acceptable:** The server cannot produce data in the format requested (Accept header). |
| **408** | **Request Timeout:** The client took too long to send the request. |
| **409** | **Conflict:** Edit collision (e.g., trying to create a user that already exists). |
| **410** | **Gone:** The resource is deleted and will never come back (more specific than 404). |
| **413** | **Payload Too Large:** The request body exceeds the server's limit. |
| **415** | **Unsupported Media Type:** Sending `XML` when the API only accepts `JSON`. |
| **429** | **Too Many Requests:** The user has hit the rate limit (API Throttling). |

### 5xx: Server Error (Backend Bug/Infrastructure)

| Code | About It |
| --- | --- |
| **500** | **Internal Server Error:** A generic crash in the backend code. |
| **501** | **Not Implemented:** The server doesn't support the functionality requested. |
| **502** | **Bad Gateway:** One server got an invalid response from another (Proxy error). |
| **503** | **Service Unavailable:** Server is overloaded or down for maintenance. |
| **504** | **Gateway Timeout:** The backend took too long to respond to the proxy. |
| **505** | **HTTP Version Not Supported:** Server doesn't support the HTTP version used. |

---

