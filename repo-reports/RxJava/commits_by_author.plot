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
plot 'commits_by_author.dat' using 1:2 title "Ben Christensen" w lines, 'commits_by_author.dat' using 1:3 title "David Karnok" w lines, 'commits_by_author.dat' using 1:4 title "akarnokd" w lines, 'commits_by_author.dat' using 1:5 title "zsxwing" w lines, 'commits_by_author.dat' using 1:6 title "David Gross" w lines, 'commits_by_author.dat' using 1:7 title "samuelgruetter" w lines, 'commits_by_author.dat' using 1:8 title "Bob T Builder" w lines, 'commits_by_author.dat' using 1:9 title "jmhofer" w lines, 'commits_by_author.dat' using 1:10 title "headinthebox" w lines, 'commits_by_author.dat' using 1:11 title "Dave Moten" w lines, 'commits_by_author.dat' using 1:12 title "Mairbek Khadikov" w lines, 'commits_by_author.dat' using 1:13 title "Jake Wharton" w lines, 'commits_by_author.dat' using 1:14 title "Niklas Baudy" w lines, 'commits_by_author.dat' using 1:15 title "dependabot-preview[bot]" w lines, 'commits_by_author.dat' using 1:16 title "George Campbell" w lines, 'commits_by_author.dat' using 1:17 title "Justin Ryan" w lines, 'commits_by_author.dat' using 1:18 title "Matt Jacobs" w lines, 'commits_by_author.dat' using 1:19 title "Matthias Kaeppler" w lines, 'commits_by_author.dat' using 1:20 title "Dave Ray" w lines, 'commits_by_author.dat' using 1:21 title "Joachim Hofer" w lines
