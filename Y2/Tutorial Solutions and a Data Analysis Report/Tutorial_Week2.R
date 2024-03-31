#1) Importing/exporting data in R

#Q1. Import the dataset from Internet and named it as dat_csv. Dataset:
dat_csv<-read.csv("https://stats.idre.ucla.edu/stat/data/hsbraw.csv")


#Q2.1
#200 Observations and 13 Variables
View(dat_csv)

#First 3 rows and last 3 rows
head(dat_csv, n = 3)
tail(dat_csv, n = 3)

#Q2.2
#Data Structure
#Data Structure =  data frame
class(dat_csv)

#Factoring the data
#Is each of the function a factor value
print(is.factor(dat_csv))
print(is.factor(dat_csv$id))
print(is.factor(dat_csv$female))
print(is.factor(dat_csv$ses))
print(is.factor(dat_csv$schtyp))
print(is.factor(dat_csv$prog))
print(is.factor(dat_csv$read))
print(is.factor(dat_csv$write))
print(is.factor(dat_csv$math))
print(is.factor(dat_csv$science))
print(is.factor(dat_csv$socst))
print(is.factor(dat_csv$honors))
print(is.factor(dat_csv$awards))
print(is.factor(dat_csv$cid))


#Q3
#Extract 3rd, 10th and 30th rows of variables in science using $ operator
dat_csv$science[3]
dat_csv$science[10]
dat_csv$science[30]


#Q4
#Find the right function to view the summary information of dat_csv.
summary(dat_csv)

#How many females? And how many males?
#How many public schools?
summary(dat_csv$female)
summary(dat_csv$schtyp)

#What are the min/max/median of variable math?
summary(dat_csv$math)
min(dat_csv$math)
max(dat_csv$math)
median(dat_csv$math)


#Q5.1
#Create a new data set called test that is all rows of the 3 column variables math, read, and write 
#from dat_csv. 
test = data.frame(dat_csv$math, dat_csv$read, dat_csv$write)
print("New data frame with three columns extracted from dat_csv: ")
print(test)

#Q5.2
#Add a new variable to the dataset test and name the new variable as test_mean which is the mean 
#of the variables math, read, and write.
View(test)
test$test_mean = rowMeans(test)
print(test)
colMeans(test)
mean(test$dat_csv.math, test$dat_csv.read, test$dat_csv.write, trim = 0, na.rm = FALSE)

