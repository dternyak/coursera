best <- function(state, outcome) {
        
        ## Validate the outcome string
        outcomes = c("heart attack", "heart failure", "pneumonia")
        if(outcome %in% outcomes == FALSE) {
                stop("invalid outcome")
        }
        
        ## Read outcome data
        
        data <- read.csv("outcome-of-care-measures.csv", colClasses = "character")
        
        ## Filter and simplify the column names
        ## 2. Hospital Name: varchar (50) Lists the name of the hospital.
        ## 7. State: varchar (2) Lists the 2 letter State code in which the hospital is located.
        ## 11. Hospital 30-Day Death (Mortality) Rates from Heart Attack: Lists the risk adjusted rate (percentage) for each hospital.
        ## 17. Hospital 30-Day Death (Mortality) Rates from Heart Failure: Lists the risk adjusted rate (percentage) for each hospital.
        ## 23. Hospital 30-Day Death (Mortality) Rates from Pneumonia: Lists the risk adjusted rate (percentage) for each hospital.
        data <- data[c(2, 7, 11, 17, 23)]
        names(data)[1] <- "name"
        names(data)[2] <- "state"
        names(data)[3] <- "heart attack"
        names(data)[4] <- "heart failure"
        names(data)[5] <- "pneumonia"
        
        ## Validating the state name given in the input
        states <- data[, 2]
        states <- unique(states)
        if(state %in% states == FALSE ) {
                stop("invalid state")
        }
        
        ## Grab only rows with our state value        
        data <- data[data$state==state & data[outcome] != 'Not Available',  ]
        vals <- data[, outcome]
        rowNum <- which.min(vals)
        ## Return hospital name in that state with lowest 30-day death rate
        data[rowNum, ]$name
        
}