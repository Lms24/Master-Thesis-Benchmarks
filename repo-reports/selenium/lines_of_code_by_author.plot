set terminal png transparent size 640,240
set size 1.0,1.0

set terminal png transparent size 640,480
set output 'lines_of_code_by_author.png'
set key left top
set yrange [0:]
set xdata time
set timefmt "%s"
set format x "%Y-%m-%d"
set grid y
set ylabel "Lines"
set xtics rotate
set bmargin 6
plot 'lines_of_code_by_author.dat' using 1:2 title "Simon Stewart" w lines, 'lines_of_code_by_author.dat' using 1:3 title "Alexei Barantsev" w lines, 'lines_of_code_by_author.dat' using 1:4 title "Jim Evans" w lines, 'lines_of_code_by_author.dat' using 1:5 title "Jason Leyba" w lines, 'lines_of_code_by_author.dat' using 1:6 title "Jari Bakken" w lines, 'lines_of_code_by_author.dat' using 1:7 title "Dan Fabulich" w lines, 'lines_of_code_by_author.dat' using 1:8 title "Daniel Wagner-Hall" w lines, 'lines_of_code_by_author.dat' using 1:9 title "David Burns" w lines, 'lines_of_code_by_author.dat' using 1:10 title "Luke Inman-Semerau" w lines, 'lines_of_code_by_author.dat' using 1:11 title "Nelson Sproul" w lines, 'lines_of_code_by_author.dat' using 1:12 title "Paul Hammant" w lines, 'lines_of_code_by_author.dat' using 1:13 title "Eran Messeri" w lines, 'lines_of_code_by_author.dat' using 1:14 title "Titus Fortner" w lines, 'lines_of_code_by_author.dat' using 1:15 title "Alex Rodionov" w lines, 'lines_of_code_by_author.dat' using 1:16 title "Dounia Berrada" w lines, 'lines_of_code_by_author.dat' using 1:17 title "Shinya Kasatani" w lines, 'lines_of_code_by_author.dat' using 1:18 title "Darrell DeBoer" w lines, 'lines_of_code_by_author.dat' using 1:19 title "Mike Williams" w lines, 'lines_of_code_by_author.dat' using 1:20 title "Diego Molina" w lines, 'lines_of_code_by_author.dat' using 1:21 title "Andreas Tolfsen" w lines
