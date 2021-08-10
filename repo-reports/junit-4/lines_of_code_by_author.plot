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
plot 'lines_of_code_by_author.dat' using 1:2 title "David Saff" w lines, 'lines_of_code_by_author.dat' using 1:3 title "dsaff" w lines, 'lines_of_code_by_author.dat' using 1:4 title "Marc Philipp" w lines, 'lines_of_code_by_author.dat' using 1:5 title "Stefan Birkner" w lines, 'lines_of_code_by_author.dat' using 1:6 title "Kevin Cooney" w lines, 'lines_of_code_by_author.dat' using 1:7 title "kbeck" w lines, 'lines_of_code_by_author.dat' using 1:8 title "Tibor Digana" w lines, 'lines_of_code_by_author.dat' using 1:9 title "egamma" w lines, 'lines_of_code_by_author.dat' using 1:10 title "Johannes Link" w lines, 'lines_of_code_by_author.dat' using 1:11 title "pimterry" w lines, 'lines_of_code_by_author.dat' using 1:12 title "emeade" w lines, 'lines_of_code_by_author.dat' using 1:13 title "Noel Yap" w lines, 'lines_of_code_by_author.dat' using 1:14 title "Stephen Connolly" w lines, 'lines_of_code_by_author.dat' using 1:15 title "Arie van Deursen" w lines, 'lines_of_code_by_author.dat' using 1:16 title "flpa" w lines, 'lines_of_code_by_author.dat' using 1:17 title "clarkware" w lines, 'lines_of_code_by_author.dat' using 1:18 title "Alistair A. Israel" w lines, 'lines_of_code_by_author.dat' using 1:19 title "Ricky" w lines, 'lines_of_code_by_author.dat' using 1:20 title "Matthew Farwell" w lines, 'lines_of_code_by_author.dat' using 1:21 title "Alberto Scotto" w lines
