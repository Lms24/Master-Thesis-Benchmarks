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
plot 'lines_of_code_by_author.dat' using 1:2 title "Henri Yandell" w lines, 'lines_of_code_by_author.dat' using 1:3 title "Gary Gregory" w lines, 'lines_of_code_by_author.dat' using 1:4 title "Emmanuel Bourg" w lines, 'lines_of_code_by_author.dat' using 1:5 title "John Keyes" w lines, 'lines_of_code_by_author.dat' using 1:6 title "Benedikt Ritter" w lines, 'lines_of_code_by_author.dat' using 1:7 title "Robert James Oxspring" w lines, 'lines_of_code_by_author.dat' using 1:8 title "Thomas Neidhart" w lines, 'lines_of_code_by_author.dat' using 1:9 title "Niall Kegan Pemberton" w lines, 'lines_of_code_by_author.dat' using 1:10 title "Sebastian Bazley" w lines, 'lines_of_code_by_author.dat' using 1:11 title "Gary D. Gregory" w lines, 'lines_of_code_by_author.dat' using 1:12 title "dependabot[bot]" w lines, 'lines_of_code_by_author.dat' using 1:13 title "Olivier Lamy" w lines, 'lines_of_code_by_author.dat' using 1:14 title "Simone Tripodi" w lines, 'lines_of_code_by_author.dat' using 1:15 title "Oliver Heger" w lines, 'lines_of_code_by_author.dat' using 1:16 title "Bela Schaum" w lines, 'lines_of_code_by_author.dat' using 1:17 title "Timothy O'Brien" w lines, 'lines_of_code_by_author.dat' using 1:18 title "Rob Tompkins" w lines, 'lines_of_code_by_author.dat' using 1:19 title "Mark R. Diggory" w lines, 'lines_of_code_by_author.dat' using 1:20 title "pascalschumacher" w lines, 'lines_of_code_by_author.dat' using 1:21 title "Rahul Akolkar" w lines
