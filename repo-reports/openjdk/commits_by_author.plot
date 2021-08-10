set terminal png transparent size 640,240
set size 1.0,1.0

set terminal png transparent size 640,480
set output 'commits_by_author.png'
set key left top
set yrange [0:]
set xdata time
set timefmt "%s"
set format x "%Y-%m-%d"
set grid y
set ylabel "Commits"
set xtics rotate
set bmargin 6
plot 'commits_by_author.dat' using 1:2 title "J. Duke" w lines, 'commits_by_author.dat' using 1:3 title "Lana Steuck" w lines, 'commits_by_author.dat' using 1:4 title "David Katleman" w lines, 'commits_by_author.dat' using 1:5 title "Jonathan Gibbons" w lines, 'commits_by_author.dat' using 1:6 title "Phil Race" w lines, 'commits_by_author.dat' using 1:7 title "Alejandro Murillo" w lines, 'commits_by_author.dat' using 1:8 title "Erik Joelsson" w lines, 'commits_by_author.dat' using 1:9 title "Coleen Phillimore" w lines, 'commits_by_author.dat' using 1:10 title "Joe Darcy" w lines, 'commits_by_author.dat' using 1:11 title "Vladimir Kozlov" w lines, 'commits_by_author.dat' using 1:12 title "Jesper Wilhelmsson" w lines, 'commits_by_author.dat' using 1:13 title "Chris Hegarty" w lines, 'commits_by_author.dat' using 1:14 title "Sergey Bylokhov" w lines, 'commits_by_author.dat' using 1:15 title "Weijun Wang" w lines, 'commits_by_author.dat' using 1:16 title "Aleksey Shipilev" w lines, 'commits_by_author.dat' using 1:17 title "Alan Bateman" w lines, 'commits_by_author.dat' using 1:18 title "Athijegannathan Sundararajan" w lines, 'commits_by_author.dat' using 1:19 title "Igor Ignatyev" w lines, 'commits_by_author.dat' using 1:20 title "Thomas Schatzl" w lines, 'commits_by_author.dat' using 1:21 title "Daniel D. Daugherty" w lines
