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
plot 'commits_by_author.dat' using 1:2 title "Henri Yandell" w lines, 'commits_by_author.dat' using 1:3 title "Gary Gregory" w lines, 'commits_by_author.dat' using 1:4 title "Emmanuel Bourg" w lines, 'commits_by_author.dat' using 1:5 title "John Keyes" w lines, 'commits_by_author.dat' using 1:6 title "Benedikt Ritter" w lines, 'commits_by_author.dat' using 1:7 title "Robert James Oxspring" w lines, 'commits_by_author.dat' using 1:8 title "Thomas Neidhart" w lines, 'commits_by_author.dat' using 1:9 title "Niall Kegan Pemberton" w lines, 'commits_by_author.dat' using 1:10 title "Sebastian Bazley" w lines, 'commits_by_author.dat' using 1:11 title "Gary D. Gregory" w lines, 'commits_by_author.dat' using 1:12 title "dependabot[bot]" w lines, 'commits_by_author.dat' using 1:13 title "Olivier Lamy" w lines, 'commits_by_author.dat' using 1:14 title "Simone Tripodi" w lines, 'commits_by_author.dat' using 1:15 title "Oliver Heger" w lines, 'commits_by_author.dat' using 1:16 title "Bela Schaum" w lines, 'commits_by_author.dat' using 1:17 title "Timothy O'Brien" w lines, 'commits_by_author.dat' using 1:18 title "Rob Tompkins" w lines, 'commits_by_author.dat' using 1:19 title "Mark R. Diggory" w lines, 'commits_by_author.dat' using 1:20 title "pascalschumacher" w lines, 'commits_by_author.dat' using 1:21 title "Rahul Akolkar" w lines
