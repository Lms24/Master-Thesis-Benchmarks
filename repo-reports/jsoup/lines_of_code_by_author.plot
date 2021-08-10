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
plot 'lines_of_code_by_author.dat' using 1:2 title "Jonathan Hedley" w lines, 'lines_of_code_by_author.dat' using 1:3 title "offa" w lines, 'lines_of_code_by_author.dat' using 1:4 title "Anton Kazennikov" w lines, 'lines_of_code_by_author.dat' using 1:5 title "jhy" w lines, 'lines_of_code_by_author.dat' using 1:6 title "dependabot[bot]" w lines, 'lines_of_code_by_author.dat' using 1:7 title "Erich Schubert" w lines, 'lines_of_code_by_author.dat' using 1:8 title "Askar Akhmerov" w lines, 'lines_of_code_by_author.dat' using 1:9 title "Alex Westphal" w lines, 'lines_of_code_by_author.dat' using 1:10 title "mingfai.ma" w lines, 'lines_of_code_by_author.dat' using 1:11 title "cketti" w lines, 'lines_of_code_by_author.dat' using 1:12 title "Pascal Schumacher" w lines, 'lines_of_code_by_author.dat' using 1:13 title "Mite Mitreski" w lines, 'lines_of_code_by_author.dat' using 1:14 title "Ioana Leontiuc" w lines, 'lines_of_code_by_author.dat' using 1:15 title "Hannes Erven" w lines, 'lines_of_code_by_author.dat' using 1:16 title "Akhmerov Askar" w lines, 'lines_of_code_by_author.dat' using 1:17 title "pafgoncalves" w lines, 'lines_of_code_by_author.dat' using 1:18 title "krystiangorecki" w lines, 'lines_of_code_by_author.dat' using 1:19 title "benoit" w lines, 'lines_of_code_by_author.dat' using 1:20 title "Jared Stehler" w lines, 'lines_of_code_by_author.dat' using 1:21 title "Jai Ram Rideout" w lines
