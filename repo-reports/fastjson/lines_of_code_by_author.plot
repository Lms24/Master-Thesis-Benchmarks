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
plot 'lines_of_code_by_author.dat' using 1:2 title "wenshao" w lines, 'lines_of_code_by_author.dat' using 1:3 title "高铁" w lines, 'lines_of_code_by_author.dat' using 1:4 title "温绍锦" w lines, 'lines_of_code_by_author.dat' using 1:5 title "shaojin.wensj" w lines, 'lines_of_code_by_author.dat' using 1:6 title "温少" w lines, 'lines_of_code_by_author.dat' using 1:7 title "业余布道师" w lines, 'lines_of_code_by_author.dat' using 1:8 title "kimmking" w lines, 'lines_of_code_by_author.dat' using 1:9 title "Omega-Ariston" w lines, 'lines_of_code_by_author.dat' using 1:10 title "Yako" w lines, 'lines_of_code_by_author.dat' using 1:11 title "Victor Zeng" w lines, 'lines_of_code_by_author.dat' using 1:12 title "Neil Dong" w lines, 'lines_of_code_by_author.dat' using 1:13 title "VictorZeng" w lines, 'lines_of_code_by_author.dat' using 1:14 title "nanqi" w lines, 'lines_of_code_by_author.dat' using 1:15 title "TimAndy" w lines, 'lines_of_code_by_author.dat' using 1:16 title "温绍" w lines, 'lines_of_code_by_author.dat' using 1:17 title "{李彦慧}({026834})" w lines, 'lines_of_code_by_author.dat' using 1:18 title "Mengdi Gao" w lines, 'lines_of_code_by_author.dat' using 1:19 title "lihengming" w lines, 'lines_of_code_by_author.dat' using 1:20 title "axmanwang" w lines, 'lines_of_code_by_author.dat' using 1:21 title "Joshua" w lines
