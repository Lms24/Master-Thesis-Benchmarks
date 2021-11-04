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
plot 'commits_by_author.dat' using 1:2 title "Gary D. Gregory" w lines, 'commits_by_author.dat' using 1:3 title "Gary Gregory" w lines, 'commits_by_author.dat' using 1:4 title "Benedikt Ritter" w lines, 'commits_by_author.dat' using 1:5 title "Sebastian Bazley" w lines, 'commits_by_author.dat' using 1:6 title "Henri Yandell" w lines, 'commits_by_author.dat' using 1:7 title "Emmanuel Bourg" w lines, 'commits_by_author.dat' using 1:8 title "dependabot[bot]" w lines, 'commits_by_author.dat' using 1:9 title "Sebb" w lines, 'commits_by_author.dat' using 1:10 title "Yonik Seeley" w lines, 'commits_by_author.dat' using 1:11 title "Chen" w lines, 'commits_by_author.dat' using 1:12 title "Niall Pemberton" w lines, 'commits_by_author.dat' using 1:13 title "Bruno P. Kinoshita" w lines, 'commits_by_author.dat' using 1:14 title "Alex Herbert" w lines, 'commits_by_author.dat' using 1:15 title "Jacopo Cappellato" w lines, 'commits_by_author.dat' using 1:16 title "belugabehr" w lines, 'commits_by_author.dat' using 1:17 title "Dennis Lundberg" w lines, 'commits_by_author.dat' using 1:18 title "aherbert" w lines, 'commits_by_author.dat' using 1:19 title "Martin van den Bemt" w lines, 'commits_by_author.dat' using 1:20 title "Arturo Bernal" w lines, 'commits_by_author.dat' using 1:21 title "pascalschumacher" w lines
