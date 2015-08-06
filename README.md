# spring-security-dynamic-authorization-and-authentication
Avoid intercept url pattern and access dynamically by using sql query in spring security.

use sql query for retriving roles of the requested URL. Generally we use intercept tag in xml along with url and roles attributes. we can avoid this tag and we can retrive those information form db.

you also found custom UserDetailsService implementaion for getting authentication.

<b>Steps</b>

1) import db.sql file into to your db.<br>
2) import thisp project into your fav editor (eclipse).<br>
3) specify you db properties in <b>Constants.properties</b> file.<br>
4) run the porject.<br>

<b> Database having following tables</b>

1) User <br>
2) Roles <br>
3) action <br>
4) User_roles <br>
5) roles_actions <br>

