# Master-Thesis-Benchmarks

This Repo contains all benchmark data from the evaluation benchmark in which we compared different test suite reduction (TSR) approaches and requirements.

## Overview

This benchmark was performed with our proposed TSR tool *JSR - The Java Test Suite Reduction Framework*.

Please feel free to try it our yourself by taking a look at our [JSR repository](https://github.com/Lms24/JSR). 

### TSR Requirements

In this benchmark, we used three different coverage metrics as TSR requirements:

* Method coverage
* Line coverage
* Checked coverage

### Reduction Algorithms

In this benchmark, we explored three different reduction algorithms:

* Greedy HGS
* Delayed Greedy
* Genetic Algorithm

### Zero-Coverage Test Cases

We call test cases (TCs) having no coverage *zero-coverage TCs*. These emerged especially in combination with checked coverage. We therefore 
performed each TSR requirement/algorithm combination **with** and **without** including zero-coverage TCs in the final reduced test suite (RTS).

Summed up, we performed 18 TSR runs per project s.t. each algorithm (3), requirement (3) and zero-coverage mode (2) choice combination was tested. 

## Used Projects

We used ten real-world, open source Java projects available on GitHub, resulting overall in 180 RTSs (18 per projects) which were evaulated and compared. 

| ID         | Project name  | Used version  | Brief description |
|----------- | ------------- | ------------- | ------------- |
| 1          | [commons-lang](https://github.com/apache/commons-lang)  | 3.4 (2015)    | Provides additional features and utilities to the `java.lang` API  |
| 2          | [commons-io](https://github.com/apache/commons-io)    | 2.6 (2017)    | Provides utilities to work with files, input, output, streams and readers  |
| 3          | [opencsv](https://github.com/cygri/opencsv)       | 3.3 (2016)    | A simple `CSV` file parser for Java  |
| 4          | [commons-cli](https://github.com/apache/commons-cli)   | 1.4 (2017)    | A CLI command parsing and utility library  |
| 5          | [commons-csv](https://github.com/apache/commons-csv)   | 1.6 (2019)  | A library to read, parse and write `CSV` files  |
| 6          | [minimal-json](https://github.com/ralfstx/minimal-json)  | 0.9.6 (2016)    | A minimalistic and performance-focused `JSON` parser  |
| 7          | [java-tuple](https://github.com/andrebreves/java-tuple)    | 1.2.1 (2020)    | Provides the Tuple datatype to the Java language  |
| 8          | [json-simple](https://github.com/fangyidong/json-simple)   | 1.1.1 (2021)    | A simple libary to read, parse and write `JSON` files  |
| 9          | [confucius](https://github.com/IvanTrendafilov/Confucius)     | 1.3 (2021)    | A library of application configuration utilities and datatypes  |
| 10         | [ascii-table](https://github.com/freva/ascii-table)     | 1.2 (2021)    | A small library to create customizable ASCII tables in Java command line applications  |


## Evaluation & Comparison

The RTSs were evaulated with respect to their reduction factor (i.e. the amount of TCs in the RTS relative to the amount of TCs in the original TS) 
and their fault detection capability (FDC) loss. FDC was measured via mutation testing (using  [PIT](https://pitest.org/)).

### Results Data

This repository contains the output of all TSR runs per project in each propject's sub-directory. 
Additionally, the file `results.csv` contains all raw data of our benchmark condensed in one `CSV` file.

