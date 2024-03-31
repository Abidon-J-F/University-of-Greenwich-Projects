#3)
#Part 1 - Comparing means
#if(!require(devtools)) install.packages("devtools")
#devtools::install_github("kassambara/ggpubr")

# then load
library(magrittr)
library(tidyselect)
library(lifecycle)
library(ggplot2)
library(ggpubr)

#import the data
set.seed(1234)
CM_data <- data.frame(
  name = paste0(rep("M_", 10), 1:10),
  weight = round(rnorm(10, 20, 2), 1)
) 

# Print the first 10 rows of the data
head(CM_data, 10) 

# Statistical summaries of weight
summary(CM_data$weight)

#Visualize your data using box plots
library(ggpubr)
ggboxplot(CM_data$weight, 
          ylab = "Weight (g)", xlab = FALSE,
          ggtheme = theme_minimal())

#Shapiro-Wilk test
shapiro.test(CM_data$weight)

#confirm by a visual inspection
library("ggpubr")
ggqqplot(CM_data$weight, ylab = "Men's weight",
         ggtheme = theme_minimal())

#Compute one-sample t-test
# One-sample t-test
res <- t.test(CM_data$weight, mu = 25)
# Printing the results
res 

# t = t-test statistic value
res$statistic

#df = degrees of freedom
res$parameter

# printing the p-value
res$p.value

# printing the mean (sample estimate)
res$estimate

# printing the confidence interval
res$conf.int


#Part 2

# Weight of the mice before treatment
before <-c(200.1, 190.9, 192.7, 213, 241.4, 196.9, 172.2, 185.5, 205.2, 193.7)
# Weight of the mice after treatment
after <-c(392.9, 393.2, 345.1, 393, 434, 427.9, 422, 383.9, 392.3, 352.2)
# Create a data frame
PST_data <- data.frame(
  group = rep(c("before", "after"), each = 10),
  weight = c(before, after)
)

# Print all data
print(PST_data)

#Install boxplot package
#install.packages("ggpubr")

#Visualize your data:
library("ggpubr")
ggboxplot(PST_data, x = "group", y = "weight",
          color = "group", palette = c("#00AFBB", "#E7B800"),
          order = c("before", "after"),
          ylab = "Weight", xlab = "Groups")

#install pairedData package
#install.packages("PairedData")

#Plot paired data
#Subset weight data before treatment
before <- subset(PST_data, group == "before", weight,
                 drop = TRUE)
# subset weight data after treatment
after <- subset(PST_data, group == "after", weight,
                drop = TRUE)
# Plot paired data
library(PairedData)
pd <- paired(before, after)
plot(pd, type = "profile") + theme_bw()

# compute the difference
d <- with(PST_data,
          weight[group == "before"] - weight[group == "after"])
# Shapiro-Wilk normality test for the differences
shapiro.test(d) # => p-value = 0.6141

# Compute t-test1
res1 <- t.test(before, after, paired = TRUE)
res1
#computer t-test2
res2 <- t.test(weight ~ group, data = PST_data, paired = TRUE)
res2

