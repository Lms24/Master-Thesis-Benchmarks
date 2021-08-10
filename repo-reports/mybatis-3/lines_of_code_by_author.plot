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
plot 'lines_of_code_by_author.dat' using 1:2 title "Eduardo Macarron" w lines, 'lines_of_code_by_author.dat' using 1:3 title "Iwao AVE!" w lines, 'lines_of_code_by_author.dat' using 1:4 title "Jeremy Landis" w lines, 'lines_of_code_by_author.dat' using 1:5 title "Kazuki Shimizu" w lines, 'lines_of_code_by_author.dat' using 1:6 title "Simone Tripodi" w lines, 'lines_of_code_by_author.dat' using 1:7 title "dependabot[bot]" w lines, 'lines_of_code_by_author.dat' using 1:8 title "dependabot-preview[bot]" w lines, 'lines_of_code_by_author.dat' using 1:9 title "Jeff Butler" w lines, 'lines_of_code_by_author.dat' using 1:10 title "Nathan Maves" w lines, 'lines_of_code_by_author.dat' using 1:11 title "Clinton Begin" w lines, 'lines_of_code_by_author.dat' using 1:12 title "CodeingBoy" w lines, 'lines_of_code_by_author.dat' using 1:13 title "eduardo" w lines, 'lines_of_code_by_author.dat' using 1:14 title "wangdx" w lines, 'lines_of_code_by_author.dat' using 1:15 title "Christian Poitras" w lines, 'lines_of_code_by_author.dat' using 1:16 title "luo.qianhong" w lines, 'lines_of_code_by_author.dat' using 1:17 title "kezhenxu94" w lines, 'lines_of_code_by_author.dat' using 1:18 title "ZhangShenao" w lines, 'lines_of_code_by_author.dat' using 1:19 title "zhanghanlin" w lines, 'lines_of_code_by_author.dat' using 1:20 title "kmoco2am" w lines, 'lines_of_code_by_author.dat' using 1:21 title "paopaofish" w lines
