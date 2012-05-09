liftweb-sbt-jrebel
==================

simple chat project to demonstrate that jRebel might not be working correctly with Lift?

Starting with jrebel, running ```~container:start```. In ```Chat.scala``` change 
```Vector("Welcome", "Welcome 2")``` to ```Vector("Welcome")```
and reload the page, the changes are not seen. You need to stop and restart the container.