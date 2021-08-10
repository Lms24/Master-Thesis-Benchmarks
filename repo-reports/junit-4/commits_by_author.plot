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
plot 'commits_by_author.dat' using 1:2 title "David Saff" w lines, 'commits_by_author.dat' using 1:3 title "dsaff" w lines, 'commits_by_author.dat' using 1:4 title "Marc Philipp" w lines, 'commits_by_author.dat' using 1:5 title "Stefan Birkner" w lines, 'commits_by_author.dat' using 1:6 title "Kevin Cooney" w lines, 'commits_by_author.dat' using 1:7 title "kbeck" w lines, 'commits_by_author.dat' using 1:8 title "Tibor Digana" w lines, 'commits_by_author.dat' using 1:9 title "egamma" w lines, 'commits_by_author.dat' using 1:10 title "Johannes Link" w lines, 'commits_by_author.dat' using 1:11 title "pimterry" w lines, 'commits_by_author.dat' using 1:12 title "emeade" w lines, 'commits_by_author.dat' using 1:13 title "Noel Yap" w lines, 'commits_by_author.dat' using 1:14 title "Stephen Connolly" w lines, 'commits_by_author.dat' using 1:15 title "Arie van Deursen" w lines, 'commits_by_author.dat' using 1:16 title "flpa" w lines, 'commits_by_author.dat' using 1:17 title "clarkware" w lines, 'commits_by_author.dat' using 1:18 title "Alistair A. Israel" w lines, 'commits_by_author.dat' using 1:19 title "Ricky" w lines, 'commits_by_author.dat' using 1:20 title "Matthew Farwell" w lines, 'commits_by_author.dat' using 1:21 title "Alberto Scotto" w lines
