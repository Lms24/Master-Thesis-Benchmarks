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
plot 'commits_by_author.dat' using 1:2 title "Henri Yandell" w lines, 'commits_by_author.dat' using 1:3 title "Gary D. Gregory" w lines, 'commits_by_author.dat' using 1:4 title "Stephen Colebourne" w lines, 'commits_by_author.dat' using 1:5 title "Sebastian Bazley" w lines, 'commits_by_author.dat' using 1:6 title "Benedikt Ritter" w lines, 'commits_by_author.dat' using 1:7 title "Matthew Jason Benson" w lines, 'commits_by_author.dat' using 1:8 title "Steven Caswell" w lines, 'commits_by_author.dat' using 1:9 title "Niall Pemberton" w lines, 'commits_by_author.dat' using 1:10 title "Oliver Heger" w lines, 'commits_by_author.dat' using 1:11 title "Daniel Rall" w lines, 'commits_by_author.dat' using 1:12 title "Joerg Schaible" w lines, 'commits_by_author.dat' using 1:13 title "Duncan Jones" w lines, 'commits_by_author.dat' using 1:14 title "Fredrik Westermarck" w lines, 'commits_by_author.dat' using 1:15 title "Phil Steitz" w lines, 'commits_by_author.dat' using 1:16 title "James W. Carman" w lines, 'commits_by_author.dat' using 1:17 title "Alex Chaffee" w lines, 'commits_by_author.dat' using 1:18 title "Robert Burrell Donkin" w lines, 'commits_by_author.dat' using 1:19 title "Olivier Lamy" w lines, 'commits_by_author.dat' using 1:20 title "Chas Honton" w lines, 'commits_by_author.dat' using 1:21 title "Thomas Neidhart" w lines
