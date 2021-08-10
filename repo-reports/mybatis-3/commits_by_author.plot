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
plot 'commits_by_author.dat' using 1:2 title "Eduardo Macarron" w lines, 'commits_by_author.dat' using 1:3 title "Iwao AVE!" w lines, 'commits_by_author.dat' using 1:4 title "Jeremy Landis" w lines, 'commits_by_author.dat' using 1:5 title "Kazuki Shimizu" w lines, 'commits_by_author.dat' using 1:6 title "Simone Tripodi" w lines, 'commits_by_author.dat' using 1:7 title "dependabot[bot]" w lines, 'commits_by_author.dat' using 1:8 title "dependabot-preview[bot]" w lines, 'commits_by_author.dat' using 1:9 title "Jeff Butler" w lines, 'commits_by_author.dat' using 1:10 title "Nathan Maves" w lines, 'commits_by_author.dat' using 1:11 title "Clinton Begin" w lines, 'commits_by_author.dat' using 1:12 title "CodeingBoy" w lines, 'commits_by_author.dat' using 1:13 title "eduardo" w lines, 'commits_by_author.dat' using 1:14 title "wangdx" w lines, 'commits_by_author.dat' using 1:15 title "Christian Poitras" w lines, 'commits_by_author.dat' using 1:16 title "luo.qianhong" w lines, 'commits_by_author.dat' using 1:17 title "kezhenxu94" w lines, 'commits_by_author.dat' using 1:18 title "ZhangShenao" w lines, 'commits_by_author.dat' using 1:19 title "zhanghanlin" w lines, 'commits_by_author.dat' using 1:20 title "kmoco2am" w lines, 'commits_by_author.dat' using 1:21 title "paopaofish" w lines
