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
plot 'lines_of_code_by_author.dat' using 1:2 title "Skylot" w lines, 'lines_of_code_by_author.dat' using 1:3 title "Ahmed Ashour" w lines, 'lines_of_code_by_author.dat' using 1:4 title "skylot" w lines, 'lines_of_code_by_author.dat' using 1:5 title "Jan S" w lines, 'lines_of_code_by_author.dat' using 1:6 title "Sergey Toshin" w lines, 'lines_of_code_by_author.dat' using 1:7 title "S-trace" w lines, 'lines_of_code_by_author.dat' using 1:8 title "YASME-Tim" w lines, 'lines_of_code_by_author.dat' using 1:9 title "sergey-wowwow" w lines, 'lines_of_code_by_author.dat' using 1:10 title "LBJ-the-GOAT" w lines, 'lines_of_code_by_author.dat' using 1:11 title "NeoSpb" w lines, 'lines_of_code_by_author.dat' using 1:12 title "Jan Peter Stotz" w lines, 'lines_of_code_by_author.dat' using 1:13 title "Jonas Konrad" w lines, 'lines_of_code_by_author.dat' using 1:14 title "Donlon" w lines, 'lines_of_code_by_author.dat' using 1:15 title "13.beta2" w lines, 'lines_of_code_by_author.dat' using 1:16 title "bagipro" w lines, 'lines_of_code_by_author.dat' using 1:17 title "Soul Trace" w lines, 'lines_of_code_by_author.dat' using 1:18 title "Daniel Ramos" w lines, 'lines_of_code_by_author.dat' using 1:19 title "tRuNKator" w lines, 'lines_of_code_by_author.dat' using 1:20 title "Choiman1559" w lines, 'lines_of_code_by_author.dat' using 1:21 title "Anton Dyachenko" w lines
