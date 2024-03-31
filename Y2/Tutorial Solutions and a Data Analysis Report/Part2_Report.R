#Imported data
#install.packages("HSAUR")
data("water", package = "HSAUR")

#Checking the data
head(water, 6) 
summary(water)

#loading required library
library(magrittr)
library(tidyselect)
library(lifecycle)
library(ggplot2)
library(ggpubr)
library(fitdistrplus)

#Q1: Do either or both variables (mortality and hardness) differ between north and south cities?
#Summary of the water data
summary(water)

#North and South Filtered Values
south_values<-data.frame("mortality"=water$mortality[water$location=="South"],"hardness"=water$hardness[water$location=="South"])
south_values
north_values<-data.frame("mortality"=water$mortality[water$location=="North"],"hardness"=water$hardness[water$location=="North"])
north_values

#BoxPlot for comparison in the report
ggplot(water, aes(x=location, y=hardness, fill = location)) +
  geom_boxplot() +
  geom_jitter(width = 0.1, height = 0.5)+
  labs(title = "Difference between North and South location in terms of Water Hardness", x = "Location", y = "Hardness")+
  theme_minimal()

ggplot(water, aes(x=location, y=mortality, fill = location)) +
  geom_boxplot() +
  geom_jitter(width = 0.1, height = 0.5)+
  labs(title = "Difference between North and South location in terms of Human Mortality", x = "Location", y = "Mortality")+
  theme_minimal()

#Q2:
#Scatterplot with 61 cities in the North and South with it's correlation
ggplot(water, aes(y=mortality, x=hardness, colour=location, inherit.aes = FALSE))+
  geom_point()+
  geom_smooth(method="auto", se=FALSE, fullrange=TRUE)+
  labs(title = "Difference between North and South", x = "Hardness", y = "Mortality")
theme_minimal()

#Scatterplot with  61 cities with it's correlation
ggplot(water, aes(y=mortality, x=hardness, inherit.aes = FALSE))+
  geom_point()+
  geom_smooth(method="auto", se=FALSE, fullrange=TRUE)+
  labs(title = "Difference between 61 towns", x = "Hardness", y = "Mortality")
theme_minimal()

#qqplot
ggqqplot(water$mortality)
ggqqplot(water$hardness)

#correlation calculation
cor(water$mortality, water$hardness, method = c("pearson", "kendall", "spearman"))

#Q3:
#Fitting a distribution for mortality
# fit the 3 different distributions: Weibull, Gamma, LogNormal
fit_w  <- fitdist(water$mortality, "weibull")
fit_g  <- fitdist(water$mortality, "gamma")
fit_ln <- fitdist(water$mortality, "lnorm")

summary(fit_ln)
summary(fit_w)
summary(fit_g)

#And for plotting and comparison use:
par(mfrow=c(2,2))
plot.legend <- c("Weibull", "lognormal", "gamma")
denscomp(list(fit_w, fit_g, fit_ln), legendtext = plot.legend)
cdfcomp (list(fit_w, fit_g, fit_ln), legendtext = plot.legend)
qqcomp  (list(fit_w, fit_g, fit_ln), legendtext = plot.legend)
ppcomp  (list(fit_w, fit_g, fit_ln), legendtext = plot.legend)

#Let's plot our candidate = chosen candidate (Weibull)
cdfcomp(fit_w, xlogscale = FALSE, ylogscale = FALSE)


#Fitting a distribution for water hardness
# fit the 3 different distributions: Weibull, Gamma, LogNormal
fit_w  <- fitdist(water$hardness, "weibull")
fit_g  <- fitdist(water$hardness, "gamma")
fit_ln <- fitdist(water$hardness, "lnorm")

summary(fit_ln)
summary(fit_w)
summary(fit_g)

#And for plotting and comparison use:
par(mfrow=c(2,2))
plot.legend <- c("Weibull", "lognormal", "gamma")
denscomp(list(fit_w, fit_g, fit_ln), legendtext = plot.legend)
cdfcomp (list(fit_w, fit_g, fit_ln), legendtext = plot.legend)
qqcomp  (list(fit_w, fit_g, fit_ln), legendtext = plot.legend)
ppcomp  (list(fit_w, fit_g, fit_ln), legendtext = plot.legend)

#Let's plot our candidate = chosen candidate (Weibull)
cdfcomp(fit_w, xlogscale = FALSE, ylogscale = FALSE)
