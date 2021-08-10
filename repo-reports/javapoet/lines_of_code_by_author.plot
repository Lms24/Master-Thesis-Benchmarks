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
plot 'lines_of_code_by_author.dat' using 1:2 title "Jake Wharton" w lines, 'lines_of_code_by_author.dat' using 1:3 title "Jesse Wilson" w lines, 'lines_of_code_by_author.dat' using 1:4 title "jwilson" w lines, 'lines_of_code_by_author.dat' using 1:5 title "Christian Stein" w lines, 'lines_of_code_by_author.dat' using 1:6 title "Egor Andreevici" w lines, 'lines_of_code_by_author.dat' using 1:7 title "Thomas Broyer" w lines, 'lines_of_code_by_author.dat' using 1:8 title "Ron Shapiro" w lines, 'lines_of_code_by_author.dat' using 1:9 title "Gregory Kick" w lines, 'lines_of_code_by_author.dat' using 1:10 title "Christian Edward Gruber" w lines, 'lines_of_code_by_author.dat' using 1:11 title "Egor Andreevich" w lines, 'lines_of_code_by_author.dat' using 1:12 title "Zac Sweers" w lines, 'lines_of_code_by_author.dat' using 1:13 title "gak" w lines, 'lines_of_code_by_author.dat' using 1:14 title "Kenzie Togami" w lines, 'lines_of_code_by_author.dat' using 1:15 title "sormuras" w lines, 'lines_of_code_by_author.dat' using 1:16 title "Willi Schönborn" w lines, 'lines_of_code_by_author.dat' using 1:17 title "Shaishav Gandhi" w lines, 'lines_of_code_by_author.dat' using 1:18 title "Eric Cochran" w lines, 'lines_of_code_by_author.dat' using 1:19 title "digitalsanctum" w lines, 'lines_of_code_by_author.dat' using 1:20 title "cgruber" w lines, 'lines_of_code_by_author.dat' using 1:21 title "James Smith" w lines
