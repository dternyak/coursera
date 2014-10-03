add2 <- function(x,y){
        x+y
}

above10 <- function(x){
        use <- x > 10 # logical vector with the numbers greatter than then
        x[use]
}

above <- function(x, n=10){
        use <- x > n
        x[use]
}

columnsmean <- function(y, removeNA = TRUE){
        nc <- ncol(y)
        #print(nc)
        means <- numeric(nc)
        for (i in 1:nc){
                means[i] <- mean(y[,i], na.rm = removeNA)
        }
        means
}

cube <- function(x, n) {
        x^3
}

f <- function(x) {
        g <- function(y) {
                y + z
        }
        z <- 4
        x + g(x)
        
}


h <- function(x, y = NULL, d = 3L) {
        z <- cbind(x, d)
        if(!is.null(y))
                z <- z + y
        else
                z <- z + f
        g <- x + y / z
        if(d == 3L)
                return(g)
        g <- g + 10
        g
}

myMat <- function(matrixx){
        rowSums 
        rowMeans 
        colMeans 
        colMeans 
        
        colSum <- apply(matrixx, 1, sum)
        rowMean <- apply(matrixx, 2, mean)
        #convem converter para data frame
        matrixx <- cbind(matrixx, colSum)
        matrixx <- rbind(matrixx, rowMean)
        matrixx
}




# factor vector with all the especies
species <- iris$Species

# dataset divided by species
s <- split(iris, species)

# subset to get specie virginica, column Sepal.Length 
sub = subset(s$virginica, select = Sepal.Length)

# now I can get the mean of Sepal.Length 
apply(sub, 2, mean)

Sepal.Length 
apply(iris[, 1:4], 2, mean)


> library(datasets)
> data(mtcars)
> ?mtcars
> tapply(mtcars$mpg, mtcars$cyl, mean)


printmessage <- function(x) {
           if(x > 0)
                       print("x is greater than zero")
          else
                       print("x is less than or equal to zero")
           invisible(x)
         }


#The first function, makeVector creates a special "vector", which is really a list containing a function to
#set the value of the vector
#get the value of the vector
#set the value of the mean
#get the value of the mean
makeVector <- function(x = numeric()) {
        m <- NULL
        set <- function(y) {
                x <<- y
                m <<- NULL
        }
        get <- function() x
        setmean <- function(mean) m <<- mean
        getmean <- function() m
        list(set = set, get = get,
             setmean = setmean,
             getmean = getmean)
}


#The following function calculates the mean of the special "vector" created with the above function. 
#However, it first checks to see if the mean has already been calculated. 
#If so, it gets the mean from the cache and skips the computation. 
#Otherwise, it calculates the mean of the data and sets the value of the mean in the cache via the setmean function.
cachemean <- function(x, ...) {
        m <- x$getmean()
        if(!is.null(m)) {
                message("getting cached data")
                return(m)
        }
        data <- x$get()
        m <- mean(data, ...)
        x$setmean(m)
        m
}