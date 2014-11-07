## R was developed by statisticians working at
The University of Auckland
The R language was developed by Ross Ihaka and Robert Gentleman who were statisticians at the University of Auckland in New Zealand.
## The definition of free software consists of four freedoms (freedoms 0 through 3). Which of the following is NOT one of the freedoms that are part of the definition?
The freedom to restrict access to the source code for the software.

##In R the following are all atomic data types EXCEPT
list

## If I execute the expression x <- 4 in R, what is the class of the object `x' as determined by the `class()' function?
numeric

## hat is the class of the object defined by x <- c(4, TRUE)?
x <- c(4, TRUE)
numeric

## If I have two vectors x <- c(1,3, 5) and y <- c(3, 2, 10), what is produced by the expression rbind(x, y)?
x <- c(1,3, 5)
y <- c(3, 2, 10) 
rbind(x, y)
a matrix with two rows and three columns

## A key property of vectors in R is that
elements of a vector all must be of the same class

## Suppose I have a list defined as x <- list(2, "a", "b", TRUE). What does x[[2]] give me?
a character vector containing the letter "a".

## Suppose I have a vector x <- 1:4 and a vector y <- 2. What is produced by the expression x + y?
a numeric vector with elements 3, 4, 5, 6.

## Suppose I have a vector x <- c(17, 14, 4, 5, 13, 12, 10) and I want to set all elements of this vector that are greater than 10 to be equal to 4. What R code achieves this?
x[x >= 11] <- 4

## In the dataset provided for this Quiz, what are the column names of the dataset?
Ozone, Solar.R, Wind, Temp, Month, Day

## Extract the first 2 rows of the data frame and print them to the console. What does the output look like?
setwd("~/Coursera/The_DataScience_R")
data <- read.csv("hw1_data.csv")
data[1:2, ]
backup <- data

Ozone Solar.R Wind Temp Month Day
1    41     190  7.4   67     5   1
2    36     118  8.0   72     5   2

## How many observations (i.e. rows) are in this data frame?
nrow(data)
[1] 153

## Extract the last 2 rows of the data frame and print them to the console. What does the output look like?
data[152:153, ]
tail(data,2) # The 'tail()' function is an easy way to extract the last few elements of an R object.
Ozone Solar.R Wind Temp Month Day
152    18     131  8.0   76     9  29
153    20     223 11.5   68     9  30

## What is the value of Ozone in the 47th row?
data[47, "Ozone"]
[1] 21

## How many missing values are in the Ozone column of this data frame?
sum(is.na(data[,"Ozone"]))
[1] 37

## What is the mean of the Ozone column in this dataset? 
##Exclude missing values (coded as NA) from this calculation.
mean(data$Ozone, na.rm=TRUE)
[1] 42.12931

sub = subset(data, !is.na(Ozone), select = Ozone)
apply(sub, 2, mean)
[1] 42.12931

## Extract the subset of rows of the data frame where 
## Ozone values are above 31 and Temp values are above 90. 
## What is the mean of Solar.R in this subset?
subboolean <- data[data[, "Ozone"] > 31 & data[, "Temp"] > 90, ]
mean(subboolean$Solar.R, na.rm=TRUE)
[1] 212.8

sub = subset(data, Ozone > 31 & Temp > 90, select = Solar.R)
apply(sub, 2, mean)
[1] 212.8

## What is the mean of "Temp" when "Month" is equal to 6?
x <- data[data[, "Month"] == 6,]
mean(x$Temp)
[1] 79.1

sub = subset(data, Month ==6, select = Temp)
apply(sub, 2, mean)
[1] 79.1

## What was the maximum ozone value in the month of May (i.e. Month = 5)?
x <- data[ data[, "Month"] == 5, ]
max(x$Ozone, na.rm=TRUE)
[1] 115

sub = subset(data, !is.na(Ozone) & Month == 5, select = Ozone)
apply(sub, 2, max)
[1] 115