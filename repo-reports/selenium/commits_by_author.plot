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
plot 'commits_by_author.dat' using 1:2 title "Simon Stewart" w lines, 'commits_by_author.dat' using 1:3 title "Alexei Barantsev" w lines, 'commits_by_author.dat' using 1:4 title "Jim Evans" w lines, 'commits_by_author.dat' using 1:5 title "Jason Leyba" w lines, 'commits_by_author.dat' using 1:6 title "Jari Bakken" w lines, 'commits_by_author.dat' using 1:7 title "Dan Fabulich" w lines, 'commits_by_author.dat' using 1:8 title "Daniel Wagner-Hall" w lines, 'commits_by_author.dat' using 1:9 title "David Burns" w lines, 'commits_by_author.dat' using 1:10 title "Luke Inman-Semerau" w lines, 'commits_by_author.dat' using 1:11 title "Nelson Sproul" w lines, 'commits_by_author.dat' using 1:12 title "Paul Hammant" w lines, 'commits_by_author.dat' using 1:13 title "Eran Messeri" w lines, 'commits_by_author.dat' using 1:14 title "Titus Fortner" w lines, 'commits_by_author.dat' using 1:15 title "Alex Rodionov" w lines, 'commits_by_author.dat' using 1:16 title "Dounia Berrada" w lines, 'commits_by_author.dat' using 1:17 title "Shinya Kasatani" w lines, 'commits_by_author.dat' using 1:18 title "Darrell DeBoer" w lines, 'commits_by_author.dat' using 1:19 title "Mike Williams" w lines, 'commits_by_author.dat' using 1:20 title "Diego Molina" w lines, 'commits_by_author.dat' using 1:21 title "Andreas Tolfsen" w lines
