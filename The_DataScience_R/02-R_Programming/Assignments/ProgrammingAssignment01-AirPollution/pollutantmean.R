#source("pollutantmean.R")
#pollutantmean("specdata", "sulfate", 1:10)
## [1] 4.064
#pollutantmean("specdata", "nitrate", 70:72)
## [1] 1.706
#pollutantmean("specdata", "nitrate", 23)
## [1] 1.281


## 'directory' is a character vector of length 1 indicating
## the location of the CSV files

## 'pollutant' is a character vector of length 1 indicating
## the name of the pollutant for which we will calculate the
## mean; either "sulfate" or "nitrate".

## 'id' is an integer vector indicating the monitor ID numbers
## to be used

## Return the mean of the pollutant across all monitors list
## in the 'id' vector (ignoring NA values)
pollutantmean <- function(directory, pollutant, id = 1:332) {
        
        ## Getting a list of filenames
        filenames <- list.files(path=directory, pattern="*.csv")
        
        ## Initialising a vector to store values
        vals <- vector()
        
        ## Loopping over the passed id's
        for(i in id) { 
                ## Pad the i to create a filename
                filename <- sprintf("%03d.csv", i)
                filepath <- paste(directory, filename, sep="/")
                
                ## Load the data from a specific file
                data <- read.csv(filepath)
                
                ## Select our column
                col <- data[,pollutant]
                
                ## Ignore NAs
                col <- col[!is.na(col)]
                
                ## append to our vector
                vals <- c(vals, col)
        }
        
        ## Return the value rounded to 3 dec places
        round(mean(vals), 3)
}