# Studypoint-5
## Exercise 2.




## Exercise 3.

The first request method is for studypoint.dk.
The second request method is for a javascript called angular.js

We end up in https://studypoints.dk/#/view1 instead of https://studypoints.dk

## Exercise 5.

Set the forms method-attribute to the value “GET” (actually the default value) and test the form. Observe what happens in your browsers address field.

We can see all the values which are parsed from the form in the url.
http://localhost:8080/Exercise-HTTP/?fname=df&lname=asd&hidden=12345678#

When we use Post all the parsed values are hiddn. we cant see them in the url


## Exercise 6

f) Most importen part of this exercise:
Explain (on paper) using both words and images how the Server can maintain state between subsequent calls even when using a stateless protocol



# Network interfaces, IP-numbers and more

1. What is the ip address of your wireless card?

- The ip is 192.168.0.5

2. What is special about the IP-addresses that starts with 10 (and 172.16 and 192.168)

- These ip adresses are non-routable adresses, which mean that all data traffic will stay inside your local network.

3.Who or what gave you that address?

- The DHCP server

4.What is a DHCP server (conceptually)

- DHCP is a network protocol, used to assign ip adresses to computers, when they request one. 

5.What is the address of your DHCP Server

- it is 192.168.0.1

6.What is a DNS server (conceptually)

 - You can say that a DNS server is a phone book which contain the ip adress for all websites.

 Ex. when you search for youtube.com you send a DNS request to the DNS server which translate it to 74.125.25.136


7.What is the DNS server address?

- im using 8.8.8.8, which is googles DNS server.

8.What is a MAC address

- Is the address of the device you are using.

9.What is the MAC address of the your Network Interface(s)?

- 20:c9:d0:da:8a:9d, a8:20:66:2c:80:f3 and aa:20:66:c2:fb:00

10.How many network interfaces do you have?

- 3.

11.Why do you have more than one? What are they for?

- I have one for WIFI , one for Ethernet and one for Thunderbolt

12.What is your public address (WAN) (can’t be found with ipconfig)  address right now. Ask others in the class for theirs, do you all have the same public address ?

- 176.23.49.57, yes.

# Networking

1.Find the IP address for cphbusiness.dk

 - 195.254.168.52

2.When was cphbusiness.dk registered first time and whois the Registrant

2008-12-15 efif or århus købmandsskole.

3.Use ping to verify whether you Digitalocean Droplet is online

-  it is running

4.How many routers do you need to go through to reach dr.dk?

- 5 

5.How many routers do you need to go through to reach rhcloud.com?

- 5

6.How many active connections do you have on your computer?

7.What is the round-trip time to reach google.com?

- 19.981 ms

8.Why is it so low if Google is in the United States?

- because google have servers all over the world.

9.Start your local Tomcat server and use netstat to verify whether “anyone” is listening on port 8080 and 3306 (what would you expect to find listening on 3306?)

10.If you have setup MySQL on Digital Ocean to be accessible from the school (or home), verify this using Telnet. If not, ask around in the class, and find one who has.


