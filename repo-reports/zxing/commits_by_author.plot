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
plot 'commits_by_author.dat' using 1:2 title "srowen" w lines, 'commits_by_author.dat' using 1:3 title "Sean Owen" w lines, 'commits_by_author.dat' using 1:4 title "dswitkin" w lines, 'commits_by_author.dat' using 1:5 title "srowen@gmail.com" w lines, 'commits_by_author.dat' using 1:6 title "smparkes@smparkes.net" w lines, 'commits_by_author.dat' using 1:7 title "dswitkin@google.com" w lines, 'commits_by_author.dat' using 1:8 title "rpechayr" w lines, 'commits_by_author.dat' using 1:9 title "christian.brunschen" w lines, 'commits_by_author.dat' using 1:10 title "vikrama" w lines, 'commits_by_author.dat' using 1:11 title "slepmog" w lines, 'commits_by_author.dat' using 1:12 title "flyashi" w lines, 'commits_by_author.dat' using 1:13 title "Yao Wei" w lines, 'commits_by_author.dat' using 1:14 title "kev.sully" w lines, 'commits_by_author.dat' using 1:15 title "MakKi (makki_d)" w lines, 'commits_by_author.dat' using 1:16 title "dkavanagh" w lines, 'commits_by_author.dat' using 1:17 title "bas5winkel@gmail.com" w lines, 'commits_by_author.dat' using 1:18 title "gln@google.com" w lines, 'commits_by_author.dat' using 1:19 title "dav.olivier@gmail.com" w lines, 'commits_by_author.dat' using 1:20 title "ralf.kistner@gmail.com" w lines, 'commits_by_author.dat' using 1:21 title "leppoc" w lines
