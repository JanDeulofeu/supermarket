## To execute this supermarket shopping list is needed: ##

* Create different offers types (Price, Weight) related to a certain Article.
* Add Articles to the shopping list
* Calculate subtotal of shopping list value
* Calculate discounts for this shopping list
* Calculate final bill (with discounts applied) 


### The architecture is based on: ###

####1-Model
* Article: Define value and the type (weight, price)
* Offer: Type of offer (unit, price) associated for a given Article (Linked by Article name)

####2-Repository
* Article and Offer repositories to maintain in memory which articles and offers have been introduced

####3-Calculator
* Services to calculate differt aspect of a bill (discounts, total bill)

####4-Service
* Main interface to interact with the shopping bag 
