
### Example of integrating JWT with Spring Security using Spring Boot and Spring MVC.

#### Auth

At the moment, there are 3 hardcoded users to simplify the example (in class UsernameAuthBean.java)
 * user1 - ROLE_TUBE (has access to the tube API call)
 * user2 - ROLE_WEATHER (has access to the weather API call)
 * user3 - ROLE_ADMIN (has access to everything)

For all of them, the JWT secret key is "secret".


#### Perform a valid request:

- Go to [jwt.io](http://jwt.io/)
- In the right panel, make sure that the data is like this:
First header:

`{
  "alg": "HS256",
  "typ": "JWT"
}`

Second header (we can change here the user we are trying to use for the request):

`{
  "username" : "user1"
}`

Third header: just leave it with default values (here we set the JWT secret key, by default in that website is "secret", so that's fine).


Example token for user1:

`eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InVzZXIxIn0.xMpiGanjLuT9-P3BXbsI6pKa8BB2suAXkxltSwrGFOc`

Example token for user2:

`eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InVzZXIyIn0.l36E3wEEZ7VhYDhpi4tOGUdxGQ7N1gWifa_57len4wY`

Example token for user3:

`eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InVzZXIzIn0.tX8OLfGxv14ET_OwjP4e2TTwp5xDxqQJ9fAo7NJaiSk`

We can perform 2 requests:

* Tube

`http://localhost:8080/tube/{line_ID}?token=<your JWT token here>`

E.G.

`http://localhost:8080/tube/bakerloo?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InVzZXIxIn0.xMpiGanjLuT9-P3BXbsI6pKa8BB2suAXkxltSwrGFOc`

* Weather

`http://localhost:8080/weather/{city_name}?token=<your JWT token here>`

E.G.

`http://localhost:8080/weather/london?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InVzZXIyIn0.l36E3wEEZ7VhYDhpi4tOGUdxGQ7N1gWifa_57len4wY`








