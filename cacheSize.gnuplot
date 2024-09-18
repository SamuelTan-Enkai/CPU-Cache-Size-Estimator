set terminal pngcairo size 1024,768 enhanced font 'Verdana,12'
set output 'cache_size_plot.png'

set logscale x 2
set xlabel "Array Size (MiB)"
set ylabel "Access Time (ns)"

set title "Cache Size Measurement"
set grid

# Convert bytes to MiB in the plot command
plot 'out.txt' using ($1/2**20):2 with linespoints title 'Access Time'
