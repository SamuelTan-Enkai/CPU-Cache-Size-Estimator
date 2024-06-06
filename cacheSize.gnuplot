set terminal pngcairo size 1024,768 enhanced font 'Verdana,12'
set output 'cache_size_plot.png'

set logscale x 2
set xlabel "Array Size (bytes)"
set ylabel "Access Time (ns)"

set title "Cache Size Measurement"
set grid

plot 'out.txt' using 1:2 with linespoints title 'Access Time'

