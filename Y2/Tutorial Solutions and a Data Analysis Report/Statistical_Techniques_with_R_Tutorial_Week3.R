#2) Quantitatively describing, summarising and plotting data in R environment

iris_data<- iris
head(iris_data, 9)
View(iris_data)

#mean
mean(iris_data$Sepal.Length)

#standard deviation
sd(iris_data$Sepal.Length)

#variance
var(iris_data$Sepal.Length)

#minimum
min(iris_data$Sepal.Length)

#maximum
max(iris_data$Sepal.Length)

#median
median(iris_data$Sepal.Length)

#range
range(iris_data$Sepal.Length)

#Sample quantiles
quantile(iris_data$Sepal.Length)

#Generic function 
summary(iris_data$Sepal.Length) 

#Interquartile range
IQR(iris_data$Sepal.Length)


#Compute an overall summary of a variable and an entire data frame
summary(iris_data, digits = 1)

summary(data.frame(iris_data))
sapply(iris_data[, -5], data.frame)

sapply(iris_data[, -5], mean)
sapply(iris_data[, -5], sd)
sapply(iris_data[, -5], var)
sapply(iris_data[, -5], min)
sapply(iris_data[, -5], max)
sapply(iris_data[, -5], median)
sapply(iris_data[, -5], range)
sapply(iris_data[, -5], quantile)
sapply(iris_data[, -5], summary)
sapply(iris_data[, -5], IQR)

#Present visualisations for your results using the appropriate package. Your
#descriptive statistics should entail box-plots, histograms, empirical cumulative
#density functions and QQ plots.

#if(!require(devtools)) 
#install.packages("devtools")
#devtools::install_github("kassambara/ggpubr")

#install.packages("tidyselect")
#install.packages("ggpubr")

# then load
library(magrittr)
library(tidyselect)
library(lifecycle)
library(ggplot2)
library(ggpubr)

#box-plots
ggboxplot(iris_data, y = "Sepal.Length", width = 0.5)

#histograms
gghistogram(iris_data, x = "Sepal.Length", bins = 9, 
            add = "mean")

#empirical cumalative density functions
ggecdf(iris_data, x = "Sepal.Length")

#QQ plots
ggqqplot(iris_data, x = "Sepal.Length")

