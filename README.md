
# Start IO
## Listing service


## API
* GET /listings
* Request Param :
  * double min_pric 
  * double max_price 
  * double min_min_cpm
  * double max_min_cpm=2
* Example : GET /listings?min_price=0.0081&max_price=0.15&min_min_cpm=1&max_min_cpm=2


## Run it locally ( Intelij)
* Run the *jar - everything it needs include internally
* make a call from Postman : 
* URL : http://localhost:8080/start/io/listings?min_price=0.0081&max_price=0.15&min_min_cpm=1&max_min_cpm=2
* Header : Content-Type application/json

## Run it via Docker
* docker build -t start-io-listings
* docker run -p 8080:8080 start-io-listings


## What would i improve?

1. testing - add unit test integration test ci test 
2. change datastore 
3. optimizations - work with DB , use Redis , use clusters ,
4. deployment - create a full CI & CD , add our micro service to docker.


```
