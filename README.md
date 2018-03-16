# Servlet 3.0 examples.

## Version 1 
A basic Hello World! servlet and jsp, with xml descriptor. Tag: v1

## Version 2
Same basic hello world, now with annotation descriptor on the servlet. Tag: v2

## Version 3
*Seems i made a mistake when commit:ing this. Use `git checkout b6801fa940d8300a3f565ada313ac298bbb0904b` instead*
This example demonstrates GET and POST, where the GET returns the helloform.html and the POST stores the name in an attribute that is then displayed in sayhello.jsp.

## Version 4
This version uses a cookie to store the name information, which makes it behave better (the name is remembered between requests). Both doGet and doPost in servlet uses redirect instead of forward so that the browser knows where it is, the url show what resource is used (helloform.html / sayhello.jsp). This version also make use of the core JSTL taglib.

## Version 5
This version uses a session to store the name, instead of using a separate cookie, which makes this an even better solution to the name storing problem than version 4. Since a cookie is used to store small amount of information in a single value, there would need to be many cookies in any real world application to keep track of everything needed, if we did not have sessions. 

## Version 6
This example demonstrates a very simple full blown mvc-style implementation, without actually using any mvc framework. This is purely intended for educational purpose to study some of the parts that make up most web applications, such as:
- Authentication / authorization, including storing hashed password (not secure enough for real world app, mind you!)
- Filter servlet, that redirects to login if necessary
- A few "routes" using mapped servlets that act on GET/POST in REST-style
- Some jsp's ("views") that interact with data using servlets ("controllers")
- Repositories and services for data/domain access. These in turn use JPA for database access
- JPA is setup to communicate with H2 in server mode, make sure you start that separately first. Or use the "mem" connection string instead (see persistence.xml)
