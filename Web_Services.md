1. API & web services difference
Web Services:
Web service facilitates interaction between two machines over a network. <br>
A Web service is designed to have an interface that is depicted in a machine-processable format usually specified in Web Service Description <br> 
A Web service uses only three styles of use: SOAP, REST and XML-RPC for communication whereas API may use any style for communication <br>

API:
API acts as an interface between two different applications so that they can communicate with each other. <br>
An API is a method by which the third-party vendors can write programs that interface easily with other programs <br>
All Web services are APIs but all APIs are not Web services.


2. API testing using postman
3. Different request methods

GET : GET is used to request data from a specified resource. <br>
HEAD : HEAD is almost identical to GET, but without the response body. <br>
POST : POST is used to send data to a server to create/update a resource. <br>
PUT : PUT is used to send data to a server to create/update a resource. <br>
DELETE : The DELETE method deletes the specified resource. <br>
CONNECT : Establishes a tunnel to the server identified by a given URI. <br>
OPTIONS : The OPTIONS method describes the communication options for the target resource. <br>
TRACE : Performs a message loop-back test along the path to the target resource. <br>
PATCH : PATCH can be used to update partial resources <br>






4. Different status codes

200 : Ok <br>
201 : Created <br>
204 : No Content <br>
301 : Redirects <br>
400 : Bad Request <br>
401 : Unauthorized <br>
403 : Forbidden <br>
404 : Not found <br>
405 : Method Not Allowed <br>
409 : Conflict <br>
429 : Too Many Requests	 <br>
500 : interal server error <br>
503 : Service Unavailable	 <br>


5. Difference between soap & rest

SOAP:
> SOAP Support Only XML format support  <br>
> Transfer protocol(s)	HTTP, SMTP, UDP, and others. <br>
> Caching	API calls cannot be cached. <br>

REST:
> REST Support Plain text, HTML, XML, JSON, YAML, and others. <br>
> Only HTTP <br>
> API calls can be cached. <br>


6. How to create mock services in local

