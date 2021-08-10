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
plot 'commits_by_author.dat' using 1:2 title "Jake Wharton" w lines, 'commits_by_author.dat' using 1:3 title "Jesse Wilson" w lines, 'commits_by_author.dat' using 1:4 title "jwilson" w lines, 'commits_by_author.dat' using 1:5 title "Christian Stein" w lines, 'commits_by_author.dat' using 1:6 title "Egor Andreevici" w lines, 'commits_by_author.dat' using 1:7 title "Thomas Broyer" w lines, 'commits_by_author.dat' using 1:8 title "Ron Shapiro" w lines, 'commits_by_author.dat' using 1:9 title "Gregory Kick" w lines, 'commits_by_author.dat' using 1:10 title "Christian Edward Gruber" w lines, 'commits_by_author.dat' using 1:11 title "Egor Andreevich" w lines, 'commits_by_author.dat' using 1:12 title "Zac Sweers" w lines, 'commits_by_author.dat' using 1:13 title "gak" w lines, 'commits_by_author.dat' using 1:14 title "Kenzie Togami" w lines, 'commits_by_author.dat' using 1:15 title "sormuras" w lines, 'commits_by_author.dat' using 1:16 title "Willi Schönborn" w lines, 'commits_by_author.dat' using 1:17 title "Shaishav Gandhi" w lines, 'commits_by_author.dat' using 1:18 title "Eric Cochran" w lines, 'commits_by_author.dat' using 1:19 title "digitalsanctum" w lines, 'commits_by_author.dat' using 1:20 title "cgruber" w lines, 'commits_by_author.dat' using 1:21 title "James Smith" w lines
