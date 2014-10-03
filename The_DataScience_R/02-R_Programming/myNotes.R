#####################################################
#####################################################
#################### WEEK 01 ########################
#####################################################
#####################################################

SEE: https://github.com/edj-boston/coursera-r-programming/blob/master/week-02/quiz.md

##set working directory
##setwd("~/Coursera/The_DataScience_R")



#####################################################
## >> from swirl
#####################################################
## vector of numbers ranging from 0 to 10, incremented by 0.5
seq(0, 10, by=0.5)

## sequence of 30 numbers between 5 and 10
seq(5, 10, length=30)

## creating a vector that contains 40 zeros, we can use 
rep(0, times = 40)

## generate a sequence of integers from 1 to N, where N represents the length of the my_seq vector
1:length(my_seq)
seq(along = my_seq)
seq_along(my_seq)

## vector to contain 10 repetitions of the vector (0, 1, 2), we can do 
rep(c(0, 1, 2), times=10)

## vector to contain 10 zeros, then 10 ones, then 10 twos. We can do this with the `each` argument
rep(c(0, 1, 2), each = 10)        


## Vectors come in two different flavors: atomic vectors and lists. 
## An atomic vector contains exactly one data type, whereas a list may contain multiple data types.
## - Types of atomic vectors include: logical, character, integer, and complex.
## -- Logical vectors can contain the values TRUE, FALSE, and NA (for 'not available')
## --- If we have two logical expressions, A and B, we can ask:
## --- whether at least one is TRUE with A | B (logical 'or' a.k.a. 'union') 
## --- or whether they are both TRUE with A & B (logical 'and' a.k.a. 'intersection'). 
## --- Lastly, !A is the negation of A and is TRUE when A is FALSE and vice versa.
## -- Double quotes are used to distinguish character objects
## --- 

## concatenating chars
my_char <- c("My", "name", "is")
paste(my_char, collapse = " ") #join the words
my_name <- c(my_char, "Hernani")

## LETTERS is a predefined variable in R containing a character vector of all 26 letters in the English alphabet

# R accepts negative integer indexes. 
# Whereas x[c(2, 10)] gives us ONLY the 2nd and 10th elements of x, 
# x[c(-2, -10)] gives us all elements of x EXCEPT for 
# the 2nd and 10 elements.
# x[-c(2, 10)]  - gets the exact same result

vect <- c(foo = 11, bar = 2, norf = NA)
# subsetting a vector by named elements
vect["bar"]
vect[c("foo", "bar")]

# vectors doen't have dimention
my_vector <- 1:20
dim(my_vector) 			# NULL
length(my_vector) 		# 20
# The dim() function allows you to get OR set the `dim` attribute for an R object
dim(my_vector) <- c(4, 5) 	# NOW we have a matrix 4 by 5
class(my_vector)			# [1] "matrix"
dim(my_vector) 				# [1] 4 5

# confirm that my_matrix and my_matrix2 are actually identical
identical(my_matrix, my_matrix2)

# implicit coersion - if we have a matrix with number and we add
patients <- c("Bill", "Gina", "Kelly", "Sean")  # a vector of Strings
cbind(patients, my_matrix)						# with cbind (or rbind)
# the result will be a string matrix
# to avoid that, lets create a data frame
my_data <- data.frame(patients, my_matrix) 
class(my_data)		# [1] "data.frame"

# now lets give names to the columns
cnames <- c("patient", "age", "weight", "bp", "rating", "test")
colnames(my_data) <- cnames

#####################################################
## >> from data types (part 1) - R Programming course
#####################################################
R has 5 atomic classes objects
character
numeric (real numbers)
integer
complex
logical

1 - numerical
1L - integer

Inf = 1/0
0 = 1/Inf
NaN = 0/0

Vector() - have only one type of object
List() - different objects

#####################################################
## >> from data types (part 2) - R Programming course
#####################################################
x <- c(0.5, 0.6)    	## numeric
print(x)
x <- c(TRUE, FALSE) 	## logical
print(x)
x <- c(T, F)        	##logical
print(x)
x <- c("a", "b", "c") 	##character
print(x)
x <- 9:13           	##integer
print(x)
x <- c(1+0i, 2+4i)  	##complex
print(x)
x <- c("numeric", length=10) 	##initiate vector
print(x)

## coercion
y <- c(1.7, "a") 	##character ("1.7", "a")
y <- c(TRUE, 2) 	##numeric (1,2)
y <- c("a", TRUE) 	##character ("a", "TRUE")

##explicitly coerced from one class to another using the as.* functions
x <- 0:6
class(x)
## [1] "integer"
as.numeric(x)
## [1] 0 1 2 3 4 5 6
as.logical(x)
## [1] FALSE  TRUE  TRUE  TRUE  TRUE  TRUE  TRUE
as.character(x)
## [1] "0" "1" "2" "3" "4" "5" "6"


## Matrices are vectors with a dimension attribute. The dimension attribute is itself an integer vector of length 2 (nrow, ncol)

m <- matrix(nrow = 2, ncol = 3) 
m
##     [,1] [,2] [,3]
##[1,]   NA   NA   NA
##[2,]   NA   NA   NA
dim(m)
##[1] 2 3
attributes(m)
## $dim
## [1] 2 3
##Matrices are constructed column-wise
m <- matrix(1:6, nrow = 2, ncol = 3) 
## Matrices can also be created directly from vectors by adding a dimension attribute.
m <- 1:10 
m
## [1] 1 2 3 4 5 6 7 8 9 10 
dim(m) <- c(2, 5) #transforms the vetor to a matrix 2 by 5
m

## cbind-ing and rbind-ing
## Matrices can be created by column-binding or row-binding with cbind() and rbind(), respectively.
x <- 1:3
y <- 10:12
cbind(x, y)
##  x  y 
## [1,] 1 10 
## [2,] 2 11 
## [3,] 3 12
rbind(x, y) 
## [,1] [,2] [,3]
## x    1    2    3
## y   10   11   12


## Lists
## Lists are a special type of vector that can contain elements of different classes.
x <- list(1, "a", TRUE, 1 + 4i) 
x


#####################################################
## >> from data types (part 3) - R Programming course
#####################################################
## Factors
## factors are used to represent categorical data - like a hasmap in java
## factors are treated specially by modelling functions like ln() and glm()
x <- factor(c("yes", "yes", "no", "yes", "no"))
x
unclass(x) # 2 2 1 2 1 - integer vector
attr(, "levels") # no yes
## the order of the levels can be set using the levels argument to factor(). 
## this can be important in linear modelling because the first level is used as the baseline level.
## by default uses the alphabetic order, so "no" cames first than "yes"
x <- factor(c("yes", "yes", "no", "yes", "no"), levels=c("yes", "no"))


## Missing Values
is.na() 	# is used to test objects if they are Na
is.nan() 	# is used to test for NaN
## NA values have a class also, so there are integer Na, character NA, etc.
## A NaN value is also NA but the converse is not true

## Data Frames
## to store tabular data
## can store classes of objects in each column (1st column can be integer, 2nd booleans, etc.)
## have a special attibute called row.names
## usually created by calling read.table() or read.csv()
## can be converted to a matrix by calling data.matrix()

## example
x <- data.frame(foo=1:4, bar=c(T,T,F,F))
x
#  foo   bar
#1   1  TRUE
#2   2  TRUE
#3   3 FALSE
#4   4 FALSE
nrow(x)
ncol(x)

## giving Names to objects
x <- 1:3
names(x)
names(x) <- c("a", "b", "c")
x
names(x)

## Lists can also have names
x <- list(a=1, b=2, c=3)
x

## Matriz can also have names
m <- matrix(1:4, nrow=2, ncol=2)
dimnames(m) <- list( c("a", "b"), c("c", "d") )
#  c d
#a 1 3
#b 2 4

# Summary
#atomic classes: numeric, logical, character, integer, complex
#vector - only element with the same class
#lists - elements from different classes
#factors - categorical data, ordered or unordered
#data frames - used to store tabular data, each column can be from different class


#####################################################
## >> from subsetting (part 1) - R Programming course
#####################################################
## [ - always returns an object of the same class as the original
## [[ - is used to extract elements of a list or a data frame
## $ - is used to extract elements of a list or data frame by name, semantics are similar to hat of [[

x <- c("a", "b", "c", "c", "d", "a")
x[1] 		# "a" - is another character vector with a single element within "a"
x[2] 		# "b"
x[1:4] 		# a b c c

x[x > "a"]	# example of a logical index access 
u <- x>"a"
u 			# False True True True True False

x <- matrix(1:6, 2, 3)
x[1,2]		# 3
x[2,1]		# 2
x[1,] 		# first row
x[,2] 		# second colomn

x <- matrix(1:6, 2, 3)
x[1,2] 		# 3

## to preserve the dimention of the object (por default drop=TRUE)
x[1,2, drop=FALSE] 	# return a matrix [1, 1] with the element 3 in it
x[1, ]				# returns the vector 1 3 5
x[1, , drop=FALSE]	# returns a matriz [1,3] with the elements 1 3 5


#####################################################
## >> from subsetting (part 2) - R Programming course
#####################################################
## subsetting Lists
x <- list(foo = 1:4, bar = 0.6)
x[1]		# or x["foo"]		>$foo \\ [1] 1 2 3 4
x[[1]]		# or x[["foo"]]		>[1] 1 2 3 4


x[["bar"]]	# >[1] 0.6
x$bar 		# >the same as x[["bar"]]
x["bar"]	# >$bar \\ [1] 0.6


################################
## extract multiple elements from a list

x <- list(foo=1:4, bar=0.6, baz="hello")
x[c(1,3)]		# returns the 1st and 3rd element:  >$foo \\ [1] 1 2 3 4 \\ $baz \\ [1] "hello"

name <- "foo"
x[[name]] 		# computed index for 'foo': >[1] 1 2 3 4
x$name 			# element 'name' does not exist, R looks for the element 'name' 
x$foo 			# element 'foo' exists: >[1] 1 2 3 4

x <- list(a = list(10, 12, 14), b = c(3.14, 2.81))
x[[c(1,3)]] 	# accessing the 3rd element in the first position of the list: >[1] 14
x[[1]][[3]] 	# does the same: >[1] 14
x[[c(2,1)]] 	# >[1] 3.14

################################
## partical matching

x <- list(aardvark = 1:5)
x$a 						# > [1] 1 2 3 4 5 
x[["a"]] 					# NULL, doesn't do partial matching
x[["a", exact=FALSE]] 		# to enable partial matching: > [1] 1 2 3 4 5 

################################
## removing missing values from a vector

x <- c(1,2,NA,4,NA,5)
bad <- is.na(x) 			# logical vector with TRUES and FALSES
#>[1] FALSE FALSE  TRUE FALSE  TRUE FALSE
x[!bad] 					# > [1] 1 2 4 5

################################
## removing NA values from multiple vectors

x <-c(	1,	2,		NA,		4,		NA,		5)
y <-c("a", 	"b", 	NA, 	"d", 	NA, 	NA)
good <-complete.cases(x,y)
good			# >[1]  TRUE  TRUE FALSE  TRUE FALSE FALSE
x[good]			# >[1] 1 2 4
y[good]			# >[1] "a" "b" "d"

################################
## removing NA values from big data, see min. 9:40
## i.e. removing rows with missing values:
airquality[1:6, ] 					# showing the first 6 rows from some dataset
good <-complete.cases(airquality)	# logical vector that tell us which rows are complete
airquality[good, ][1:6, ]			# shows the first 6 rows that are complete (i.e. without missing values) 
 


#####################################################
## >> from reading and writting data (part 1) - R Programming course
#####################################################
setwd("~/Coursera/The_DataScience_R")	# sets the root to our workspace
data <- read.table("test.txt") 			# default separator is the space, for read.csv is the comma
data

# specify what kind of data each column has - see slide 7

# Calculating Memory requirements:
# dataset with 1,500,000 rows and 120 columns
> 1,500,000 * 120 * 8 bytes (if numeric)
> 1440000000 bytes / 220 bytes/MB = 1,373.29MB = 1.34 GB
> R will require twice the memory, i.e. 2.7GB

# dput and dget writes and gets R object to and from a file
# dump and source writes and gets multple objectes to and from a file

con <- url ("https://class.coursera.org/rprog-005/lecture", "r")
x <- readLines(con, 10)










#####################################################
#####################################################
#################### WEEK 04 ########################
#####################################################
#####################################################
# lapply() always returns a list, regardless of the class of the input.
x < list(a = 1:5, b = rnorm(10))
lapply(x, mean)
# $a
# [1] 3
# 
# $b
# [1] 0.0296824

#For sums and means of matrix dimensions, we have some shortcuts.
rowSums = apply(x, 1, sum)
rowMeans = apply(x, 1, mean)
colMeans = apply(x, 2, sum)
colMeans = apply(x, 2, mean)


