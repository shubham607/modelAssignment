*****************************Coding Assignment********************************

Modelling Problem:

You are the proprietor of füber, an on call taxi service.
You have a fleet of cabs at your disposal, and each cab has a location, determined by it’s latitude and longitude.
A customer can call one of your taxis by providing their location, and you must assign the nearest taxi to the customer.
Some customers are particular that they only ride around in pink cars, for hipster reasons. You must support this ability.
When the cab is assigned to the customer, it can no longer pick up any other customers
If there are no taxis available, you reject the customer's request.
The customer ends the ride at some location. The cab waits around outside the customer’s house, and is available to be assigned to another customer.




********************************Solution***************************************

Description:

 A Fuber taxi service is a web application which helps the customer to book a cab from current location to destination location with a facility of special pink color cabs (for hipster reason), once the cab is assigned to the customer as he/she reaches to the destination and complete the ride, a total fare amount (i.e. 2 dogecon /km & for special pink cabs additional 5dogecoin) is generated, once the payment is done and submitted, the cab is now avaliable from the drop location to all other customers.  

		
WorkFlow of project:

1.HomePage -> ask customer to enter current & destination location & cab color.
2.According to current location of customer we will map the shotage cab avaliable to customer location and assign to him/her.
3. once the cab is assigned it will not be avaliable to any other customer, as we change the status to assign in our database.
4. as soon as customer reach to its location and end the trip, we wil generate a fare amount depending on facility & distance covered.
5. once he/she submit the payment, from the same location cab will be now avaliable to other customer.


Technologies used: Jsp, Servlet, coreJava, Hibernate, mysql.
IDE: eclipse Mars2.0
Server: Apache Tomcat8.0

Note: 

1. Due to time limitation, i am unable to cover the testCases, so i am really sorry for this.
2. I hope you will like the application as i had covered almost all the scenarios mentioned in the assignment.   
