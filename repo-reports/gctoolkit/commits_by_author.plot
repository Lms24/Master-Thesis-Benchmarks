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
plot 'commits_by_author.dat' using 1:2 title "Kirk Pepperdine" w lines, 'commits_by_author.dat' using 1:3 title "David Grieve" w lines, 'commits_by_author.dat' using 1:4 title "Martijn Verburg" w lines, 'commits_by_author.dat' using 1:5 title "Microsoft Open Source" w lines, 'commits_by_author.dat' using 1:6 title "Christian Stein" w lines, 'commits_by_author.dat' using 1:7 title "anant" w lines, 'commits_by_author.dat' using 1:8 title "Bruno Borges" w lines, 'commits_by_author.dat' using 1:9 title "slowy07" w lines, 'commits_by_author.dat' using 1:10 title "microsoft-github-operations[bot]" w lines, 'commits_by_author.dat' using 1:11 title "Frank Dietrich" w lines, 'commits_by_author.dat' using 1:12 title "Anant Kurapati" w lines
