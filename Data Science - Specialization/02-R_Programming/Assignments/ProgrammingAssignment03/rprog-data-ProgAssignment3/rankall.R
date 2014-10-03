rankall <- function(outcome, num = "best") {
        ## Validating the outcome string
        outcomes = c("heart attack", "heart failure", "pneumonia")
        if( outcome %in% outcomes == FALSE ) {
                stop("invalid outcome")
        }
        
        ## Reading outcome data
        data <- read.csv("outcome-of-care-measures.csv", colClasses = "character")
        data <- data[c(2, 7, 11, 17, 23)]
        names(data)[1] <- "name"
        names(data)[2] <- "state"
        names(data)[3] <- "heart attack"
        names(data)[4] <- "heart failure"
        names(data)[5] <- "pneumonia"
        
        
        ## Validating the num value given as input
        if( num != "best" && num != "worst" && num%%1 != 0){
                stop("invalid num")
        }      
         
        ## Grab only rows with data in our outcome
        data <- data[data[outcome] != 'Not Available', ]
        
        
        ## Ordering the data
        data[outcome] <- as.data.frame(sapply(data[outcome], as.numeric))
        data <- data[order(data$name, decreasing = FALSE), ]
        data <- data[order(data[outcome], decreasing = FALSE), ]
        
        
        ## auxiliar function
        hospitalsByRank <- function(dat, estado, n) {
                dat <- dat[dat$state==estado, ]
                vals <- dat[, outcome]
                if( n == "best" ) {
                        rowNum <- which.min(vals)
                } else if( n == "worst" ) {
                        rowNum <- which.max(vals)
                } else {
                        rowNum <- n
                }
                dat[rowNum, ]$name
        }


        
        ## For each state, we need to find the hospital ranking number
        states <- data[, 2]
        states <- unique(states)
        newdata <- data.frame("hospital"=character(), "state"=character())
        for(st in states) {
                hosp <- hospitalsByRank(data, st, num)
                newdata <- rbind(newdata, data.frame(hospital=hosp, state=st))
        }
        
        
        ## Returning a data frame with the hospital names and the (abbreviated) state name
        newdata <- newdata[order(newdata['state'], decreasing = FALSE), ]
        newdata
}