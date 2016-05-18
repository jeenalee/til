library(ggplot2)

# Plotting data `data` in 2-D `y~x`.
g = ggplot(data, aes(x, y))

# `pch` is for the shape of the point.
# `width` in `position_jitter` introduces a 
#   spreadness in data points in horizontal direction.
g = g + geom_jitter(aes(pch=x), position=position_jitter(width=0.1))

# Show plot.
g
