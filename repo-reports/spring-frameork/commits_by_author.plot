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
plot 'commits_by_author.dat' using 1:2 title "Juergen Hoeller" w lines, 'commits_by_author.dat' using 1:3 title "Rossen Stoyanchev" w lines, 'commits_by_author.dat' using 1:4 title "Sam Brannen" w lines, 'commits_by_author.dat' using 1:5 title "Arjen Poutsma" w lines, 'commits_by_author.dat' using 1:6 title "Chris Beams" w lines, 'commits_by_author.dat' using 1:7 title "Stephane Nicoll" w lines, 'commits_by_author.dat' using 1:8 title "Sebastien Deleuze" w lines, 'commits_by_author.dat' using 1:9 title "Brian Clozel" w lines, 'commits_by_author.dat' using 1:10 title "Keith Donald" w lines, 'commits_by_author.dat' using 1:11 title "Phillip Webb" w lines, 'commits_by_author.dat' using 1:12 title "Andy Clement" w lines, 'commits_by_author.dat' using 1:13 title "Costin Leau" w lines, 'commits_by_author.dat' using 1:14 title "Thomas Risberg" w lines, 'commits_by_author.dat' using 1:15 title "Stephane Maldini" w lines, 'commits_by_author.dat' using 1:16 title "Sébastien Deleuze" w lines, 'commits_by_author.dat' using 1:17 title "Rob Winch" w lines, 'commits_by_author.dat' using 1:18 title "David Syer" w lines, 'commits_by_author.dat' using 1:19 title "Spring Buildmaster" w lines, 'commits_by_author.dat' using 1:20 title "Mark Pollack" w lines, 'commits_by_author.dat' using 1:21 title "Mark Fisher" w lines
