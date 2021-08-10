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
plot 'commits_by_author.dat' using 1:2 title "Ilkka Seppälä" w lines, 'commits_by_author.dat' using 1:3 title "Ilkka Seppala" w lines, 'commits_by_author.dat' using 1:4 title "allcontributors[bot]" w lines, 'commits_by_author.dat' using 1:5 title "Narendra Pathai" w lines, 'commits_by_author.dat' using 1:6 title "Joseph McCarthy" w lines, 'commits_by_author.dat' using 1:7 title "Jeroen Meulemeester" w lines, 'commits_by_author.dat' using 1:8 title "Anurag Agarwal" w lines, 'commits_by_author.dat' using 1:9 title "Thomas" w lines, 'commits_by_author.dat' using 1:10 title "Gopinath Langote" w lines, 'commits_by_author.dat' using 1:11 title "Subhrodip Mohanta" w lines, 'commits_by_author.dat' using 1:12 title "Ashish Trivedi" w lines, 'commits_by_author.dat' using 1:13 title "Piyush Chaudhari" w lines, 'commits_by_author.dat' using 1:14 title "Sabiq Ihab" w lines, 'commits_by_author.dat' using 1:15 title "Amit Dixit" w lines, 'commits_by_author.dat' using 1:16 title "Besok" w lines, 'commits_by_author.dat' using 1:17 title "Argyro-Sioziou" w lines, 'commits_by_author.dat' using 1:18 title "nikhilbarar" w lines, 'commits_by_author.dat' using 1:19 title "Paul Campbell" w lines, 'commits_by_author.dat' using 1:20 title "tmcconville" w lines, 'commits_by_author.dat' using 1:21 title "dependabot-preview[bot]" w lines
