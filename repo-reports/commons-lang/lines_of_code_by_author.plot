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
plot 'lines_of_code_by_author.dat' using 1:2 title "Henri Yandell" w lines, 'lines_of_code_by_author.dat' using 1:3 title "Gary D. Gregory" w lines, 'lines_of_code_by_author.dat' using 1:4 title "Stephen Colebourne" w lines, 'lines_of_code_by_author.dat' using 1:5 title "Sebastian Bazley" w lines, 'lines_of_code_by_author.dat' using 1:6 title "Benedikt Ritter" w lines, 'lines_of_code_by_author.dat' using 1:7 title "Matthew Jason Benson" w lines, 'lines_of_code_by_author.dat' using 1:8 title "Steven Caswell" w lines, 'lines_of_code_by_author.dat' using 1:9 title "Niall Pemberton" w lines, 'lines_of_code_by_author.dat' using 1:10 title "Oliver Heger" w lines, 'lines_of_code_by_author.dat' using 1:11 title "Daniel Rall" w lines, 'lines_of_code_by_author.dat' using 1:12 title "Joerg Schaible" w lines, 'lines_of_code_by_author.dat' using 1:13 title "Duncan Jones" w lines, 'lines_of_code_by_author.dat' using 1:14 title "Fredrik Westermarck" w lines, 'lines_of_code_by_author.dat' using 1:15 title "Phil Steitz" w lines, 'lines_of_code_by_author.dat' using 1:16 title "James W. Carman" w lines, 'lines_of_code_by_author.dat' using 1:17 title "Alex Chaffee" w lines, 'lines_of_code_by_author.dat' using 1:18 title "Robert Burrell Donkin" w lines, 'lines_of_code_by_author.dat' using 1:19 title "Olivier Lamy" w lines, 'lines_of_code_by_author.dat' using 1:20 title "Chas Honton" w lines, 'lines_of_code_by_author.dat' using 1:21 title "Thomas Neidhart" w lines
