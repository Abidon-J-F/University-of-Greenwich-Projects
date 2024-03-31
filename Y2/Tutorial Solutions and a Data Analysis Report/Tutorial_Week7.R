#Q5
#importa data and test it
#install.packages("fitdistrplus")
library(fitdistrplus)

data("groundbeef", package = "fitdistrplus")
gb_data <- groundbeef$serving

head(gb_data, 10)
View(gb_data)

#ggqqplot and ggdensit

#if(!require(devtools)) install.packages("devtools")
#devtools::install_github("kassambara/ggpubr")

# then load

library(ggpubr)

## QQ plot
ggqqplot(gb_data)


#Plot the data histrogramm
ggdensity(gb_data, 
          main = "Density plot of GroundBeef Serving",
          xlab = "Ground Beef")

## Running a hypothesis test to support the visual
# note: sample size must be between 3 and 5000
shapiro.test(gb_data[1:5000])

#plot test
library(fitdistrplus)
plotdist(gb_data, histo = TRUE, demp = TRUE)

#Fitting a distribution
# fit the 3 different distributions: Weibull, Gamma, LogNormal
fit_w  <- fitdist(gb_data, "weibull")
fit_g  <- fitdist(gb_data, "gamma")
fit_ln <- fitdist(gb_data, "lnorm")

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

#Let's plot our candidate
cdfcomp(fit_w, xlogscale = FALSE, ylogscale = FALSE)
#The highest liklihood and lower BIC/AIC here is the Weibull (almost identical to the gamma to be honest - this is because of the nature of the two distributions that are special cases of each other).

