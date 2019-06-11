# ruby-java-benchmarking

![https://raw.githubusercontent.com/jacaetevha/ruby-java-benchmarking/master/images/fold-inject-benchmark.png](ruby implementations)

![https://raw.githubusercontent.com/jacaetevha/ruby-java-benchmarking/master/images/folding-benchmark.png](java implementations)

### Java 8 (Oracle): Java HotSpot(TM) 64-Bit Server VM (build 25.152-b16, mixed mode)
```
$> java Folding

COUNT: 1000
ARRAY SIZE: 10000


           TOTAL
forLoop    0.649
folding    0.603

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> java -DCOUNT=10000 Folding

COUNT: 10000
ARRAY SIZE: 10000


           TOTAL
forLoop    4.716
folding    4.745

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> java -DCOUNT=100000 Folding

COUNT: 100000
ARRAY SIZE: 10000


           TOTAL
forLoop    44.303
folding    44.023

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> java -DCOUNT=1000000 Folding

COUNT: 1000000
ARRAY SIZE: 10000


           TOTAL
forLoop    449.28
folding    499.585
```

### GraalVM Community Edition 19.0.0

```
$> JAVA_HOME=~/graalvm-ce-19.0.0/Contents/Home java Folding

COUNT: 1000
ARRAY SIZE: 10000


           TOTAL
forLoop    0.52
folding    0.49

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> JAVA_HOME=~/graalvm-ce-19.0.0/Contents/Home java -DCOUNT=10000 Folding

COUNT: 10000
ARRAY SIZE: 10000


           TOTAL
forLoop    3.943
folding    4.024

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> JAVA_HOME=~/graalvm-ce-19.0.0/Contents/Home java -DCOUNT=100000 Folding
COUNT: 100000
ARRAY SIZE: 10000


           TOTAL
forLoop    32.627
folding    37.523

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> JAVA_HOME=~/graalvm-ce-19.0.0/Contents/Home java -DCOUNT=1000000 Folding

COUNT: 1000000
ARRAY SIZE: 10000


           TOTAL
forLoop    329.049
folding    388.802
```

### Compiled binary via native-image (GraalVM Community Edition 19.0.0)

```
$> ./folding

COUNT: 1000
ARRAY SIZE: 10000


           TOTAL
forLoop    0.983
folding    1.169

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> ./folding -DCOUNT=10000

COUNT: 10000
ARRAY SIZE: 10000


           TOTAL
forLoop    9.051
folding    11.338

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> ./folding -DCOUNT=100000

COUNT: 100000
ARRAY SIZE: 10000


           TOTAL
forLoop    87.038
folding    114.265

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> ./folding -DCOUNT=1000000

COUNT: 1000000
ARRAY SIZE: 10000


           TOTAL
forLoop    914.598
folding    1131.142
```

### JRuby 9.2.7.0

```
$> ruby --server ~/tmp/fold-inject-benchmark.rb

COUNT: 1000
ARRAY SIZE: 10000

Rehearsal ----------------------------------------------------
inject             1.210000   0.080000   1.290000 (  0.713372)
aliased fold       0.600000   0.040000   0.640000 (  0.585862)
handcrafted fold   1.340000   0.050000   1.390000 (  1.167361)
------------------------------------------- total: 3.320000sec

                       user     system      total        real
inject             0.560000   0.030000   0.590000 (  0.587254)
aliased fold       0.650000   0.000000   0.650000 (  0.615340)
handcrafted fold   1.070000   0.050000   1.120000 (  1.093021)

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> COUNT=10_000 ruby --server ~/tmp/fold-inject-benchmark.rb

COUNT: 10000
ARRAY SIZE: 10000

Rehearsal ----------------------------------------------------
inject             5.820000   0.230000   6.050000 (  5.286536)
aliased fold       4.930000   0.050000   4.980000 (  4.738057)
handcrafted fold   9.440000   0.060000   9.500000 (  9.236729)
------------------------------------------ total: 20.530000sec

                       user     system      total        real
inject             4.810000   0.030000   4.840000 (  4.763401)
aliased fold       5.090000   0.010000   5.100000 (  5.078943)
handcrafted fold   9.300000   0.020000   9.320000 (  9.226186)

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> COUNT=100_000 ruby --server ~/tmp/fold-inject-benchmark.rb

COUNT: 100000
ARRAY SIZE: 10000

Rehearsal ----------------------------------------------------
inject            51.690000   0.580000  52.270000 ( 51.327311)
aliased fold      50.040000   0.220000  50.260000 ( 49.173802)
handcrafted fold  98.370000   0.430000  98.800000 ( 96.610352)
----------------------------------------- total: 201.330000sec

                       user     system      total        real
inject            50.260000   0.250000  50.510000 ( 49.404785)
aliased fold      55.020000   0.290000  55.310000 ( 54.135756)
handcrafted fold  98.680000   0.540000  99.220000 ( 97.105497)

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> COUNT=1_000_000 ruby --server ~/tmp/fold-inject-benchmark.rb

COUNT: 1000000
ARRAY SIZE: 10000

Rehearsal ----------------------------------------------------
inject           508.920000   3.010000 511.930000 (503.048829)
aliased fold     506.930000   3.320000 510.250000 (502.301853)
handcrafted fold 1019.150000   6.090000 1025.240000 (1006.165320)
---------------------------------------- total: 2047.420000sec

                       user     system      total        real
inject           501.290000   2.290000 503.580000 (492.294283)
aliased fold     540.420000   2.560000 542.980000 (531.554101)
handcrafted fold 1033.910000   5.020000 1038.930000 (1017.801138)
```

### MRI 2.5.3

```
$> ruby ~/tmp/fold-inject-benchmark.rb

COUNT: 1000
ARRAY SIZE: 10000

Rehearsal ----------------------------------------------------
inject             0.620085   0.002363   0.622448 (  0.624269)
aliased fold       0.630930   0.002655   0.633585 (  0.637310)
handcrafted fold   0.802883   0.005157   0.808040 (  0.818519)
------------------------------------------- total: 2.064073sec

                       user     system      total        real
inject             0.626664   0.002399   0.629063 (  0.631700)
aliased fold       0.629671   0.002487   0.632158 (  0.635208)
handcrafted fold   0.780936   0.002214   0.783150 (  0.788546)

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> COUNT=10_000 ruby ~/tmp/fold-inject-benchmark.rb

COUNT: 10000
ARRAY SIZE: 10000

Rehearsal ----------------------------------------------------
inject             6.070346   0.022347   6.092693 (  6.122041)
aliased fold       6.074565   0.021689   6.096254 (  6.133728)
handcrafted fold   7.518431   0.029966   7.548397 (  7.578389)
------------------------------------------ total: 19.737344sec

                       user     system      total        real
inject             6.287740   0.024383   6.312123 (  6.335854)
aliased fold       6.239949   0.020483   6.260432 (  6.285993)
handcrafted fold   8.769731   0.034049   8.803780 (  9.333247)

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> COUNT=100_000 ruby ~/tmp/fold-inject-benchmark.rb

COUNT: 100000
ARRAY SIZE: 10000

Rehearsal ----------------------------------------------------
inject            64.667404   0.209130  64.876534 ( 65.209512)
aliased fold      61.896522   0.199264  62.095786 ( 62.479436)
handcrafted fold  75.609482   0.195161  75.804643 ( 76.075891)
----------------------------------------- total: 202.776963sec

                       user     system      total        real
inject            63.342514   0.184856  63.527370 ( 63.987717)
aliased fold      63.414819   0.203144  63.617963 ( 63.958534)
handcrafted fold  82.643665   0.254360  82.898025 ( 83.452553)

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> COUNT=1_000_000 ruby ~/tmp/fold-inject-benchmark.rb

COUNT: 1000000
ARRAY SIZE: 10000

Rehearsal ----------------------------------------------------
inject           633.901653   3.058981 636.960634 (642.448300)
aliased fold     612.872762   1.341543 614.214305 (616.346561)
handcrafted fold 743.038595   1.329808 744.368403 (746.059732)
---------------------------------------- total: 1995.543342sec

                       user     system      total        real
inject           616.495874   1.143973 617.639847 (619.174612)
aliased fold     636.365195   1.307027 637.672222 (639.569087)
handcrafted fold 754.031493   1.992305 756.023798 (758.851287)
```

### Truffle Ruby 1.0.0-rc10

```
$> ruby ~/tmp/fold-inject-benchmark.rb

COUNT: 1000
ARRAY SIZE: 10000

Rehearsal ----------------------------------------------------
inject             0.063628   0.008791   0.072419 (  0.048752)
aliased fold       0.069343   0.009213   0.078556 (  0.049038)
handcrafted fold   0.088057   0.010800   0.098857 (  0.060614)
------------------------------------------- total: 0.249832sec

                       user     system      total        real
inject             0.049898   0.000241   0.050139 (  0.029252)
aliased fold       0.056721   0.000473   0.057194 (  0.040916)
handcrafted fold   0.097868   0.000507   0.098375 (  0.060274)

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> COUNT=10_000 ruby ~/tmp/fold-inject-benchmark.rb
COUNT: 10000
ARRAY SIZE: 10000

Rehearsal ----------------------------------------------------
inject             0.319726   0.011651   0.331377 (  0.292287)
aliased fold       0.326877   0.010651   0.337528 (  0.302838)
handcrafted fold   0.192831   0.015332   0.208163 (  0.143857)
------------------------------------------- total: 0.877068sec

                       user     system      total        real
inject             0.273698   0.000107   0.273805 (  0.273894)
aliased fold       0.308301   0.000555   0.308856 (  0.281253)
handcrafted fold   0.178559   0.000625   0.179184 (  0.130660)

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> COUNT=100_000 ruby ~/tmp/fold-inject-benchmark.rb

COUNT: 100000
ARRAY SIZE: 10000

Rehearsal ----------------------------------------------------
inject             2.782480   0.019926   2.802406 (  2.766959)
aliased fold       2.784755   0.019529   2.804284 (  2.770256)
handcrafted fold   0.875799   0.021803   0.897602 (  0.833362)
------------------------------------------- total: 6.504292sec

                       user     system      total        real
inject             2.800667   0.006017   2.806684 (  2.817613)
aliased fold       2.790353   0.003099   2.793452 (  2.766635)
handcrafted fold   0.876179   0.001066   0.877245 (  0.826215)

~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~

$> COUNT=1_000_000 ruby ~/tmp/fold-inject-benchmark.rb

COUNT: 1000000
ARRAY SIZE: 10000

Rehearsal ----------------------------------------------------
inject             9.545670   0.043610   9.589280 (  9.574863)
aliased fold       9.577544   0.052886   9.630430 (  9.648903)
handcrafted fold   7.637310   0.057066   7.694376 (  7.640166)
------------------------------------------ total: 26.914086sec

                       user     system      total        real
inject             7.211924   0.007001   7.218925 (  7.225697)
aliased fold       9.270379   0.008738   9.279117 (  9.238720)
handcrafted fold   7.330860   0.006344   7.337204 (  7.267856)
```
