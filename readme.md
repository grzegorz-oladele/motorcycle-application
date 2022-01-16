#Welcome to the motorcycle application

Motorcycle application is a place where every motorcyclist racing on a motorcycle track will find something for himself.

The platform in an easy and clear way allows you to add and compare the results of your rides with other racers.

All you have to do is register in the application, add your motorcycle and you can fully use the potential of the 
solution, which is the motorcycle application. 


###Documentation:

####<span style="color: red">BIKERS</span>
<span style="color: yellow">**@GetMapping**</span> <span style="color: green">*/bikers*</span> - allows you to retrieve 
all motorcyclists from the database

<span style="color: yellow">**@GetMapping**</span> <span style="color: green">*/bikers/{id}*</span> - retrieves a 
specific, unique user from the database; if no such user exists, an appropriate 
message will be returned

<span style="color: yellow">**@PostMapping**</span> <span style="color: green">*/bikers*</span> - Allows you to add 
the corresponding motorcyclist to your database
message will be returned

<span style="color: yellow">**@PatchMapping**</span> <span style="color: green">*/bikers/{id}*</span> - Allows to 
"remove" a motorcyclist from the database; the business logic assumes that the user will not be permanently removed 
from the database, but only his ACTIVE status will be changed to false

<span style="color: yellow">**@PatchMapping**</span> <span style="color: green">*/bikers/{bikerId}/bikes/{bikeId}*</span> -
Allows you to assign a specific motorcycle to a specific rider

####<span style="color: red">MOTORCYCLES</span>
<span style="color: yellow">**@GetMapping**</span> <span style="color: green">*/motorcycles*</span> - Downloads all 
motorcycles from the database

<span style="color: yellow">**@GetMapping**</span> <span style="color: green">*/motorcycles/{id}*</span> - Allows you 
to retrieve a specific motorcycle from the database; if the motorcycle is not found, an appropriate message is displayed

<span style="color: yellow">**@PostMapping**</span> <span style="color: green">*/motorcycles*</span> - Allows you to 
add a new motorcycle to the database

<span style="color: yellow">**@DeleteMapping**</span> <span style="color: green">*/motorcycles/{id}*</span> - Allows you to delete a motorcycle from the database; if the motorcycle is not found, an appropriate message is displayed

<span style="color: yellow">**@PatchMapping**</span> <span style="color: green">*/motorcycles/{id}/capacity?<span style="color: blue">capacity=599</span>*</span> - Allows you to edit the motorcycle capacity; if the motorcycle is not found, an appropriate message will be displayed

<span style="color: yellow">**@PatchMapping**</span> <span style="color: green">*/motorcycles/{id}/horse-power?<span style="color: blue">horse-power=155</span>*</span> - Allows you to edit the motorcycle horse power; if the motorcycle is not found, an appropriate message will be displayed

<span style="color: yellow">**@GetMapping**</span> <span style="color: green">*/motorcycles/horse-power?<span style="color: blue">min=100&max=200</span>*</span> - Allows you to download a list of motorcycles by the given motorcycle power parameters; if the list is empty, an appropriate message will be displayed

<span style="color: yellow">**@GetMapping**</span> <span style="color: green">*/motorcycles/brand?<span style="color: blue">brand=ducati</span>*</span> - Allows you to retrieve a list of motorcycles by the specified motorcycle brand parameter; if the list is empty, an appropriate message will be displayed

<span style="color: yellow">**@GetMapping**</span> <span style="color: green">*/motorcycles/model?<span style="color: blue">model=s1000rr</span>*</span> - Allows you to retrieve a list of motorcycles by the specified motorcycle model parameter; if the list is empty, an appropriate message will be displayed

<span style="color: yellow">**@GetMapping**</span> <span style="color: green">*/motorcycles/capacity?<span style="color: blue">min=599&max=1000</span>*</span> - Allows to download the list of motorcycles according to the given parameters of the motorcycle capacity; if the list is empty, an appropriate message will be displayed

####<span style="color: red">CIRCUITS</span>
<span style="color: yellow">**@GetMapping**</span> <span style="color: green">*/circuits*</span> - Allows you to retrieve a list of all tracks from the database

<span style="color: yellow">**@GetMapping**</span> <span style="color: green">*/circuits/{id}*</span> - Allows a specific track from the database; if the track is not found, an appropriate message is displayed

<span style="color: yellow">**@PostMapping**</span> <span style="color: green">*/circuits*</span> - Allows you to add a track to the database

<span style="color: yellow">**@DeleteMapping**</span> <span style="color: green">*/circuits/{id}*</span> - Allows you to remove a track from the database

<span style="color: yellow">**@PatchMapping**</span> <span style="color: green">*/circuits/{id}/*</span> - Allows you to edit the length of a specific track; if this is not found, an appropriate message will be displayed

####<span style="color: red">LAPS</span>
<span style="color: yellow">**@GetMapping**</span> <span style="color: green">*/laps*</span> - Allows you to view all trips from the databases

<span style="color: yellow">**@PostMapping**</span> <span style="color: green">*/laps/bikers/{bikerId}/circuits/{circuitId}*</span> - Allows you to add the ride of a specific motorcyclist on a specific track to the database; if the motorcyclist or track is not found, an appropriate message will be displayed

<span style="color: yellow">**@GetMapping**</span> <span style="color: green">*/laps/bikers/{bikerId}*</span> - Allows you to view a list of all rides of a specific motorcyclist; if a motorcyclist is not found, a corresponding message will be displayed

<span style="color: yellow">**@GetMapping**</span> <span style="color: green">*/laps/circuits/{circuitId}*</span> - Lists all rides on a particular track; if the track is not found, an appropriate message is displayed




