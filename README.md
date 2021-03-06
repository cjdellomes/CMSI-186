##CMSI 186

============

This is a collection of code made for LMU's Computer Programming Lab class with Dr. Philip Dorin. 

##CountTheDays

Used for finding the number of days between two specified dates. Dates should be entered as month, day, year.
Example input: `java CountTheDays 7 4 1776 12 25 1955`.
Returns number of days between July 4, 1776 and December 25, 1955.

##PiSolver

Simulates throwing 1000 darts at a unit circle inside a unit square to estimate the value of pi.

##BirthdaySolver

Simulates a million trials to determines the probability that at least 2 people will share a birthday among an input number of people.

##RandomIntegrator

Uses Monte Carlo (Randomized) Integration to find an estimate of the definite integral of an equation. Can be used for polynomial, sine, cosine, tangent, natural log, and base 10 log functions. Input should be lower bound, upper bound, function type, values.
Example input: `java RandomIntegrator -1.3 5 poly 1 -2.1 3.2`.
Returns definite integral for the polynomial 1-2.1x+3.2x^2 from x=-1.3 to x=5.

##RiemannIntegrator

Uses Riemann Sum Integration to find the definite integral of an equation. Can be used for polynomial, sine, cosine, tangent, natural log, and base 10 log functions. Input should be lower bound, upper bound, function type, values.
Example input: `java RiemannIntegrator -1.3 5 sin`.
Returns definite integral for the function sin(x) from x=-1.3 to x=5.

##MapSolver

Simulates an specified multiregional map and uses up to 4 colors to color the entire map such that no two regions of the same color border each other.
Example input: `java MapSolver 0 1 0 2 0 3 0 4`.
Returns color scheme for 5 region map where region 0 borders 4 other regions that do not border each other.
