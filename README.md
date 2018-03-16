# Servlet 3.0 examples.

## Version 1 
A basic Hello World! servlet and jsp, with xml descriptor. Tag: v1

## Version 2
Same basic hello world, now with annotation descriptor on the servlet. Tag: v2

## Version 3
This example demonstrates GET and POST, where the GET returns the helloform.html and the POST stores the name in an attribute that is then displayed in sayhello.jsp.

## Version 4
This version uses a cookie to store the name information, which makes it behave better (the name is remembered between requests). Both doGet and doPost in servlet uses redirect instead of forward so that the browser knows where it is, the url show what resource is used (helloform.html / sayhello.jsp). This version also make use of the core JSTL taglib.

## Version 5
This version uses a session to store the name, instead of using a separate cookie, which makes this an even better solution to the name storing problem than version 4. Since a cookie is used to store small amount of information in a single value, there would need to be many cookies in any real world application to keep track of everything needed, if we did not have sessions. 