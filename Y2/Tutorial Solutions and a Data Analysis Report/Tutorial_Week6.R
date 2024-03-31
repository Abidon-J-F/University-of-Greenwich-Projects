#Q4 Data plotting with ggplot2
#import the data
school_csv<-read.csv("C:Users/..../R/Week 6/school.csv")

print(school_csv)

#Standard Checks
head(school_csv, 10) 
summary(school_csv)

#if(!require(devtools)) install.packages("devtools")
#devtools::install_github("kassambara/ggpubr")

# then load
library(magrittr)
library(tidyselect)
library(lifecycle)
library(ggplot2)
library(ggpubr)

#Visualize your data using box plots
library(ggplot2)
plot<-ggplot(school_csv, aes(x=prog, y=read)) +
  geom_boxplot() + labs(title = "Plot of read per prog") +
  theme_minimal()

plot

#print(plot)
#Add geom_jitter
plot+geom_jitter(width = 0.1, height = 0.5)

#school type boxplot
library(ggplot2)
schooltype<-ggplot(school_csv, aes(x=prog, y=read, fill = schtyp)) +
  geom_boxplot() +
  theme_minimal()

#print(schooltype)
#Add geom_jitter
new_plot<-schooltype+geom_jitter(width = 0.1, height = 0.5)
new_plot

#change of title, font style, panel background and removing grids
new_style<-new_plot + labs(title = "Read by programme from public and private schools") +
  theme(plot.title = element_text(family = "serif", face = "bold.italic", colour = "black", size = "11"),
panel.background = element_rect(fill = "grey", colour = "grey", size = 0.5, linetype = "solid"),
panel.grid.major = element_blank(),
panel.grid.minor = element_blank())
                
new_style

